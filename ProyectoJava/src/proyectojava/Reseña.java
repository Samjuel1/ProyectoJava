package proyectojava;

public class Reseña {
    private String textoReseña;
    private int estrellas;

    public Reseña(String textoReseña, int estrellas) {
        this.textoReseña = textoReseña;
        this.estrellas = estrellas;
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
