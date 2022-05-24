/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Moru
 */
public class Ejer1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        
        //definicion de variables
        double volumen;
        double area;
        double circunferencia;
        int radio = 0;
        boolean conmutador = true; //variable para la captura de errores
        
        while (conmutador == true) {

            try {
                //Lectura del radio
                System.out.println("Introduce un radio");
                radio = sc.nextInt();
                conmutador = false;

                //Captura de errores en lectura de radio
            } catch (InputMismatchException x) {
                conmutador = true;
                System.out.println("El dato introducido no es correcto");
                sc.next();

            }catch(Exception e){
                conmutador = true;
                System.out.println("El dato introducido no es correcto");
                sc.next();
            }
        }

        //bateria de calculos
        area = (radio * radio) * Math.PI;
        volumen = 4 / 3 * Math.PI * Math.pow(radio, 3);
        circunferencia = 2 * Math.PI * radio;

        //Print con todos los datos solicitados
        System.out.println("El area= " + area + " La cicunferencia= " + circunferencia + " El volumen= " + volumen);

    }

}
