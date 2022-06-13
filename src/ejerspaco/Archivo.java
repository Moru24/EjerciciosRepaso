/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerspaco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Moru
 */
public class Archivo {

    File a = new File("base.txt");
    FileWriter aw;

    public Archivo() throws IOException {
        this.aw = new FileWriter(a, true);
    }

    public void escribir(int Linea,int id, String Nombre, int año) throws IOException {
        aw.write("La linea modificada es la "+ Linea+"\n");
        aw.write("id " + id + " nombre " + Nombre + " año " + año + "\n");
   }
   public void cerrar() throws IOException{
       aw.close();
   } 

}
