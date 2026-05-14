package casarural;

import casarural.dao.*;
import casarural.model.*;
import casarural.util.CSVExporter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner t = new Scanner(System.in);
    static HabitacionDAO habitacionDAO = new HabitacionDAO();
    static ClienteDAO clienteDAO = new ClienteDAO();
    static ReservaDAO reservaDAO = new ReservaDAO();
    static FacturaDAO facturaDAO = new FacturaDAO();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CASA RURAL ---");
            System.out.println("1. Anadir habitacion");
            System.out.println("2. Listar habitaciones");
            System.out.println("3. Eliminar habitacion");
            System.out.println("4. Buscar habitacion");
            System.out.println("5. Anadir cliente");
            System.out.println("6. Anadir reserva");
            System.out.println("7. Generar factura");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = t.nextInt();
            t.nextLine();

            try {
                switch (opcion) {
                    case 1: anadirHabitacion(); break;
                    case 2: listarHabitaciones(); break;
                    case 3: eliminarHabitacion(); break;
                    case 4: buscarHabitacion(); break;
                    case 5: anadirCliente(); break;
                    case 6: anadirReserva(); break;
                    case 7: generarFactura(); break;
                    case 0: break;
                    default: System.out.println("Opcion no valida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    static void anadirHabitacion() throws SQLException {
        System.out.print("Numero: "); String numero = t.nextLine();
        System.out.print("Tipo (SUITE/ESTANDAR/FAMILIAR): "); TipoHabitacion tipo = TipoHabitacion.valueOf(t.nextLine().toUpperCase());
        System.out.print("Capacidad: "); int capacidad = Integer.parseInt(t.nextLine());
        System.out.print("Precio/noche: "); double precio = Double.parseDouble(t.nextLine());
        System.out.print("Descripcion: "); String desc = t.nextLine();
        habitacionDAO.insertar(new Habitacion(0, numero, tipo, capacidad, precio, desc));
        System.out.println("Habitacion anadida.");
    }

    static void listarHabitaciones() throws SQLException {
        List<Habitacion> lista = habitacionDAO.listarTodas();
        for (Habitacion h : lista) {
            System.out.println(h.getId() + " | " + h.getNumero() + " | " + h.getTipo() + " | " + h.getCapacidad() + " | " + h.getPrecioNoche() + " EUR");
        }
    }

    static void eliminarHabitacion() throws SQLException {
        System.out.print("ID a eliminar: "); int id = Integer.parseInt(t.nextLine());
        habitacionDAO.eliminar(id);
        System.out.println("Habitacion eliminada.");
    }

    static void buscarHabitacion() throws SQLException {
        System.out.print("ID a buscar: "); int id = Integer.parseInt(t.nextLine());
        Habitacion h = habitacionDAO.buscarPorId(id);
        if (h != null) System.out.println(h.getNumero() + " | " + h.getTipo() + " | " + h.getPrecioNoche() + " EUR");
        else System.out.println("No encontrada.");
    }

    static void anadirCliente() throws SQLException {
        System.out.print("Nombre: "); String nombre = t.nextLine();
        System.out.print("Telefono: "); String tel = t.nextLine();
        System.out.print("Email: "); String email = t.nextLine();
        System.out.print("DNI: "); String dni = t.nextLine();
        clienteDAO.insertar(new Cliente(0, nombre, tel, email, dni));
        System.out.println("Cliente anadido.");
    }

    static void anadirReserva() throws SQLException {
        System.out.print("ID cliente: "); int clienteId = Integer.parseInt(t.nextLine());
        System.out.print("ID habitacion: "); int habId = Integer.parseInt(t.nextLine());
        System.out.print("Fecha entrada (YYYY-MM-DD): "); LocalDate entrada = LocalDate.parse(t.nextLine());
        System.out.print("Fecha fin (YYYY-MM-DD): "); LocalDate fin = LocalDate.parse(t.nextLine());
        System.out.print("Numero personas: "); int personas = Integer.parseInt(t.nextLine());
        System.out.print("Observaciones: "); String obs = t.nextLine();
        reservaDAO.insertar(new Reserva(0, entrada, fin, personas, "pendiente", obs, clienteId, habId));
        System.out.println("Reserva anadida.");
    }

    static void generarFactura() throws Exception {
        System.out.print("ID habitacion: "); int habId = Integer.parseInt(t.nextLine());
        Habitacion h = habitacionDAO.buscarPorId(habId);
        System.out.print("Nombre cliente: "); String nombre = t.nextLine();
        System.out.print("DNI: "); String dni = t.nextLine();
        System.out.print("Email: "); String email = t.nextLine();
        Cliente c = new Cliente(0, nombre, "", email, dni);
        System.out.print("Fecha entrada (YYYY-MM-DD): "); LocalDate entrada = LocalDate.parse(t.nextLine());
        System.out.print("Fecha fin (YYYY-MM-DD): "); LocalDate fin = LocalDate.parse(t.nextLine());
        System.out.print("Numero personas: "); int personas = Integer.parseInt(t.nextLine());
        Reserva r = new Reserva(0, entrada, fin, personas, "confirmada", "", 0, habId);
        System.out.print("Formato (csv/txt): "); String formato = t.nextLine();
        String ruta = "factura." + formato.toLowerCase();
        if (formato.equalsIgnoreCase("csv")) CSVExporter.exportarCSV(r, c, h, ruta);
        else CSVExporter.exportarTXT(r, c, h, ruta);
        System.out.println("Factura generada: " + ruta);
    }
}