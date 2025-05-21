package proyectojava;
import Interfaz.Ventana_in_sesion;
import Interfaz.VentanaConBoton;
import Interfaz.VentanaMixta;
import Interfaz.Ventana_principal;
import Interfaz.VentanaInicio;
import Interfaz.Ventana_in_sesion;
import java.time.LocalDateTime;
import java.time.Month;
import javax.swing.*;
public class ProyectoJava {
    public static void main(String[] args) {
    //    Cliente cliente1 = new Cliente("hola@gmail","1234","Juan","651728694","1522 2727 2833 2387","12/28", "callef",4,"madrid",28732,true);
      //  System.out.println(cliente1);
        Evento e1 = new Evento("Evento Principal", "Concierto", "callef",4,"madrid",28732,LocalDateTime.of(2025, Month.MAY, 1, 10, 30),50,4.5);
        System.out.print(e1);
        //SwingUtilities.invokeLater(() -> {
           // new Interfaz.Ventana_principal().setVisible(true);
        //});
       /// SwingUtilities.invokeLater(() -> {
          ///  new VentanaConBoton().setVisible(true);
        ///});
       /// SwingUtilities.invokeLater(() -> {
          ///  new VentanaMixta().setVisible(true);
        ///});
      //  SwingUtilities.invokeLater(() -> {
        //    new VentanaInicio().setVisible(true);
        //});
        SwingUtilities.invokeLater(() -> new Ventana_in_sesion().setVisible(true));
    
    }
    
}
