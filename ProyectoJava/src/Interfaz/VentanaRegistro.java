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


import java.util.ArrayList;
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
            dispose();
        });
        
        registrar.addActionListener(e -> {
            String contrasena = campoContrasena.getText();
            String telefono = campoTelefono.getText();
            String numero_tarjeta = campoNumeroT.getText();
            if (contrasena.length() < 8){
            JOptionPane.showMessageDialog(this, 
            "Contraseña inválida",
            "Por favor introduce una contraseña con al menos 8 caracteres.",
            JOptionPane.INFORMATION_MESSAGE);
            return;}
            if (telefono.length() != 9){
            JOptionPane.showMessageDialog(this, 
            "Teléfono inválido",
            "Por favor introduce una teléfono válido.",
            JOptionPane.INFORMATION_MESSAGE);
            return;}
            try{
             int numero = Integer.parseInt(campoNumero.getText());
            } catch(NumberFormatException i){
            JOptionPane.showMessageDialog(this, 
            "Número de puerta",
            "Por favor introduce un número de puerta válido.",
            JOptionPane.INFORMATION_MESSAGE);
            return;}
            
            try{
             int codigo = Integer.parseInt(campoNumero.getText());
            } catch(NumberFormatException i){
            JOptionPane.showMessageDialog(this, 
            "Número de código postal",
            "Por favor introduce un número de código postal válido.",
            JOptionPane.INFORMATION_MESSAGE);
            return;}
            if(numero_tarjeta.length() != 16){
            JOptionPane.showMessageDialog(this, 
            "Número de tarjeta inválido",
            "Por favor introduce un número de tarjeta válido.",
            JOptionPane.INFORMATION_MESSAGE);}
            
            Cliente cliente = registrarCliente();
            ArrayList<Cliente> lista = GestionClientes.cargarClientes();

    // Agregar el nuevo
            lista.add(cliente);

    // Guardar lista actualizada
            GestionClientes.guardarClientes(lista);
            System.out.println(lista);

            JOptionPane.showMessageDialog(this, "Cliente registrado y guardado.");
            new VentanaInicio().setVisible(true);
            dispose();
            

            
        });
        
 //       public guardarCliente()  {
 //           FileOutputStream fileOutputStream = new FileOutputStream("datos.txt");
 //           ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
 //           objectOutputStream.writeObject(cliente);
 //           objectOutputStream.close();}

            
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
    return new Cliente(correo, contrasena, nombre,telefono,titular_tarjeta,numero_tarjeta,fecha_caducidad,calle,numero,ciudad,codigo,false);
}
     //   public guardarCliente(){
       // ArrayLis
        //}
    


    
    
    
}
