/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

/**
 *
 * @author Moru
 */
public class Ejer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] español = {"nosotros","trabajo","dar","esto","boligrafo","casa","coche","habitación","clase","usar"};
        String[] ingles = {"us","work","give","this","pen","house","car","room","class","use"};
        String rojo="\033[31m";
        String azul="\033[34m";
       
        for (int i = 0; i < español.length; i++) {
            
            System.out.print(azul+español[i]+"     "+"\t"+rojo+ingles[i]+"\n");
        }

        
        
    }
    
}
