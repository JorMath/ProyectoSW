package Conexiones;
import Usuario.Usuario;
import Usuario.ObjetosComunicacion.Conversacion;
import Usuario.ObjetosComunicacion.Mensaje;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EnviarRunnable implements Runnable {
    private Socket socket;
    private Usuario usuario;

    public EnviarRunnable(Socket socket, Usuario usuario) {
        this.socket = socket;
        this.usuario = usuario;
    }

    @Override
    public void run() {
        // Obtener flujo de salida del socket
        DataOutputStream dataOutputStream = null;
        try {
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Leer mensajes del usuario y enviarlos al servidor
        Scanner scanner = new Scanner(System.in);
        Conversacion conversacion = new Conversacion(usuario);
        while (true) {
            String contenido= scanner.nextLine();
            Mensaje mensaje = new Mensaje(usuario, contenido);
            conversacion.mensajes.add(mensaje);
            try {
                dataOutputStream.writeUTF(mensaje.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
