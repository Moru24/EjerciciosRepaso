/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheros;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Víctor Zero
 */
public class Ejercicio3 extends Fichero {

    private String[] nombres;//Contiene todos los nombres
    private String[] tipos;//Contiene todos los tipos

    public Ejercicio3() throws IOException {
        super("./resources/personajes.txt");
    }

    /**
     * Menu del generador de personajes: 1-Opciones de inicio 1.1-Crear o
     * Importar 1.2-(si creas) introducir todos los registros 2-Opciones finales
     * 2.1-Modificar registros 2.2-Ver datos 2.3-Ver generador de probabilides
     * 2.4 Salir
     */
    @Override
    public void menu() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenido al generador de ficheros:");
            menuInicio(sc);
            menuOpciones(sc);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Te permite crear o importar personajes desde el fichero personajes.txt
     *
     * @param sc
     * @throws IOException
     */
    private void menuInicio(Scanner sc) throws IOException {
        int opcion;
        do {
            System.out.println("Diga lo que quiere hacer:\n\t1-Leer un fichero (si existe personajes.txt en resources)\n\t2-Crear un fichero e introducir los datos");
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                opcion = -1;
                sc.next();
            }
            switch (opcion) {
                case 1:
                    System.out.print("\nLeyendo");//Bucle simulacion de espera
                    for (int i = 0; i < 3; i++) {
                        this.esperar(500000000);
                        System.out.print(".");
                    }
                    System.out.println("");
                    this.importarDatos();//Importa los datos y comprueba si es valido
                    if (this.isVoid() || !this.ficheroValido()) {
                        System.out.println("El fichero no es valido, introduzca otra opcion");
                        opcion = -1;
                    }
                    break;
                case 2:
                    System.out.print("\nCreando fichero");//Bucle simulacion de espera
                    for (int i = 0; i < 3; i++) {
                        this.esperar(500000000);
                        System.out.print(".");
                    }
                    this.introducir("nombre", sc);//Te pide introducir los registros
                    this.introducir("tipo", sc);
                    break;
                default:
                    System.err.println("Opcion incorrecta, revise sus datos...");
                    System.out.println();
                    break;
            }
        } while (opcion > 2 || opcion < 1);
        actualizarNombresYtipos();//Actualizo los array de strings
    }

    //Menu de opciones de modificacion y visualizacion de informacion YA CARGADA
    private void menuOpciones(Scanner sc) {
        int opcion;
        boolean salir = false;
        do {
            System.out.println("Diga lo que quiere hacer:\n\t1-Modificar registro\n\t2-Ver todas las posibilidades\n\t3-Ver datos\n\t4-Salir");
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                opcion = -1;
                sc.next();
            }
            switch (opcion) {
                case 1:
                    //Se inicializan en valores imposibles y vas introduciendo que quieres modificar
                    int tipo = -1;
                    int index = -1;
                    String nuevo = "";
                    do {
                        mostrarDatos();
                        System.out.println("Introduzca el tipo de registro a cambiar:\n\t1-Nombre\n\t2-Tipo");
                        tipo = sc.nextInt();
                        System.out.println("Introduzca el numero del registro a cambiar:");
                        index = sc.nextInt();
                        System.out.println("Introduzca a que lo quiere cambiar:");
                        nuevo = sc.next();
                    } while (!modificarRegistro(tipo, index, nuevo));//Lo va modificando mientras comprueba
                    break;
                case 2://Genera y muestra posibilidades
                    generarPosibilidades();
                    break;
                case 3://Muestra datos
                    mostrarDatos();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.err.println("Opcion incorrecta, revise sus datos...");
                    System.out.println();
                    break;

            }
        } while (!salir);
    }

    //Bucle de creacion de registros
    public void introducir(String opcion, Scanner sc) {
        String datos = "";
        System.out.println("\nAhora deberá introducir los 10 " + opcion + "s");
        for (int i = 0; i < 10; i++) {
            System.out.print(opcion + ": ");
            datos += sc.next() + ";";
        }
        System.out.println("");
        datos += "\n";
        fichArray.add(datos);
    }

    /**
     * Actualizar los arrays de nombres y tipos
     */
    private void actualizarNombresYtipos() {
        nombres = fichArray.get(0).replaceAll("\n", "").split(";");
        tipos = fichArray.get(1).replaceAll("\n", "").split(";");
    }

    /**
     * Modifica cualquier registro de este formato
     *
     * @param tipo si es nombre o tipo
     * @param index Posicion del valor
     * @param nuevo Nuevo valor
     * @return si se pudo hacer o no
     */
    public boolean modificarRegistro(int tipo, int index, String nuevo) {
        if (index <= 0 || index > 10 || tipo <= 0 || tipo > 2) {
            System.out.println("Numero incorrecto");
            return false;
        }
        try {
            tipo -= 1;
            String old = (fichArray.get(tipo).split(";"))[index - 1];
            fichArray.set(tipo, fichArray.get(tipo).replaceAll(old + ";", nuevo + ";"));
            this.exportarDatos();
        } catch (Exception e) {
            System.err.println("Tipo no valido");
            System.out.println("");
            return false;
        }
        actualizarNombresYtipos();//Al haber cambiado la info, cambiamos la informacion que tenemos guardada en los arrays
        return true;
    }
    //Bucle de muestra de datos
    public void mostrarDatos() {

        System.out.println("\nNombres:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println((i + 1) + "\t" + nombres[i]);
        }
        System.out.println("\nTipos:");
        for (int j = 0; j < tipos.length; j++) {
            System.out.println((j + 1) + "\t" + tipos[j]);
        }
    }
    //Bucle que muestra todas las posibilidades
    public void generarPosibilidades() {
        System.out.println("");
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < tipos.length; j++) {
                System.out.println(((j + 1) + (i * 10)) + "\tNombre: " + nombres[i] + "\tTipo: " + tipos[j]);
            }
        }
    }
    /**
     * Comprueba si el formato es valido 
     * 
     * @return Si el formato del fichero es valido
     */
    public boolean ficheroValido() {
        if (fichArray.size() >= 2 && fichArray.get(0).split(";").length == 10 && fichArray.get(1).split(";").length == 10) {
            return true;
        }
        return false;
    }
}
