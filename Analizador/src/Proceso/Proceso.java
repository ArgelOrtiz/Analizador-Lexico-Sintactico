/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proceso;

import Scanner.Lector_Gramatica;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author argel
 */
public class Proceso {

    Estructuras e;
    String linea;

    File archivo;
    String nuevoArchivo;
    Lector_Gramatica l;
    Returns r;
    Clasificaciones c;

    Identificadores p;

    String token;

    public ArrayList<String> noTerminales;
    public ArrayList<String> terminales;
    public ArrayList<String> producciones;

    public Proceso() {
        p = new Identificadores();
        l = new Lector_Gramatica();
        e = new Estructuras();
        r = new Returns();
        c = new Clasificaciones();
        archivo = l.leeArch();
        token = "";
        nuevoArchivo = "";
        noTerminales = new ArrayList<>();
        terminales = new ArrayList<>();
        producciones = new ArrayList<>();
    }

    public void ProcesarArchivo() {

        if (archivo != null) {
            try {
                Scanner scn = new Scanner(archivo);
                while (scn.hasNext()) {
                    linea = scn.nextLine();

                    //llamada de metodo para agregar la gramatica completa
                    e.addGramatica(linea);

                    //llamada al metodo para agregar los simbolos no terminales
                    e.addSimboloNT(daTokenNT(linea));

                    //llamada al metodo para generar un nuevo archivo
                    generaNuevoArchivo(linea);

                    //llama al metodo que separa y guarda las producciones
                    generaLineas(linea);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            tokenNuevoArchivo(nuevoArchivo);

        }

        //prueba de impresion
//        for (int i = 0; i < e.getGramatica().length; i++) {//Retorna la gramatica
//
//            System.out.println(e.getGramatica()[i]);
//        }
//        System.out.println("----------");

        for (int i = 0; i < e.getSimbolsNT().length; i++) {//Retorna no terminales
            noTerminales.add(e.getSimbolsNT()[i]);
//            System.out.println(noTerminales.get(i));
        }

//        System.out.println("----------");

        for (int i = 0; i < e.getSimbolsT().length; i++) {//Retorna terminales
            terminales.add(e.getSimbolsT()[i]);
//            System.out.println(terminales.get(i));
        }

//        System.out.println("------------");

        for (int i = 0; i < e.getProducciones().length; i++) {//Retorna las producciones
            producciones.add(e.getProducciones()[i]);
//            System.out.println(producciones.get(i));
        }

    }

    public String daTokenNT(String linea) {
        int inicio, fin;
        inicio = 0;
        fin = inicio;
        String token = "";

        do {

            //recorre espacios
            if (p.isWhite(linea.charAt(fin))) {
                fin++;
                inicio = fin;

                //metodo de paro
            } else if (p.isWhite(linea.charAt(fin + 1)) || p.isDerivation(linea.charAt(fin + 1))) {

                token += linea.charAt(fin);
                fin++;
                inicio = fin;
                break;

                //guardar el token
            } else {
                token += linea.charAt(fin);
                fin++;
            }
        } while (fin <= linea.length());

        return token;
    }

    public void generaNuevoArchivo(String linea) {
        int inicio = 0;
        int fin = 0;

        while ('>' != linea.charAt(fin)) {

            fin++;
            inicio = fin;

        }
        fin++;
        inicio = fin;

        do {

            if (c.isWhite(linea.charAt(fin))) {
                fin++;
                inicio = fin;
            } else if (c.isGato(linea.charAt(fin))) {

                break;

            } else {

                nuevoArchivo += linea.charAt(fin);
                fin++;

                if (c.isWhite(linea.charAt(fin))) {
                    nuevoArchivo += " ";
                    fin++;
                    inicio = fin;
                }

            }
            {

            }

        } while (fin <= linea.length());

    }

    public void tokenNuevoArchivo(String nuevo) {
        int inicio = 0;
        int fin = 0;
        String token = "";

        do {
            if (c.isWhite(nuevo.charAt(fin))) {
                fin++;
                inicio = fin;
                e.addSimbolosT(token);
                token = "";
            } else {

                token += nuevo.charAt(fin);
                fin++;

            }

        } while (fin < nuevo.length());

    }

    private void generaLineas(String linea) {

        int inicio = 0;
        int fin = 0;

        String line = "";
        while ('>' != linea.charAt(fin)) {

            fin++;
            inicio = fin;

        }
        fin++;
        inicio = fin;

        do {

            if (c.isWhite(linea.charAt(fin))) {
                fin++;
                inicio = fin;
            } else if (c.isGato(linea.charAt(fin))) {

                break;

            } else {

                line += linea.charAt(fin);
                fin++;

                if (c.isWhite(linea.charAt(fin))) {
                    line += " ";
                    fin++;
                    inicio = fin;
                }

            }
            {

            }

        } while (fin <= linea.length());

        e.addProducciones(line);

    }

}
