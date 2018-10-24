package Scanner;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MartinCoss
 */
public class Lector {

    String linea;

    File archivoR;
    File archivoG;

    public void leeArch() {

        archivoR = null;

        try {

            JFileChooser selectorArchivos = new JFileChooser();

            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto", "txt");
            selectorArchivos.setFileFilter(filtro);

            selectorArchivos.showOpenDialog(null);
            File archivo = selectorArchivos.getSelectedFile();

            if ((archivo == null) || (archivo.getName().equals(""))) {
                JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }
            archivoR = archivo;

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void leeArchG() {
        archivoG = new File("src/RecursosExternos/Gramatica.txt");

        try {

            if ((archivoG == null) || (archivoG.getName().equals(""))) {
                System.out.println("entro");
                JOptionPane.showMessageDialog(null, "Archivo de gramática inválido", "Archivo de gramática inválido", JOptionPane.ERROR_MESSAGE);

                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public String[] pruebaArch(File arch) {
        String[] prueba = new String[1];
        String[] auxP;
        String[] l = new String[2];

        int contP = 0;

        if (arch != null) {
            try {
                Scanner scn = new Scanner(arch);//Escaner de prueba

                auxP = prueba;

                while (scn.hasNext()) { // prueba
                    if (prueba[0] == null && contP == 0) {
                        prueba[0] = scn.nextLine();
                        contP++;
                    } else {
                        auxP = prueba;
                        prueba = new String[auxP.length + 1];

                        for (int i = 0; i < auxP.length; i++) {
                            prueba[i] = auxP[i];
                        }
                        prueba[contP] = scn.nextLine();
                        contP++;
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        l = prueba;
        return l;
    }

    public File getArchivoR() {

        return archivoR;
    }

    public File getArchivoG() {

        return archivoG;
    }
}
