/**
 * Esta es la Clase en la que se almacenan todos los metodos y variables estaticas/os necesarias/os para el correcto funcionamiento 
 * de ambos paquetes de  clases, Interfaz y Logica.
 * 
*/
package proyectojava;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class GestionClientes {
    
    /**
     * Esta variable registra el Objeto de tipo Cliente que se toma como usuario que esta utilizando el programa
     */
    public static Cliente usuarioActivo;
    /**
     * Esta variable registra en forma de booleano si se ha ingresado al programa con un administrador o no.
     */
    public static boolean admin = false;
    /**
     * Esta variable registra el Objeto de tipo Administrador que se toma como usuario tipo Admin que esta utilizando el programa.
     */
    public static Administrador adminActivo;

    /**
     * Sirve para recuperar el contenido de la variable estatica usuarioActivo.
     * @return retorna un Objeto tipo Cliente si se ha registrado previamente un usuario
     * o un null si la variable no ha sido inicializada o se ha ingresado como admin.
     */

    public static Cliente getUsuarioActivo() {
        return usuarioActivo;
    }
    
    /**
     * Sirve para actualizar la variable estatica usuarioActivo.
     * @param usuarioActivo Se le pasa como argumento un Objeto tipo Cliente el cual sera el usuario Activo.
     */

    public static void setUsuarioActivo(Cliente usuarioActivo) {
        GestionClientes.usuarioActivo = usuarioActivo;
    }
    
    /**
     * Sirve para recuperar el contenido de la variable estatica adminActivo.
     * @return retorna un Objeto tipo Administrador si se ha ingresado al programa como administrador o
     * un null si la variable no ha sido inicializada o se ha ingresado como cliente.
     */

    public static Administrador getAdminActivo() {
        return adminActivo;
    }
    
    /**
     * Sirve para actualizar la variable estatica adminActivo.
     * @param adminActivo Se le pasa como argumento un Objeto tipo Adminitrador el cual pasara a ser el Admin Activo.
     */

    public static void setAdminActivo(Administrador adminActivo) {
        GestionClientes.adminActivo = adminActivo;
    }
    
    private static final String ARCHIVO_CLIENTES = "clientes.dat";
    private static final String ARCHIVO_EVENTOS = "eventos.dat";
    private static final String ARCHIVO_ADMINISTRADORES = "Administradores.dat";

    
/**
 * Sirve para serializar los objetos de tipo Cliente en forma de HashMap en un archivo .dat
 * @param lista Se le pasa como parametro el HashMap con claves de tipo String y valores de tipo Cliente que queremos serializar.
 */
    public static void guardarClientes(HashMap<String, Cliente> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            out.writeObject(lista);
            System.out.println("Lista de clientes guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sirve para recuperar el HashMap que contiene los Objetos tipo Cliente serializados del archivo .dat que tenga asignado.
     * @return retorna siempre un HashMap con claves tipo String y valores tipo Cliente, si falla retornara un HashMap vacio.
     */
    public static HashMap<String, Cliente> cargarClientes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            return (HashMap<String, Cliente>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<String, Cliente>();
        }
    }
    
    /**
     * Sirve para serializar los objetos de tipo Evento en forma de ArrayList en un archivo .dat que tiene asociado.
     * @param lista Se le pasa como parametro el ArrayList con Objetos de tipo Evento que queremos serializar.
     */
    public static void guardarEventos(ArrayList<Evento> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EVENTOS))) {
            out.writeObject(lista);
            System.out.println("Lista de eventos guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sirve para recuperar el ArrayList que contiene los Objetos tipo Evento serializados del archivo .dat que tiene asignado.
     * @return retorna siempre un ArrayList con objetos tipo Evento, si falla retorna un ArrayList vacio.
     */
    public static ArrayList<Evento> cargarEventos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_EVENTOS))) {
            return (ArrayList<Evento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Evento>();
        }
    }
    
    /**
     * Sirve para serializar los Objetos de tipo Administrador en forma de HashMap dentro del archivo .dat asociado.
     * @param lista 
     */
    public static void guardarAdmin(HashMap<String, Administrador> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ADMINISTRADORES))) {
            out.writeObject(lista);
            System.out.println("Lista de Admins guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sirve para recupear el hashMap que contiene los Objetos de tipo Administrador serializados del archivo .dat que tiene asociado. 
     * @return retorna siempre un HashMap de claves tipo String y valores de tipo Administrador, si falla devuelve un HashMap vacio.
     */
    public static HashMap<String, Administrador> cargarAdmin() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_ADMINISTRADORES))) {
            return (HashMap<String, Administrador>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<String, Administrador>();
        }
    }
    
    /**
     * Sive para filtrar un ArrayList de tipo Evento teniendo en cuenta unicamente el atributo ciudad.
     * @param ciudad Es el JTextField del que se saca la ciudad que tendremos en cuenta para filtrar el arrayList
     * @param EventosPorCiudad El ArrayList que queremos filtrar
     * @return retorn el ArrayList filtrado segun el parametro ciudad.
     */
    
    public static ArrayList<Evento> busquedaEventoPorCiudad(JTextField ciudad, ArrayList<Evento> EventosPorCiudad){
        if (!leerTexto(ciudad, null, "Error en el campo Ciudad, se saltara el filtro")){
            return null;
        } 
        else{
            ArrayList<Evento> eventosFiltrados = new ArrayList<>();
            for (Evento evento: EventosPorCiudad){
                if (evento.getDireccion().getCiudad().equals(ciudad)){
                    eventosFiltrados.add(evento);
                }
            }
            return eventosFiltrados;
        }    
    }
    
/**
 * Sive para filtrar un ArrayList de tipo Evento teniendo en cuenta unicamente el atributo Tipo.
 * @param tipo Es el JTextField del que se saca el Tipo que tendremos en cuenta para filtrar el ArrayList
 * @param EventosPorTipo el ArrayList que queremos filtrar
 * @return Retorna el ArrayList con los elementos filtrados segun el parametro Tipo
 */
    
    public static ArrayList<Evento> busquedaEventoPorTipo(JTextField tipo, ArrayList<Evento> EventosPorTipo){
        if (!leerTexto(tipo, null, "Error en el campo Ciudad, se saltara el filtro")){
            return null;
        }
        else{
            ArrayList<Evento> eventosFiltrados = new ArrayList<>();
            for (Evento evento: EventosPorTipo){
                if (evento.getTipo().equals(tipo)){
                    eventosFiltrados.add(evento);
                }
            }
            return eventosFiltrados;
        }
    }
    
    /**
     * Sirve para filtrar un ArrayList de tipo Evento teniendo en cuenta unicamente el atributo Titulo
     * @param titulo Es el JTextField del que e saca el Titulo que tendremos en cuenta para filtrar el ArrayList
     * @param EventosPorTitulo El ArrayList que queremos filtrar
     * @return Retorna el ArrayList con los elementos filtrados segun el parametro Titulo
     */
    
    public static ArrayList<Evento> busquedaEventoPorTitulo(JTextField titulo, ArrayList<Evento> EventosPorTitulo){
        if (titulo.getText().equals("")){
            return null;
        }
        else{
            ArrayList<Evento> eventosFiltrados = new ArrayList<>();
            for (Evento evento: EventosPorTitulo){
                if (evento.getTitulo().toLowerCase().contains(titulo.getText().toLowerCase())){
                    eventosFiltrados.add(evento);
                }
            }
            return eventosFiltrados;
        }    
    }
    
    /**
     * Sirve para filtrar un ArrayList de tipo Evento teniendo en cuenta unicamente el atributo Fecha
     * @param campoFecha Es el campo de texto del cual se extrae el String fecha que se tratara para utilizarse como filtro
     * @param listaEventos Es el ArrayList que queremos filtrar
     * @return Retorna un ArrayList con los elementos filtrados segun el parametro Fecha 
     */
    
    public static ArrayList<Evento> busquedaEventoPorFechaEventos (JFormattedTextField campoFecha, ArrayList<Evento> listaEventos, Component parent){
        ArrayList<Evento> listaFiltrada = new ArrayList<>();
        LocalDate fechaBase = leerFecha(campoFecha.getText(), null);
        System.out.println(campoFecha.getText());
        if (fechaBase == null){
            JOptionPane.showMessageDialog(null, "Formato de fecha no valido, se saltara el filtro", "Error de Entrada", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        for (Evento evento : listaEventos){
            if (evento.getFecha().isEqual(fechaBase) || evento.getFecha().isAfter(fechaBase)){
                listaFiltrada.add(evento);
            }
        }
        return listaFiltrada;
    }
    
    /**
     * Sirve para ordenar un ArrayList de tipo Evento segun el atributo Calificacion
     * @param listaEventos Es el ArrayList que se quiere ordenar
     * @return Retorna un ArrayList de tipo Evento ordenado segun el parametro Calificacion
     */
    
    public static ArrayList<Evento> ordenacionPorCalificacion(ArrayList<Evento> listaEventos){
        ArrayList<Evento> eventosFiltrados = new ArrayList<>();
        for (Evento evento: listaEventos){
            eventosFiltrados.add(evento);
        }
        Evento temp;
        for (int i = 0; i < eventosFiltrados.size()-1; i++){
            boolean terminado = false;
            for (int j = 0; j < eventosFiltrados.size() -i-1; j++){
                if (eventosFiltrados.get(j).getCalificacion() < eventosFiltrados.get(j+1).getCalificacion()){
                    temp = eventosFiltrados.get(j);
                    eventosFiltrados.set(j, eventosFiltrados.get(j+1));
                    eventosFiltrados.set(j+1, temp);
                    terminado = false;
                }
            }
            if(terminado){
                break;
            }
            
        }
        return eventosFiltrados;
    }
    
    /**
     * Sirve para ordenar un ArrayList de tipo Reserva segun el atributo Fecha
     * @param listaReservas Es la lista de reservas que se quiere ordenar segun la fecha.
     * @return Retorna un ArrayList de tipo Reserva 
     */
    
    public static ArrayList<Reservas> ordenacionPorFechaReserva(ArrayList<Reservas> listaReservas){
        ArrayList<Reservas> reservasFiltradas = new ArrayList<>();
        for (Reservas reserva: listaReservas){
            reservasFiltradas.add(reserva);
        }
        Reservas temp;
        for (int i = 0; i < reservasFiltradas.size()-1; i++){
            boolean terminado = false;
            for (int j = 0; j < reservasFiltradas.size() -i-1; j++){
                if (leerFecha(reservasFiltradas.get(j).getFecha(), null).isAfter(leerFecha(reservasFiltradas.get(j+1).getFecha(), null))){
                    temp = reservasFiltradas.get(j);
                    reservasFiltradas.set(j, reservasFiltradas.get(j+1));
                    reservasFiltradas.set(j+1, temp);
                    terminado = false;
                }
            }
            if(terminado){
                break;
            }
            
        }
        return reservasFiltradas;
    }
    
    /**
     * Sirve para ordenar un ArraYlist de tipo Evento segun el atributo Precio
     * @param listaEventos Es el ArrayList de Eventos que queremos ordenar
     * @return Retorna un ArrayList con los elementos ordenados segun el Precio
     */
    public static ArrayList<Evento> ordenacionPorPrecio(ArrayList<Evento> listaEventos){
        ArrayList<Evento> eventosFiltrados = new ArrayList<>();
        for (Evento evento: listaEventos){
            eventosFiltrados.add(evento);
        }
        Evento temp;
        for (int i = 0; i < eventosFiltrados.size()-1; i++){
            boolean terminado = false;
            for (int j = 0; j < eventosFiltrados.size() -i-1; j++){
                if (eventosFiltrados.get(j).getPrecio() < eventosFiltrados.get(j+1).getPrecio()){
                    temp = eventosFiltrados.get(j);
                    eventosFiltrados.set(j, eventosFiltrados.get(j+1));
                    eventosFiltrados.set(j+1, temp);
                    terminado = false;
                }
            }
            if(terminado){
                break;
            }
            
        }
        return eventosFiltrados;
    }
    
    /**
     * Sirve para aplicar en funcion de unos checkBox y JTexfield/JRadioButton unos ciertos filtros al ArrayList de Eventos que se mostrara en la busqueda
     * @param campoTitulo Es el campo de texto que recoge el Titulo a buscar
     * @param checkCiudad Es el campo que recoge si se aplica o no el filtro de busqueda en funcion de la ciudad
     * @param campoCiudad Es el campo de texto que recoge la Ciudad a buscar
     * @param checkTipo Es el campo que recoge si se aplica o no el filtro de busqueda en funcion del Tipo
     * @param campoTipo Es el campo de texto que recoge el Tipo a buscar
     * @param checkFecha Es el campo que recoge si se aplica o no el filtro de busqueda en funcion de la Fecha
     * @param campoFecha Es el campo de texto que recoge la Fecha a partir de la que buscar
     * @param precio Es el campo que recoge si se aplica o no la ordenacion por Precio
     * @param calificacion Es el campo que recoge si se aplica o no la ordenacion por Calificacion
     * @return Retorna un ArrayList de tipo Evento al cual se le han aplicado los filtros seleccionados.
     */
    
    public static ArrayList<Evento> aplicarFiltrosBusqueda(JTextField campoTitulo, JCheckBox checkCiudad, JTextField campoCiudad, JCheckBox checkTipo, JTextField campoTipo, JCheckBox checkFecha, JFormattedTextField campoFecha, JRadioButton precio, JRadioButton calificacion){
        ArrayList<Evento> listaEventos = cargarEventos();
        ArrayList<Evento> resultado = busquedaEventoPorTitulo(campoTitulo, listaEventos);
        if (resultado != null){
            listaEventos = resultado;
        }
        if (checkCiudad.isSelected()){
            resultado = busquedaEventoPorCiudad(campoCiudad, listaEventos);
            if (resultado != null) {
                listaEventos = resultado;
            }  
        }
        if (checkTipo.isSelected()){
            resultado = busquedaEventoPorTipo(campoTipo, listaEventos);
            if (resultado != null) {
                listaEventos = resultado;
            }
        }
        if (checkFecha.isSelected()){
            resultado = busquedaEventoPorFechaEventos(campoFecha, listaEventos, null);
            if (resultado != null) {
                listaEventos = resultado;
            }
        }
        if (precio.isSelected()){
            listaEventos = ordenacionPorPrecio(listaEventos);
        }
        else if (calificacion.isSelected()){
            listaEventos = ordenacionPorCalificacion(listaEventos);
        }
        return listaEventos;
    }
    
    /**
     * Sirve para abrir un JOptionPane.showMessageDialog en relacion a un cierto evento y darle la funcion de dar info sobre el evento,
     * dar la posibilidad de reservar un cierto numero de entradas, dejar una reseña con comentario y puntuacion y generar una factura 
     * @param evento Es el evento en torno al cual se da info y funcionalidades varias
     */
    public static void accionBotonEventos (Evento evento){
        String[] opciones = {"Reservar", "Volver"};
        System.out.print(evento.getRutaImagen());
        ImageIcon icono = new ImageIcon("/resources/imagen_negra");
        File archivo = new File(evento.getRutaImagen()); 
        if (archivo.exists()) {
           icono = new ImageIcon(archivo.getPath());
        } else {
        System.out.println("La imagen no existe en: " + archivo.getAbsolutePath());
        }

      //  ImageIcon icono = new ImageIcon(GestionClientes.class.getResource(evento.getRutaImagen()));
        JPanel panelBoton = new JPanel();
                    panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
                    
                    
                    
                    panelBoton.add(new JLabel("Titulo: " + evento.getTitulo()));
                    panelBoton.add(new JLabel("Tipo: " + evento.getTipo()));
                    panelBoton.add(new JLabel("Fecha: " + evento.getFecha().toString()));
                    panelBoton.add(new JLabel("Direccion:"));
                    panelBoton.add(new JLabel("Ciudad: " + evento.getDireccion().getCiudad()));
                    panelBoton.add(new JLabel("Codigo Postal: " + evento.getDireccion().getCp()));
                    panelBoton.add(new JLabel("Calle y nº: " + evento.getDireccion().getCalle() + " " + evento.getDireccion().getNumero()));
                    panelBoton.add(new JLabel("Calificacion: " + evento.getCalificacion()));
                    panelBoton.add(new JLabel("Precio: " + evento.getPrecio()));
                    panelBoton.add(Box.createVerticalStrut(5));
                    panelBoton.add(new JLabel("Pulse Ok para proceder a la reserva y Cancel para volver   "));
                    
                    int resultado = JOptionPane.showOptionDialog(null, panelBoton, evento.getTitulo(), JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icono,opciones,opciones[0]);
                    
                    if (resultado == JOptionPane.OK_OPTION) {
                        JPanel panelCompra = new JPanel();
                        panelCompra.setLayout(new BoxLayout(panelCompra, BoxLayout.Y_AXIS));
                        double precio;
                        String msg;
                        if (usuarioActivo.getEsvip()){
                            precio = evento.getPrecioVip();
                            msg = " -Precio Vip-";
                        } 
                        else{
                            precio = evento.getPrecio();
                            msg = "";
                        }
                        panelCompra.add(new JLabel("Precio: " + precio + msg));
                        JSpinner entradas = new JSpinner();
                        SpinnerNumberModel modelo = new SpinnerNumberModel(1,1,30,1);
                        entradas.setModel(modelo);
                        ((JSpinner.DefaultEditor) entradas.getEditor()).getTextField().setEditable(false);
                        panelCompra.add(entradas);
                        
                        resultado = JOptionPane.showConfirmDialog(null, panelCompra, evento.getTitulo(), JOptionPane.OK_CANCEL_OPTION);
                        
                        if (resultado == JOptionPane.OK_OPTION) {
                            String vip;
                            if (usuarioActivo.getEsvip() == true){vip = "Sí";} else {vip = "No";}
                            double cobro = (int) entradas.getValue()*precio;
                            JPanel panelReseña = new JPanel();
                            panelReseña.setLayout(new BoxLayout(panelReseña, BoxLayout.Y_AXIS));
                            panelReseña.add(new JLabel("Usted ha comprado " + entradas.getValue() + " por un total de: " + cobro + "€"));
                            panelReseña.add(Box.createVerticalStrut(5));
                            
                            String carpeta = "recibos";
                            new File(carpeta).mkdirs();

                            String nombreArchivo = "recibos/recibo_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss, dd_MM_yyyy")) + ".txt";
                            try (BufferedWriter recibo = new BufferedWriter(new FileWriter(nombreArchivo))){
                                recibo.write("- Información de la reserva:");
                                recibo.newLine();
                                recibo.newLine();
                                recibo.write("    Fecha de la reserva: " + evento.getFecha());
                                recibo.newLine();
                                recibo.write("    Precio: " + evento.getPrecio());
                                recibo.newLine();
                                recibo.write("    - Datos del evento:");
                                recibo.newLine();
                                recibo.write("        Título: " + evento.getTitulo());
                                recibo.newLine();
                                recibo.write("        Tipo de evento: " + evento.getTipo());
                                recibo.newLine();
                                recibo.write("        Dirección: ");
                                recibo.newLine();
                                recibo.write("            Calle: " + evento.getDireccion().getCalle());
                                recibo.newLine();
                                recibo.write("            Número: " + evento.getDireccion().getNumero());
                                recibo.newLine();
                                recibo.write("            Ciudad: " + evento.getDireccion().getCiudad());
                                recibo.newLine();
                                recibo.write("            Código postal: " + evento.getDireccion().getCp());
                                recibo.newLine();
                                recibo.write("    - Datos del reservante: ");
                                recibo.newLine();
                                recibo.write("        Nombre: " + usuarioActivo.getNombre());
                                recibo.newLine();
                                recibo.write("        Correo electrónico: " + usuarioActivo.getCorreo());
                                recibo.newLine();
                                recibo.write("        Teléfono: " + usuarioActivo.getCorreo());
                                recibo.newLine();
                                recibo.write("        - Dirección del reservante: ");
                                recibo.newLine();
                                recibo.write("            Calle: " + usuarioActivo.getDireccion().getCalle());
                                recibo.newLine();
                                recibo.write("            Número: " + usuarioActivo.getDireccion().getNumero());
                                recibo.newLine();
                                recibo.write("            Ciudad: " + usuarioActivo.getDireccion().getCiudad());
                                recibo.newLine();
                                recibo.write("            Código postal: " + usuarioActivo.getDireccion().getCp());
                                recibo.newLine();
                                recibo.write("        Cliente VIP: " + vip);
                                recibo.newLine();
                                recibo.newLine();
                                recibo.write("Muchas gracias por su compra.");
                            
                            } catch (IOException e) {
                                System.out.println("no se crea el archivo");
                               e.printStackTrace();
                            }
                            
                            panelReseña.add(new JLabel("Deje aqui su reseña:"));
                            panelReseña.add(Box.createVerticalStrut(5));
                            
                            JTextField campoReseña = new JTextField(10);
                            panelReseña.add(campoReseña);
                            panelReseña.add(Box.createVerticalStrut(5));
                            panelReseña.add(new JLabel("Puntuenos aqui:"));
                            panelReseña.add(Box.createVerticalStrut(5));

                            JSlider puntuacion = new JSlider(1, 5, 5);
                            puntuacion.setMinorTickSpacing(1);  
                            puntuacion.setMajorTickSpacing(1); 
                            puntuacion.setPaintLabels(true);
                            puntuacion.setPaintTicks(true);
                            panelReseña.add(puntuacion);
                            resultado = JOptionPane.showConfirmDialog(null, panelReseña, evento.getTitulo(), JOptionPane.OK_CANCEL_OPTION);
                            if (resultado == JOptionPane.OK_OPTION){
                                int estrellas = (int) puntuacion.getValue();
                                Reservas reserva = new Reservas(GestionClientes.usuarioActivo.getNombre(), evento.getFecha().toString(), cobro, evento);
                                Reseña reseña = new Reseña(campoReseña.getText(), estrellas, evento, GestionClientes.usuarioActivo.getCorreo());
                                HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
                                lista.get(usuarioActivo.getCorreo()).añadirReserva(reserva);
                                lista.get(usuarioActivo.getCorreo()).añadirReseña(reseña);
                                ArrayList<Evento> listaSinEvento = GestionClientes.borrarIguales(evento);
                                Evento eventoNuevo = evento;
                                eventoNuevo.añadirReseña(reseña);
                                eventoNuevo.setCalificacion(evento.calcularCalificacion());
                                listaSinEvento.add(eventoNuevo);
                                                          
                                GestionClientes.guardarClientes(lista);
                                GestionClientes.guardarEventos(listaSinEvento);
                                
                            JOptionPane.showMessageDialog(null, "Gracias por su compra y por confiar en nosotros", "Reseña puesta", JOptionPane.PLAIN_MESSAGE);}
                        }
                    }
    }
    
    /**
     * Sirve para dar formato a unos ciertos botones en relacion a su posicion en el ranking por calificacion 
     */ 
    public static void botonEventoClasificacion(JButton boton1, JButton boton2, JButton boton3, JButton boton4, JButton boton5){
        ArrayList<Evento> listaEventos = ordenacionPorCalificacion(cargarEventos());
        JButton[] listaBotones = {boton1, boton2, boton3, boton4, boton5};
        for (int i = 0; i < 5; i++){
            JButton boton = listaBotones[i];
            if (i >= listaEventos.size()){
                boton.setText("");
            }
            else{
                Evento eventoSeleccionado = listaEventos.get(i);
                boton.setText(eventoSeleccionado.getTitulo() + "    Calificacion: " + eventoSeleccionado.getCalificacion());
            } 
        }
    }
    
    /**
     * Sirve para dar funcionalidad a cirtos botones en relacion a un Evento que presenta una posicion determinada en el ranking por calificacion
     * @param boton Es el JButton al que se le da la funcionalidad
     * @param pos Es la posicion en el ranking que tiene el evento, siempre es i - 1 es decir 1º -> pos = 0, 2º -> pos = 1, etc
     */
    public static void accionBotonEventosCalificacion(JButton boton, int pos){
        ArrayList<Evento> listaEventos = ordenacionPorCalificacion(cargarEventos());
        Evento evento = listaEventos.get(pos);
            accionBotonEventos(evento);
        }
    
    /**
     * Sirve para dar Formato a ciertos botones ordenados en relacion a un cierto ArrayList, previamente tratado, de tipo Evento 
     * @param listaEventos Es la lista en torno a la que se da la funcionalidad a los botones
     */
    public static void botonEventosBusqueda(ArrayList<Evento> listaEventos, JButton boton1, JButton boton2, JButton boton3, JButton boton4, JButton boton5, JButton boton6, JButton boton7, JButton boton8, JButton boton9, int pagina){
        JButton[] listaBotones = {boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9};
        for (int i = pagina * listaBotones.length; i < pagina * listaBotones.length + 9;i++){
            int j = i - pagina * listaBotones.length;
            JButton boton = listaBotones[j];
            if (i >= listaEventos.size()){
                boton.setText("");
            } 
            else{
                Evento evento = listaEventos.get(i);
                boton.setText(evento.getTitulo()+ " Calificacion: " + evento.getCalificacion());
            }
        }
    }
    
    /**
     * Sirve para dar funcionalidad a ciertos botones ordenados en relacion a un cierto ArrayList, previamente tratado, de tipo Evento
     * @param listaEventos Es el ArrayList de los Eventos tratados en torno al que se da funcionalidad
     * @param pagina Es la pagina de botones en la que se encuentra
     * @param nBoton Es la posicion de boton al cual se le esta dando funcionalidad
     */
    public static void accionBotonEventosBusqueda(ArrayList<Evento> listaEventos, int pagina, int nBoton, Component parent){
        int i = pagina * 9 + nBoton;
        if (i < listaEventos.size()){
            Evento evento = listaEventos.get(i);
            accionBotonEventos(evento);
        }
    }
    
    /**
     * Sirve para dar formato a ciertos botones en relacion a un cierto ArrayList de Reservas
     * @param listaReservas Es el ArrayList que almacena los objetos de tipo Reservas
     * @param pagina Es la pagina que de botones en la que se encuentra
     */
    public static void botonReservas(ArrayList<Reservas> listaReservas, JButton boton1, JButton boton2, JButton boton3, JButton boton4, JButton boton5, JButton boton6, JButton boton7, JButton boton8, JButton boton9, int pagina){
        JButton[] listaBotones = {boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9};
        for (int i = pagina * listaBotones.length; i < pagina * listaBotones.length + 9;i++){
            int j = i - pagina * listaBotones.length;
            JButton boton = listaBotones[j];
            if (i >= listaReservas.size()){
                boton.setText("");
            } 
            else{
                Reservas reserva = listaReservas.get(i);
                boton.setText(reserva.getEvento().getTitulo() + "   Precio: " + reserva.getPrecio());
            }
        }
    }
    
    /**
     * Sirve para dar funcionalidad a ciertos botones en torno a un cierto ArrayList de Reservas, dando la posibilidad de mostrar la informacion de la reserva
     * @param listaReservas Es la lista de Reservas en torno a la cual se le aplica la accion al boton
     * @param pagina Es la pagina de botones en la que se encuentra
     * @param nBoton Es la posicion de boton al cual se le esta dando funcionalidad
     */
    public static void accionBotonReservas(ArrayList<Reservas> listaReservas, int pagina, int nBoton, Component parent){
        int i = pagina * 9 + nBoton;
        if (i < listaReservas.size()){
            Reservas reserva = listaReservas.get(i);
            JPanel panelBoton = new JPanel();
                panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
                    
                panelBoton.add(new JLabel("Reservante: " + reserva.getReservante()));
                panelBoton.add(new JLabel("Evento: "));
                panelBoton.add(new JLabel("Titulo: " + reserva.getEvento().getTitulo()));
                panelBoton.add(new JLabel("Tipo: " + reserva.getEvento().getTipo()));
                panelBoton.add(new JLabel("Fecha: " + reserva.getFecha()));
                panelBoton.add(new JLabel("Direccion:"));
                panelBoton.add(new JLabel("Ciudad: " + reserva.getEvento().getDireccion().getCiudad()));
                panelBoton.add(new JLabel("Codigo Postal: " + reserva.getEvento().getDireccion().getCp()));
                panelBoton.add(new JLabel("Calle y nº: " + reserva.getEvento().getDireccion().getCalle() + ", " + reserva.getEvento().getDireccion().getNumero()));
                panelBoton.add(new JLabel("Precio: " + reserva.getPrecio()));
                JOptionPane.showMessageDialog(null, panelBoton, reserva.getEvento().getTitulo(), JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    /**
     * Sirve para dar formato a ciertos botones en relacion a un ArrayList de tipo Reseñas
     * @param listaReseñas Es el ArrayList de Reseñas en torno al cual se da formato
     * @param pagina Es la pagina que de botones en la que se encuentra
     */
    public static void botonReseñas(ArrayList<Reseña> listaReseñas, JButton boton1, JButton boton2, JButton boton3, JButton boton4, JButton boton5, JButton boton6, JButton boton7, JButton boton8, JButton boton9, int pagina){
        JButton[] listaBotones = {boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9};
        for (int i = pagina * listaBotones.length; i < pagina * listaBotones.length + 9;i++){
            int j = i - pagina * listaBotones.length;
            JButton boton = listaBotones[j];
            if (i >= listaReseñas.size()){
                boton.setText("");
            } 
            else{
                Reseña reseña = listaReseñas.get(i);
                boton.setText(reseña.getAutor() + "   Estrellas: " + reseña.getEstrellas());
            }
        }
    }
    
    /**
     * Sirve para dar funcionalidad a ciertos botones en torno a un cierto ArrayList de Reseñas, dando la posibilidad de mostrar la informacion de la Reseña
     * @param listaReseñas Es la lista de Reseñas en torno a la cual se le aplica la accion al boton
     * @param pagina Es la pagina de botones en la que se encuentra
     * @param nBoton Es la posicion de boton al cual se le esta dando funcionalidad
     */
    public static void accionBotonReseñas(ArrayList<Reseña> listaReseñas, int pagina, int nBoton, Component parent){
        int i = pagina * 9 + nBoton;
        if (i < listaReseñas.size()){
            Reseña reseña = listaReseñas.get(i);
            JPanel panelBoton = new JPanel();
                panelBoton.setLayout(new BoxLayout(panelBoton, BoxLayout.Y_AXIS));
                    
                panelBoton.add(new JLabel("Autor: " + reseña.getAutor()));
                panelBoton.add(new JLabel("Evento: "));
                panelBoton.add(new JLabel("Titulo: " + reseña.getEvento().getTitulo()));
                panelBoton.add(new JLabel("Reseña: " + reseña.getTextoReseña()));
                panelBoton.add(new JLabel("Estrellas: " + reseña.getEstrellas()));
                JOptionPane.showMessageDialog(null, panelBoton, reseña.getEvento().getTitulo(), JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Sirve para comprobar si el correo y la contraseña recogidas en los campos de texto coinciden con algun objeto Administrador serializado
     * @param correo es el correo recogido en el campo de texto del inicio de sesion
     * @param contraseña es la contraseña recogida en el campo de texto del inicio de sesion
     * @return retorna un booleano verdadero si hay coincidencias con algun objeto serializado y falso en el caso contrario
     */
    public static boolean comprobarAdmin(String correo, String contraseña){
        HashMap<String, Administrador> listaAdmins = cargarAdmin();
        boolean resultado;
        if (listaAdmins.containsKey(correo)){
            Administrador admin = listaAdmins.get(correo);
            resultado = admin.getContraseña().equals(contraseña);
        }
        else{resultado = false;}
        return resultado;
    }
    
    /**
     * Sirve para comparar el correo y la contraseña introducidas con el HashMap de clientes gurdada para validar el usuario
     * @param correo Es el correo que se introduce en el campo de inicio de sesion
     * @param contraseña es la contraseña que se introduce en el campo de inicio de sesion
     * @return  retorna un booleano positivo si se encuentra el usuario en el HashMap y un booleano negativo en el caso contrario
     */
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
    
    /**
     * Sirve para comprobar el inicio de sesion y saber si se ha ingresado como admin o como cliente
     * @param correo es el campo del que se extrae el correo introducido
     * @param contraseña es el campo del que se extrae la contraseña introducida
     * @return retorna un booleano positivo si se ha completado el inicio de sesion y uno negativo en el caso contrario
     */
    public static boolean inicioDeSesion(String correo, String contraseña){
        boolean resultado = true;
        GestionClientes.admin = comprobarAdmin(correo, contraseña);
        if (GestionClientes.admin = comprobarAdmin(correo, contraseña)){
            GestionClientes.adminActivo = GestionClientes.cargarAdmin().get(correo);
        }
        else {
            if (resultado = GestionClientes.comprobarUsuario(correo, contraseña)){
                GestionClientes.setUsuarioActivo(GestionClientes.cargarClientes().get(correo));
            }
        }
        return resultado;
    }
    
    /**
     * Sirve para recoger la informacion de diferentes campos de texto, comprobar el formato de la informacion y actualizar los datos del correo del cliente 
     * @param boton es el boton que permite saber si se ha pulsado el Ok del JOptionPane.showMessageDialog
     * @param correo es el campo en el que se introduce el correo nuevo del cliente 
     * @param contraseña es el campo en el que se introduce la contraseña
     */
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
    
    /**
     * Sirve para recoger la informacion de diferentes campos de texto, comprobar el formato de la informacion y actualizar los datos de la contraseña del cliente 
     * @param boton es el boton que permite saber si se ha pulsado el Ok del JOptionPane.showMessageDialog
     * @param contraseñaNueva es el campo en el que se introduce la contraseña nueva 
     * @param contraseñaNueva2 es el campo en el que se introduce la confirmacion de la contraseña
     * @param contraseña es el campo en el que se introduce la contraseña antigua
     */
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
    
    /**
     * Sirve para recoger la informacion de diferentes campos de texto, comprobar el formato de la informacion y actualizar los datos de la Tarjeta del cliente 
     * @param boton es el boton que permite saber si se ha pulsado el Ok del JOptionPane.showMessageDialog
     * @param nombreT es el campo en el que se introduce el nombre del titular de la tarjeta 
     * @param numeroT es el campo en el que se introduce el numero de tarjeta 
     * @param fechaT es el campo en el que se introduce la fecha de caducidad de la tarjeta 
     * @param contraseña es el campo en el que se introduce la contraseña
     */
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
    
    /**
     * Sirve para recoger la informacion de diferentes campos de texto, comprobar el formato de la informacion y actualizar los datos de la direccion del cliente 
     * @param boton es el boton que permite saber si se ha pulsado el Ok del JOptionPane.showMessageDialog
     * @param calle es el campo en el que se introduce la calle 
     * @param numero es el campo en el que se introduce el numero
     * @param ciudad es el campo en el que se introduce la ciudad
     * @param codigo es el campo en el que se introduce el codigo
     * @param contraseña es el campo en el que se introduce la contraseña
     */
    public static void modificarClienteDireccion(int boton, JTextField calle, JTextField numero, JTextField ciudad, JTextField codigo, JTextField contraseña, Component parent){
        if (boton == JOptionPane.OK_OPTION && (GestionClientes.leerTexto(calle, parent, "Porfavor introduce una calle")&& 
                GestionClientes.leerNumero(numero, parent, "Por favor introduce un número válido") && GestionClientes.leerTexto(ciudad, parent, "Porfavor introduce una ciudad") 
                && GestionClientes.leerNumero(codigo, parent, "Porfavor introduce un código válido") && GestionClientes.leerContraseñaRegistro(contraseña, parent))){
            if (contraseña.getText().equals(usuarioActivo.getContrasena())){
                HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
                lista.get(usuarioActivo.getCorreo()).getDireccion().setCalle(calle.getText());
                lista.get(usuarioActivo.getCorreo()).getDireccion().setNumero(Integer.parseInt(numero.getText()));
                lista.get(usuarioActivo.getCorreo()).getDireccion().setCiudad(ciudad.getText());
                lista.get(usuarioActivo.getCorreo()).getDireccion().setNumero(Integer.parseInt(codigo.getText()));
                GestionClientes.guardarClientes(lista);
                JOptionPane.showMessageDialog(parent, 
                        "Cambio de dirección", 
                        "Has actualizado dirección", 
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }    
        }
        else{
            JOptionPane.showMessageDialog(parent, 
                    "Contraseña incorrecta", 
                    "La contraseña no coincide", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /**
     * Sirve para agregar un Cliente nuevo al HashMap de clientes serializado
     * @param cliente Es el objeto cliente que se quiere añadir 
     */
    public static void agregarClienteArchivoRegistro(Cliente cliente){
        HashMap<String, Cliente> lista = GestionClientes.cargarClientes();
        lista.put(cliente.getCorreo(), cliente);
        GestionClientes.guardarClientes(lista);
    }
    
    /**
     * Sirve para eliminar un evento de la lista de eventos Serializada en funcion de su titulo
     * @param eventoABuscar es el evento que se desea eliminar de la lista 
     * @return retorna la lista sin el evento que se quiere eliminar
     */    
    public static ArrayList<Evento> borrarIguales(Evento eventoABuscar){
        ArrayList<Evento> lista = GestionClientes.cargarEventos();
        for (Evento evento : lista){
            if(evento.getTitulo().equals(eventoABuscar.getTitulo())){
                lista.remove(evento);
                break;
            }
        }
        return lista;
    }
    
    /**
     * Sirve para comprobar que el contenido de un campo de texto se puede convertir en una variable de tipo int 
     * @param campo Es el campo del cual se extre el contenido 
     * @param mensajeError es el mensaje que aparecera en el mensaje de error
     * @return retorna la variable tipo int en caso de que se pueda y un null en el caso contrario
     */
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
    
    /**
     * Sirve para comprobar que el contenido de un campo de texto se puede convertir en una variable de tipo Long 
     * @param campo Es el campo del cual se extre el contenido 
     * @param mensajeError es el mensaje que aparecera en el mensaje de error
     * @return retorna la variable tipo Long en caso de que se pueda y un null en el caso contrario
     */
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
    
    /**
     * Sirve para comprobar si un campo de texto esta vacio y crear un mensaje de error en dicho caso
     * @param campo es el campo del que se extrae el contenido 
     * @param mensajeError es el mensaje que aparecera en el mensaje de error
     * @return Retorna un booleano positivo en el caso de que el campo no este vacio y uno negativo en el caso contrario
     */
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
    /**
     * Sirve para comprobar que el formato del texto de un campo de texto es compatible con el de un LocalDate
     * @param campoFecha Es el campo del que se extraera el String para comprobar si tiene un buen formato
     * @return Retorna un booleano positivo si el formato es compatible y el campo no esta vacio y uno negativo en el caso contrario
     */
    
    public static boolean comprobarFecha(String campoFecha, Component parent){
        boolean resultado;
        DateTimeFormatter  formato = DateTimeFormatter .ofPattern("yyyy-MM-dd");
        if (campoFecha.equals("")){
            resultado = false;
        } 
        else{
            try {
                LocalDate.parse(campoFecha, formato);
                resultado = true;
            } 
            catch (DateTimeParseException e) {
                resultado = false;
            }
        }
        return resultado;
    }
    
    /**
     * Sirve para tratar un String y poder pasarlo a un tipo LocalDate
     * @param campoFecha es el campo del que se extraera el String
     * @return retorna un LocalDate con la fecha que representaba el String
     */
    
    public static LocalDate tratarFecha(String campoFecha){
        String[] stringFecha = campoFecha.split("-");
        LocalDate fecha = LocalDate.of(Integer.parseInt(stringFecha[0]), Integer.parseInt(stringFecha[1]), Integer.parseInt(stringFecha[2]));
        System.out.println(fecha);
        return fecha;
    }
    
    /**
     * Sirve para comprobar y devolver una fecha de tipo LocalDate a partir de un campo de Texto, utilizando los metodos tratarFecha u comprobarFecha
     * @param campoFecha es el campo del que se extraera el String a convertir en LocalDate
     * @return retorna un LocalDate en el caso de que la fecha este en el formato correcto y un null en el otro caso
     */
    
    public static LocalDate leerFecha(String campoFecha, Component parent){
        if (comprobarFecha(campoFecha, parent)){
            return tratarFecha(campoFecha);
        } else {
            return null;
        }
    }
    
    /**
     * sirve para leer un campo JTextField cualquiera y comprobar que en su interior solo se han introducido caracteres compatibles con int
     * @param campo es el campo del que se extrae el String 
     * @param mensajeError es el mensaje de error que aparecera en la ventana de error
     * @return retorna un booleano positivo en caso de que se sea un numero y uno negativo en el caso de que no lo sea
     */
    public static boolean leerNumero(JTextField campo, Component parent, String mensajeError){
        Integer aux = leerEntero(campo, parent, mensajeError);
        if (aux == null){
            return false;
        }
        return true;
    }
    
    /**
     * Sirve para comprobar que el campo de numero de Telefono tiene la longitud necesaria y no contiene caracteres invalidos
     * @param campo Es el campo tipo JTextField del que se extrae el String numero de Telefono
     * @return retorna un booleano positivo si dicho campo tiene el formato correcto y uno negativo si no lo tiene.
     */
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
    
    /**
     * Sirve para comprobar que el campo de Numero de Tarjeta tiene la longitud necesaria y no contene caracteres invalidos
     * @param campo Es el campo tipo JTextField del que se extrae el String numero de Trajeta
     * @return retorna un booleano positivo si dicho campo tiene el formato correcto y uno negativo si no lo tiene.
     */    
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
    
    /**
     * Sirve para comprobar que el campo del que se xtrae el correo no esta vacio o con un formato incorrecto.
     * @param campo es el campo tipo JTextField del que se extrae el correo
     * @return retorna un booleano positivo si el correo no esta vacio y esta en el formato correcto y uno negativo si esta vacio o no tiene el formato correcto
     */    
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
    
    /**
     * Sirve para leer una contraseña desde un campo tipo JTextField y comprobar que no este vacio
     * @param campo es el campo del que se extrae la contraseña
     * @return retorna un booleano positivo si no esta vacio y un boolenao negativo si lo esta.
     */
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
    
    /**
     * Sirve para comprobar el formato de un campo contraseña a la hora de registrarse
     * @param campo Es el campo del que se extrae la contraseña
     * @return retorna un booleano positivo si la contraseña tiene el formato correcto y negativo si no lo tiene
     */
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
    
    /**
     * Sirve para comprobar el Pin/contraseña para acceder al registro de un admin
     * @param campo Es el campo del cual se extrae el Pin introducido
     * @return retorn un booleano positivo si el pin es correcto o uno negativo si es incorrecto
     */
    
    public static boolean comprobarPinAdmin(JTextField campo, Component parent){
        if (campo.getText().equals("")){
            JOptionPane.showMessageDialog(parent,
                "Por favor introduce el pin.",
                "ERROR de Entrada", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else if (!campo.getText().equals("123456789")){
            JOptionPane.showMessageDialog(parent,
                "Contraseña PIN incorrecta.",
                "ERROR de Entrada", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else {return true;}
    }
    
    /**
     * Sirve para comprobar si el campo de texto correspondiente a lcorreo del admin esta en el formato correcto o no 
     * @param campo Es el campo de texto del que se extrae el correo
     * @return Retorna un booleano positivo si esta en el formato correcto y neegativo si no lo esta
     */
    public static boolean leerCorreoAdmin(JTextField campo, Component parent){
        if (campo.getText().equals("")){
            JOptionPane.showMessageDialog(parent,
                "Por favor, introduce un correo.",
                "Correo no introducido", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else if (!campo.getText().endsWith("@javaevents.es") && !campo.getText().endsWith("@javaevents.com")){
            JOptionPane.showMessageDialog(parent,
                "Formato del correo invalido.",
                "Formato correo invalido", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else{return true;}
    }
    
    /**
     * Sirve para comparar dos capos de contraseñas 
     * @param contra1 Es la contraseña uno 
     * @param contra2 Es la contraseña dos 
     * @return Retorna un booleano positivo si son iguales y negativo si son diferentes
     */
    public static boolean compararContraseñaAdmin (JTextField contra1, JTextField contra2, Component parent){
        if (contra1.getText().equals("") || contra2.getText().equals("")){
            JOptionPane.showMessageDialog(parent,
                "Por favor rellena todos los campos.",
                "Campo/s vacio/s", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else if (!contra1.getText().equals(contra2.getText())){
            JOptionPane.showMessageDialog(parent,
                "Las contraseñas no coinciden.",
                "Comprueba contraseñas", 
                JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else{return true;}
    }
}
