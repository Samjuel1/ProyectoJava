/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMixta extends JFrame {

    private JLabel etiqueta;  // Declaramos la etiqueta como atributo

    public VentanaMixta() {
        setTitle("Ventana con etiquetas y botón");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear una etiqueta
        etiqueta = new JLabel("Texto inicial");
        add(etiqueta);

        // Crear botón
        JButton boton = new JButton("Cambiar texto");
        add(boton);

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("¡Texto cambiado!");
            }
        });
    }
}
