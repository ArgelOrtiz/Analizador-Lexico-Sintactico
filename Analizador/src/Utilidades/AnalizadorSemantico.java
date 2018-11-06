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
public class AnalizadorSemantico {
    
    String[][] tablaSimbolos;
    
    
    public AnalizadorSemantico(){
        
        tablaSimbolos = new String[1][2];
    }
    
    
    
    public boolean insert(String id,String type){
        String[][] aux;
        
        if (empty()) {
            
            tablaSimbolos[0][0] = id;
            tablaSimbolos[0][1] = type;
            return true;
            
             
        }else if (!find(id)) {
            
            aux = tablaSimbolos;
            tablaSimbolos = new String[tablaSimbolos.length+1][2];
            for (int i = 0; i < aux.length; i++) {
                
                tablaSimbolos[i][0] = aux[i][0];
                tablaSimbolos[i][1] = aux[i][1];
                
            }
            
            tablaSimbolos [aux.length][0] = id;
            tablaSimbolos [aux.length][1] = type;
            
            return true;
            
        }else{
            return false;
        }
        
        
    }
    
    public boolean find(String id){
        
        for (int i = 0; i < tablaSimbolos.length; i++) {
            
            if (tablaSimbolos[i].equals(id)) {
                
                return true;
            }
            
        }
           return false;
    }
    
    public boolean empty(){
        
        if (tablaSimbolos[0] == null)
            return true;
        else
            return false;
    }
    
    public String[][] getString(){
        
        return tablaSimbolos;
    }
    
    
}
