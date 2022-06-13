/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

import java.io.IOException;
import java.sql.*;

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
        base.conexion();
        base.modificacionDeDatos(4, 4, "Victi", 6000);
        base.insercionDeDatos(22, "Victi2", 23);
            
            
    }
    
}
