package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import proyectojava.Cliente;
import proyectojava.GestionClientes;
import static proyectojava.GestionClientes.*;

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
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new BoxLayout(panelBusqueda,BoxLayout.Y_AXIS));
        panelBusqueda.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        
        JLabel buscar = new JLabel("Buscar eventos");
        buscar.setFont(new Font("Arial", Font.BOLD, 40));
        panelBusqueda.add(buscar);
        panelBusqueda.add(Box.createVerticalStrut(70)); 
        campoBusqueda = new JTextField();
        campoBusqueda.setMaximumSize(campoBusqueda.getPreferredSize());
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(Box.createVerticalStrut(70)); 
        JLabel otros = new JLabel("Eventos destacados: ");
        otros.setFont(new Font("Arial", Font.BOLD,35));
        panelBusqueda.add(otros);
        panelBusqueda.add(Box.createVerticalStrut(30));
        JButton botonevento1 = new JButton("Evento 1: Concierto bernabeu            Calificacion: 5");
        botonevento1.setFont(new Font("Arial", Font.BOLD,30));
        botonevento1.setBackground(Color.WHITE);
        botonevento1.setHorizontalAlignment(SwingConstants.LEFT);
        panelBusqueda.add(botonevento1);
        JButton botonevento2 = new JButton("Evento 2: concierto en mi casa          Calificaion: 4");
        botonevento2.setFont(new Font("Arial", Font.BOLD,30));
        botonevento2.setBackground(Color.WHITE);
        botonevento2.setHorizontalAlignment(SwingConstants.LEFT);

        panelBusqueda.add(botonevento2);
        
        
        
        
         
        
        buscar.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoBusqueda.setAlignmentX(Component.CENTER_ALIGNMENT);
        otros.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonevento1.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonevento2.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        campoBusqueda.setMaximumSize(new Dimension(600, 40));
        campoBusqueda.setPreferredSize(new Dimension(600, 40));
        
        botonevento1.setMaximumSize(new Dimension(800, 70));
        botonevento1.setPreferredSize(new Dimension(800, 70));
        
        botonevento2.setMaximumSize(new Dimension(800, 70));
        botonevento2.setPreferredSize(new Dimension(800, 70));
        
        

        
        
      //  panelBuscarEvento.add(botonlupa);
        pestañas.addTab("Buscar eventos", panelBusqueda);
        
        
        
        prueba = false;
        if (prueba){
        JPanel panelTexto2 = new JPanel(new GridLayout(2,2));
        panelTexto2.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelTexto2.add(new JLabel("Busca aqui un evento: "));
        panelTexto2.add(botonlupa);
        pestañas.addTab("Buscar eventos", panelTexto2);
        }

        //pestaña gestion admin
        
        JPanel panelConfiguracionAdmin = new JPanel();
        panelConfiguracionAdmin.setLayout( new BoxLayout(panelConfiguracionAdmin,BoxLayout.Y_AXIS));
        panelConfiguracionAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton gestionarEvento = new JButton("Gestionar evento");
        gestionarEvento.setFont(new Font("Arial", Font.BOLD, 25));
        
        JButton consultarEvento = new JButton("Consultar eventos ");
        consultarEvento.setFont(new Font("Arial", Font.BOLD, 25));
        
        JButton consultarUsuarios = new JButton("Consultar usuarios");
        consultarUsuarios.setFont(new Font("Arial", Font.BOLD, 25));
        
        JButton consultarReservas = new JButton("Consultar reservas");
        consultarReservas.setFont(new Font("Arial", Font.BOLD, 25));
        
        gestionarEvento.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultarEvento.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultarUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        consultarReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        gestionarEvento.setMaximumSize(new Dimension(300, 100));
        gestionarEvento.setPreferredSize(new Dimension(300, 100));
        
        consultarEvento.setMaximumSize(new Dimension(300, 100));
        consultarEvento.setPreferredSize(new Dimension(300, 100));
        
        consultarUsuarios.setMaximumSize(new Dimension(300, 100));
        consultarUsuarios.setPreferredSize(new Dimension(300, 100));
        
        consultarReservas.setMaximumSize(new Dimension(300, 100));
        consultarReservas.setPreferredSize(new Dimension(300, 100));
        
        panelConfiguracionAdmin.add(Box.createVerticalGlue());       
        panelConfiguracionAdmin.add(gestionarEvento);
        panelConfiguracionAdmin.add(Box.createVerticalStrut(30));  
        panelConfiguracionAdmin.add(consultarEvento);
        panelConfiguracionAdmin.add(Box.createVerticalStrut(30)); 
        panelConfiguracionAdmin.add(consultarUsuarios);
        panelConfiguracionAdmin.add(Box.createVerticalStrut(30)); 
        panelConfiguracionAdmin.add(consultarReservas);
        panelConfiguracionAdmin.add(Box.createVerticalGlue());
        
        pestañas.addTab("Gestionar eventos", panelConfiguracionAdmin);
        
        //botones del admin
        
        gestionarEvento.addActionListener(e -> {

        });
        
        consultarEvento.addActionListener(e -> {
            JFrame ventanaUsuarios = new JFrame("Usuarios");
           // ventanaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventanaUsuarios.setSize(300, 200);
            ventanaUsuarios.setLocationRelativeTo(this); 
        /*
            ArrayList<Evento> eventosRecuperados = GestionClientes.cargarEventos();
            ArrayList<String> recuperadosArray = new ArrayList<>();

        for (Evento evento : eventosRecuperados) {
            String clave = evento.getTitulo(); // Suponiendo que existe este método
            recuperadosArray.add(clave);
            System.out.println(recuperadosArray);
            System.out.println("Clave: " + clave);
        }

        JList<String> lista = new JList<>(recuperadosArray.toArray(new String[0]));*/
        JList<String> lista = new JList<>(clientesToArray());
        JScrollPane scroll = new JScrollPane(lista);

            ventanaUsuarios.add(scroll);
            ventanaUsuarios.setVisible(true);

        });
        
        consultarUsuarios.addActionListener(e -> {
            JFrame ventanaUsuarios = new JFrame("Usuarios");
           // ventanaUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventanaUsuarios.setSize(300, 200);
            ventanaUsuarios.setLocationRelativeTo(this); 
        
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
            ArrayList<String> recuperadosArray = new ArrayList<>();
            for (String clave : recuperados.keySet()) {
            recuperadosArray.add(clave);
            System.out.println(recuperadosArray);
            System.out.println("Clave: " + clave);
            }
           JList<String> lista = new JList<>(recuperadosArray.toArray(new String[0]));  //cambiar

           JScrollPane scroll = new JScrollPane(lista);

            ventanaUsuarios.add(scroll);
            ventanaUsuarios.setVisible(true);

        });
        
        consultarReservas.addActionListener(e -> {
            JFrame ventanaUsuarios = new JFrame("Reservas");
            ventanaUsuarios.setSize(300, 200);
            ventanaUsuarios.setLocationRelativeTo(this); 
        
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
            ArrayList<String> recuperadosArray = new ArrayList<>();
            for (String clave : recuperados.keySet()) {
            recuperadosArray.add(clave);
            System.out.println(recuperadosArray);
            System.out.println("Clave: " + clave);
            }
           JList<String> lista = new JList<>(recuperadosArray.toArray(new String[0]));

           JScrollPane scroll = new JScrollPane(lista);

            ventanaUsuarios.add(scroll);
            ventanaUsuarios.setVisible(true);

        });
        
        
        
        
        
        
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
            JTextField campoContrasena = new JTextField(10);
            JTextField campoCambioContrasena = new JTextField(10);
            JTextField campoCambioContrasenaV = new JTextField(10);
            
            JPanel panelCambioContrasena = new JPanel();
            panelCambioContrasena.setLayout(new BoxLayout(panelCambioContrasena, BoxLayout.Y_AXIS));
            panelCambioContrasena.add(new JLabel("Contraseña actual: "));
            panelCambioContrasena.add(campoContrasena);          
            panelCambioContrasena.add(Box.createVerticalStrut(10));
            panelCambioContrasena.add(new JLabel("Nueva contraseña: "));
            panelCambioContrasena.add(campoCambioContrasena); 
            panelCambioContrasena.add(Box.createVerticalStrut(10));
            panelCambioContrasena.add(new JLabel("Repetir nueva contraseña: "));
            panelCambioContrasena.add(campoCambioContrasenaV); 
            
            int resultadoC = JOptionPane.showConfirmDialog(this, panelCambioContrasena, "Cambio de contraseña", JOptionPane.OK_CANCEL_OPTION);
            String contrasena = campoContrasena.getText();
            String nuevaContrasena = campoCambioContrasena.getText();
            String nuevaContrasenaV = campoCambioContrasenaV.getText();
            
            if (resultadoC == JOptionPane.OK_OPTION && (contrasena.isEmpty() || nuevaContrasena.isEmpty() || nuevaContrasenaV.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce los datos");
            } else{
            }
            
            
            
        
        });
        
        cambioTarjeta.addActionListener(e -> {
            JTextField campoCambioNombreT = new JTextField(10);
            JTextField campoCambioNumeroT = new JTextField(10);
            JTextField campoCambioFechaT = new JTextField(10);
            JTextField campoCambioContrasenaT = new JTextField(10);

            JPanel panelCambioTarjeta = new JPanel();
            panelCambioTarjeta.setLayout(new BoxLayout(panelCambioTarjeta, BoxLayout.Y_AXIS)); 
            panelCambioTarjeta.add(new JLabel("Tarjeta de credito"));
            panelCambioTarjeta.add(Box.createVerticalStrut(10));  
            panelCambioTarjeta.add(new JLabel("Nuevo titular de la tarjeta: "));
            panelCambioTarjeta.add(campoCambioNombreT);
            panelCambioTarjeta.add(Box.createVerticalStrut(10));  
            panelCambioTarjeta.add(new JLabel("Nuevo número de tarjeta: "));
            panelCambioTarjeta.add(campoCambioNumeroT);
            panelCambioTarjeta.add(Box.createVerticalStrut(10)); 
            panelCambioTarjeta.add(new JLabel("Nueva fecha de caducidad de tarjeta: "));
            panelCambioTarjeta.add(campoCambioFechaT);
            panelCambioTarjeta.add(Box.createVerticalStrut(10));
            panelCambioTarjeta.add(new JLabel("Contraseña: "));
            panelCambioTarjeta.add(campoCambioContrasenaT);
            
            
            int resultadoT = JOptionPane.showConfirmDialog(null, panelCambioTarjeta, "Cambio de tarjeta", JOptionPane.OK_CANCEL_OPTION);
            String nombreT = campoCambioNombreT.getText();
            String numeroT = campoCambioNombreT.getText();
            String fechaT = campoCambioNombreT.getText();
            String contrasenaT = campoCambioContrasenaT.getText();
            
            if (resultadoT == JOptionPane.OK_OPTION && (nombreT.isEmpty() || numeroT.isEmpty() || fechaT.isEmpty() || contrasenaT.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce los datos");
            } else { 
            }
        });
            
            cambioDireccion.addActionListener(e -> {
            JTextField campoCambioCalle = new JTextField(10);
            JTextField campoCambioNumero = new JTextField(10);
            JTextField campoCambioCiudad = new JTextField(10);
            JTextField campoCambioCodigo = new JTextField(10);
            JTextField campoContrasenaD = new JTextField(10);
           
            JPanel panelCambioDireccion = new JPanel();
            panelCambioDireccion.setLayout(new BoxLayout(panelCambioDireccion,BoxLayout.Y_AXIS));
            panelCambioDireccion.add(new JLabel("Nueva calle: "));
            panelCambioDireccion.add(campoCambioCalle);
            panelCambioDireccion.add(Box.createVerticalStrut(10));
            panelCambioDireccion.add(new JLabel("Nuevo número: "));
            panelCambioDireccion.add(campoCambioNumero);
            panelCambioDireccion.add(Box.createVerticalStrut(10));
            panelCambioDireccion.add(new JLabel("Nueva ciudad: "));
            panelCambioDireccion.add(campoCambioCiudad);
            panelCambioDireccion.add(Box.createVerticalStrut(10));
            panelCambioDireccion.add(new JLabel("Nuevo código: "));
            panelCambioDireccion.add(campoCambioCodigo);
            panelCambioDireccion.add(Box.createVerticalStrut(10));
            panelCambioDireccion.add(new JLabel("Contraseña: "));
            panelCambioDireccion.add(campoContrasenaD);
            
            int resultadoD = JOptionPane.showConfirmDialog(null, panelCambioDireccion, "Cambio de dirección", JOptionPane.OK_CANCEL_OPTION);
            String calle = campoCambioCalle.getText();
            String numeroD = campoCambioNumero.getText();
            String ciudad = campoCambioCiudad.getText();
            String codigo = campoCambioCodigo.getText();
            String contrasenaD = campoContrasenaD.getText();
            
            if (resultadoD == JOptionPane.OK_OPTION && (calle.isEmpty() || numeroD.isEmpty() || ciudad.isEmpty() || codigo.isEmpty() || contrasenaD.isEmpty())){
            JOptionPane.showMessageDialog(this, "Por favor, introduce los datos", "Datos no introducidos", HEIGHT);}
            
            });
            
        
        
    }}

