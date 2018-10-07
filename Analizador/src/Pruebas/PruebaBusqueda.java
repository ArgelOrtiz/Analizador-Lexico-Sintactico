
package Pruebas;

import Entidades.Token;
import Procesos.Busquedas;

/**
 *
 * @author argel
 */
public class PruebaBusqueda {
    
    public static void main(String[] args) {
        
        Token t = new Token();
        Busquedas b = new Busquedas();
        
        t.setToken("Captura");
        t.setClasificacion("Reservada");
//        System.out.println(b.matriz[1][2]);
//        System.out.println(b.getAltoMatriz());
//        System.out.println(b.getAnchoMatriz());
        
        System.out.println(b.posicionA(t) +"/");
    }
    
}
