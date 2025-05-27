/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author icesa
 */

import javax.swing.*;
import java.awt.*;
import proyectojava.Cliente;


import proyectojava.GestionClientes;

public class VentanaRegistro extends JFrame{
    private JTextField campoNombre;
    private JTextField campoCorreo;
    private JPasswordField campoContrasena;
    private JTextField campoTelefono;
    private JTextField campoCalle;
    private JTextField campoNumero;
    private JTextField campoCiudad;
    private JTextField campoCodigo;
    private JTextField campoNombreT;
    private JTextField campoNumeroT;
    private JTextField campoFechaT;

    public VentanaRegistro(){
        setTitle("Registrar usuario");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(14, 2, 10, 10)); 

        JButton cancelar = new JButton("Cancelar");
        JButton registrar = new JButton("Registrarse");
        
        add(new JLabel("Nombre: ",SwingConstants.CENTER));
        campoNombre = new JTextField(10);
        add(campoNombre);
        add(new JLabel("Correo: "));
        campoCorreo = new JTextField(10);
        add(campoCorreo);
        add(new JLabel("Contraseña: "));
        campoContrasena = new JPasswordField();
        add(campoContrasena);
        add(new JLabel ("Teléfono: "));
        campoTelefono = new JTextField();
        add(campoTelefono);
        add(new JLabel("Direccion"));
        add(new JLabel(""));
        add(new JLabel("Calle"));
        campoCalle = new JTextField(10);
        add(campoCalle);
        
        add(new JLabel("Número"));
        campoNumero = new JTextField(10);
        add(campoNumero);
        add(new JLabel("Ciudad:"));
        campoCiudad = new JTextField(10);
        add(campoCiudad);
        add(new JLabel("Codigo:"));
        campoCodigo = new JTextField(10);
        add(campoCodigo);
        add(new JLabel("Tarjeta"));
        add(new JLabel(""));
        add(new JLabel("NombreT"));
        campoNombreT = new JTextField(10);
        add(campoNombreT);
        add(new JLabel("Número de la tarjeta: "));
        campoNumeroT = new JTextField(10);
        add(campoNumeroT);
        add(new JLabel("Fecha de caducidad: "));
        campoFechaT = new JTextField(10);
        add(campoFechaT);
        add(cancelar);
        add(registrar);
        
        cancelar.addActionListener(e -> {
            new Ventana_in_sesion().setVisible(true);
            dispose();
        });
        
        registrar.addActionListener(e -> {

            if(GestionClientes.leerTexto(campoNombre, this, "Por favor Introduzca un nombre") && GestionClientes.leerCorreo(campoCorreo, this) && GestionClientes.leerContraseñaRegistro(campoContrasena, this) 
            && GestionClientes.leerTelefono(campoTelefono, this) && GestionClientes.leerTexto(campoCalle, this, "Por favor Introduzca una Calle") && GestionClientes.leerNumero(campoNumero, this,"Porfavor Introduzca un numero válido") 
            && GestionClientes.leerTexto(campoCiudad, this, "Por favor Introduzca un Ciudad") && GestionClientes.leerNumero(campoCodigo, this,"Porfavor Introduzca un Codigo Postal válido") 
            && GestionClientes.leerTexto(campoNombreT, this, "Por favor Introduzca un nombre") && GestionClientes.leerNumeroTarjeta(campoNumeroT, this) && GestionClientes.leerTexto(campoFechaT, this, "Por favor Introduzca una Fecha válida")){
                
                GestionClientes.agregarClienteArchivoRegistro(registrarCliente());

                JOptionPane.showMessageDialog(this, "Cliente registrado y guardado.");
                new VentanaInicio().setVisible(true);
                dispose();
            }});
            
            
    }
    
        public Cliente registrarCliente() {
            String nombre = campoNombre.getText();
            String correo = campoCorreo.getText();
            String contrasena = new String(campoContrasena.getPassword());
            String telefono = campoTelefono.getText();
            String calle = campoCalle.getText();
            int numero = Integer.parseInt(campoNumero.getText());
            String ciudad = campoCiudad.getText();
            int codigo = Integer.parseInt(campoCodigo.getText());
            String titular_tarjeta = campoNombreT.getText();
            String numero_tarjeta = campoNumeroT.getText();
            String fecha_caducidad = campoFechaT.getText();
            return new Cliente(correo, contrasena, nombre,telefono,titular_tarjeta,numero_tarjeta,fecha_caducidad,calle,numero,ciudad,codigo);
        }

}