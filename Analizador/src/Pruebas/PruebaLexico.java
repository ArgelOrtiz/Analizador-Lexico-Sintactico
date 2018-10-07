package Pruebas;

import Entidades.Token;
import Utilidades.AnalizadorLexico;

/**
 *
 * @author Ortiz Arenas Argel 14/09/2018
 *
 * clase de prueba para el analizador lexico
 */
public class PruebaLexico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Token t = new Token();
        AnalizadorLexico al = new AnalizadorLexico();

        al.q0("Iniciar", t);
        System.out.println("Ingresado " + t.getToken() + " " + "\n" + "con clasificacion " + t.getClasificacion());

        al.q0("int", t);
        System.out.println("Ingresado " + t.getToken() + " " + "\n" + "con clasificacion " + t.getClasificacion());

        al.q0("a", t);
        System.out.println("Ingresado " + t.getToken() + " " + "\n" + "con clasificacion " + t.getClasificacion());

        al.q0("==", t);
        System.out.println("Ingresado " + t.getToken() + " " + "\n" + "con clasificacion " + t.getClasificacion());

    }

}
