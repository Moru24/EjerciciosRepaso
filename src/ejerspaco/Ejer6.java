/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

import java.util.Scanner;

/**
 *
 * @author Moru
 */
public class Ejer6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        accionesAbsurdas a = new accionesAbsurdas();
        int eleccion;
        boolean conmutador = true;

        while (conmutador == true) {
            System.out.println("Elige una opcion");
            System.out.println("1. Opcion Absurda");
            System.out.println("2. Opcion mas Absurda");
            System.out.println("3. Salir");
            eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    a.accionAbsurda1();
                    break;
                case 2:
                    System.out.println("El numero introducido es "+a.accionabsurda2());
                    break;
                case 3:
                    conmutador=false;
                    break;
            }
        }

    }

}
