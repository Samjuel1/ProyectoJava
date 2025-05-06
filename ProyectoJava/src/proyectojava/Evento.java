package proyectojava;

import java.time.*;
import java.util.ArrayList;

public class Evento {
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private ArrayList<LocalDateTime> ListaFechas = new ArrayList<>();
    private ArrayList<Reseña> ListaReseñas = new ArrayList<>();
    private long precio;
    private double calificacion;

    public Evento(String titulo, String tipo, String calle, int numero, String ciudad, int cp, long precio) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.precio = precio;
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

    public ArrayList<LocalDateTime> getListaFechas() {
        return ListaFechas;
        
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

    public void addFecha(LocalDateTime fechaHora) {
        this.ListaFechas.add(fechaHora);
        
    }
    public void removeReseña(LocalDateTime fechaHora) {
        if (!this.ListaFechas.contains(fechaHora)){
            System.out.println("No se ha encontrado ningun evento en esa fecha");
        }
        else{
            this.ListaFechas.remove(fechaHora);
        }
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    public double calcularCalificacion(){
        int suma = 0;
        int recuento = 0;
        for (int i = 0; i < ListaReseñas.size(); i++){
            suma += ListaReseñas.get(i).getEstrellas();
            recuento+= 1;
        }
        return Math.round(suma / recuento);
    }

    @Override
    public String toString() {
        return "Evento{" + "titulo=" + titulo + ", tipo=" + tipo + ", direccion=" + direccion + ", ListaFechas=" + ListaFechas + ", ListaReseñas=" + ListaReseñas + ", precio=" + precio + ", calificacion=" + calificacion + '}';
    }

}
