package Utilidades;

import Entidades.Token;
import Extras.Clasificaciones;
import Procesos.Lectura;

/**
 *
 * @author 
 *  Argel Ortiz Arenas
 *  Jose Martin Ruiz Coss
 *
 *  Paerte del software que analiza si un programa escrito
 *  en un lenguaje especifico es sintactica y lexicamente correcto o no
 *
 *  Con colaboracion en conjunto de:
 *  
 *  Eder Luis Beade Gomez
 *  Angel Cristian Alvrez Trujillo
 */
public class Controlador {

    Token t;
    Lectura l;
    AnalizadorLexico al;
    Clasificaciones c;
    public Controlador(Token t){
        
        this.t = t;
        l = new Lectura();
        al = new AnalizadorLexico();
        c = new Clasificaciones();
        
        
    }
    
    public void controlador(){  // Verifica si hay algo en el archivo, en caso contrario retorna solo un espacio vacío
       
        al.q0( l.metodoParche(), t);
      
    }
    
}
