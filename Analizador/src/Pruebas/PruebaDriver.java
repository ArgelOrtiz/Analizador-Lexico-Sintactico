package Pruebas;

import Procesos.LLDriver;

/**
 *
 * @author Ortiz Arenas Argel 14/09/2018
 *
 * prueba del analizador sintactico, esta classe une todo el proyecto clase
 * principal
 */
public class PruebaDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        LLDriver lld = new LLDriver();

        lld.analizar();
    }

}
