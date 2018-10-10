package Procesos;

import Entidades.Token;
import Utilidades.Controlador;
import Utilidades.Pila;

/**
 *
 * @author
 *
 * Ortiz Arenas Argel 8/09/2018
 *
 * Clase LLDriver, clase encargada de hacer el analisis sintactico. Paerte del
 * software que analiza si un programa escrito en un lenguaje espesifico es
 * sintactica y lexicamente correcto o no
 */
public class LLDriver {

    Pila p;         // Pila genérica
    Token a;        // Estructura de token
    Controlador c;  // Manejador del analizador lexico
    String x;       // String auxiliar para el analisis
    Busquedas b;    // Clase encargada de comprobar los terminales, no terminales y matriz predictiva

    

    //constructor
    public LLDriver() {
        a = new Token();
        c = new Controlador(a);
        b = new Busquedas();
        p = new Pila();

        x = "";
    }

    //modificar metodos de comprobacion (Ubicados hasta abajo)
    public void analizar() {
        //se agrega el simbolo inicial
        p.push("program");

        // asignar "x" al tope de la pila
        x = (String) p.peak();

        // asignando el token a "a"
        c.controlador();

        try {

            //inicia el analisis sintactico
            while (!p.isEmpty()) {

                //si el token es un no terminal
                if (b.isNoTerminal(x)) {

                    //se optiene la posicion del no terminal
                    int px = b.posicionX(x);

                    //se optiene la posicion del token
                    int pa = b.posicionA(a);
                   
      
//                    System.out.println(x+"/"+a.getToken());
//                    System.out.println(px +"/"+pa);
//                    System.out.println(b.matriz[px][pa]);
                    //se busca en la matris predictiva la siguiente produccion a sguir
                    if (b.matriz[px][pa] != 0) {
//                        System.out.println("entro a matriz");
                       

                        //elimina el tope de la pila
                        p.pop();
                         

                        //arreglo auxiliar que guarda los simbolos separados por un espacio dentro de la produccion
                        String[] aux = b.producciones[b.matriz[px][pa] - 1].split(" ");

                        for (int i = aux.length - 1; i >= 0; i--) {

                            //agrega cada simbolo que se encuentra en la produccion
                            if (!aux[i].equals("") && !aux[i].equals(" ")) {

                                //agrega el simbolo a la pila
//                                System.out.println("----"+aux[i]);
                                p.push(aux[i]);

                            }

                        }

                        //se asigna a x el tope de la pila
                        x = (String) p.peak();

                    //cuando no coinciden las entradas con lo esperado
                    } else {

                        //espesificar los tipos de errores que causan esta salida
                        System.out.println(a.getToken()+"/");
                        System.out.println("Token no esperado en esa posicion");
                        System.exit(0);
                    }

                    //si x es un terminal
                } else {

//                    System.out.println(x+"/"+a.getToken());

                    //verifica si el terminal es una palabra reservada                                                                                                                 
                    if (a.getClasificacion().equals("Reservada")) {

                        //System.out.println("Reservada -LLD-");
                        if (x.equals(a.getToken())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //el terminal no es la palabra reservada esperada
                        } else {

                            System.out.println("Error en las reservadas -LLD-");
                            System.exit(0);

                        }

                        //verificar si el terminal es un identificador
                        //rebisar la ambiguedad de este codigo
                    } else if (a.getClasificacion().equals("Id")) {

//                        System.out.println("Id -LLD-");
                        
                        if (x.equals(a.getClasificacion())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //revisar ambiguedad
                        } else {

                            System.out.println(x+"/"+a.getToken()+"/"+a.getClasificacion());
                            System.out.println("1");
                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                        //verificar si el terminal es un caracter simple    
                    } else if (a.getClasificacion().equals("Caracter Simple")) {

//                        System.out.println("Caracter simple -LLD-");
                        if (x.equals(a.getToken())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //si el terminal no es el caracter simple esperado    
                        } else {
                            //error 03/10/2018

                            System.out.println("2");
                            System.out.println("Error Lexico/Sintactico /--3--/");
                            System.exit(0);
                            //error 07/10/2018
                           // System.out.println(x);
//                            System.out.println(a.getToken());
//                            System.out.println(a.getClasificacion());
                        }

                        //verifica si el terminal es una cadena
                        //verificar ambiguedad de codigo
                    } else if (a.getClasificacion().equals("cadena")) {

                        //System.out.println("cadena -LLD-");
                        
                        if (x.equals(a.getClasificacion())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //revisar ambiguedad del error    
                        } else {

                            System.out.println("3");
                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                        //verificar si el terminal es un operadorl    
                    } else if (a.getClasificacion().equals("Operadores")) {

                        //System.out.println("Operadores -LLD-");
                        if (x.equals(a.getToken())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //el terminal no es un operador esperado
                        } else {
                            
                            System.out.println("4");
                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }

                           
                    } else if (a.getClasificacion().equals("Char")) {
                        
                        
                        if (x.equals(a.getClasificacion())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //revisar ambiguedad del error    
                        } else {
                            System.out.println("5");
                            System.out.println("Error Lexico/Sintactico --3--");
                            System.exit(0);

                        }
                        //si el terminal no pertenece a ninguna clasificacion
                    }else{
                        System.out.println("6");
                        System.out.println(x + " / " + a.getToken()+"/"+a.getClasificacion());

                        System.out.println("Error Lexico/Sintactico --3--");
                        System.exit(0);

                    }

                }

            }
        } catch (Exception e) {
////            error 8/10/2018
//            System.out.println(x);
//            System.out.println(a.getToken());
//            System.out.println(a.getClasificacion());


            System.out.println("Error Lexico/Sintactico --1--");
            System.out.println(e);
            System.exit(0);

        }

        System.out.println(
                "El programa es sintacticamente aceptado :D");

    }

    private void procesoTerminal() {

        //elimina el tope de la pila
        p.pop();

        // asignando el siguiente token a "a"
        c.controlador();

        //verificacion de fin de la lectura
        if (!a.getToken().equals(" ")) {

            //asignar el nuevo "x"
            x = (String) p.peak();

        }
    }

}
