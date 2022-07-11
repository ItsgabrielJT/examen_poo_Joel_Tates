package datos;
import javax.swing.*;
import java.io.*;

public class Data
{
    private static File archivo = new File("src/datos/usuarios.txt");
    private static FileWriter escribir;
    private static PrintWriter line;

    public static void crearArchivo(Object usuario) {
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                line = new PrintWriter(escribir);
                line.println(usuario);
                escribir.close();
                JOptionPane.showMessageDialog(null, "Usuario insertado con éxito");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        } else {
            try {
                escribir = new FileWriter(archivo, true);
                line = new PrintWriter(escribir);
                line.println(usuario);
                escribir.close();
                JOptionPane.showMessageDialog(null, "Usuario insertado con éxito");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        }
    }
}
