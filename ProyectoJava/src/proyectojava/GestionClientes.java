package proyectojava;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionClientes {
    
    // Nombres de Archivos
    
    private static final String ARCHIVO_CLIENTES = "clientes.dat";
    private static final String ARCHIVO_EVENTOS = "eventos.dat";
    
    // Serializacion de Clientes
    
    public static void guardarClientes(HashMap<String, Cliente> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            out.writeObject(lista);
            System.out.println("Lista de clientes guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); //imprimir error
        }
    }
    
    public static HashMap<String, Cliente> cargarClientes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            return (HashMap<String, Cliente>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<String, Cliente>(); // si falla, devuelve una lista vacía
        }
    }
    
    // Serializacion de Eventos
    
    public static void guardarEventos(ArrayList<Evento> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EVENTOS))) {
            out.writeObject(lista);
            System.out.println("Lista de clientes guardada correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); //imprimir error
        }
    }
    
    public static ArrayList<Evento> cargarEventos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            return (ArrayList<Evento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<Evento>(); // si falla, devuelve una lista vacía
        }
    } 
    
    
}
