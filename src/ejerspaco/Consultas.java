/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerspaco;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Moru
 */
public class Consultas {
    Scanner sc = new Scanner (System.in);

    String url;
    String user;
    String pass;

    public Consultas(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection conexion() throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        //se carga la clase del Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //datos de conexión
        String url = this.url;

        String user = this.user;

        String pass = this.pass;

        //Establezco
        Connection conn = DriverManager.getConnection(url, user, pass);

        //Saco por pantalla confirmación si OK
        System.out.println("La conexión se ha establecido");

        //AQUÍ SE REALIZARÁN OTRAS ACCIONES
        return conn;

    }

    public void modificacionDeDatos(int Fila, int id, String Nombre, int año) throws ClassNotFoundException, SQLException, IOException {
        Archivo a = new Archivo();

        Statement stmnt = conexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = stmnt.executeQuery("Select * from ejer7.general");

        rs.absolute(Fila);
        rs.updateInt(1, id);
        rs.updateString(2, Nombre);
        rs.updateInt(3, año);
        rs.updateRow();
        a.escribir(Fila, id, Nombre, año);

    }

    public void insercionDeDatos(int id, String Nombre, int año) throws ClassNotFoundException, SQLException, IOException {
        Archivo a = new Archivo();
        

        Statement stmnt = conexion().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        PreparedStatement stm = conexion().prepareCall("insert into ejer7.general (id,nombre,edad) values (?,?,?);");
        ResultSet rs = stmnt.executeQuery("Select * from ejer7.general");
        
        //esto no esta bien deberia irse a otro metodo pero es para probar en el mismo
        System.out.println("Quieres añadir: 1. muchos datos 2.solo 1");
        if (sc.nextInt()==1) {
            for (int i = 0; i < 10; i++) {
                int ida=(30+i);
                int añoa=(23+i);
                stm.setInt(1, ida);
                stm.setString(2, Nombre);
                stm.setInt(3, añoa);
                stm.executeUpdate();
                a.escribir(rs.getRow(), ida, Nombre, añoa);
            }
        }else{
        rs.moveToInsertRow();
        rs.updateInt(1, id);
        rs.updateString(2, Nombre);
        rs.updateInt(3, año);
        rs.insertRow();
        a.escribir(rs.getRow(), id, Nombre, año);

        }
        a.cerrar();
        

       
    }
    public void cerrar() throws ClassNotFoundException, SQLException{
        this.conexion().close();
    }

}
