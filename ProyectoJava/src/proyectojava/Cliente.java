/*
Cliente representa la clase con la que los usuarios acceden a la aplicación.

Está formada por varios campos de texto en los que el cliente puede rellenar con sus datos personales,
para poder acceder a la aplicación.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
 */
package proyectojava;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private String correo;
    private String contrasena;
    private String nombre;
    private String telefono;
    private Tarjeta_credito tarjeta;
    private Direccion direccion;
    private ArrayList<Reseña> listaReseñas;
    private ArrayList<Reservas> listaReservas;
    private boolean esvip;
    
    /**
     * El método Cliente devuelve un cliente el cuál se guardará para poder gestionar su
     * información posteriormente.
     * 
     * @param correo Correo del cliente, que será su usuario para iniciar sesión
     * @param contrasena Contraseña del cliente, que junto al correo serán las claves para que el usuario inicie sesión
     * @param nombre Nombre del cliente
     * @param telefono Teléfono del usuario
     * Tarjeta de crédito asociada al cliente, se guarda mediente un objeto Tarjeta_credito
     * @param titular_tarjeta Nombre del titular de la tarjeta asociada al usuario
     * @param numero_tarjeta Número de tarjeta de la tarjeta asociada al usuario
     * @param fecha_caducidad Fecha de caducidad de la tarjeta asociada al usuario
     * Dirección del cliente, se guarda mediante un objeto Direccion
     * @param calle Calle del usuario
     * @param numero Numero de puerta del usuario
     * @param ciudad Ciudad del usuario
     * @param cp Código postal de la ciudad del usuario
     * @param esvip El cliente puede ser o no vip
     * @param listaReseñas Lista de reseñas de los eventos que el usuario ha reservado
     * @param listaReservas Lista de reservas de los eventos que el usuario ha reservado
     *   
    */
    
    public Cliente(String correo, String contrasena, String nombre, String telefono, String titular_tarjeta, String numero_tarjeta, String fecha_caducidad, String calle, int numero, String ciudad, int cp, boolean esvip) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre; 
        this.telefono = telefono;
        this.tarjeta = new Tarjeta_credito(titular_tarjeta,numero_tarjeta, fecha_caducidad);
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.esvip = esvip;
        this.listaReservas = new ArrayList<Reservas>();
        this.listaReseñas = new ArrayList<Reseña>();

    }
    
    /**
     * @return Devuelve el correo del usuario 
     */

    public String getCorreo() {
        return correo;
    }
    
    /**
     * @return Devuelve si el usuario es vip o no
     */
    
    public boolean getEsvip() {
        return esvip;
    }
    
    /**
     * @return Devuelve la contraseña del usuario
     */

    public String getContrasena() {
        return contrasena;
    }
    
    /**
     * @return Devuelve el nombre del usuario 
     */

    public String getNombre() {
        return nombre;
    }
    
    /**
     * @return Devuelve el teléfono del usuario
     */

    public String getTelefono() {
        return telefono;
    }
    
    /**
     * @return Devuelve los datos de la tarjeta de crédito asignada al usuario 
     */

    public Tarjeta_credito getTarjeta() {
        return tarjeta;
    }
    
    /**
     * @return Devuelve la dirección del usuario
     */

    public Direccion getDireccion() {
        return direccion;
    }
    
    /**
     * @param correo Correo del cliente, que será su usuario para iniciar sesión
     */

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * @param esvip Sirve para saber si el cliente es o no vip
     */
    
    public void setEsvip(boolean esvip) {
        this.esvip = esvip;
    }
    
    /**
     * @param contraseña Contraseña del cliente, que junto al correo serán las claves para que el usuario inicie sesión
     */

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }
    
    /**
     * @param nombre Nombre del cliente
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @param telefono Teléfono del usuario
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * @param tarjeta Tarjeta de crédito asociada al cliente
     */

    public void setTarjeta(Tarjeta_credito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    /**
     * @param direccion Dirección del cliente
     */

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Este método añade una reseña puesta por el usuario que no esté ya en la lista de sus reseñas.
     * 
     * @param reseña Reseña escrita por el cliente de un evento en el que ha reservado
     */
    public void añadirReseña(Reseña reseña){
        if (!this.listaReseñas.contains(reseña) || this.listaReseñas == null){
        this.listaReseñas.add(reseña);}}
    
    /**
     * @return Devuelve la lista de las reseñas puestas por el usuario
     */

    public ArrayList<Reseña> getListaReseñas() {
        return listaReseñas;
    }
    
    /**
     * @param listaReseñas Lista de reseñas de los eventos que el usuario ha reservado
     */

    public void setListaReseñas(ArrayList<Reseña> listaReseñas) {
        this.listaReseñas = listaReseñas;
    }
    
    /**
     * Este método añade una reserva comprada por el usuario.
     * 
     * @param reserva Reserva de un evento comprado por el usuario
     */
    
    public void añadirReserva(Reservas reserva){
        this.listaReservas.add(reserva);
        
    }
    
    /**
     * @return Devuelve la lista de las reservas compradas por el usuario.
     */

    public ArrayList<Reservas> getListaReservas() {
        return listaReservas;
    }
    
    /**
     * @return Devuelve la información completa del cliente
     */
    
    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", contrasena=" + contrasena + ", nombre=" + nombre + ", telefono=" + telefono + ", tarjeta=" + tarjeta + ", direccion=" + direccion + "VIP: " + esvip + '}';
    }
    
    
}
