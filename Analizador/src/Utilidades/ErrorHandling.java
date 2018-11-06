/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author argel
 */
public class ErrorHandling {
    
    public ErrorHandling(){
        
        
    }
    
    public void error(String token,String errorType){
        
        System.err.println("\"" + token + "\""+"  "+ errorType+"*");
        
        System.exit(0);
        
    }
}
