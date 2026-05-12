package casaRural;

import java.util.Scanner;

public class Principal {
    public static Scanner t=new Scanner(System.in);

    public void run(){

        eliminarHabitacion();
    }

    public void eliminarHabitacion(){
        System.out.println("Que habitacion quieres eliminar: ");
        int habitacionAEliminar=t.nextInt();

    }


    public static void main(String[] args) {
        new Principal().run();
    }
}
