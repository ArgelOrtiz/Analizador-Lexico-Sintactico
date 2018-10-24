/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Extras.Clasificaciones;
import Scanner.Lector;
import Utilidades.AnalizadorLexico;
import java.io.File;

/**
 *
 * @author MartinCoss
 */
public class Lectura {

    Lector l = new Lector();
    AnalizadorLexico a = new AnalizadorLexico();
    Clasificaciones c = new Clasificaciones();
    int inicio, fin;
    String token = "";
    String[] lineas;
    int cont = 0;

    public Lectura() {

        l.leeArch();
        lectura();
    }

    public void lectura() {
        inicio = 0;
        fin = inicio;
        File archivo = l.getArchivoR();
        try {
            lineas = l.pruebaArch(archivo);
        } catch (Exception e) {

        }
    }

    public String daTokenv3(String[] linea) {
        String token = "";
        if (cont != linea.length) {
            while (fin <= linea[cont].length()) {
                if (fin == linea[cont].length()) {
                    fin = 0;
                    inicio = fin;
                    if (cont != linea.length) {
                        cont++;
                        break;
                    }

                } else {

                    if (c.isWhite(linea[cont].charAt(fin))) {
                        fin++;
                        inicio = fin;
                    } else if (c.isComillaDoble(linea[cont].charAt(fin))) { //este entra primero. Si encuetra una comilla doble lee todo lo que tiene hasta que encuentra otra comilla doble
                        do {
                            token += linea[cont].charAt(fin);
                            fin++;

                        } while (!c.isComillaDoble(linea[cont].charAt(fin)));// falta agregar que en caso de que no tenga comilla de cierre, sigua leyendo hasta el fin del archivo(varibale linea)
                        token += linea[cont].charAt(fin);
                        fin++;//
                        inicio = fin;
                        break;

                    } else if (fin <= linea[cont].length() - 2) {

                        if (c.isWhite(linea[cont].charAt(fin + 1))) {

                            token += linea[cont].charAt(fin);
                            fin++;
                            inicio = fin;
                            break;
                        }
                        token += linea[cont].charAt(fin);
                        fin++;

                    } else {
                        token += linea[cont].charAt(fin);

                        fin++;
                    }
                }

            }
        }

        return token;
    }

    public String metodoParche() {
        String l = "";

        l = token = daTokenv3(lineas);
        if (l.length() != 0) {
            return l;
        } else {
            return " ";
        }

    }
}
