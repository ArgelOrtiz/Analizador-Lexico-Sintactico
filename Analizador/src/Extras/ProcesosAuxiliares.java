package Extras;

/**
 *
 * @author
 *
 * Ortiz Arenas Argel 16/09/2018
 *
 * Clase que adopta procesos que no coinciden entre si y son necesarios
 * esporadicamente en algunas clases principales o secundarias
 */
public class ProcesosAuxiliares {

    public ProcesosAuxiliares() {

    }

    public boolean verificarGuion(String palabra) {          // Verifica si existe un guíon bajo para los identificadores

        for (int i = 0; i < palabra.length(); i++) {    // Recorrido de la cadena para buscar ún _

            if (palabra.charAt(i) == '_') {

                return true;
            }
        }

        return false;
    }

}
