import datos.Data;

import javax.swing.*;

public class Menu {
    private static int opcion;
    private static Usuario[] lista = new Usuario[3];
    private static int maximo_usuarios = 0;

    public Menu() {
        inicializarLista();
    }

    public void mostrarVentanaPrincipal() {
        do {
            opcion = mostrarMenu();
            if (maximo_usuarios == 3) {
                JOptionPane.showConfirmDialog(null, "Capacidad maxima de usuarios Alcanzad");
            } else {
                cargarProceso();
            }
        } while (opcion != 3);
    }

    private static int mostrarMenu() {
        int opcion_ventana = JOptionPane.showOptionDialog(null,
                mostrarMensajePrincipal(),
                "Cajero Pacifico",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Ingresar Usuario", "Retirar dinero", "Ingresar Dinero", "Salir"},
                null);
        return opcion_ventana;
    }

    private static String mostrarMensajePrincipal() {
        return " ---- B I E N V E N I D O ----" +
                "\n Escoga cualquiera de las opciones";
    }

    private static void cargarProceso() {
        switch (opcion) {
            case 0:
                ingresarUsuario();
                break;
            case 1:
                retirarDinero();
                break;
            case 2:

        }
    }

    private static void ingresarUsuario() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre: ");
        String apellido = JOptionPane.showInputDialog(null, "Apellido: ");
        String cedula = JOptionPane.showInputDialog(null, "Cedula: ");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad: "));
        double dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Dinero: "));
        lista[maximo_usuarios] = new Usuario(nombre, apellido, cedula, edad, dinero);
        Data.crearArchivo(lista[maximo_usuarios]);
        maximo_usuarios++;
    }

    private static void retirarDinero() {
        String cedula = JOptionPane.showInputDialog(null, "Cedula: ");
        for (Usuario u : lista) {
            if (cedula.equals(u.getCedula())) {
                JOptionPane.showConfirmDialog(null, mostrarDatos(cedula));
                double retiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Retirar: "));
                u.setDinero(u.getDinero() - retiro);
                JOptionPane.showConfirmDialog(null, "Retiro correcto\n" + "Saldo REstante: " + u.getDinero());
                break;
            } else {
                JOptionPane.showConfirmDialog(null, "Ninguna coincidencia");
                break;
            }
        }
    }

    private static String mostrarDatos(String cedula) {
        String mensaje = " ";
        for (int j = 0; j < lista.length; j++) {
            if (cedula.equals(lista[j].getCedula())) {
                mensaje = lista[j].getNombre() + " " + lista[j].getApellido() +
                        "\n" + lista[j].getEdad() + "\n" + lista[j].getDinero() + "\n";
                break;
            } else {
                mensaje = "Usuario no existente";
                break;
            }
        }
        return mensaje;
    }

    private static void inicializarLista() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new Usuario("", "", "", 0, 0.0);
        }
    }
}
