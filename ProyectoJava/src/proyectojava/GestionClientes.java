package proyectojava;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class GestionClientes {
    
    public static Cliente usuarioActivo;
    public static boolean admin = false;

    public static Cliente getUsuarioActivo() {
        return usuarioActivo;
    }

    public static void setUsuarioActivo(Cliente usuarioActivo) {
        GestionClientes.usuarioActivo = usuarioActivo;
    }
    
    // Nombres de Archivos
    
    private static final String archivo_clientes = "clientes.dat";
    private static final String ARCHIVO_EVENTOS = "eventos.dat";
    
    // Serializacion de Clientes
    
    public static void guardarClientes(HashMap<String, Cliente> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo_clientes))) {
            out.writeObject(lista);
            System.out.println("Lista de clientes guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); //imprimir error
        }
    }
    
    public static HashMap<String, Cliente> cargarClientes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo_clientes))) {
            return (HashMap<String, Cliente>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("hola");
            return new HashMap<String, Cliente>(); // si falla, devuelve una lista vacía
        }
    }
    
    // Serializacion de Eventos
    
    public static void guardarEventos(ArrayList<Evento> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EVENTOS))) {
            out.writeObject(lista);
            System.out.println("Lista de clientes guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); //imprimir error
        }
    }
    
    public static ArrayList<Evento> cargarEventos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_EVENTOS))) {
            return (ArrayList<Evento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("hola");
            return new ArrayList<Evento>(); // si falla, devuelve una lista vacía
        }
    }
    
    // Busqueda de Eventos 
    
    public static ArrayList<Evento> busquedaEventoPorCiudad(String ciudad, ArrayList<Evento> EventosPorCiudad){
        for (Evento evento: EventosPorCiudad){
            if (!evento.getDireccion().getCiudad().equals(ciudad)){
                EventosPorCiudad.remove(evento);
            }
        }
        return EventosPorCiudad;
    }
    
    public static ArrayList<Evento> busquedaEventoPorTipo(String tipo, ArrayList<Evento> EventosPorTipo){
        for (Evento evento: EventosPorTipo){
            if (!evento.getTipo().equals(tipo)){
                EventosPorTipo.remove(evento);
            }
        }
        return EventosPorTipo;
    }
    
    public static ArrayList<Evento> busquedaEventoPorPrecio(long precio, ArrayList<Evento> EventosPorPrecio){
        for (Evento evento: EventosPorPrecio){
            if (evento.getPrecio() > precio) {
                EventosPorPrecio.remove(evento);
            }
        }
        return EventosPorPrecio;
    }
    
    public static ArrayList<Evento> busquedaEventoPorCalificacion(double calificacion, ArrayList<Evento> EventosPorCalificacion){
        for (Evento evento: EventosPorCalificacion){
            if (evento.getCalificacion() > calificacion) {
                EventosPorCalificacion.remove(evento);
            }
        }
        return EventosPorCalificacion;
    }
    
    // Ordenacion de Eventos
    
    public static ArrayList<Evento> ordenacionPorCalificacion(ArrayList<Evento> listaEventos){
        Evento temp;
        for (int i = 0; i < listaEventos.size()-1; i++){
            boolean terminado = false;
            for (int j = 0; j < listaEventos.size() -i-1; j++){
                if (listaEventos.get(j).getCalificacion() < listaEventos.get(j+1).getCalificacion()){
                    temp = listaEventos.get(j);
                    listaEventos.set(j, listaEventos.get(j+1));
                    listaEventos.set(j+1, temp);
                    terminado = false;
                }
            }
            if(terminado){
                break;
            }
            
        }
        return listaEventos;
    }
    
    public static ArrayList<Evento> ordenacionPorPrecio(ArrayList<Evento> listaEventos){
        Evento temp;
        for (int i = 0; i < listaEventos.size()-1; i++){
            boolean terminado = false;
            for (int j = 0; j < listaEventos.size() -i-1; j++){
                if (listaEventos.get(j).getPrecio() < listaEventos.get(j+1).getPrecio()){
                    temp = listaEventos.get(j);
                    listaEventos.set(j, listaEventos.get(j+1));
                    listaEventos.set(j+1, temp);
                    terminado = false;
                }
            }
            if(terminado){
                break;
            }
            
        }
        return listaEventos;
    }
    
    // Inicio de Sesion
    
    public static boolean comprobarAdmin(String correo, String contraseña){
        boolean resultado = correo.equals("admin@javaevents.com") && contraseña.equals("admin");
        return resultado;
    }
    
    public static boolean comprobarUsuario(String correo, String contraseña){
        HashMap<String, Cliente> usuarios = GestionClientes.cargarClientes();
        boolean resultado;
        if (usuarios.containsKey(correo)){
            Cliente cliente = usuarios.get(correo);
            resultado = cliente.getContrasena().equals(contraseña);
        }
        else{resultado = false;}
        return resultado;
    }
    
    public static boolean inicioDeSesion(String correo, String contraseña){
        boolean resultado = true;
        GestionClientes.admin = comprobarAdmin(correo, contraseña);
        if (!GestionClientes.admin){
            resultado = GestionClientes.comprobarUsuario(correo, contraseña);
            GestionClientes.setUsuarioActivo(GestionClientes.cargarClientes().get(correo));
        }
        return resultado;
    }
    
    // Varios 
    
    public static void modificarClienteCorreo(int boton, JTextField correo, JTextField contraseña, Component parent){
        if (boton == JOptionPane.OK_OPTION && (correo.getText().isEmpty() || contraseña.getText().isEmpty())) {
            JOptionPane.showMessageDialog(parent, "Por favor, introduce los datos");
        } 
        else if(boton == JOptionPane.OK_OPTION && !correo.getText().isEmpty() && !contraseña.getText().isEmpty()){
                if (contraseña.getText().equals(usuarioActivo.getContrasena()) && (usuarioActivo.getCorreo().endsWith("@gmail.com") || 
                        usuarioActivo.getCorreo().endsWith("@hotmail.com") || usuarioActivo.getCorreo().endsWith("@gmail.es"))){
                    HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
                    lista.get(GestionClientes.usuarioActivo.getCorreo()).setCorreo(correo.getText());
                    Cliente cliente = lista.get(GestionClientes.usuarioActivo.getCorreo());
                    lista.remove(GestionClientes.usuarioActivo.getCorreo());
                    lista.put(correo.getText(), cliente);
                    GestionClientes.guardarClientes(lista);
                    JOptionPane.showMessageDialog(parent, 
                            "Cambio de correo", 
                            "Has actualizado tu direccion de correo correctamente", 
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else if(!contraseña.getText().equals(usuarioActivo.getContrasena())){
                JOptionPane.showMessageDialog(parent, 
                        "La contraseña es incorrecta, por favor, vuelve a introducir los datos", 
                        "Datos incorrectos", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
        }  
    }
    
    public static void modificarClienteContraseña(int boton, JTextField contraseñaNueva, JTextField contraseñaNueva2, JTextField contraseña, Component parent){
        if (boton == JOptionPane.OK_OPTION && (contraseña.getText().isEmpty() || contraseñaNueva.getText().isEmpty() || contraseñaNueva2.getText().isEmpty())) {
            JOptionPane.showMessageDialog(parent, "Datos no introducidos","Por favor vuelve a introducir los datos", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (boton == JOptionPane.OK_OPTION && (!contraseña.getText().isEmpty() && !contraseñaNueva.getText().isEmpty() && !contraseñaNueva2.getText().isEmpty())){
            if (contraseña.getText().equals(GestionClientes.usuarioActivo.getContrasena())){
                if(contraseñaNueva.getText().equals(contraseñaNueva.getText()) && (contraseñaNueva.getText().length() > 7 && contraseñaNueva2.getText().length() > 7)){
                    HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
                    lista.get(GestionClientes.usuarioActivo.getCorreo()).setContrasena(contraseñaNueva.getText());
                    GestionClientes.guardarClientes(lista);
                }
                if (contraseñaNueva.getText().length() > 7 && contraseñaNueva2.getText().length() > 7){
                        if (!contraseñaNueva.getText().equals(contraseñaNueva2.getText())){
                            JOptionPane.showMessageDialog(parent, "Contraseñas desiguales", "La nueva contraseña no coincide, por favor, vuelve a introducirlas", JOptionPane.INFORMATION_MESSAGE);
                            return;
                            
                        }   
                }
                if(contraseñaNueva.getText().length() < 8 || contraseñaNueva2.getText().length() < 8){ 
                    JOptionPane.showMessageDialog(parent, 
                            "Formato de contraseña inválido", 
                            "La nueva contraseña tiene que contener al menos 8 caracteres, por favor, vuelve a introducirlas", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else {JOptionPane.showMessageDialog(parent, "Contraseña incorrecta", "La contraseña no coincide", JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    public static void modificarClienteTarjeta(int boton, JTextField nombreT, JTextField numeroT, JTextField fechaT, JTextField contraseña, Component parent){
        if (boton == JOptionPane.OK_OPTION && ((GestionClientes.leerTexto(nombreT, parent, "Por favor introduzca un nombre"))&& (GestionClientes.leerNumero(numeroT, parent, "Introduzca un numero válido")) 
                && (GestionClientes.leerTexto(fechaT, parent, "Por favor introduzca una fecha válida")) && (GestionClientes.leerContraseñaRegistro(contraseña, parent)))) {
            JOptionPane.showMessageDialog(parent, 
                    "Datos no introducidos",
                    "Por favor, introduce los datos",
                    JOptionPane.INFORMATION_MESSAGE);
        } 
        else if (boton == JOptionPane.OK_OPTION && (!nombreT.getText().isEmpty() && !numeroT.getText().isEmpty() && !fechaT.getText().isEmpty() && !contraseña.getText().isEmpty())){
            
            if (contraseña.getText().equals(usuarioActivo.getContrasena())){
                HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
                lista.get(usuarioActivo.getCorreo()).getTarjeta().setNombre_titular(nombreT.getText());
                lista.get(usuarioActivo.getCorreo()).getTarjeta().setNumero_tarjeta(numeroT.getText());
                lista.get(usuarioActivo.getCorreo()).getTarjeta().setFecha_caducidad(fechaT.getText());
                GestionClientes.guardarClientes(lista);    
                JOptionPane.showMessageDialog(parent, 
                        "Cambio de tarjeta", 
                        "La tarjeta se ha guardado correctamente", 
                        JOptionPane.INFORMATION_MESSAGE);
                
            } 
            else if (numeroT.getText().length() > 16){JOptionPane.showMessageDialog(parent, 
                    "Formato de tarjeta inválido", 
                    "El número de tarjeta tiene que contener 16 dígitos, por favor, vuelve a introducirla", 
                    JOptionPane.ERROR_MESSAGE);
            }
            else {JOptionPane.showMessageDialog(parent, 
                    "Contraseña incorrecta", 
                    "Las contraseñas no coinciden, por favor, vuelve a introducirla", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void agregarClienteArchivoRegistro(Cliente cliente){
        HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
        lista.put(cliente.getCorreo(), cliente);
        GestionClientes.guardarClientes(lista);
    }
    
    public static String[] clientesToArray(){
        HashMap<String, Cliente> clientes = GestionClientes.cargarClientes();
        ArrayList<String> clientesArray = new ArrayList<>();
        for(String clave : clientes.keySet()){
            clientesArray.add(clave);
        }
        return clientesArray.toArray(new String[0]);
    }
    
    public static JButton crearBoton(int posicion){
        ArrayList<Evento> eventosOrdenados = ordenacionPorCalificacion(GestionClientes.cargarEventos());
        JButton boton = new JButton(eventosOrdenados.get(posicion+1).getTitulo() + "    Calificacion: " + eventosOrdenados.get(posicion+1).getCalificacion());
        boton.setFont(new Font("Arial", Font.BOLD,30));
        boton.setBackground(Color.WHITE);
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        return boton;
    }
    
    
    
    // Tratado de Datos REGISTRO
    
    public static Integer leerEntero(JTextField campo, Component parent, String mensajeError) {
        try {
            return Integer.parseInt(campo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent,
                mensajeError,
                "Error de entrada",
                JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    public static Long leerLong(JTextField campo, Component parent, String mensajeError) {
        try {
            return Long.parseLong(campo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent,
                mensajeError,
                "Error de entrada",
                JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
    }
    
    public static boolean leerTexto(JTextField campo, Component parent, String mensajeError){
        if (campo.getText().equals("")){
            JOptionPane.showMessageDialog(parent,
                mensajeError,
                "Error de entrada",
                JOptionPane.INFORMATION_MESSAGE);
                return false;
        }
        return true;
    }
    
    public static boolean leerNumero(JTextField campo, Component parent, String mensajeError){
        Integer aux = leerEntero(campo, parent, mensajeError);
        if (aux == null){
            return false;
        }
        return true;
    }
    
    public static boolean leerContraseñaRegistro(JTextField campo, Component parent){
        if (GestionClientes.leerContraseñaSesion(campo, parent)){
            if (campo.getText().length() <= 8){
                JOptionPane.showMessageDialog(parent,
                "La contraseña debe ser mayor de ocho caracteres",
                "Error de entrada",
                JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public static boolean leerTelefono(JTextField campo, Component parent){
        Integer aux = leerEntero(campo, parent, "El número de teléfono debe incluir solo números");
        if (aux == null){
            return false;
        }
        if (campo.getText().length() != 9){
                JOptionPane.showMessageDialog(parent,
                "Formato del Numero de Teléfono inválido",
                "Error de entrada",
                JOptionPane.INFORMATION_MESSAGE);
                return false;
        }
        return true;
    }
    
    public static boolean leerNumeroTarjeta(JTextField campo, Component parent){
        Long aux = leerLong(campo, parent, "El número de Tarjeta debe incluir solo números");
        if (aux == null){
            return false;
        }
        if (campo.getText().length() != 16){
                JOptionPane.showMessageDialog(parent,
                "Formato del Numero de Tarjeta inválido",
                "Error de entrada",
                JOptionPane.INFORMATION_MESSAGE);
                return false;
        }
        return true;
    }
    
    // Tratado de Datos INICIO DE SESION
    
    public static boolean leerCorreo(JTextField campo, Component parent){
        if (campo.getText().equals("")){
            JOptionPane.showMessageDialog(parent,
                "Por favor, introduce un correo.",
                "Correo no introducido", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if (!campo.getText().endsWith("@gmail.com")&&!campo.getText().endsWith("@gmail.es")&&!campo.getText().endsWith("@hotmail.com")&&!campo.getText().endsWith("@javaevents.com")){
            JOptionPane.showMessageDialog(parent,
                "Formato del correo invalido.",
                "Formato correo invalido", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
        
    public static boolean leerContraseñaSesion(JTextField campo, Component parent){
        if (campo.getText().equals("")){
            JOptionPane.showMessageDialog(parent,
                "Por favor, introduce los datos.",
                "Contraseña no introducida", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else if (campo.getText().equals("admin")){
            return true;
        }
        return true;
    }
}
