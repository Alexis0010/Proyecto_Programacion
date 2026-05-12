package casaRural;

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


    }


    public static void main(String[] args) {
        new Principal().run();
    }
}
