
package Utilidades;

import Entidades.Token;
import Extras.Clasificaciones;
import Extras.ProcesosAuxiliares;

/**
 *
 * @author 
 *          Ortiz Arenas Argel
 *          11/09/2018
 * 
 * Clase parte de un conjunto mayor de clases
 * para la creacion de un analizador lexico-sintactico
 * 
 * //Analisis lexico//
 * 
 */
public class AnalizadorLexico {
    
    private final Clasificaciones c;
    private final ProcesosAuxiliares pa;
    
    //Variables a utilizar
    private Token t;
    
    
    public AnalizadorLexico(){
        c = new Clasificaciones();
        t = new Token();
        pa = new ProcesosAuxiliares();
    }
    
    /* -- Inicio del autómata manejado con métodos --
    
    Funcionamiento: El primer estado recibe todo el token completo, conforme se va leyendo
                    caracter por caracter, el token se va moviendo por los estados del autómata
                    descomponiendose símbolo por símbolo, en caso de que en algún momento no encuentre
                    a donde moverse, el token se mueve al estado de error léxico.    
    
    */
    
    public void q0(String token, Token t){
        
        this.t = t;
        int posicion = 0;
        
        
        switch (token.charAt(posicion)) {
            case '=':
                q1(token, posicion +1);
                break;
            case '+':
                q3(token, posicion +1);
                break;
            case '(':
                q4(token, posicion +1);
                break;
            case ')':
                q5(token, posicion +1);
                break;
            case ';':
                q6(token, posicion +1);
                break;
            case ',':
                q7(token, posicion +1);
                break;
            case '\'':
                q12(token, posicion +1);
                break;
            case '"':
                //linea consecuene para las cadenas
                q8(token, posicion +1);
                break;
            case '$':
                // marca de fin de archivo
                q15(token, posicion +1);
                break;
            default:
                //entrada para los id y las palabras reservadas
                q9(token, posicion );
                break;
        }
    }
    
    private void q1(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else if (posicion < token.length()) {
            
            if (token.charAt(posicion) == '=') {

                q2(token, posicion + 1);

            } else {

                t.setToken(token);
                t.setClasificacion("Error lexico");
            }
        }
        
    }
    
    private void q2(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
        }
        
    }
     
    private void q3(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
        }
        
        
    }
    
    private void q4(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
        }
    }
     
    private void q5(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
        }
        
    }
    
    private void q6(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
        }
    }
    
    private void q7(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter Simple");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
        }
        
    }
    
    private void q8(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
            
        }else if (posicion < token.length()) {
            
            if (c.isLetterMin(token.charAt(posicion))) {
                
                q8(token,posicion + 1);
                
            }else if (c.isLetterMay(token.charAt(posicion))) {
                q8(token,posicion + 1);
                
            }else if (c.isAcentMin(token.charAt(posicion))) {
                
                q8(token,posicion + 1);
                
            }else if (c.isAcentMay(token.charAt(posicion))) {
                
                q8(token,posicion + 1);
                
            }else if (c.isWhite(token.charAt(posicion))) {
                
                q8(token,posicion + 1);
                
            } else if (token.charAt(posicion) == ':') {
                
                q8(token,posicion + 1);
                
            } else if (token.charAt(posicion) == '?') {
                
                q8(token,posicion + 1);
                
                
            }else if (token.charAt(posicion) == '"') {
                
                q13(token, posicion +1);
                
            }else{
                
                
                t.setToken(token);
                t.setClasificacion("Error lexico");
            }
        }
        
    }
        
      
    
    
    private void q9(String token, int posicion){
        
       if (posicion == token.length()) {
            
           // al no haber consumido palabras y estar en el fin del
           //token, significa que es una entrada completamente vacia
           // nota: poco probable
            t.setToken(token);
            t.setClasificacion("Error lexico");
            
            
        }else if (posicion < token.length()){
            
            //minusculas para los id y algunas reservadas
            if (c.isLetterMin(token.charAt(posicion))) {
            
                q10(token,posicion + 1);
            
            //mayusculas solamente para reservadas
            }else if (c.isLetterMay(token.charAt(posicion))) {
               
                q14(token, posicion +1);
                
           }else{
            
                t.setToken(token);
                t.setClasificacion("Error lexico");
            
            }
        } 
        
    }
       
       
   
    private void q10(String token, int posicion){
        
        if (posicion == token.length()) {
            
            if (pa.verificarGuion(token)) {
                
                t.setToken(token);
                t.setClasificacion("Id");
                
            }else{
                if (c.isReservada(token)) {
                    
                    t.setToken(token);
                    t.setClasificacion("Reservada");
                    
                }else{
                    
                    t.setToken(token);
                    t.setClasificacion("Id");
                
                }
            
            }
            
            
        }else if (posicion < token.length()){
           
             if (c.isLetterMin(token.charAt(posicion))) {
            
                q10(token,posicion + 1);
            
            }else if (c.isLetterMay(token.charAt(posicion))) {
            
                q10(token,posicion + 1);
            
            }else if ('_' == token.charAt(posicion)) {
            
                q11(token,posicion + 1);
            
            } else {
            
                t.setToken(token);
                t.setClasificacion("Error lexico");
            
            }
        }
            
        
    }
        
    
    
   
    private void q11(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
            
            
        }else if (posicion < token.length()){
            
            
            if (c.isLetterMin(token.charAt(posicion))) {
            
                q10(token,posicion + 1);
            
            }else if (c.isLetterMay(token.charAt(posicion))) {
            
                q10(token,posicion + 1);
            
            }else{
                
                t.setToken(token);
                t.setClasificacion("Error lexico");
                
            }
        }
               
        
    }
    
    private void q12(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Caracter simple");
            
        }else{
            
            if (c.isLetterMin(token.charAt(posicion))) {
                
                q16(token,posicion + 1);
            }else if (c.isLetterMay(token.charAt(posicion))) {
                
                 q16(token,posicion + 1);
                
            }else{
            
            t.setToken(token);
            t.setClasificacion("Error lexico");
            
            }
        }
        
    }
    
   
    private void q13(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("cadena");
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error Lexico");
            
        }
        
    }
    
    private void q14(String token, int posicion){
        
        if (posicion == token.length()) {
            
            if (c.isReservada(token)) {
                
                t.setToken(token);
                t.setClasificacion("Reservada");
            }else{
                
                t.setToken(token);
                t.setClasificacion("Error Lexico");
            }
            
            
        }else{
            
            if (c.isLetterMin(token.charAt(posicion))) {
                
                q14(token, posicion +1);
            }else{
                
                t.setToken(token);
                t.setClasificacion("Error Lexico");
                
            }
            
        }
    }
    
    private void q15(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Reservada");
            
                
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error Lexico");
            
        }
    }
    
    
    public void q16(String token, int posicion){
        
        if (posicion == token.length()) {
            
            t.setToken(token);
            t.setClasificacion("Error Lexico");
            
        }else{
        
            if (token.charAt(posicion) == '\'') {
                
                q17(token, posicion +1);
            
            }else{
            
                t.setToken(token);
                t.setClasificacion("Error Lexico");
            
            
        }
        
        }
        
    
    }
    
    public void q17(String token, int posicion){
        
        if (posicion == token.length()) {
            
            
            t.setToken(token);
            t.setClasificacion("Char");
            
            
        }else{
            
            t.setToken(token);
            t.setClasificacion("Error Lexico");
            
        }
        
    }
}
