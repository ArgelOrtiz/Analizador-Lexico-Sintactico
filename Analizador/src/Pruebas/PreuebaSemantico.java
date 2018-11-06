/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Utilidades.AnalizadorSemantico;

/**
 *
 * @author argel
 */
public class PreuebaSemantico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       AnalizadorSemantico test = new AnalizadorSemantico();
       
        System.out.println(test.insert("a","String"));
        System.out.println(test.insert("b","int"));
        System.out.println(test.insert("c","String"));
        System.out.println(test.insert("d","int"));
        System.out.println(test.insert("e","String"));
        System.out.println(test.insert("a","String"));
        
        
        String[][] aux = test.getString();
        
        for (int i = 0; i < aux.length; i++) {
            
            System.out.println(aux[i][0]);
            System.out.println(aux[i][1]);
        }
       
    }
    
    
    
}
