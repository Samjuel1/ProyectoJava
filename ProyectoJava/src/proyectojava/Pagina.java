package proyectojava;

import java.util.ArrayList;

public class Pagina {
    private ArrayList<Evento> ListaEventos;
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Administrador> ListaAdministradores;

    public Pagina() {
        this.ListaEventos = new ArrayList<>();
        this.ListaClientes = new ArrayList<>();
        this.ListaAdministradores = new ArrayList<>();
    }

    public ArrayList<Evento> getListaEventos() {
        return ListaEventos;
    }

    public ArrayList<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public ArrayList<Administrador> getListaAdministradores() {
        return ListaAdministradores;
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
