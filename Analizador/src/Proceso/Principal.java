package Proceso;

import Scanner.Lector_Gramatica;

/**
 *
 * @author MartinCoss
 */
public class Principal {

    Lector_Gramatica l = new Lector_Gramatica();
    PProceso p = new PProceso();
    int inicio, fin;
    String token = "";

    public Principal() {

    }

    public String daTokenv2(String linea) {

        String token = "";
        do {

            if (p.isWhite(linea.charAt(fin))) {
                fin++;
                inicio = fin;

            } else if (p.isWhite(linea.charAt(fin + 1))|| p.isDerivation(linea.charAt(fin+1))) {

                token += linea.charAt(fin);
                fin++;
                inicio = fin;
                break;
            } else {
                token += linea.charAt(fin);
                fin++;
            }
        } while (fin <= linea.length());

        return token;
    }


}
