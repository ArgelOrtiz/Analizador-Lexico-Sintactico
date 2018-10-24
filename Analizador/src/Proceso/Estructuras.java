package Proceso;

public class Estructuras {

    String[] gramatica, simbolNT, simbolT, producciones, auxP, auxNT, auxG, auxT;

    int contNT, contG, contT, contP;

    public Estructuras() {
        simbolNT = new String[1];
        gramatica = new String[1];
        simbolT = new String[1];
        producciones = new String[1];

        contNT = 0;
        contG = 0;
        contT = 0;
    }

    public void addGramatica(String linea) {
        auxG = gramatica;

        //si es la primera linea a ingresar
        if (gramatica[0] == null && contG == 0) {

            gramatica[0] = linea;
            contG++;

            //a partir de la segunda, redimencionar y agregar
        } else {

            //se utiliza el arreglo auxiliar y se aumenta el tamaño del principal
            auxG = gramatica;
            gramatica = new String[auxG.length + 1];

            //se regresan los valores al principal
            for (int i = 0; i < auxG.length; i++) {

                gramatica[i] = auxG[i];
            }

            gramatica[contG] = linea;

            contG++;

        }

    }

    public String[] getGramatica() {

        return gramatica;
    }

    public void addSimboloNT(String token) {

        boolean existSimbol = true;
        auxNT = simbolNT;

        if (simbolNT[0] == null && contNT == 0) {
            simbolNT[0] = token;

            contNT++;

        } else {

            for (int i = 0; i < simbolNT.length; i++) {

                if (simbolNT[i].equals(token)) {
                    existSimbol = true;
                    break;
                } else {
                    existSimbol = false;
                }
            }

            if (!existSimbol) {

                try {
                    auxNT = simbolNT;
                    simbolNT = new String[auxNT.length + 1];

                    for (int i = 0; i < auxNT.length; i++) {
                        simbolNT[i] = auxNT[i];

                    }

                    simbolNT[contNT] = token;

                    contNT++;
                } catch (Exception e) {

                }

            }

        }

    }

    public String[] getSimbolsNT() {
        return simbolNT;
    }

    public void addSimbolosT(String token) {
        boolean existSimbol = true;

        if (simbolT[0] == null && contT == 0) {

            for (int i = 0; i < simbolNT.length; i++) {

                if (token.equals(simbolNT[i])) {

                    existSimbol = true;
                    break;
                } else {

                    existSimbol = false;
                }

            }

            if (!existSimbol) {
                simbolT[0] = token;

                contT++;
            }

        } else {

            for (int i = 0; i < simbolNT.length; i++) {

                if (token.equals(simbolNT[i])) {

                    existSimbol = true;
                    break;
                } else {

                    existSimbol = false;
                }

            }

            if (!existSimbol) {

                for (int i = 0; i < simbolT.length; i++) {

                    if (token.equals(simbolT[i])) {

                        existSimbol = true;
                        break;
                    } else {

                        existSimbol = false;

                    }

                }

                if (!existSimbol) {

                    auxT = simbolT;
                    simbolT = new String[auxT.length + 1];

                    for (int i = 0; i < auxT.length; i++) {
                        simbolT[i] = auxT[i];
                    }

                    simbolT[contT] = token;
                    contT++;
                }

            }

        }

    }

    public String[] getSimbolsT() {

        return simbolT;
    }

    public void addProducciones(String line) {

        if (producciones[0] == null && contP == 0) {

            producciones[0] = line;
            contP++;

        } else {

            auxP = producciones;
            producciones = new String[auxP.length + 1];

            for (int i = 0; i < auxP.length; i++) {
                producciones[i] = auxP[i];
            }

            producciones[contP] = line;
            contP++;

        }

    }

    public String[] getProducciones() {
        return producciones;

    }

}
