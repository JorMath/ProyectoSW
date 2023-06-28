import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class AppServidor implements Conexion{
    //static String nombre = "";
    //static String numTelefono;
    static ServerSocket serverSocket = null;
    static Usuario usuario;

    public static void main(String[] args) {
        ingresarDatos();
        AppServidor servidor = new AppServidor();
        servidor.conexion();
        
    }

    private static void ingresarDatos() {
        String nombre = "";
        System.out.println("Ingrese su nombre");
        Scanner scanner = new Scanner(System.in);
        nombre = scanner.nextLine();
        String numTelefono = "";
        System.out.println("Ingresa tu numero de telefono");
        numTelefono = scanner.nextLine();
        usuario = new Usuario(nombre, numTelefono);
    }

    public void conexion() {

        try {
            socketServidor = new ServerSocket(1449);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            // Aceptar nueva conexión de cliente
            Socket clientSocket = null;
            try {
                clientSocket = socketServidor.accept();
                if (clientSocket.isConnected()) {
                    System.out.println("Conexion exitosa");
                    Thread hiloEnviar = new Thread(new EnviarRunnable(clientSocket, usuario));
                    Thread hiloRecibir = new Thread(new RecibirRunnable(clientSocket));

                    hiloEnviar.start();
                    hiloRecibir.start();
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}