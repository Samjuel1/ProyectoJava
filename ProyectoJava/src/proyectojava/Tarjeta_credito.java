/*
Tarjeta_credito representa la clase con la que los clientes registran sus datos para poder realizar compras en los eventos.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
 */
package proyectojava;

import java.io.Serializable;

public class Tarjeta_credito implements Serializable{
    
    private String numero_tarjeta;
    private String fecha_caducidad;
    private String nombre_titular;
    
    

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }


    public Tarjeta_credito(String nombre_titular, String numero_tarjeta, String fecha_caducidad) {
        this.nombre_titular = nombre_titular;
        this.numero_tarjeta = numero_tarjeta;
        this.fecha_caducidad = fecha_caducidad;
    }

    @Override
    public String toString() {
        return  "{ Numero de tarjeta: " + numero_tarjeta + ". Fecha de caducidad: " + fecha_caducidad + ". Titular de la tarjeta: " + nombre_titular + " }";
    }

    

    
    

    
}
