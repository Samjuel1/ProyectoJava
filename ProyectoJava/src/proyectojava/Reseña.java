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
    
    /**
     * El método Reseña devuelve una reseña que ha sido puesta por el usuario que ha realizado una reserva.
     * 
     * @param textoReseña Reseña escrita por el usuario al evento
     * @param estrellas Puntuación puesta por el usuario al evento
     * @param evento Evento asignado a la reseña
     * @param autor Autor de la reseña
     */

    public Reseña(String textoReseña, int estrellas, Evento evento, String autor) {
        this.textoReseña = textoReseña;
        this.estrellas = estrellas;
        this.evento = evento;
        this.autor = autor;
        
    }
    
    /**
     * @return Devuelve el evento asignado a la reseña
     */

    public Evento getEvento() {
        return evento;
    }
    
    /**
     * @param evento Evento asignado a la reseña
     */

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    /**
     * @return Devuelve el autor de la reseña
     */

    public String getAutor() {
        return autor;
    }
    
    /**
     * @param autor Autor de la reseña
     */

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    /**
     * @return Devuelve el texto de la reseña escrita por el usuario
     */

    public String getTextoReseña() {
        return textoReseña;
    }
    
    /**
     * @return Devuelve la puntuación de la reseña puesta por el usuario
     */

    public int getEstrellas() {
        return estrellas;
    }
    
    /**
     * @param textoReseña Reseña escrita por el usuario al evento
     */

    public void setTextoReseña(String textoReseña) {
        this.textoReseña = textoReseña;
    }
    
    /**
     * @param estrellas Puntuación puesta por el usuario al evento
     */

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    
    /**
     * @return Devuelve la información completa de la reseña
     */

    @Override
    public String toString() {
        return "Rese\u00f1a{" + "textoRese\u00f1a=" + textoReseña + ", estrellas=" + estrellas + ", evento=" + evento + ", autor=" + autor + '}';
    }
    
    
    
}
