package proyectojava;
import java.time.LocalDateTime;
import java.time.Month;
public class ProyectoJava {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("hola@gmail","1234","Juan","651728694","1522 2727 2833 2387","12/28", "callef",4,"madrid",28732,true);
        System.out.println(cliente1);
        Evento e1 = new Evento("Evento Principal", "Concierto", "callef",4,"madrid",28732,LocalDateTime.of(2025, Month.MAY, 1, 10, 30), 20, 5);
        System.out.print(e1);
    }
    
}
