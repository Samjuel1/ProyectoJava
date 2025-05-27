package proyectojava;

import java.io.Serializable;


public class Reservas implements Serializable{

    private String reservante;
    private String fecha;
    private double precio;
    private Evento evento;

    public Reservas(String reservante, String fecha, double precio, Evento evento) {
        this.reservante = reservante;
        this.fecha = fecha;
        this.precio = precio;
        this.evento = evento;
        
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public String getReservante() {
        return reservante;
    }

    public void setReservante(String reservante) {
        this.reservante = reservante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
