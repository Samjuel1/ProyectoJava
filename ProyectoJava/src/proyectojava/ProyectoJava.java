/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectojava;

/**
 *
 * @author icesa
 */
public class ProyectoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("hola@gmail","1234","Juan","651728694","1522 2727 2833 2387","12/28", "callef",4,"madrid",28732,true);
        System.out.println(cliente1);
        Administrador admin1 = new Administrador("admin@gmail.com","admin123");
        System.out.println(admin1);
    }
    
}
