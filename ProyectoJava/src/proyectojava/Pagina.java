package proyectojava;

import java.util.ArrayList;
import java.util.HashMap;

public class Pagina {
    private ArrayList<Evento> ListaEventos;
    private HashMap<String,Cliente> UsuariosClientes;
    private HashMap<String, Administrador> UsuariosAdministradores;

    public Pagina() {
        this.ListaEventos = new ArrayList<>();
        this.UsuariosClientes = new HashMap<>();
        this.UsuariosAdministradores = new HashMap<>();
    }

    public ArrayList<Evento> getListaEventos() {
        return ListaEventos;
    }
    
    public HashMap<String, Cliente> getUsuariosClientes(){
        return this.UsuariosClientes;
    }
    
    public void añadirCliente(Cliente cliente){
        this.UsuariosClientes.put(cliente.getNombre(), cliente);
    }
    
    public HashMap<String, Administrador> getUsuariosAdministradores(){
        return this.UsuariosAdministradores;
    }
    
    public void añadirAdministradores(Administrador administrador){
        this.UsuariosAdministradores.put(administrador.getCorreo(), administrador);
    }
    
    public ArrayList<Evento> busquedaEventoPorCiudad(String ciudad){
        ArrayList<Evento> EventosPorCiudad = new ArrayList<>();
        for (int i = 0; i < this.ListaEventos.size(); i++){
            if (ListaEventos.get(i).getDireccion().getCiudad().equals(ciudad)){
                EventosPorCiudad.add(ListaEventos.get(i));
            }
        }
        return EventosPorCiudad;
    }
    public ArrayList<Evento> busquedaEventoPorTipo(String tipo) {
        ArrayList<Evento> EventosPorTipo = new ArrayList<>();
        for (int i = 0; i < this.ListaEventos.size(); i++){
            if (ListaEventos.get(i).getTipo().equals(tipo)){
                EventosPorTipo.add(ListaEventos.get(i));
            }
        }
        return EventosPorTipo;
    }
    
    // Crear, Eliminar y Modificar Eventos como Administrador
    
    public void añadirEvento(Evento evento){
        ListaEventos.add(evento);
    }
    
    public void eliminarEvento(Evento evento){
        if(ListaEventos.contains(evento)){
            ListaEventos.remove(evento);
        }
        else{
            System.out.println("Este evento no existe");
        }
    }
    
}
