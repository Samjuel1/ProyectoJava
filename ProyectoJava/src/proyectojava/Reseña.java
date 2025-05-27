/*
Reseña representa la clase con la que los clientes pueden calificar los eventos de los que realizan una compra,
asignándoles una puntuación y un comentario.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
*/


package proyectojava;

import java.io.Serializable;

public class Reseña implements Serializable{
    private String textoReseña;
    private int estrellas;
    private Evento evento;
    private String autor;

    public Reseña(String textoReseña, int estrellas, Evento evento, String autor) {
        this.textoReseña = textoReseña;
        this.estrellas = estrellas;
        this.evento = evento;
        this.autor = autor;
        
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTextoReseña() {
        return textoReseña;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setTextoReseña(String textoReseña) {
        this.textoReseña = textoReseña;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    
}
