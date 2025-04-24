/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectojava;

/**
 *
 * @author icesa
 */
public class Direccion {
    
    private String calle;
    private int numero;
    private String ciudad;
    private int cp;

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
        return "{ Calle: " + calle + ". Numero: " + numero + ". Ciudad: " + ciudad + ". Codigo postal" + cp + " }";
    }
    

    
}
