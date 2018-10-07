package Pruebas;

import Entidades.Token;
import Utilidades.Controlador;

/**
 *
 * @author Ortiz Arenas Argel 14/09/2018
 *
 * Prueba para el controlador que relaciona el lector con el analizador lexico
 */
public class PruebaControlador {

    public static void main(String[] args) {

        Token t = new Token();
        Controlador c = new Controlador(t);

        do {

            c.controlador();

            System.out.println(t.getToken());
            System.out.println(t.getClasificacion());
            System.out.println("---------------------------------");

        } while (t.getToken() != " ");

    }

}
