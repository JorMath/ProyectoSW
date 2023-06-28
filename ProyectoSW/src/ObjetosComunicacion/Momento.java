package ObjetosComunicacion;

import java.util.Date;

public class Momento {
    private Date fechaInicio;
    private Object contenido;
    private String descripcion;
    public Momento(Object contenido, String descripcion){
        this.contenido = contenido;
        this.descripcion = descripcion;
    }
    public Momento(Object contenido){
        this.contenido = contenido;
    }
    public void subirMomento(){

    }
    public void eliminarMomento(){

    }
    public void modificarMomento(){

    }
}
