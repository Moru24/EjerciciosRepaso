/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerspaco;

import java.util.Scanner;

/**
 *
 * @author Moru
 * @see https://classroom.google.com/u/1/c/NDE0NDg1MDcwMjUw/a/NDg3NTg5ODExOTc1/details
 * @version 1.0
 */
public class accionesAbsurdas extends Ejer6 {

    /**
     * Escanner para la lectura de datos
     */
    Scanner sc = new Scanner(System.in);

    /**
     * 
     */
    public void accionAbsurda1() {

        int num1 = 0;
        int num2 = 0;
        boolean conmutador = false;

        while (conmutador == false) {
            System.out.println("Introduzca numero1");
            num1 = sc.nextInt();
            conmutador = comprobacion(num1, num2);

            System.out.println("Introduzca numero2");
            num2 = sc.nextInt();
            conmutador = comprobacion(num1, num2);

        }

    }

    /**
     * 
     * @param num1
     * @param num2
     * @return true / false
     */
    public boolean comprobacion(int num1, int num2) {
        String num1a;
        String num2a;
        num1a = num1 + "";
        num2a = num2 + "";

        if (num1a.equals(num2a) && num2a.equals(num1a)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 
     * @return num1a
     */
    public String accionabsurda2() {
        double num1;
        String num1a;
        System.out.println("Introduce un numero");
        num1 = sc.nextDouble();
        num1a = num1 + "";
        return num1a;

    }

}
