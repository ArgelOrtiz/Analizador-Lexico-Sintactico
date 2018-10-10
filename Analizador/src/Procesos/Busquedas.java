package Procesos;

import Entidades.Token;
import Proceso.Proceso;

/**
 *
 * @author Argel Ortiz Arenas
 *
 *
 * clase dedicada a la busqueda de token y clasificacion en las listas
 * predeterminadas de estructuras
 */
public class Busquedas {

    // Matriz predictiva
    public int matriz[][]
            = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 4, 4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 6, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 12, 0, 0, 0, 0, 13, 11, 0, 0, 0, 11, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 15, 0, 0, 0, 0, 0},
            {0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 18, 0, 0, 0},
            {0, 0, 0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0},
            {0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    // Estructura con todos los lados derechos de la gramática
    public String[] producciones;

    // Símbolos no terminales
    public String[] simbolNT;

    // Símbolos terminales
    public String[] simbolT;
    
    public void vaciadoDeGramatica() {
        Proceso gramatica = new Proceso();
        gramatica.ProcesarArchivo();
        producciones = new String[gramatica.producciones.size()];
        simbolNT = new String[gramatica.noTerminales.size()];
        simbolT = new String[gramatica.terminales.size()];
        
        for (int i = 0; i < gramatica.producciones.size(); i++) {
            producciones[i] = gramatica.producciones.get(i);
//            System.out.println(producciones[i]);
        }
//        System.out.println("-----------");
        for (int i = 0; i < gramatica.noTerminales.size(); i++) {
            simbolNT[i] = gramatica.noTerminales.get(i);
//            System.out.println(simbolNT[i]);
        }
//        System.out.println("-----------");
        for (int i = 0; i < gramatica.terminales.size(); i++) {
            simbolT[i] = gramatica.terminales.get(i);
//            System.out.println(simbolT[i]);
        }
        
    }
//344tr6t    public static void main(String[] args) {
//        Busquedas o ;
//        
//        o = new Busquedas();
//        
// 
//    }
    
    public Busquedas() {
        vaciadoDeGramatica();
    }

    //regresa la numeracion dentro de la matriz
    public int getMatriz(int px, int pa) {
        
        try {
            System.out.println(px + "/" + pa);
            return matriz[px][px];
            
        } catch (Exception e) {
            
            return 0;
        }
        
    }
    
    public int getAltoMatriz() {
        
        return matriz.length;
    }
    
    public int getAnchoMatriz() {
        
        return matriz[0].length;
    }

    //regresar el numero de la posicion del 
    public int posicionA(Token a) {

        //se compara la clasificacion para saber si es una reservada
        if (a.getClasificacion().equals("Reservada")) {

            //System.out.println("Reservada --");
            for (int i = 0; i < simbolT.length; i++) {

                //System.out.println(a.getToken() + "/" +e.simbolT[i]);
                //se busca el token dentro de los simbolos terminales
                if (a.getToken().equals(simbolT[i])) {

                    //si se encuentra una coincidencia se regresa la posicion
                    return i;
                }
                
            }

            //se verficica la clasificacion para saber si es un identificador
        } else if (a.getClasificacion().equals("Id")) {

            //System.out.println("Id");
            for (int i = 0; i < simbolT.length; i++) {

                //se busca la clasificacion id dentro del los simbolos terminales
                if (a.getClasificacion().equals(simbolT[i])) {

                    //si se encuentra una coincidencia se regresa la posicion
                    return i;
                }
                
            }

            //se verifica la clasificacion para saber si es un caracter simple
        } else if (a.getClasificacion().equals("Caracter Simple")) {

            //System.out.println("Caracter simple");
            for (int i = 0; i < simbolT.length; i++) {

                //se busca el token dentro de los simbolos terminales
                if (a.getToken().equals(simbolT[i])) {

                    //si se encuentra una coincidencia se regresa la posicion
                    return i;
                }
                
            }

            //se verifica la clasificacion para saber si es una cadena
        } else if (a.getClasificacion().equals("cadena")) {

            //System.out.println("cadena");
            for (int i = 0; i < simbolT.length; i++) {

                //se busca la clasificacion cadena dentro de los simbolos terminales
                if (a.getClasificacion().equals(simbolT[i])) {

                    //si se encuentra una coincidencia se regresa la posicion
                    return i;
                }
                
            }

            //si la entrada no se encontro dentro de ninguna clasificacion
        } else {

            //se retorna el tamaño de la lista para sobrepasar la matris
            //y determinar que no se encontro
            //cambiar esta forma por una mas efectiva para llevar el control de errores
            return simbolT.length;
            
        }

        //se retorna el tamaño de la lista para sobrepasar la matris
        //y determinar que no se encontro
        //cambiar esta forma por una mas efectiva para llevar el control de errores
        return simbolT.length;
    }

    //buscar las posiciones de los no terminales
    public int posicionX(String x) {
        
        for (int i = 0; i < simbolNT.length; i++) {
            
            if (x.equals(simbolNT[i])) {
                
                return i;
                
            }
            
        }
        
        return simbolNT.length;
    }

    //buscar las posiciones de los terminales
    public boolean isNoTerminal(String x) {
        
        for (int i = 0; i < simbolNT.length; i++) {
            
            if (x.equals(simbolNT[i])) {
                
                return true;
            }
            
        }
        
        return false;
    }
    
}
