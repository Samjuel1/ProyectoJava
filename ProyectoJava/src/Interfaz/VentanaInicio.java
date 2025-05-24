/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {

    private JLabel etiquetaResultado;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JTextField campoTexto;
    //fsvareogbmepig

    public VentanaInicio() {
        setTitle("Ejemplo completo");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // Layout en fila

        // Etiqueta inicial
        etiquetaResultado = new JLabel("Escribe algo:");
        add(etiquetaResultado);
     

        // Campo de texto
        campoTexto = new JTextField(20); // 20 columnas de ancho
        add(campoTexto);

        // Botón
        JButton boton = new JButton("Actualizar etiqueta");
        add(boton);
        
        JButton boton2 = new JButton("Borrar");
        add(boton2);
               
        etiqueta2 = new JLabel("Has escrito:");
        add(etiqueta2);
        etiqueta3 = new JLabel("");
        add(etiqueta3);

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText(); // obtener texto del campo
                etiqueta3.setText(texto);    // actualizar la etiqueta
            }
        });
        
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");
            }
        });
    }
}

