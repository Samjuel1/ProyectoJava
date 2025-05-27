package proyectojava;
import Interfaz.VentanaEventos;
import Interfaz.Ventana_in_sesion;
import java.util.HashMap;
import javax.swing.*;
import java.util.ArrayList;


public class ProyectoJava {
    public static HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
    public static ArrayList<Evento> recuperadosEventos = GestionClientes.cargarEventos();
    public static void main(String[] args) {
        System.out.println(recuperados);
        System.out.println(recuperadosEventos);
        
  //      ArrayList<Cliente> clientes = new ArrayList<>();
  //      clientes.add(new Cliente("hola@gmail","1234","Juan","651728694","juan","1522 2727 2833 2387","12/28", "callef",4,"madrid",28732,true));
  //      System.out.println(clientes);
  //      clientes.add(new Cliente("hola@gmail","1234","Juan","651728694","juan","1522 2727 2833 2387","12/28", "callef",4,"madrid",28732,true));
  //      System.out.println(clientes);
  //      GestionClientes.guardarClientes(clientes);
        //SwingUtilities.invokeLater(() -> {
           // new Interfaz.Ventana_principal().setVisible(true);
        //});
       /// SwingUtilities.invokeLater(() -> {
          ///  new VentanaConBoton().setVisible(true);
        ///});
       /// SwingUtilities.invokeLater(() -> {
          ///  new VentanaMixta().setVisible(true);
        ///});
   /*   SwingUtilities.invokeLater(() -> {
            new VentanaInicio().setVisible(true);
        });*/
        
        
     //  SwingUtilities.invokeLater(() -> new Ventana_in_sesion().setVisible(true));
     //SwingUtilities.invokeLater(() -> new VentanaGestion().setVisible(true));
     SwingUtilities.invokeLater(() -> new VentanaEventos().setVisible(true));
    
    }
    
}
