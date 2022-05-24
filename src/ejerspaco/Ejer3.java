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
public class Ejer3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        String frase;
        
        
        System.out.println("Introduce una frase para que contemos los coracteres");
        frase=sc.nextLine();
        char[] caracteres=frase.toCharArray();
        System.out.println("Tu frase "+frase+" tiene "+ caracteres.length+ " caracteres");
        System.out.println("Tu frase "+frase+" tiene "+ frase.length()+ " caracteres");
        
        
    }
    
}
