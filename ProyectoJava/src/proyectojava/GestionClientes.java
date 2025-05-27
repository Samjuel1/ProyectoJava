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
    
    public static void agregarClienteArchivo(Cliente cliente){
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
    
    public static boolean leerNumero(JTextField campo, Component parent){
        Integer aux = leerEntero(campo, parent, "Porfavor Introduzca un numero válido");
        if (aux == null){
            return false;
        }
        return true;
    }
    
    public static boolean leerContraseñaRegistro(JTextField campo, Component parent){
        if (GestionClientes.leerContraseñaSesion(campo, parent)){
            if (campo.getText().length() < 8){
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
        }else if (!campo.getText().endsWith("@gmail.com")&&!campo.getText().endsWith("@gmail.es")&&!campo.getText().endsWith("@hotmail.com")){
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
        return true;
    }
}
