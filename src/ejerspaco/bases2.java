/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Moru
 */
public class bases2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        
        Consultas base = new Consultas("jdbc:mysql://localhost:3306/test","root","");
        Statement a = base.conexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Scanner sc = new Scanner (System.in);
        ResultSet rs = a.executeQuery("Select * from ejer7."+sc.next()+";");
        base.conexion();
        base.vertabla(a,rs);
        base.cerrar();
            
            
    }
    
}
