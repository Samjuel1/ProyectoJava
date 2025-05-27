/*
Evento representa la clase con la que los usuarios interactúan pudiendo buscar, reservar y comprar plazas para estos,
así como añadirles reseñas.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
*/

package proyectojava;

import java.io.Serializable;
import java.util.ArrayList;

public class Evento implements Serializable{
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private String fecha;
    private long precio;
    private double calificacion;
    private ArrayList<Reseña> listaReseñas;

    public Evento(String titulo, String tipo, String calle, int numero, String ciudad, int cp, long precio, double calificacion, String fecha) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.precio = precio;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.listaReseñas = new ArrayList<Reseña>();
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


    public double getPrecio() {
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
    public void añadirReseña(Reseña reseña){
        if (!this.listaReseñas.contains(reseña)){
        this.listaReseñas.add(reseña);}}
    

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
