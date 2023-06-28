package ObjetosComunicacion;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Date;

public class Conversacion {
    private Date fechaInicio;
    public ArrayList<Mensaje> mensajes = new ArrayList<>();
    public ArrayList<Usuario> usuarios = new ArrayList<>();

    public Conversacion(Usuario emisor, Usuario receptor){

    }
    public Conversacion(Usuario usuario){

    }
    public void agregarUsuario(Usuario nuevoParticipante){

    }
    public void eliminarUsuario(Usuario participante){

    }
}
