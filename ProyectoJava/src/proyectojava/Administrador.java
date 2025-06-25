/*
Administrador representa la clase con la que los administradores acceden a la aplicación y 

Gracias a esta clase se puede acceder como administrador para gestionar los eventos
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
 */

package proyectojava;

import java.io.Serializable;


public class Administrador implements Serializable{
    private String correo;
    private String contraseña;
    
    /**
     * El método Administrador devuelve un administrador el cuál se guardará para poder gestionar su
     * información posteriormente.
     * 
     * @param correo Correo del administrador, será su usuario para iniciar sesión
     * @param contraseña Contraseña del administrador, que junto al correo seran las claves para que el usuario inicie sesión
     */

    public Administrador(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
        
    }
    
    /**
     * @return Devuelve el correo del administrador
     */
    

    public String getCorreo() {
        return correo;
    }
    
    /**
     * @param correo Correo del administrador, será su usuario para iniciar sesión
     */

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * @return Devuelve la contraseña del administrador
     */

    public String getContraseña() {
        return contraseña;
    }
    
    /**
     * @param contraseña Contraseña del administrador, que junto al correo seran las claves para que el usuario inicie sesión
     */

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    /**
     * @return Devuelve la información completa del administrador
     */

    @Override
    public String toString() {
        return "Administrador{" + "correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}



