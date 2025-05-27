/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import proyectojava.Evento;
import proyectojava.GestionClientes;
import static proyectojava.GestionClientes.*;

/**
 *
 * @author icesa
 */
public class VentanaGestion extends JFrame{
    private JTextField campoAnadirTitulo;
    private JTextField campoAnadirTipo;
    private JTextField campoAnadirCalle;
    private JTextField campoAnadirNumero;
    private JTextField campoAnadirCiudad;
    private JTextField campoAnadirCp;
    private JTextField campoAnadirPrecio;
    
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
        campoAnadirTitulo = new JTextField(10);
        campoAnadirTipo = new JTextField(10);
        campoAnadirCiudad = new JTextField(10);
        campoAnadirCalle = new JTextField(10);
        campoAnadirNumero = new JTextField(10);
        campoAnadirCp = new JTextField(10);
        campoAnadirPrecio = new JTextField(10);

        JPanel panelAnadirEvento = new JPanel();
        panelAnadirEvento.setLayout(new BoxLayout(panelAnadirEvento, BoxLayout.Y_AXIS)); 
        panelAnadirEvento.add(new JLabel("Título: "));
        panelAnadirEvento.add(campoAnadirTitulo);
        panelAnadirEvento.add(Box.createVerticalStrut(10));  
        panelAnadirEvento.add(new JLabel("Tipo:"));
        panelAnadirEvento.add(campoAnadirTipo);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Ciudad:"));
        panelAnadirEvento.add(campoAnadirCiudad);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Calle:"));
        panelAnadirEvento.add(campoAnadirCalle);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Numero:"));
        panelAnadirEvento.add(campoAnadirNumero);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Codigo postal:"));
        panelAnadirEvento.add(campoAnadirCp);
        panelAnadirEvento.add(Box.createVerticalStrut(10)); 
        panelAnadirEvento.add(new JLabel("Precio:"));
        panelAnadirEvento.add(campoAnadirPrecio);
  
     
        
        
        int resultado = JOptionPane.showConfirmDialog(null, panelAnadirEvento, "Añadir evento", JOptionPane.OK_CANCEL_OPTION);
        String titulo = campoAnadirTitulo.getText();
        String tipo = campoAnadirTipo.getText();
        String calle = campoAnadirCalle.getText();
        String ciudad = campoAnadirCiudad.getText();      


        
        if (resultado == JOptionPane.OK_OPTION) {
            Integer numero = leerEntero(campoAnadirNumero, this, " Error en el formato del Numero\nPor favor vuelva a introducir los datos.");
            if (numero == null) return;
            /*try{
             int numero = Integer.parseInt(campoAnadirNumero.getText());
            } catch(NumberFormatException i){
            JOptionPane.showMessageDialog(this, 
            "Error en el formato de número",
            "Por favor vuelva a introducir los datos.",
            JOptionPane.INFORMATION_MESSAGE);
            return;} */
            numero = leerEntero(campoAnadirCp, this, " Error en el formato del Codigo Postal\nPor favor vuelva a introducir los datos.");
            if (numero == null) return;
            /*
            try{
             int cp = Integer.parseInt(campoAnadirCp.getText());
            } catch(NumberFormatException i){
            JOptionPane.showMessageDialog(this, 
            "Error en el formato de código postal",
            "Por favor vuelva a introducir los datos.",
            JOptionPane.INFORMATION_MESSAGE);
            return;}*/
            Long numero2 = leerLong(campoAnadirPrecio, this, " Error en el formato del Precio\nPor favor vuelva a introducir los datos.");
            if (numero2 == null) return;
            /*
            try{
             long precio = Long.parseLong(campoAnadirPrecio.getText());
            } catch(NumberFormatException i){
            JOptionPane.showMessageDialog(this, 
            "Error en el formato de precio",
            "Por favor vuelva a introducir los datos.",
            JOptionPane.INFORMATION_MESSAGE);
            return;}*/ 
            JOptionPane.showMessageDialog(this, 
            "Evento registrado correctamente",
            "Evento registrado",
            JOptionPane.INFORMATION_MESSAGE);
            
            Evento evento = registrarEvento();
            ArrayList<Evento> recuperadosArrayEventos = GestionClientes.cargarEventos();
            recuperadosArrayEventos.add(evento);
            GestionClientes.guardarEventos(recuperadosArrayEventos);
            System.out.println(recuperadosArrayEventos);
            
            
        } else if(resultado == JOptionPane.OK_OPTION && (titulo.isEmpty() || tipo.isEmpty() || calle.isEmpty() || ciudad.isEmpty())){
        JOptionPane.showMessageDialog(this,"Datos no introducidos", "Por favor, rellene los datos", JOptionPane.INFORMATION_MESSAGE);}
        });
    
        eliminarEvento.addActionListener(e -> {
            JFrame panelEliminarEvento = new JFrame("Eliminar evento");
            JPanel panelPantallaEliminarEvento = new JPanel();
            panelPantallaEliminarEvento.setLayout(new BoxLayout(panelPantallaEliminarEvento, BoxLayout.Y_AXIS));
            panelEliminarEvento.setSize(300, 200);
            panelEliminarEvento.setLocationRelativeTo(this); 
            
        
            ArrayList<Evento> eventosRecuperados = GestionClientes.cargarEventos();
            ArrayList<String> recuperadosArray = new ArrayList<>();
            

        for (Evento evento : eventosRecuperados) {
            String clave = evento.getTitulo(); 
            recuperadosArray.add(clave);
            System.out.println(recuperadosArray);
            System.out.println("Clave: " + clave);
        }

        JList<String> lista = new JList<>(recuperadosArray.toArray(new String[0]));
        JScrollPane scroll = new JScrollPane(lista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    int index = lista.locationToIndex(event.getPoint());
                    if (index >= 0) {
                        Evento seleccionado = eventosRecuperados.get(index);
                                              
                        panelPantallaEliminarEvento.add(new JLabel("¿Estás seguro que deseas eliminar el evento " + seleccionado.getTitulo() + '?'));
                        
                        int resultado = JOptionPane.showConfirmDialog(null, panelPantallaEliminarEvento, "Eliminar evento", JOptionPane.OK_CANCEL_OPTION);
                        
                        if (resultado == JOptionPane.OK_OPTION){ eventosRecuperados.remove(seleccionado);
                        GestionClientes.guardarEventos(eventosRecuperados);
                        panelPantallaEliminarEvento.removeAll();
                        panelEliminarEvento.dispose();
                        } else if (resultado == JOptionPane.CANCEL_OPTION){panelPantallaEliminarEvento.removeAll();}
                    }
                }
            }
        });

            panelEliminarEvento.add(scroll);
            panelEliminarEvento.setVisible(true);

          });
        
        modificarEvento.addActionListener(e -> {
            JFrame panelModificarEvento = new JFrame("Modificar evento");
            JPanel panelPantallaModificarEvento = new JPanel();
            panelPantallaModificarEvento.setLayout(new BoxLayout(panelPantallaModificarEvento, BoxLayout.Y_AXIS)); 
            panelModificarEvento.setSize(300, 200);
            panelModificarEvento.setLocationRelativeTo(this); 
            
            
        
            ArrayList<Evento> eventosRecuperados = GestionClientes.cargarEventos();
            ArrayList<String> recuperadosArray = new ArrayList<>();

        for (Evento evento : eventosRecuperados) {
            String clave = evento.getTitulo(); 
            recuperadosArray.add(clave);
        }

        JList<String> lista = new JList<>(recuperadosArray.toArray(new String[0]));
        JScrollPane scroll = new JScrollPane(lista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    int index = lista.locationToIndex(event.getPoint());
                    if (index >= 0) {
                        Evento seleccionado = eventosRecuperados.get(index);
                        
                        panelPantallaModificarEvento.removeAll();

                        JTextField campoModificarTitulo = new JTextField(seleccionado.getTitulo());
                        JTextField campoModificarTipo = new JTextField(seleccionado.getTipo());
                        JTextField campoModificarCalle = new JTextField(seleccionado.getDireccion().calle);
                        JTextField campoModificarNumero = new JTextField(String.valueOf(seleccionado.getDireccion().numero));
                        JTextField campoModificarCiudad = new JTextField(seleccionado.getDireccion().ciudad);
                        JTextField campoModificarCp = new JTextField(String.valueOf(seleccionado.getDireccion().cp));
                        JTextField campoModificarPrecio = new JTextField(String.valueOf(seleccionado.getPrecio()));
                        panelPantallaModificarEvento.add(new JLabel("Título: "));
                        panelPantallaModificarEvento.add(campoModificarTitulo);
                        panelPantallaModificarEvento.add(Box.createVerticalStrut(10));
                        panelPantallaModificarEvento.add(new JLabel("Tipo: "));
                        panelPantallaModificarEvento.add(campoModificarTipo);
                        panelPantallaModificarEvento.add(Box.createVerticalStrut(10));
                        panelPantallaModificarEvento.add(new JLabel("Calle: "));
                        panelPantallaModificarEvento.add(campoModificarCalle);
                        panelPantallaModificarEvento.add(Box.createVerticalStrut(10));
                        panelPantallaModificarEvento.add(new JLabel("Numero: "));
                        panelPantallaModificarEvento.add(campoModificarNumero);
                        panelPantallaModificarEvento.add(Box.createVerticalStrut(10));
                        panelPantallaModificarEvento.add(new JLabel("Ciudad: "));
                        panelPantallaModificarEvento.add(campoModificarCiudad);
                        panelPantallaModificarEvento.add(Box.createVerticalStrut(10));
                        panelPantallaModificarEvento.add(new JLabel("Código postal: "));
                        panelPantallaModificarEvento.add(campoModificarCp);
                        panelPantallaModificarEvento.add(Box.createVerticalStrut(10));
                        panelPantallaModificarEvento.add(new JLabel("Precio: "));
                        panelPantallaModificarEvento.add(campoModificarPrecio);
                        
                        int resultado = JOptionPane.showConfirmDialog(null, panelPantallaModificarEvento, "Modificar evento", JOptionPane.OK_CANCEL_OPTION);
                        
                        if (resultado == JOptionPane.OK_OPTION){
                        String tituloModificado = campoModificarTitulo.getText();
                        String tipoModificado = campoModificarTipo.getText();
                        String calleModificada = campoModificarCalle.getText();
                        int numeroModificado = Integer.parseInt(campoModificarNumero.getText());
                        String ciudadModificada = campoModificarCiudad.getText();
                        int cpModificado = Integer.parseInt(campoModificarCp.getText());
                        long precioModificado = Long.parseLong(campoModificarPrecio.getText());
                        
                        
                        seleccionado.setTitulo(tituloModificado);
                        seleccionado.setTipo(tipoModificado);
                        seleccionado.getDireccion().setCalle(calleModificada);
                        seleccionado.getDireccion().setNumero(numeroModificado);
                        seleccionado.getDireccion().setCiudad(ciudadModificada);
                        seleccionado.getDireccion().setCp(cpModificado);
                        seleccionado.setPrecio(precioModificado);

                        
                        GestionClientes.guardarEventos(eventosRecuperados);
                        panelPantallaModificarEvento.removeAll();

                        }else if(resultado == JOptionPane.CANCEL_OPTION){panelPantallaModificarEvento.removeAll();}
                    }
                }
            }
        });

            panelModificarEvento.add(scroll);
            panelModificarEvento.setVisible(true);

          });
    
        
    }
    
    
    
    
    
    
    public Evento registrarEvento(){
        String titulo = campoAnadirTitulo.getText();
        String tipo = campoAnadirTipo.getText();
        String calle = campoAnadirCalle.getText();
        int numero = Integer.parseInt(campoAnadirNumero.getText());
        String ciudad = campoAnadirCiudad.getText();
        int cp = Integer.parseInt(campoAnadirCp.getText());
        long precio = Long.parseLong(campoAnadirPrecio.getText());
        return new Evento(titulo,tipo,calle,numero,ciudad,cp,precio,0);
        
        }
    
}
