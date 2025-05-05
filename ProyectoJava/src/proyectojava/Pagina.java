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
    
}
