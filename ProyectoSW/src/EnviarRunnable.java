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
        while (true) {
            String contenido= scanner.nextLine();
            Mensaje mensaje = new Mensaje(usuario, contenido);
            try {

                dataOutputStream.writeUTF(mensaje.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
