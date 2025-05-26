/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectojava.Evento;
import proyectojava.GestionClientes;

/**
 *
 * @author icesa
 */
public class VentanaGestion extends JFrame{
    private JTextField campoAnadirTitulo;
    private JTextField campoAnadirTipo;
    private JTextField campoAnadirCalle;
    private JTextField campoAnadirNumero;
    private JTextField campoAnadirCiudad;
    private JTextField campoAnadirCp;
    private JTextField campoAnadirPrecio;
    
    public VentanaGestion(){
    setTitle("Gestión de eventos");
    setSize(1100, 700);
    setLocationRelativeTo(null); 
 //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panelVentanaGestion = new JPanel();
    panelVentanaGestion.setLayout(new BoxLayout(panelVentanaGestion,BoxLayout.X_AXIS));
    panelVentanaGestion.setAlignmentY(Component.CENTER_ALIGNMENT);
    panelVentanaGestion.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
    
    JButton anadirEvento = new JButton("Añadir evento");
    anadirEvento.setFont(new Font("Arial", Font.BOLD, 25));
    
    JButton eliminarEvento = new JButton("Eliminar evento");
    eliminarEvento.setFont(new Font("Arial", Font.BOLD, 25));
    
    JButton modificarEvento = new JButton("Modificar evento");
    modificarEvento.setFont(new Font("Arial", Font.BOLD, 25));
    
    anadirEvento.setAlignmentY(Component.CENTER_ALIGNMENT);
    eliminarEvento.setAlignmentY(Component.CENTER_ALIGNMENT);
    modificarEvento.setAlignmentY(Component.CENTER_ALIGNMENT);
    
    anadirEvento.setMaximumSize(new Dimension(300, 100));
    anadirEvento.setPreferredSize(new Dimension(300, 100));
    
    eliminarEvento.setMaximumSize(new Dimension(300, 100));
    eliminarEvento.setPreferredSize(new Dimension(300, 100));
        
    modificarEvento.setMaximumSize(new Dimension(300, 100));
    modificarEvento.setPreferredSize(new Dimension(300, 100));
    
    panelVentanaGestion.add(Box.createHorizontalGlue());       
    panelVentanaGestion.add(anadirEvento);
    panelVentanaGestion.add(Box.createHorizontalStrut(30));
    panelVentanaGestion.add(eliminarEvento);
    panelVentanaGestion.add(Box.createHorizontalStrut(30));
    panelVentanaGestion.add(modificarEvento);
    panelVentanaGestion.add(Box.createHorizontalGlue());
    
    add(panelVentanaGestion); 
    setVisible(true);   
    
    
    anadirEvento.addActionListener(e -> {
        campoAnadirTitulo = new JTextField(10);
        campoAnadirTipo = new JTextField(10);
        campoAnadirCiudad = new JTextField(10);
        campoAnadirCalle = new JTextField(10);
        campoAnadirNumero = new JTextField(10);
        campoAnadirCp = new JTextField(10);
        campoAnadirPrecio = new JTextField(10);

        JPanel panelAnadirEvento = new JPanel();
        panelAnadirEvento.setLayout(new BoxLayout(panelAnadirEvento, BoxLayout.Y_AXIS)); 
        panelAnadirEvento.add(new JLabel("Título: "));
        panelAnadirEvento.add(campoAnadirTitulo);
        panelAnadirEvento.add(Box.createVerticalStrut(10));  
        panelAnadirEvento.add(new JLabel("Tipo:"));
        panelAnadirEvento.add(campoAnadirTipo);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Ciudad:"));
        panelAnadirEvento.add(campoAnadirCiudad);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Calle:"));
        panelAnadirEvento.add(campoAnadirCalle);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Numero:"));
        panelAnadirEvento.add(campoAnadirNumero);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Codigo postal:"));
        panelAnadirEvento.add(campoAnadirCp);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Precio:"));
        panelAnadirEvento.add(campoAnadirPrecio);
  
     
        
        
        int resultado = JOptionPane.showConfirmDialog(null, panelAnadirEvento, "Cambio de contraseña", JOptionPane.OK_CANCEL_OPTION);
        String titulo = campoAnadirTitulo.getText();
        String tipo = campoAnadirCiudad.getText();
        String calle = campoAnadirCalle.getText();
        int numero = Integer.parseInt(campoAnadirNumero.getText());
        String ciudad = campoAnadirCiudad.getText();
        int cp = Integer.parseInt(campoAnadirCp.getText());
        long precio = Long.parseLong(campoAnadirPrecio.getText());
        


        
        if (resultado == JOptionPane.OK_OPTION && (titulo.isEmpty() || tipo.isEmpty() || calle.isEmpty() || ciudad.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce los datos");
        //  System.out.println(ProyectoJava.recuperados);
            } else {
            Evento evento = registrarEvento();
            ArrayList<Evento> recuperadosArrayEventos = GestionClientes.cargarEventos();
            recuperadosArrayEventos.add(evento);
            GestionClientes.guardarEventos(recuperadosArrayEventos);
            System.out.println(recuperadosArrayEventos);
            dispose();
            }

        });
    
    
        
    }
    public Evento registrarEvento(){
        String titulo = campoAnadirTitulo.getText();
        String tipo = campoAnadirCiudad.getText();
        String calle = campoAnadirCalle.getText();
        int numero = Integer.parseInt(campoAnadirNumero.getText());
        String ciudad = campoAnadirCiudad.getText();
        int cp = Integer.parseInt(campoAnadirCp.getText());
        long precio = Long.parseLong(campoAnadirPrecio.getText());
        return new Evento(titulo,tipo,calle,numero,ciudad,cp,precio,0);
        
        }
    
}
