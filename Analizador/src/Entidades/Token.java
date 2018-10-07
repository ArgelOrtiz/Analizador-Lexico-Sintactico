/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Argel Ortiz Arenas Jose Martin Ruiz Coss Angel Cristian Alvrez
 * Trujillo
 *
 * Paerte del software que analiza si un programa escrito en un lenguaje
 * espesifico es sintactica y lexicamente correcto o no
 *
 * Con colaboracion en conjunto de:
 *
 *
 *
 */
public class Token {

    String token, clasificacion;    // Token y clasificación léxica

    public Token() {

        token = clasificacion = "";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String palabra) {
        this.token = palabra;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

}
