/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectojava;

/**
 *
 * @author icesa
 */
public class Tarjeta_credito {
    
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
