/*
Direccion representa la clase con la que la clase Evento y la clase Cliente registran sus direcciones para
poder guardarlas.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
 */
package proyectojava;

import java.io.Serializable;
public class Direccion implements Serializable {
    
    public String calle;
    public int numero;
    public String ciudad;
    public int cp;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Direccion(String calle, int numero, String ciudad, int cp) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.cp = cp;
    }

    @Override
    public String toString() {
        return " Calle: " + calle + ". Numero: " + numero + ". Ciudad: " + ciudad + ". Codigo postal" + cp ;
    }
    

    
}
