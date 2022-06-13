/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Víctor Zero
 */
public abstract class Fichero {

    protected File f;
    protected ArrayList<String> fichArray = new ArrayList();

    /**
     * Crea un fichero donde se almacenan o sacan datos
     *
     * @param path Ruta del fichero de texto
     * @throws IOException
     */
    protected Fichero(String path) {
        f = new File(path);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

    protected Fichero() {

    }

    /**
     * Importa los datos del fichero al array
     *
     * @throws IOException Lanza una excepcion si el archivo no existe o si
     * existe pero no permite lectura
     */
    protected void importarDatos() throws IOException {
        if (!f.exists() || (f.exists() && !f.canRead())) {
            throw new IOException();
        }
        try {
            Scanner sc = new Scanner(f);
            fichArray.clear();
            while (sc.hasNext()) {
                fichArray.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Exporta los datos desde el array hasta el fichero
     *
     * @throws IOException Lanza excepcion si no se puede escribir
     */
    protected void exportarDatos() throws IOException {
        if (!f.canWrite()) {
            throw new IOException();
        }
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < fichArray.size(); i++) {
                fw.write(fichArray.get(i));
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    /**
     * 
     * @return Si esta vacio
     */
    protected boolean isVoid() {

        for (int i = 0; i < fichArray.size(); i++) {
            if (!fichArray.get(i).equals("")) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param nanosec En nanosegundos tiempo en el que se espera
     */
    protected void esperar(long nanosec) {
        long inicio = System.nanoTime();
        long fin = System.nanoTime();
        while (fin - inicio < nanosec) {
            fin = System.nanoTime();
        }
    }

    public abstract void menu();
}
