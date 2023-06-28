

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Mensaje {

    private final Usuario usuario;
    private final Object contenido;
    private Date fechaInicio;

    public Mensaje(Usuario usuario, Object contenido) {
        this.usuario = usuario;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return usuario.nombre + ": " + contenido;
    }

    public void editarMensaje() {
    }
    public void eliminarMensaje(){

    }
}