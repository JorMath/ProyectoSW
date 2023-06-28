import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class RecibirRunnable implements Runnable {
    private Socket socket;

    public RecibirRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Obtener flujo de entrada del socket
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Leer mensajes del servidor y mostrarlos en la consola
        while (true) {
            String message = null;
            try {
                message = dataInputStream.readUTF();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(message);
        }
    }
}
