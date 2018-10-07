
package Proceso;

/**
 *
 * @author MartinCoss
 */
public class Identificadores {
    
    public Identificadores(){
        
    }
    
    public Boolean isWhite(char simbolo) {
        if (simbolo == ' ' || simbolo == '\n' || simbolo == '\t' || simbolo == '\r') {

            return true;
        } else {
            return false;
        }
    }
    
    public Boolean isPComa(char simbolo){
        if(simbolo == ';'){
            return true;
        }else{
            return false;
        }
        
    }
     public Boolean isDerivation(char simbolo){
         if(simbolo == '-'){
             return true;
         }else{
             return false;
         }
         
     }
}
