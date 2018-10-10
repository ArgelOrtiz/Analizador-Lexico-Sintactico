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

    public File leeArch() {
      File archivoR = null;

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
        return archivoR;
    }

    public String pruebaArch(File arch) {
        String l = "";
        if (arch != null) {
            try {
                Scanner scn = new Scanner(arch);
                while (scn.hasNext()) {
                    linea = scn.nextLine() + " ";
                    l += linea;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return l;
    }
}
