package casarural.util;

import casarural.model.Cliente;
import casarural.model.Habitacion;
import casarural.model.Reserva;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    public static void exportarCSV(Reserva r, Cliente c, Habitacion h, String ruta) throws IOException {
        try (FileWriter fw = new FileWriter(ruta)) {
            fw.write("Campo,Valor\n");
            fw.write("Cliente," + c.getNombre() + "\n");
            fw.write("DNI," + c.getDni() + "\n");
            fw.write("Email," + c.getEmail() + "\n");
            fw.write("Habitacion," + h.getNumero() + "\n");
            fw.write("Tipo," + h.getTipo() + "\n");
            fw.write("Fecha entrada," + r.getFechaEntrada() + "\n");
            fw.write("Fecha fin," + r.getFechaFin() + "\n");
            fw.write("Personas," + r.getNumeroPersonas() + "\n");
            fw.write("Precio/noche," + h.getPrecioNoche() + "\n");
        }
    }

    public static void exportarTXT(Reserva r, Cliente c, Habitacion h, String ruta) throws IOException {
        try (FileWriter fw = new FileWriter(ruta)) {
            fw.write("--- FACTURA ---\n");
            fw.write("Cliente:       " + c.getNombre() + "\n");
            fw.write("DNI:           " + c.getDni() + "\n");
            fw.write("Email:         " + c.getEmail() + "\n");
            fw.write("Habitacion:    " + h.getNumero() + " (" + h.getTipo() + ")\n");
            fw.write("Fecha entrada: " + r.getFechaEntrada() + "\n");
            fw.write("Fecha fin:     " + r.getFechaFin() + "\n");
            fw.write("Personas:      " + r.getNumeroPersonas() + "\n");
            fw.write("Precio/noche:  " + h.getPrecioNoche() + " EUR\n");
            fw.write("-----------------------\n");
        }
    }
}