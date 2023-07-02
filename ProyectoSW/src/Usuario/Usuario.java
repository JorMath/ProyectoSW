package Usuario;

import ObjetosComunicacion.Grupo;
import ObjetosComunicacion.Llamada;
import ObjetosComunicacion.Momento;

import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
    public String nombre;
    private String numTelefono;
    public ArrayList<Usuario> usuariosAmigos = new ArrayList<>();
    public ArrayList<Momento> momentos = new ArrayList<Momento>();
    public ArrayList<Grupo> participaEnGrupo = new ArrayList<>();
    public ArrayList<Llamada> registroDeLlamadas = new ArrayList<Llamada>();
   // public ArrayList<ObjetosComunicacion.Grupo> grupos = new ArrayList<>();

    public Usuario(String nombre, String numTelefono) {
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }
    public void agregarAmigo(Usuario usuario){}
    public void salirDeGrupo(Grupo grupo){}
    static Scanner sc = new Scanner(System.in);
}
