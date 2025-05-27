package proyectojava;

import java.time.LocalDate;


public class Reservas {

    private String reservante;
    private LocalDate fecha;
    private Direccion direccion;
    private String titulo;
    private double precio;

    public Reservas(String reservante, LocalDate fecha, String calle, int numero, String ciudad, int cp, String titulo, double precio) {
        this.reservante = reservante;
        this.fecha = fecha;
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.titulo = titulo;
        this.precio = precio;
    }
    
    

    public String getReservante() {
        return reservante;
    }

    public void setReservante(String reservante) {
        this.reservante = reservante;
    }

    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
