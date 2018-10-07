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
    String linea;

    public Lectura() {

        lectura();
    }

    public void lectura() {
        inicio = 0;
        fin = inicio;
        File archivo = l.leeArch();
        try {
//do{
            linea = l.pruebaArch(archivo);

            //a.q0(token);
//}while(token !=null);
        } catch (Exception e) {

        }
    }

    public String daTokenv2(String linea) {
        String token = "";
        do {

            if (c.isWhite(linea.charAt(fin))) {// recorre los dos punteros cuando hay espacios en blanco
                fin++;
                inicio = fin;

            } else if (c.isComillaDoble(linea.charAt(fin))) { //este entra primero. Si encuetra una comilla doble lee todo lo que tiene hasta que encuentra otra comilla doble
                do {
                    token += linea.charAt(fin);
                    fin++;

                } while (!c.isComillaDoble(linea.charAt(fin)));// falta agregar que en caso de que no tenga comilla de cierre, sigua leyendo hasta el fin del archivo(varibale linea)
                token += linea.charAt(fin);
                fin++;//
                inicio = fin;
                break;

            } else if (c.isWhite(linea.charAt(fin + 1))) {// esta leyendo un caracter, si encuentra un espacio, corta y guarda el token. posteriormente se igualan los apuntadores 
                //al lugar del ultimo espacio para que a partir de ahi, se comience a leer desde el ultimo punto cuando se vuelva a llamar el metodo
                token += linea.charAt(fin);
                fin++;
                inicio = fin;
                break;

            } else {

                token += linea.charAt(fin); // se concatena un caracter en la variable token
                fin++;
            }
        } while (fin <= linea.length());// mientras el apuntador no sobrepase la longitud de la cadena, el ciclo sigue en ejecucion

        return token;
    }

    public String metodoParche() {      // Metodo para saber si es fin de archivo, si lo es retorna un espacio vacío

        try {

            return token = daTokenv2(linea);

        } catch (Exception e) {

            return " ";
        }
    }
}
