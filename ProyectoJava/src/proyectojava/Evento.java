package proyectojava;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;

public class Evento implements Serializable{
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private ArrayList<LocalDateTime> ListaFechas;
    private long precio;
    private double calificacion;

    public Evento(String titulo, String tipo, String calle, int numero, String ciudad, int cp, LocalDateTime fechaHora, long precio, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.precio = precio;
        this.calificacion = calificacion;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
        return "Evento{" + "titulo=" + titulo + ", tipo=" + tipo + ", direccion=" + direccion + ", precio=" + precio + ", calificacion=" + calificacion + '}';
    }
    
}
