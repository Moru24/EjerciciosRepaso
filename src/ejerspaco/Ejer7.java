/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

import java.sql.*;

/**
 *
 * @author Moru
 */
public class Ejer7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int num = 0;
        int[] si = new int[10];
        int contador = 0;
        int aux;

        try {

            //Gestión de driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Eliijo dónde me voy a conectar, no pongo esquema porque lo crearé:
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");

            System.out.println("La conexión se ha establecido");

            //Monto la sesión, OJO: ESTABLECIENDO NAVEGABILIDAD Y CONCURRENCIA
            Statement stmt = conn.createStatement();

            System.out.println("Inicié sesión");

            stmt.execute("drop database if exists EJER7;");
            stmt.execute("CREATE DATABASE EJER7;");
            stmt.execute(" USE EJER7;");
            stmt.execute("Drop table if exists TABLA1;");
            stmt.execute("CREATE TABLE TABLA1(ID INT PRIMARY KEY auto_increment,NUMERO_ALEATORIO INT );");

            for (int i = 0; i < 10; i++) {

                num = (int) Math.floor(Math.random() * (336) - 3);

                stmt.executeUpdate("INSERT INTO TABLA1 (NUMERO_ALEATORIO)VALUES(" + (num) + ");");

            }

            ResultSet rs = stmt.executeQuery("Select * from TABLA1;");

            while (rs.next()) {
                si[contador] = rs.getInt("NUMERO_ALEATORIO");
                contador++;
            }
            
            for (int i = 0; i < si.length; i++) {

                for (int w = 0; w < si.length - 1; w++) {

                    if (si[w] > si[w + 1]) {
                        aux = si[w];
                        si[w] = si[w + 1];
                        si[w + 1] = aux;

                    }

                }
            }
            for (int i = 0; i < si.length; i++) {
                System.out.println(si[i]);
            }

            System.out.println("-------Acciones realizadas--------");

            stmt.close();

            conn.close();

            System.out.println("-------Fin de conexión------"); //tijeras!!

        } catch (Exception e) {  // manejamos el error

            System.out.println(e);

        }

    }

}
