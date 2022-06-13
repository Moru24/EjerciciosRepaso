/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerspaco;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Moru
 */
public class Repaso1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        File a = new File("repaso1.txt");
        Scanner al = new Scanner(a);
        Scanner sc = new Scanner(System.in);
        FileWriter aw = new FileWriter(a, true);
        FileWriter awcase2 = new FileWriter(a, true);
        FileWriter awr = new FileWriter(a, false);
        String[] nombres = new String[10];
        String[] personajes = new String[10];
        String[] lectormodif = null;
        int eleccion;
        boolean conmutadorgeneral = true;

        try {

            System.out.println("Introduce 10 nombres y 10 tipos de personaje");
            for (int i = 0; i < 10; i++) {
                System.out.println("Nombre " + (i + 1));
                nombres[i] = sc.nextLine();
                System.out.println("Personaje " + (i + 1));
                personajes[i] = sc.nextLine();
                aw.write(nombres[i] + ";" + personajes[i]);
                aw.write("\n");
            }
            aw.close();

            do {
                System.out.println("****************Menu*********************");
                System.out.println("1. Quieres modificar algun registro?");
                System.out.println("2. Generar posibilidades automaticamente");
                System.out.println("3. Salir");
                eleccion = sc.nextInt();

                switch (eleccion) {
                    case 1:

                        int contador = 1;
                        int contador2 = 0;
                        int eleccionregistro1;
                        String elececcionregistro;
                        boolean conmu = true;

                        System.out.println("Realiza un cambio en el quer quieras, estos son los actuales valores");
                        while (al.hasNextLine()) {
                            lectormodif = (al.nextLine()).split(";");
                            System.out.println(contador + ". Nombre " + lectormodif[0]);
                            nombres[contador2] = lectormodif[0];
                            System.out.println(contador + ". Personaje " + lectormodif[1]);
                            nombres[contador2] = lectormodif[1];
                            contador++;
                            System.out.println("---------------------------------------");
                        }

                        System.out.println("Que registro quieres cambiar introduce si es nombre o personaje y el numero (nombre 2)");
                        System.out.println("Tipo de dato");
                        elececcionregistro = sc.next();
                        System.out.println("Numero de dato");
                        eleccionregistro1 = sc.nextInt();
                        System.out.println("introduce el nuevo registro");
                        if (elececcionregistro.equalsIgnoreCase("nombre") && eleccionregistro1 >= 0 && eleccionregistro1 <= 10) {
                            nombres[eleccionregistro1] = sc.next();

                        } else if (elececcionregistro.equalsIgnoreCase("personaje") && eleccionregistro1 >= 0 && eleccionregistro1 <= 10) {
                            personajes[eleccionregistro1] = sc.next();

                        } else {
                            System.out.println("Registro no valido");

                        }
                        for (int i = 0; i < 10; i++) {
                            awr.write(nombres[i] + ";" + personajes[i]);
                            awr.write("\n");
                        }
                        awr.close();
                        break;
                    case 2:
                        String[] ele= new String[100];
                        int eleccioncase2;
                        System.out.println("Se van a generar 100 opciones diferentes esocge cual es la que quieres y se plasmara en el archivo");
                        for (int i = 0; i < nombres.length; i++) {
                            for (int j = 0; j < personajes.length; j++) {
                                System.out.println(((j + 1) + (i * 10)) + "\tNombre: " + nombres[i] + "\tTipo: " + personajes[j]);
                                ele[(((j + 1) + (i * 10)))-1]="\tNombre: " + nombres[i] + "\tTipo: " + personajes[j];
                            }
                            };
                            System.out.println("Que opcion prefieres?");
                            eleccioncase2=sc.nextInt();
                            System.out.println(ele[eleccioncase2]);
                            System.out.println("Se guardara en el archivo");
                            awcase2.write("\n-------------------------------------------"+"\n");
                            awcase2.write(ele[eleccioncase2]);
                            awcase2.close();
                            break;
                        
                
                case 3:
                    conmutadorgeneral=true;
                    
                        break;

                }

            } while (conmutadorgeneral = true);
                al.close();

            } catch (Exception e) {
            System.out.println(e);
        }
        }

    }
