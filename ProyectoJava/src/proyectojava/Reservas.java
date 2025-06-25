/*
Reservas representa la clase con la que los clientes compran entradas, y se mantienen guardadas en su perfil,
que pueden ser visualizadas posteriormente.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
*/
package proyectojava;

import java.io.Serializable;


public class Reservas implements Serializable{

    private String reservante;
    private String fecha;
    private double precio;
    private Evento evento;
    
    /**
     * El método Reservas devuelve una reserva que haya sido puesta por un usuario
     * 
     * @param reservante Nombre del usuario que realiza la reserva
     * @param fecha Fecha en la que el usuario realiza la reserva
     * @param precio Precio total de la suma de todas las entradas que compre el usuario
     * @param evento Evento de la reserva
     */

    public Reservas(String reservante, String fecha, double precio, Evento evento) {
        this.reservante = reservante;
        this.fecha = fecha;
        this.precio = precio;
        this.evento = evento;
        
    }
    
    /**
     * @return Devuelve el evento asignado a la reserva
     */

    public Evento getEvento() {
        return evento;
    }
    
    /**
     * @param evento Evento de la reserva
     */

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    /**
     * 
     * @return Devuelve el reservante del evento
     */
    
    public String getReservante() {
        return reservante;
    }
    
    /**
     * @param reservante Nombre del usuario que realiza la reserva
     */

    public void setReservante(String reservante) {
        this.reservante = reservante;
    }
    
    /**
     * @return Devuelve la fecha de la reserva del evento
     */

    public String getFecha() {
        return fecha;
    }
    
    /**
     * @param fecha Fecha en la que el usuario realiza la reserva
     */

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * @return Devuelve el precio de la reserva
     */

    public double getPrecio() {
        return precio;
    }
    
    /**
     * @param precio Precio total de la suma de todas las entradas que compre el usuario
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * @return Devuelve la información completa de la reserva
     */

    @Override
    public String toString() {
        return "Reservas{" + "reservante=" + reservante + ", fecha=" + fecha + ", precio=" + precio + ", evento=" + evento + '}';
    }
    
    
    
}
