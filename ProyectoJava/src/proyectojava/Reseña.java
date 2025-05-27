package proyectojava;

import java.io.Serializable;

public class Reseña {
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
