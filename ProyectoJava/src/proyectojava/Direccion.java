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
    
    /**
     * @return Devuelve la calle del cliente o del evento
     */
    
    public String getCalle() {
        return calle;
    }
    
    /**
     * @param calle Calle del evento o del usuario
     */

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    /**
     * @return Devuelve el número de puerta del cliente o del evento
     */

    public int getNumero() {
        return numero;
    }
    
    /**
     * @param numero Número de puerta del evento o del usuario
     */

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * @return Devuelve la cuidad del evento o del usuario
     */

    public String getCiudad() {
        return ciudad;
    }
    
    /**
     * @param ciudad Ciudad del evento o del usuario
     */

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * @return Devuelve el código postal del evento o del usuario
     */

    public int getCp() {
        return cp;
    }
    
    /**
     * @param cp Código postal de la ciudad del evento o del usuario
     */

    public void setCp(int cp) {
        this.cp = cp;
    }
    /**
     * El método Dirección devuelve una dirección que será asignada a un cliente o a un evento.
     * 
     * @param calle Calle del evento o del usuario
     * @param numero Número de puerta del evento o del usuario
     * @param ciudad Ciudad del evento o del usuario
     * @param cp Código postal de la ciudad del evento o del usuario
     */

    public Direccion(String calle, int numero, String ciudad, int cp) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.cp = cp;
    }
    
    /**
     * @return Devuelve la información de la dirección completa
     */

    @Override
    public String toString() {
        return " Calle: " + calle + ". Numero: " + numero + ". Ciudad: " + ciudad + ". Codigo postal" + cp ;
    }
    

    
}
