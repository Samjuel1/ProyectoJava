/*
Clase principal que lanza la aplicación.
Contiene el método main, que es el punto de entrada del programa.
Desde aquí se inicializan las ventanas y las clases para poder iniciar la aplicación.
*/

package proyectojava;
import Interfaz.Ventana_in_sesion;
import java.util.HashMap;
import javax.swing.*;
import java.util.ArrayList;


public class ProyectoJava {
    public static HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
    public static ArrayList<Evento> recuperadosEventos = GestionClientes.cargarEventos();
    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> new Ventana_in_sesion().setVisible(true));
    
    }
    
}
