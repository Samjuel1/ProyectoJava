package proyectojava;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;

public class Evento implements Serializable{
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private String fecha;
    private long precio;
    private double calificacion;

    public Evento(String titulo, String tipo, String calle, int numero, String ciudad, int cp, long precio, double calificacion, String fecha) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.precio = precio;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public Direccion getDireccion() {
        return direccion;
    }


    public long getPrecio() {
        return precio;
    }

    public double getCalificacion() {
        return calificacion;
    }
    public String getFecha(){
        return fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    
  /*  
    
    public crearBoton(){
        ArrayList<Evento> eventos = GestionClientes.cargarEventos();

        // Verifica que haya al menos un evento
        if (eventos.isEmpty()) {
            return new JButton("Sin eventos disponibles");
        }

        Evento evento = eventos.get(0); // primer evento
        JButton boton = new JButton("Evento: " + evento.getTitulo() + " - Calificación: 0");
        
        boton.setFont(new Font("Arial", Font.BOLD, 30));
        boton.setBackground(Color.WHITE);

        return boton;
    } */

    @Override
    public String toString() {
        return "Evento\n"
        + " Titulo: " + titulo 
        + ", Tipo: " + tipo 
        + ", Direccion ==> [" + direccion + "]" 
        + ", Precio: " + precio 
        + ", Calificacion: " + calificacion + "\n";
    }
    
}
