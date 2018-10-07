package Extras;

/**
 *
 * @author Ortiz Arenas Argel 12/09/2018
 *
 * Clasificaciones de los recursos gramaticales necesarios para la
 * identificacion lexica
 */
public class Clasificaciones {

    private final String letterMin = "abcdefghijklmnñopqrstuvwxyz";     // Letras minúsculas para las cadenas
    private final String letterMay = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";     // Letras mayúsculas para las cadenas
    private final String acentMin = "áéíóú";                            // Vocales minúsculas para las cadenas
    private final String acentMay = "ÁÉÍÓÚ";                            // Vocales mayúsculas para las cadenas
    private final String[] reservadas = {"Iniciar", "Finalizar", "Variables", "int", "String", "do", "while", "printf","captura", "$"};   // Palabras reservadas
    private final String comillaDoble = "\"";                           // Símbolos especiales permitidos

    public Clasificaciones() {

    }

    public Boolean isComillaDoble(char simbolo) {        // Comillas dobles
        return simbolo == comillaDoble.charAt(0);
    }

    public Boolean isLetterMin(char simbolo) {          // Letra minúscula

        for (int i = 0; i < letterMin.length(); i++) {
            if (simbolo == letterMin.charAt(i)) {
                return true;

            }
        }
        return false;
    }

    public Boolean isLetterMay(char simbolo) {          // Letra mayúscula

        for (int i = 0; i < letterMay.length(); i++) {
            if (simbolo == letterMay.charAt(i)) {
                return true;

            }
        }
        return false;
    }

    public Boolean isAcentMin(char simbolo) {           // Es vocal mínuscula con acento

        for (int i = 0; i < acentMin.length(); i++) {
            if (simbolo == acentMin.charAt(i)) {
                return true;

            }
        }
        return false;
    }

    public Boolean isAcentMay(char simbolo) {           // Es vocal mayúscula con acento

        for (int i = 0; i < acentMay.length(); i++) {
            if (simbolo == acentMay.charAt(i)) {
                return true;

            }
        }
        return false;
    }

    public Boolean isWhite(char simbolo) {              // Es un espacio en blanco
        if (simbolo == ' ' || simbolo == '\n' || simbolo == '\t' || simbolo == '\r') {

            return true;
        }

        return false;
    }

    public boolean isReservada(String token) {           // Es palabra reservada

        for (int i = 0; i < reservadas.length; i++) {

            if (token.equals(reservadas[i])) {

                return true;
            }

        }

        return false;
    }

}
