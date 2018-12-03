package Procesos;

import Entidades.Token;
import Utilidades.AnalizadorSemantico;
import Utilidades.Controlador;
import Utilidades.ErrorHandling;
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

    Pila p;                 // Pila genérica
    Token a;                // Estructura de token
    Controlador c;          // Manejador del analizador lexico
    String x;               // String auxiliar para el analisis
    Busquedas b;            // Clase encargada de comprobar los terminales, no terminales y matriz predictiva
    AnalizadorSemantico al; // analizador semantico
    ErrorHandling eh;         // Manejador de errores
    boolean selector;       // variable para controlar el guardado de simbolos para el semantico
    String type;            // seleccionador de tipo de variable

    

    //constructor
    public LLDriver() {
        a = new Token();
        c = new Controlador(a);
        b = new Busquedas();
        p = new Pila();
        al = new AnalizadorSemantico();
        eh = new ErrorHandling();
        selector = false;
        type = new String();
            
        x = "";
    }

    //modificar metodos de comprobacion (Ubicados hasta abajo)
    public boolean analizar() {
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

                        eh.error(a.getToken(),"Primer error" );
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

                            eh.error(a.getToken(), "No se encuentra como parte de: "+a.getClasificacion());

                        }

                        //verificar si el terminal es un identificador
                        //rebisar la ambiguedad de este codigo
                    } else if (a.getClasificacion().equals("Id")) {

//                        System.out.println("Id -LLD-");
                        
                        if (x.equals(a.getClasificacion())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();
                            
                            if (selector) {
                                
                                if (al.insert(a.getToken(), type)) {
                                    
                                }else{
                                    
                                    eh.error(a.getToken(), "El identificador fue previamente utilizado");
                                }
                            }

                            //revisar ambiguedad
                        } else {
                            
                            eh.error(a.getClasificacion(),"No es una clasificacion esperada en esa posicion" );

                        }

                        //verificar si el terminal es un caracter simple    
                    } else if (a.getClasificacion().equals("Caracter Simple")) {

//                        System.out.println("Caracter simple -LLD-");
                        if (x.equals(a.getToken())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();
                            
                            
                            //procesos para identificaer la declaracion de variables
                            if (a.getToken().equals("String")) {
                                selector = true;
                            }else if(a.getToken().equals("int")){
                                selector = true;
                            }else{
                                selector = false;
                            }

                            //si el terminal no es el caracter simple esperado    
                        } else {

                          eh.error(a.getToken(),"No es un token esperado en esa posicion" );                           
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

                            eh.error(a.getToken(),"No es un token esperado en esa posicion" );   

                        }

                        //verificar si el terminal es un operadorl    
                    } else if (a.getClasificacion().equals("Operadores")) {

                        //System.out.println("Operadores -LLD-");
                        if (x.equals(a.getToken())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //el terminal no es un operador esperado
                        } else {
                            
                           eh.error(a.getToken(),"No es un token esperado en esa posicion" );   

                        }

                           
                    } else if (a.getClasificacion().equals("Char")) {
                        
                        
                        if (x.equals(a.getClasificacion())) {

                            //proceso para leer el siguiente elemento de la pila
                            procesoTerminal();

                            //revisar ambiguedad del error    
                        } else {
                        
                            eh.error(a.getToken(),"No es un token esperado en esa posicion" );   
                        }
                        //si el terminal no pertenece a ninguna clasificacion
                    }else{
                        
                    eh.error(a.getToken(),"No es un token reconocido por el sistema" );   

                    }

                }

            }
        } catch (Exception e) {    

           
            eh.error(a.getToken(),"Error no controlado con "+a.getClasificacion() );   

        }

        return true;
        

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
