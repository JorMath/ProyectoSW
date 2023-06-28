import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
    public String nombre;
    private String numTelefono;
    public ArrayList<Usuario> usuariosAmigos = new ArrayList<>();
   // public ArrayList<Grupo> grupos = new ArrayList<>();

    public Usuario(String nombre, String numTelefono) {
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }
    public Usuario(){

    }


    public ArrayList<Usuario> retornarAmigos(Usuario usuarioPrincipal){
        return  usuarioPrincipal.usuariosAmigos;
    }

    static Scanner sc = new Scanner(System.in);
}
