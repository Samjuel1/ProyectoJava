/*
Evento representa la clase con la que los usuarios interactúan pudiendo buscar, reservar y comprar plazas para estos,
así como añadirles reseñas.
Es una clase serializada para poder guardar sus datos cuando la aplicación se cierra.
*/

package proyectojava;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Evento implements Serializable{
    private String titulo;
    private String tipo;
    private Direccion direccion;
    private LocalDate fecha;
    private double precio;
    private double calificacion;
    private ArrayList<Reseña> listaReseñas;
    private String rutaImagen;
    
    /**
     * El método Evento devuelve un evento creado por un administrador, con el cuál los 
     * usuarios pueden realizar reservas.
     * 
     * @param titulo Titulo del evento
     * @param tipo Tipo de evento
     * Dirección del evento, se guarda mediante un objeto Direccion
     * @param calle Calle en la que se realizará el evento
     * @param numero Número de puerta en la que se realizará el evento
     * @param ciudad Ciudad en la que se realizará el evento
     * @param cp Código postal de la ciudad en la que sealizará el evento
     * 
     * @param precio Precio de 1 entrada del evento
     * @param calificacion Calificación media, puesta por los usuarios
     * @param fecha Fecha en la que se realizará el evento
     * @param listaReseñas Lista de las reseñas que ha puesto el cliente después de reservar en un evento
     * @param rutaImagen Ruta para localizar las imágenes asociadas a los eventos
     */

    public Evento(String titulo, String tipo, String calle, int numero, String ciudad, int cp, long precio, double calificacion, LocalDate fecha, String rutaImagen) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = new Direccion(calle,numero,ciudad,cp);
        this.precio = precio;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.listaReseñas = new ArrayList<Reseña>();
        this.rutaImagen = rutaImagen;
    }
    
    /**
     * @return Devuelve el título del evento
     */

    public String getTitulo() {
        return titulo;
    }
    
    /**
     * @return Devuelte el tipo de evento
     */

    public String getTipo() {
        return tipo;
    }
    
    /**
     * @return Devuelve la dirección completa del evento
     */

    public Direccion getDireccion() {
        return direccion;
    }
    
    /**
     * @return Devuelve el precio de la compra de entradas del evento
     */

    public double getPrecio() {
        return precio;
    }
    
    /**
     * @return Este método devuelve el precio del evento para un cliente vip
     */
    
    public double getPrecioVip(){
        return Math.round(((precio * 0.9) * 100))/100;
    }
    
    /**
     * @return Devuelve la calificación media del evento
     */

    public double getCalificacion() {
        return calificacion;
    }
    
    /**
     * @return Devuelve la fecha en la que se realiza el evento
     */
    
    public LocalDate getFecha(){
        return fecha;
    }
    
    /**
     * @return Devuelve la lista de las reseñas puestas por el usuario
     */

    public ArrayList<Reseña> getListaReseñas() {
        return listaReseñas;
    }
    
    /**
     * @param listaReseñas Lista de las reseñas que ha puesto el cliente después de reservar en un evento
     */

    public void setListaReseñas(ArrayList<Reseña> listaReseñas) {
        this.listaReseñas = listaReseñas;
    }
    
    /**
     * @return Devuelve la ruta de la imagen asociada al evento
     */

    public String getRutaImagen() {
        return rutaImagen;
    }
    
    /**
     * @param rutaImagen Ruta para localizar las imágenes asociadas a los eventos
     */

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    /**
     * @param titulo Titulo del evento
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * @param fecha Fecha en la que se realizará el evento
     */
    
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    
    /**
     * @param tipo Tipo de evento
     */

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @param direccion Dirección del evento
     */

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     * @param precio Precio de 1 entrada del evento
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * @param calificacion Calificación media, puesta por los usuarios
     */

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    /**
     * @param reseña Reseña asociada al evento, se guarda en la lista de reseñas del evento
     */
    
    public void añadirReseña(Reseña reseña){
        if (!this.listaReseñas.contains(reseña)){
        this.listaReseñas.add(reseña);}}
    
    /**
     * @return Este método devuelve la calificaión media de la nota de las reseñas del evento
     */
    
    public double calcularCalificacion(){
        int suma = 0;
        int conteo = 0;
        for(Reseña reseña : this.listaReseñas){
            suma += reseña.getEstrellas();
            conteo += 1;
        }
        double resultado = suma / conteo;
        return resultado;
    }
    
    /**
     * @return Devuelve la información completa del evento
     */

    @Override
    public String toString() {
        return "Evento\n"
        + " Titulo: " + titulo 
        + ", Tipo: " + tipo 
        + ", Direccion ==> [" + direccion + "]" 
        + ", Precio: " + precio 
        + ", Calificacion: " + calificacion + "\n";
    }
    
}
