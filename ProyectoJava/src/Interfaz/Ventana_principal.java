/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Ventana_principal extends JFrame {
    public Ventana_principal() {
        setTitle("Mi aplicación con Swing");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        Menu menu = new Menu();
        add(menu.etiq1);
        add(menu.etiq2);
        add(menu.etiq3);
        add(menu.etiq4);

    }
}

