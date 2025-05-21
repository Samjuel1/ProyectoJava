/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectojava;

/**
 *
 * @author icesa
 */
public class Cliente extends Usuario {

    private String nombre;
    private String telefono;
    private Tarjeta_credito tarjeta;
    private Direccion direccion;
    private boolean vip;
    
    public Cliente(String correo, String contrasena, String nombre, String telefono, String titular_tarjeta, String numero_tarjeta, String fecha_caducidad, String calle, int numero, String ciudad, int cp, boolean vip) {
        super(correo, contrasena);
        this.nombre = nombre; 
        this.telefono = telefono;
        this.tarjeta = new Tarjeta_credito(titular_tarjeta,numero_tarjeta, fecha_caducidad);
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.vip = vip;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String comprobar_vip(boolean vip){
    String esvip = "";
    if (vip){
    esvip = "Si.";}
    else{
    esvip = "No.";}
    return esvip;
    }
    
    
    
    @Override
    public String toString() {
        return "Cliente: \n" +
               "Nombre: "  + nombre + "\n" + 
               "Telefono: " + telefono + "\n" +
               "Tarjeta de credito ==> " + tarjeta.toString() + "\n" +
               "Direccion ==> " + direccion.toString() +
               "Correo electronico: " + correo + "\n" + 
               "Clave: " + contrasena + "\n" + 
               "VIP: " + comprobar_vip(vip);
    }
    
}
