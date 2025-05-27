/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import proyectojava.Evento;
import proyectojava.GestionClientes;

/**
 *
 * @author icesa
 */
public class VentanaEventos extends JFrame{
    
        
        
        public VentanaEventos(){
        setTitle("Registrar usuario");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        
        JPanel panelEventos = new JPanel();
        panelEventos.setLayout(new BoxLayout(panelEventos,BoxLayout.Y_AXIS));
        panelEventos.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelEventos.setBorder(BorderFactory.createEmptyBorder(50, 100, 100, 100));
        
        JLabel resultados = new JLabel("Resultados");
        resultados.setFont(new Font("Arial", Font.BOLD, 50));
        panelEventos.add(resultados);
        resultados.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelEventos.add(Box.createVerticalStrut(70)); 
        
        ArrayList<Evento> eventosRecuperados = GestionClientes.cargarEventos();
        GestionClientes.crearBotonEventos(eventosRecuperados, panelEventos);
        
        add(panelEventos);
        setVisible(true);
}

  

    
}
