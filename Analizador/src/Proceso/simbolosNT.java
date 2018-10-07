package Proceso;

public class simbolosNT {

    String[] simbolNT, aux;
    Boolean existSimbol;
    int cont = 0;

    public simbolosNT() {
        simbolNT = new String[1];
    }

    public void addSimboloNT(String token) {

        existSimbol = true;
        aux = simbolNT;

        if (simbolNT[0] == null && cont == 0) {
            simbolNT[0] = token;
            cont++;

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
                    aux = simbolNT;
                    simbolNT = new String[aux.length + 1];

                    for (int i = 0; i < aux.length; i++) {
                        simbolNT[i] = aux[i];
                    }

                    simbolNT[cont] = token;
                    cont++;
                } catch (Exception e) {

                }

            }

        }

    }

    public String[] getSimbolsNT() {
        return simbolNT;
    }

    public static void main(String[] args) {
        simbolosNT demo = new simbolosNT();
        demo.addSimboloNT("eee");
        demo.addSimboloNT("ee2");
        demo.addSimboloNT("ee6");
        demo.addSimboloNT("e2e");
        demo.addSimboloNT("eae");
        demo.addSimboloNT("efe");
        demo.addSimboloNT("ee");

        for (int i = 0; i < demo.getSimbolsNT().length; i++) {
            System.err.println(demo.getSimbolsNT()[i]);
        }

    }
}
