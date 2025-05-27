/*
Cliente representa la clase con la que los usuarios acceden a la aplicación y 

Está formada por varios campos de texto en los que el cliente puede rellenar con sus datos personales,
para poder acceder a la aplicación.
 */
package proyectojava;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author icesa
 */
public class Cliente implements Serializable {
    private String correo;
    private String contrasena;
    private String nombre;
    private String telefono;
    private Tarjeta_credito tarjeta;
    private Direccion direccion;
    private ArrayList<Reseña> listaReseñas;
    private ArrayList<Reservas> listaReservas;
    
    public Cliente(String correo, String contrasena, String nombre, String telefono, String titular_tarjeta, String numero_tarjeta, String fecha_caducidad, String calle, int numero, String ciudad, int cp) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre; 
        this.telefono = telefono;
        this.tarjeta = new Tarjeta_credito(titular_tarjeta,numero_tarjeta, fecha_caducidad);
        this.direccion = new Direccion(calle,numero,ciudad,cp);
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Tarjeta_credito getTarjeta() {
        return tarjeta;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTarjeta(Tarjeta_credito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public void añadirReseña(Reseña reseña){
        if (!this.listaReseñas.contains(reseña)){
        this.listaReseñas.add(reseña);}}

    public ArrayList<Reseña> getListaReseñas() {
        return listaReseñas;
    }

    public void setListaReseñas(ArrayList<Reseña> listaReseñas) {
        this.listaReseñas = listaReseñas;
    }
    
    public void añadirReserva(Reservas reserva){
        if (!this.listaReservas.contains(reserva)){
        this.listaReservas.add(reserva);
        }
    }

    public ArrayList<Reservas> getListaReservas() {
        return listaReservas;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", contrasena=" + contrasena + ", nombre=" + nombre + ", telefono=" + telefono + ", tarjeta=" + tarjeta + ", direccion=" + direccion + '}';
    }
    
    
}
