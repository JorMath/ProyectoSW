import java.util.ArrayList;
import java.util.Date;

public class Llamada {
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private float duracion;
    public TipoLlamada tipoLlamada;

    public Llamada(Usuario emisor, Usuario receptor, TipoLlamada tipoLlamada){
        this.usuarios.add(emisor);
        this.usuarios.add(receptor);
        this.tipoLlamada = tipoLlamada;
    }
    public float calcularDuracion(){
        return 0;
    }
    public void agregarUsuario(Usuario nuevoParticipante){

    }
    public void cambiarTipoDeLlamada(TipoLlamada tipoLlamada){

    }
    public void iniciarLlamada(){

    }
    public void finalizarLlamada(){

    }
    public void prenderMicrofono(){

    }
    public void apagarMicrofono(){

    }
    public void prenderCamara(){

    }
    public void apagarCamara(){

    }

}