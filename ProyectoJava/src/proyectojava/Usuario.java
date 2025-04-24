/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectojava;

/**
 *
 * @author icesa
 */
public abstract class Usuario {
    
    protected String correo;
    protected String clave;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    


    
}
