/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author icesa
 */
public class VentanaGestion extends JFrame{
    
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

        });
    }
    
}
