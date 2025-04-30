/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    JLabel etiq1;
    JLabel etiq2;
    JLabel etiq3;
    JLabel etiq4;

    public Menu() {
        setLayout(new GridLayout(4, 1)); // o cualquier layout que prefieras

        etiq1 = new JLabel("Etiqueta1",100);
        etiq1.setFont(new Font("Italic",Font.BOLD,50));

        etiq2 = new JLabel("Etiqueta2");
        etiq2.setFont(new Font("Helvetica", Font.BOLD, 100));

        Icon imagen = new ImageIcon("javalogo.gif");
        etiq3 = new JLabel("Etiqueta3", imagen, SwingConstants.CENTER);
        etiq3.setVerticalTextPosition(SwingConstants.TOP);

        etiq4 = new JLabel("Etiqueta4", SwingConstants.RIGHT);

        add(etiq1);
        add(etiq2);
        add(etiq3);
        add(etiq4);
    }
}


