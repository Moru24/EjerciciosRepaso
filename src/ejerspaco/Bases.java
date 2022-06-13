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
public class Bases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            //se carga la clase del Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //datos de conexión
            String url = "jdbc:mysql://localhost:3306/test";

            String user = "root";

            String pass = "";

            //Establezco
            Connection conn = DriverManager.getConnection(url, user, pass);

            //Saco por pantalla confirmación si OK
            System.out.println("La conexión se ha establecido");

            //AQUÍ SE REALIZARÁN OTRAS ACCIONES
            Statement stmt = conn.createStatement();

            stmt.execute("Use Ejer7;");
            stmt.execute("drop table if exists general;");
            stmt.execute("Create table  general (id int primary key,nombre varchar(20) ,edad int);");
            System.out.println("Tabla generada");
            Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            PreparedStatement stmnt3 = conn.prepareStatement("Insert into general (id,nombre,edad) values (?,?,?);");

            System.out.println("Prepared");

            for (int i = 0; i < 10; i++) {
                stmnt3.setInt(1, (i + 1));
                stmnt3.setString(2, "Pablo");
                stmnt3.setInt(3, (i + 23));
                stmnt3.executeUpdate();
            }
            System.out.println("Fin del prepared");

            ResultSet rs1 = stmnt2.executeQuery("Select * from ejer7.general;");

            rs1.absolute(2);
            rs1.updateString("nombre", "Juan");
            rs1.updateInt("edad", 10);
            rs1.updateRow();

            System.out.println("Primera edicion realizada");

            rs1.moveToInsertRow();
            rs1.updateInt("id", 11);
            rs1.updateString("nombre", "Juan");
            rs1.updateInt("edad", 10);
            rs1.insertRow();

            System.out.println("Primera insercion realizada");

            ResultSetMetaData res2 = rs1.getMetaData();

            System.out.println("La tabla general tiene " + res2.getColumnCount() + " columnas");
            rs1.last();
            System.out.println("La tabla general tiene " + rs1.getRow() + " columnas");

            stmt.close();
            stmnt3.close();
            conn.close(); //recordamos finalizar la conexión

            System.out.println("La conexión se ha terminado");

        } catch (Exception e) {

            System.out.println("Error: " + e);

        }
    }

}
