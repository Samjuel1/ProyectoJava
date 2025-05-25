/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_in_sesion extends JFrame {

    private JTextField campoCorreo;
    private JPasswordField campoContrasena;

    public Ventana_in_sesion() {
        setTitle("Formulario de acceso");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ----- Panel del centro (etiquetas y campos) -----       GridLayout ignora el tamaño de campos que pongas
        JPanel panelCampos = new JPanel(new GridLayout(4, 1, 5, 50));   //Filas, colummnas, separacion filas, separacion columnas
        panelCampos.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); //Margenes por arriba, izquierda, abajo y derecha

        panelCampos.add(new JLabel("Correo:"));
        campoCorreo = new JTextField(20);
        panelCampos.add(campoCorreo);

        panelCampos.add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        panelCampos.add(campoContrasena);

        add(panelCampos, BorderLayout.CENTER);

        // ----- Panel del sur (botones) -----
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 100)); //pixeles entre botones, pixeles por encima del borde(inferior)
        JButton boton1 = new JButton("Guardar");
        JButton boton2 = new JButton("Limpiar");
        JButton boton3 = new JButton("Iniciar sesion");
        JButton boton4 = new JButton("Registrarse");

        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);

        add(panelBotones, BorderLayout.SOUTH);

        // Acción botón Guardar
        boton1.addActionListener(e -> {
            String correo = campoCorreo.getText();
            String contrasena = new String(campoContrasena.getPassword());
            JOptionPane.showMessageDialog(this,
                "Correo: " + correo + "\nContraseña: " + contrasena,
                "Datos ingresados", JOptionPane.INFORMATION_MESSAGE);
        });

        // Acción botón Limpiar
        boton2.addActionListener(e -> {
            campoCorreo.setText("");
            campoContrasena.setText("");
        });
        
        
        boton3.addActionListener(e -> {
            String correo = campoCorreo.getText();
            String contrasena = new String (campoContrasena.getText());
            if (correo.equals("") || contrasena.equals("") || contrasena.length() < 8){
                    JOptionPane.showMessageDialog(this,
                    "Por favor, introduce los datos.",
                    "Datos no introducidos", 
                    JOptionPane.INFORMATION_MESSAGE);
            }else if(!correo.endsWith("@gmail.com") || correo.endsWith("@hotmail.com")){
                JOptionPane.showMessageDialog(this, 
                "Formato inválido",
                "Por favor introduce un correo valido",
                JOptionPane.INFORMATION_MESSAGE);
            } 
            else{
                JOptionPane.showMessageDialog(this,
                "Has iniciado sesion.",
                "Inicio de sesion correcto ", 
                JOptionPane.INFORMATION_MESSAGE);
                                
            new VentanaInicio().setVisible(true);
            dispose();
            
            }
                
        });
        boton4.addActionListener(e -> {
            dispose();
            new VentanaRegistro().setVisible(true);
            
        });
        
       
        
        
        
        
        
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoCorreo.getText().equals("") || campoCorreo.getText().equals("")){
                campoCorreo.setText("hola");}
            }
        });
    }
}

