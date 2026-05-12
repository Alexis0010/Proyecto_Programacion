package casaRural;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Principal {
    public static Scanner t=new Scanner(System.in);
    Habitacion habitacion;

    public void run(){

        eliminarHabitacion();
        crearFactura();
    }

    public void eliminarHabitacion(){
        System.out.println("Que habitacion quieres eliminar: ");
        int habitacionAEliminar=t.nextInt();
        if (habitacionAEliminar==habitacion.id){

        }

    }

    public void crearFactura(){
        System.out.println("Creando factura....");

        try {
            FileWriter writer = new FileWriter("factura.txt");

            writer.write("Factura Nº: F-001\n");
            writer.write("Cliente: Juan Pérez\n");
            writer.write("Fecha: 12/05/2026\n");
            writer.write("Total: 150.75 €\n");

            writer.close();
            System.out.println("Factura creada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Principal().run();
    }
}
