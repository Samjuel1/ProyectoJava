/*
VentanaInicio representa la ventana que usa el cliente para poder navegar por la página.

Está formada por fichas, por las que el cliente puede moverse para buscar eventos, así como comprar sus entradas,
publicar reseñas, ver estas mismas, y consultar sus reservas. 
El usuario también puede realizar cambios en sus datos de perfil.


*/
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import proyectojava.Cliente;
import proyectojava.Evento;
import proyectojava.GestionClientes;
import static proyectojava.GestionClientes.*;
import proyectojava.Reservas;
import proyectojava.Reseña;

public class VentanaInicio extends JFrame {

    private JTextField campoBusqueda;
    private boolean prueba;

    public VentanaInicio() {
        setTitle("Gestión de eventos");
        setSize(1300, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        ImageIcon lupa = new ImageIcon(getClass().getResource("/resources/lupa.png"));
        Image lupaimagenredimensionada = lupa.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoredimensionado = new ImageIcon(lupaimagenredimensionada);
        JButton botonlupa = new JButton(iconoredimensionado);
        
        botonlupa.setBorderPainted(false);
        botonlupa.setContentAreaFilled(false);
        botonlupa.setFocusPainted(false);
        botonlupa.setOpaque(false);
        
        ImageIcon filtros = new ImageIcon(getClass().getResource("/resources/filtros.png"));
        Image filtrosimagenredimensionada = filtros.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon filtroiconoredimensionado = new ImageIcon(filtrosimagenredimensionada);
        JButton botonfiltro = new JButton(filtroiconoredimensionado);
        
        botonfiltro.setBorderPainted(false);
        botonfiltro.setContentAreaFilled(false);
        botonfiltro.setFocusPainted(false);
        botonfiltro.setOpaque(false);
        
        JTabbedPane pestañas = new JTabbedPane();

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new BoxLayout(panelBusqueda,BoxLayout.Y_AXIS));
        panelBusqueda.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        
        JLabel buscar = new JLabel("Buscar eventos");
        buscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 40));
        panelBusqueda.add(buscar);
        panelBusqueda.add(Box.createVerticalStrut(50)); 
        campoBusqueda = new JTextField();
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(Box.createVerticalStrut(20)); 
        panelBusqueda.add(botonlupa);
        panelBusqueda.add(Box.createVerticalStrut(5)); 
        panelBusqueda.add(botonfiltro);
        
        panelBusqueda.add(Box.createVerticalStrut(30));
        JLabel otros = new JLabel("Eventos destacados: ");
        otros.setFont(new Font("Arial", Font.BOLD,35));
        panelBusqueda.add(otros);
        panelBusqueda.add(Box.createVerticalStrut(30));
        
        ArrayList<Evento> eventosRecuperados_botones = GestionClientes.cargarEventos();
        GestionClientes.ordenacionPorCalificacion(eventosRecuperados_botones);
        GestionClientes.crearBotonEventos(eventosRecuperados_botones, panelBusqueda);
    
        botonlupa.addActionListener(e -> {
            new VentanaEventos().setVisible(true);

        });
        
        botonfiltro.addActionListener(e -> {
            new VentanaEventos().setVisible(true);

        });
        
        buscar.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoBusqueda.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonlupa.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonfiltro.setAlignmentX(Component.CENTER_ALIGNMENT);
        otros.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        campoBusqueda.setMaximumSize(new Dimension(600, 40));
        campoBusqueda.setPreferredSize(new Dimension(600, 40));

        pestañas.addTab("Buscar eventos", panelBusqueda);
        
        
        
        prueba = false;
        if (prueba){
        JPanel panelTexto2 = new JPanel(new GridLayout(2,2));
        panelTexto2.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelTexto2.add(new JLabel("Busca aqui un evento: "));
        panelTexto2.add(botonlupa);
        pestañas.addTab("Buscar eventos", panelTexto2);
        }

        if(admin){
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
            new VentanaGestion().setVisible(true);

        });
        
        consultarEvento.addActionListener(e -> {
            JFrame panelConsultarEvento = new JFrame("Consultar eventos");
            JPanel panelPantallaConsultarEvento = new JPanel();
            panelPantallaConsultarEvento.setLayout(new BoxLayout(panelPantallaConsultarEvento, BoxLayout.Y_AXIS));
            panelConsultarEvento.setSize(300, 200);
            panelConsultarEvento.setLocationRelativeTo(this); 

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
        lista.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent event) {
                    if (event.getClickCount() == 2) {
                      int index = lista.locationToIndex(event.getPoint());
                        if (index >= 0) {
                           Evento seleccionado = eventosRecuperados.get(index);
                           
                           JOptionPane.showMessageDialog(null,"Nombre: " + seleccionado.getTitulo() + "\n"
                                   + "Tipo: " + seleccionado.getTipo() + "\nCiudad: " + seleccionado.getDireccion().getCiudad() + "\n"
                                   + "Calle: " + seleccionado.getDireccion().getCalle() + "\nNúmero: " + seleccionado.getDireccion().getNumero() + "\n"
                                   + "Código postal: " + seleccionado.getDireccion().getCp() + "\nPrecio: " + seleccionado.getPrecio() + "\n"
                                   + "Calificación: " + seleccionado.getCalificacion(),"Consultar evento: " + seleccionado.getTitulo() ,JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
});

            panelConsultarEvento.add(scroll);
            panelConsultarEvento.setVisible(true);

        });
        
        consultarUsuarios.addActionListener(e -> {
            JFrame panelConsultarUsuarios = new JFrame("Usuarios");
            JPanel panelPantallaConsultarUsuarios = new JPanel();
            panelPantallaConsultarUsuarios.setLayout(new BoxLayout(panelPantallaConsultarUsuarios, BoxLayout.Y_AXIS));
            panelConsultarUsuarios.setSize(300, 200);
            panelConsultarUsuarios.setLocationRelativeTo(this); 

            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
            ArrayList<Cliente> recuperadosArray = new ArrayList<>(recuperados.values());

            String[] nombresClientes = recuperadosArray.stream()
            .map(cliente -> cliente.getCorreo()) 
            .toArray(String[]::new);

            JList<String> lista = new JList<>(nombresClientes);
            JScrollPane scroll = new JScrollPane(lista);
            lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


            lista.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent event) {
                    if (event.getClickCount() == 2) {
                      int index = lista.locationToIndex(event.getPoint());
                        if (index >= 0) {
                           Cliente seleccionado = recuperadosArray.get(index);
                           
                           JOptionPane.showMessageDialog(null,"Nombre: " + seleccionado.getNombre() + "\nCorreo: " + seleccionado.getCorreo() + "\n"
                                   + "Teléfono: " + seleccionado.getTelefono() + "\nCiudad: " + seleccionado.getDireccion().getCiudad() + "\n"
                                   + "Calle: " + seleccionado.getDireccion().getCalle() + "\nNúmero: " + seleccionado.getDireccion().getNumero() + "\n"
                                   + "Código postal: " + seleccionado.getDireccion().getCp(), "Consultar: " + seleccionado.getNombre(), JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }
});

                           panelConsultarUsuarios.add(scroll);
                           panelConsultarUsuarios.setVisible(true);
        
        });
 
        consultarReservas.addActionListener(e -> {
            JFrame panelConsultarReservas = new JFrame("Reservas");
            JPanel panelPantallaConsultarReservas = new JPanel();
            panelPantallaConsultarReservas.setLayout(new BoxLayout(panelPantallaConsultarReservas, BoxLayout.Y_AXIS));
            panelConsultarReservas.setSize(300, 200);
            panelConsultarReservas.setLocationRelativeTo(this); 
        
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
            ArrayList<String> recuperadosArray = new ArrayList<>();
            for (String clave : recuperados.keySet()) {
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
                           //Cliente seleccionado = recuperadosArray.get(index);
                           
                           JOptionPane.showMessageDialog(null,"Nombre: ","titulo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
});
            panelConsultarReservas.add(scroll);
            panelConsultarReservas.setVisible(true);

        });
             
        }
        
        JPanel panelMisReservas = new JPanel();
        panelMisReservas.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelMisReservas.setLayout(new BoxLayout(panelMisReservas, BoxLayout.Y_AXIS));
        JLabel misReservas = new JLabel("Mis reservas");
        misReservas.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,50));
        misReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMisReservas.add(misReservas);
        panelMisReservas.add(Box.createVerticalStrut(100));
        

        ArrayList<Reservas> listaReservas = usuarioActivo.getListaReservas();
        crearBotonReservas(listaReservas,panelMisReservas);
        
           
        pestañas.addTab("Mis reservas", panelMisReservas);
        add(pestañas);
        
        JPanel panelMisResenas = new JPanel();
        panelMisResenas.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelMisResenas.setLayout(new BoxLayout(panelMisResenas, BoxLayout.Y_AXIS));
        JLabel misResenas = new JLabel("Mis reseñas");
        misResenas.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,50));
        misResenas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelMisResenas.add(misResenas);
        panelMisResenas.add(Box.createVerticalStrut(100));
        
        ArrayList<Reseña> listaReseñas = usuarioActivo.getListaReseñas();
        crearBotonReseñas(listaReseñas,panelMisResenas);
        
        pestañas.addTab("Mis reseñas", panelMisResenas);
        add(pestañas);
        
        JPanel panelConfiguracion = new JPanel();
        panelConfiguracion.setLayout(new BoxLayout(panelConfiguracion,BoxLayout.Y_AXIS));
        panelConfiguracion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton cambioCorreo = new JButton("Cambiar correo");
        cambioCorreo.setFont(new Font("Arial", Font.BOLD, 25));  

        JButton cambioContrasena = new JButton("Cambiar contraseña");
        cambioContrasena.setFont(new Font("Arial", Font.BOLD, 21));  
        
        JButton cambioTarjeta = new JButton("Cambiar datos de la tarjeta");
        cambioTarjeta.setFont(new Font("Arial", Font.BOLD,15));
        
        JButton cambioDireccion = new JButton("Cambiar dirección");
        cambioDireccion.setFont(new Font("Arial", Font.BOLD,20));
        
        cambioCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambioContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambioTarjeta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cambioDireccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        cambioCorreo.setMaximumSize(new Dimension(300, 100));
        cambioCorreo.setPreferredSize(new Dimension(300, 100));
        
        cambioContrasena.setMaximumSize(new Dimension(300, 100));
        cambioContrasena.setPreferredSize(new Dimension(300, 100));
        
        cambioTarjeta.setMaximumSize(new Dimension(300, 100));
        cambioTarjeta.setPreferredSize(new Dimension(300, 100));
        
        cambioDireccion.setMaximumSize(new Dimension(300, 100));
        cambioDireccion.setPreferredSize(new Dimension(300, 100));

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
               
        botonlupa.addActionListener(e -> {
        });
        if(!admin){
        cambioCorreo.addActionListener(e -> {
            JTextField campoCorreo = new JTextField(10);
            JTextField campoContrasena = new JTextField(10);
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();

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

            } else if(resultado == JOptionPane.OK_OPTION && !usuario.isEmpty() && !contrasena.isEmpty()){
                if (contrasena.equals(usuarioActivo.getContrasena()) && (usuarioActivo.getCorreo().endsWith("@gmail.com") || usuarioActivo.getCorreo().endsWith("@hotmail.com"))){
                    recuperados.get(usuarioActivo.getCorreo()).setCorreo(usuario);
                    Cliente cliente = recuperados.get(usuarioActivo.getCorreo());
                    recuperados.remove(usuarioActivo.getCorreo());
                    recuperados.put(usuario, cliente);
                    GestionClientes.guardarClientes(recuperados);
                    System.out.println(usuario);
                    System.out.println(recuperados);

                    JOptionPane.showMessageDialog(this, "Cambio de correo", "Has actualizado tu direccion de correo correctamente", JOptionPane.INFORMATION_MESSAGE);
                    }
                else if(!contrasena.equals(usuarioActivo.getContrasena())){
                JOptionPane.showMessageDialog(this, "La contraseña es incorrecta, por favor, vuelve a introducir los datos", "Datos incorrectos", JOptionPane.INFORMATION_MESSAGE);}
                
            }
        });
        } if(!admin){
        cambioContrasena.addActionListener(e -> {
            JTextField campoContrasena = new JTextField(10);
            JTextField campoCambioContrasena = new JTextField(10);
            JTextField campoCambioContrasenaV = new JTextField(10);
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
            
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
            JOptionPane.showMessageDialog(this, "Datos no introducidos","Por favor vuelve a introducir los datos", JOptionPane.INFORMATION_MESSAGE);
            } else if (resultadoC == JOptionPane.OK_OPTION && (!contrasena.isEmpty() && !nuevaContrasena.isEmpty() && !nuevaContrasenaV.isEmpty())){
                if (contrasena.equals(usuarioActivo.getContrasena())){
                    if(nuevaContrasena.equals(nuevaContrasenaV) && (nuevaContrasena.length() > 7 && nuevaContrasena.length() > 7)){
                        recuperados.get(usuarioActivo.getCorreo()).setContrasena(contrasena);
                        GestionClientes.guardarClientes(recuperados);
                        System.out.println(recuperados);
                        JOptionPane.showMessageDialog(this, "Cambio de contraseña", "Has actualizado tu contraseña", JOptionPane.INFORMATION_MESSAGE);
                        return;
                        
                    } if (nuevaContrasena.length() > 7 && nuevaContrasenaV.length() > 7){
                        if (!nuevaContrasena.equals(nuevaContrasenaV)){
                            JOptionPane.showMessageDialog(this, "Contraseñas desiguales", "La nueva contraseña no coincide, por favor, vuelve a introducirlas", JOptionPane.INFORMATION_MESSAGE);
                            return;
                            
                }
            }if(nuevaContrasena.length() < 8 || nuevaContrasenaV.length() < 8){ JOptionPane.showMessageDialog(this, "Formato de contraseña inválido", "La nueva contraseña tiene que contener al menos 8 caracteres, por favor, vuelve a introducirlas", JOptionPane.ERROR_MESSAGE);}
            }else {JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "La contraseña no coincide", JOptionPane.ERROR_MESSAGE);}
            }
        
        });}
        
        if(!admin){
        cambioTarjeta.addActionListener(e -> {
            JTextField campoCambioNombreT = new JTextField(10);
            JTextField campoCambioNumeroT = new JTextField(10);
            JTextField campoCambioFechaT = new JTextField(10);
            JTextField campoCambioContrasenaT = new JTextField(10);
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();

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
            JOptionPane.showMessageDialog(this, "Datos no introducidos","Por favor, introduce los datos",JOptionPane.INFORMATION_MESSAGE);
            } else if (resultadoT == JOptionPane.OK_OPTION && (!nombreT.isEmpty() && !numeroT.isEmpty() && !fechaT.isEmpty() && !contrasenaT.isEmpty())){ 
                if (contrasenaT.equals(usuarioActivo.getContrasena())){
                    System.out.println(recuperados);
                    recuperados.get(usuarioActivo.getCorreo()).getTarjeta().setNombre_titular(nombreT);
                    recuperados.get(usuarioActivo.getCorreo()).getTarjeta().setNumero_tarjeta(numeroT);
                    recuperados.get(usuarioActivo.getCorreo()).getTarjeta().setFecha_caducidad(fechaT);
                    GestionClientes.guardarClientes(recuperados);
                    System.out.println(recuperados);
                    JOptionPane.showMessageDialog(this, "Cambio de tarjeta", "La tarjeta se ha guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
                
                } else if (numeroT.length() > 16){JOptionPane.showMessageDialog(this, "Formato de tarjeta inválido", "El número de tarjeta tiene que contener 16 dígitos, por favor, vuelve a introducirla", JOptionPane.ERROR_MESSAGE);}
                else  {JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Las contraseñas no coinciden, por favor, vuelve a introducirla", JOptionPane.ERROR_MESSAGE);}
            }
        });
        }if(!admin){
            cambioDireccion.addActionListener(e -> {
            JTextField campoCambioCalle = new JTextField(10);
            JTextField campoCambioNumero = new JTextField(10);
            JTextField campoCambioCiudad = new JTextField(10);
            JTextField campoCambioCodigo = new JTextField(10);
            JTextField campoContrasenaD = new JTextField(10);
            HashMap<String, Cliente> recuperados = GestionClientes.cargarClientes();
           
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
            int numeroD = Integer.parseInt(campoCambioNumero.getText());
            String ciudadD = campoCambioCiudad.getText();
            int codigo = Integer.parseInt(campoCambioCodigo.getText());
            String contrasenaD = campoContrasenaD.getText();
            
            if (resultadoD == JOptionPane.OK_OPTION && (calle.isEmpty() || ciudadD.isEmpty() || contrasenaD.isEmpty())){
            JOptionPane.showMessageDialog(this, "Por favor, introduce los datos", "Datos no introducidos", HEIGHT);}
            else if (resultadoD == JOptionPane.OK_OPTION && (!calle.isEmpty() && !ciudadD.isEmpty() && !contrasenaD.isEmpty())){
                if (contrasenaD.equals(usuarioActivo.getContrasena())){
                recuperados.get(usuarioActivo.getCorreo()).getDireccion().setCalle(calle);
                recuperados.get(usuarioActivo.getCorreo()).getDireccion().setNumero(numeroD);
                recuperados.get(usuarioActivo.getCorreo()).getDireccion().setCiudad(ciudadD);
                recuperados.get(usuarioActivo.getCorreo()).getDireccion().setNumero(codigo);
                GestionClientes.guardarClientes(recuperados);
                System.out.println(recuperados);
                JOptionPane.showMessageDialog(this, "Cambio de dirección", "Has actualizado dirección", JOptionPane.INFORMATION_MESSAGE);
                return;
            } JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "La contraseña no coincide", JOptionPane.ERROR_MESSAGE);
            }
            
            });     
    }}}

