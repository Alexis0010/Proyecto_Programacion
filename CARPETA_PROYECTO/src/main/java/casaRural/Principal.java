package casaRural;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Principal {
    public static Scanner t=new Scanner(System.in);
    Habitacion habitacion;
    Cliente cliente;
    Reserva reserva;

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
        for (int i = 0; i < 1000; i++) {
        try {
            FileWriter writer = new FileWriter("factura.txt");

            writer.write("Factura Nº:"+ i+"\n");
            writer.write("Cliente: "+cliente.nombre+"\n");
            writer.write("Fecha: "+reserva.fecha+"\n");
            writer.write("Total: 150.75 €\n");

            writer.close();
            System.out.println("Factura creada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    }


    public static void main(String[] args) {
        new Principal().run();
    }
}
