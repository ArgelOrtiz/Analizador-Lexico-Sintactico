package Scanner;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author MartinCoss
 */
public class Lector_Gramatica {

    public Lector_Gramatica() {

    }

    public File leeArch() {

        File archivoR = new File("src/Recursos Externos/Gramatica.txt");
        try {

            if ((archivoR == null) || (archivoR.getName().equals(""))) {
                JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return archivoR;
    }

}
