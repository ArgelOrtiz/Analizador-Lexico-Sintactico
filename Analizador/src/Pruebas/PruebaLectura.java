package Pruebas;

import Procesos.Lectura;
import Scanner.Lector;

/**
 *
 * Ortiz Arenas Argel 14/09/2018
 *
 * Prueba para el metodo parche de la lectura
 *
 */
public class PruebaLectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
String [] programa;
        Lector l = new Lector();
        l.leeArch();
       programa = l.pruebaArch(l.getArchivoR());
       
        for (int i = 0; i < programa.length; i++) {
            System.out.println(programa[i]);
            
        }
        

    }

}
