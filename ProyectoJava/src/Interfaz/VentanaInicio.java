/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyectojava.ProyectoJava;

public class VentanaInicio extends JFrame {

    private JTextField campoBusqueda;
    private boolean prueba;
    //fsvareogbmepig

    public VentanaInicio() {
        // Configurar ventana
        setTitle("Gestión de eventos");
        setSize(1300, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        ImageIcon lupa = new ImageIcon(getClass().getResource("/resources/lupa.png"));

        JButton botonlupa = new JButton(lupa);

        // Crear el JTabbedPane
        
        JTabbedPane pestañas = new JTabbedPane();
        

        // === Pestaña 1: Texto simple ===
        JPanel panelTexto = new JPanel(new GridLayout(2,2));
        panelTexto.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelTexto.add(new JLabel("Busca aqui un evento: "));
        panelTexto.add(botonlupa);
        pestañas.addTab("Buscar eventos", panelTexto);
        
        
        
        prueba = false;
        if (prueba){
        JPanel panelTexto2 = new JPanel(new GridLayout(2,2));
        panelTexto2.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelTexto2.add(new JLabel("Busca aqui un evento: "));
        panelTexto2.add(botonlupa);
        pestañas.addTab("Buscar eventos", panelTexto2);
        }

        
        //pestaña ajustes usuario
        JPanel panelConfiguracion = new JPanel();
        panelConfiguracion.setLayout(new BoxLayout(panelConfiguracion,BoxLayout.Y_AXIS));
        panelConfiguracion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //crear botones ajustando el tamaño de las letras
        JButton cambioCorreo = new JButton("Cambiar correo");
        cambioCorreo.setFont(new Font("Arial", Font.BOLD, 25));  // Arial, negrita, tamaño 16
    //    cambioCorreo.setForeground(Color.RED);
    //    cambioCorreo.setBackground(Color.BLACK);
        
        JButton cambioContrasena = new JButton("Cambiar contraseña");
        cambioContrasena.setFont(new Font("Arial", Font.BOLD, 21));  // Arial, negrita, tamaño 16
        
        JButton cambioTarjeta = new JButton("Cambiar datos de la tarjeta");
        cambioTarjeta.setFont(new Font("Arial", Font.BOLD,15));
        
        JButton cambioDireccion = new JButton("Cambiar dirección");
        cambioDireccion.setFont(new Font("Arial", Font.BOLD,20));
        

        //alinearlos en el centro de la ventana
        cambioCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambioContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambioTarjeta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambioDireccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //ajustar el tamaño de los botones
        cambioCorreo.setMaximumSize(new Dimension(300, 100));
        cambioCorreo.setPreferredSize(new Dimension(300, 100));
        
        cambioContrasena.setMaximumSize(new Dimension(300, 100));
        cambioContrasena.setPreferredSize(new Dimension(300, 100));
        
        cambioTarjeta.setMaximumSize(new Dimension(300, 100));
        cambioTarjeta.setPreferredSize(new Dimension(300, 100));
        
        cambioDireccion.setMaximumSize(new Dimension(300, 100));
        cambioDireccion.setPreferredSize(new Dimension(300, 100));


        //ajustar espacios entre boton y boton, la primera y la ultima ajustan flexiblemente al borde superior e inferior
        panelConfiguracion.add(Box.createVerticalGlue());       
        panelConfiguracion.add(cambioCorreo);
        panelConfiguracion.add(Box.createVerticalStrut(30));  
        panelConfiguracion.add(cambioContrasena);
        panelConfiguracion.add(Box.createVerticalStrut(30)); 
        panelConfiguracion.add(cambioTarjeta);
        panelConfiguracion.add(Box.createVerticalStrut(30)); 
        panelConfiguracion.add(cambioDireccion);
        panelConfiguracion.add(Box.createVerticalGlue()); 
        
        pestañas.addTab("Configuración usuario ",panelConfiguracion);
        
        
        // === Pestaña 2: Imagen ===
        JPanel panelImagen = new JPanel();

        // Cargar imagen desde carpeta "imagenes"
        ImageIcon imagen = new ImageIcon("resources/imagen_negra.png");

        // Añadir imagen a un JLabel
        JLabel etiquetaImagen = new JLabel(imagen);

        // Añadir al panel
        panelImagen.add(etiquetaImagen);

        // Añadir pestaña
        pestañas.addTab("Logo", panelImagen);

        // Añadir JTabbedPane a la ventana
        add(pestañas);
        
        
        botonlupa.addActionListener(e -> {
            dispose();
        });
        
        cambioCorreo.addActionListener(e -> {
            JTextField campoCorreo = new JTextField(10);
            JTextField campoContrasena = new JTextField(10);

            JPanel panelCambioContrasena = new JPanel();
            panelCambioContrasena.setLayout(new BoxLayout(panelCambioContrasena, BoxLayout.Y_AXIS)); 
            panelCambioContrasena.add(new JLabel("Nuevo correo: "));
            panelCambioContrasena.add(campoCorreo);
            panelCambioContrasena.add(Box.createVerticalStrut(10));  
            panelCambioContrasena.add(new JLabel("Contraseña:"));
            panelCambioContrasena.add(campoContrasena);

            int resultado = JOptionPane.showConfirmDialog(null, panelCambioContrasena, "Cambio de contraseña", JOptionPane.OK_CANCEL_OPTION);
            String usuario = campoCorreo.getText();
            String contrasena = campoContrasena.getText();

            if (resultado == JOptionPane.OK_OPTION && (usuario.isEmpty() || contrasena.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce los datos");
        //  System.out.println(ProyectoJava.recuperados);
            } else if(resultado == JOptionPane.OK_OPTION && !usuario.isEmpty() && !contrasena.isEmpty()){
                JOptionPane.showMessageDialog(this, "Las credenciales no coinciden,\nvuelve a introducir los datos", "Datos erróneos", resultado);
            }


        });
        
        cambioContrasena.addActionListener(e -> {
            JDialog dialogo = new JDialog((Frame) null, "Formulario", true);
            dialogo.setSize(700,300);
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialogo.setLayout(new GridLayout(3, 2, 10, 10));
        
        JTextField campo1 = new JTextField(10);
        JTextField campo2 = new JTextField(10);
        //JTextField campo
        JButton botonOk = new JButton("OK");

        dialogo.add(new JLabel("Usuario:"));
        dialogo.add(campo1);
        dialogo.add(new JLabel("Contraseña:"));
        dialogo.add(campo2);
        dialogo.add(new JLabel()); // espacio vacío
        dialogo.add(botonOk);

        botonOk.addActionListener(i -> {
            String usuario = campo1.getText();
            String pass = campo2.getText();
            
            // Aquí haces lo que quieras antes de cerrar
            if (usuario.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(dialogo, "Rellena todos los campos.");
                return; // No cerrar
            }

            System.out.println("Usuario: " + usuario);
            System.out.println("Contraseña: " + pass);

            dialogo.dispose(); // Esto sí cierra el diálogo
        });

        dialogo.pack();
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);
        });
        
        cambioTarjeta.addActionListener(e -> {
            JTextField campoNombreT = new JTextField(10);
            JTextField campoNumeroT = new JTextField(10);
            JTextField campoFechaT = new JTextField(10);

            JPanel panelCambioTarjeta = new JPanel();
            panelCambioTarjeta.setLayout(new BoxLayout(panelCambioTarjeta, BoxLayout.Y_AXIS)); 
            panelCambioTarjeta.add(new JLabel("Nuevo titular de la tarjeta: "));
            panelCambioTarjeta.add(campoNombreT);
            panelCambioTarjeta.add(Box.createVerticalStrut(10));  
            panelCambioTarjeta.add(new JLabel("Nuevo número de tarjeta: "));
            panelCambioTarjeta.add(campoNumeroT);
            panelCambioTarjeta.add(Box.createVerticalStrut(10)); 
            panelCambioTarjeta.add(new JLabel("Nueva fecha de caducidad de tarjeta: "));
            panelCambioTarjeta.add(campoFechaT);
            
            int resultado = JOptionPane.showConfirmDialog(null, panelCambioTarjeta, "Cambio de tarjeta", JOptionPane.OK_CANCEL_OPTION);
            
        });
        
    }}

