

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Mensaje {

    private final Usuario usuario;
    private final String contenido;


    public Mensaje (Usuario usuario, String contenido){
        this.usuario = usuario;
        this.contenido = contenido;
    }

    @Override
    public String toString(){
        return usuario.nombre + ": " + contenido;
    }
}