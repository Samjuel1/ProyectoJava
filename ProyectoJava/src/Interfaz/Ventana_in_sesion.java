/*
Ventana_in_sesion representa la ventana que usa el cliente para poder iniciar sesión en la aplicación.

Es la primera ventana que se abre al ejecutar la aplicación, el usuario puede iniciar sesión,
(así como el administrador con sus claves) para acceder a la aplicación. El cliente también puede 
registrarse desde esta ventana.
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;
import proyectojava.GestionClientes;

public class Ventana_in_sesion extends JFrame {

    private JTextField campoCorreo;
    private JPasswordField campoContrasena;

    public Ventana_in_sesion() {
        setTitle("Formulario de acceso");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(4, 1, 5, 50));   
        panelCampos.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100)); 

        panelCampos.add(new JLabel("Correo:"));
        campoCorreo = new JTextField(20);
        panelCampos.add(campoCorreo);

        panelCampos.add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        panelCampos.add(campoContrasena);

        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 100)); 
        JButton boton2 = new JButton("Limpiar");
        JButton boton3 = new JButton("Iniciar sesion");
        JButton boton4 = new JButton("Registrarse");

        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);

        add(panelBotones, BorderLayout.SOUTH);


        boton2.addActionListener(e -> {
            campoCorreo.setText("");
            campoContrasena.setText("");
        });
        
        
        boton3.addActionListener(e -> {
            if (GestionClientes.leerCorreo(campoCorreo, this) && GestionClientes.leerContraseñaSesion(campoContrasena, this)) {
                if(GestionClientes.inicioDeSesion(campoCorreo.getText(), campoContrasena.getText())) {
                    JOptionPane.showMessageDialog(this,
                    "Has iniciado sesión.",
                    "Inicio de sesión correcto",
                    JOptionPane.INFORMATION_MESSAGE);
                new VentanaInicio().setVisible(true);
                dispose();
                GestionClientes.inicio = true;
                } else {
                    JOptionPane.showMessageDialog(this,
                    "Usuario o Contraseña Incorrectos",
                    "Inicio de sesión incorrecto",
                    JOptionPane.INFORMATION_MESSAGE);
            }
}
                
        });
        boton4.addActionListener(e -> {
            dispose();
            new VentanaRegistro().setVisible(true);
            
        });
    }
}

