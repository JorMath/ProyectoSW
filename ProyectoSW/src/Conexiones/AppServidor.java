package Conexiones;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import Usuario.Usuario;
import Usuario.Conexion;
import Usuario.Registrarse;


public class AppServidor implements Conexion, Registrarse {
    static ServerSocket socketServidor = null;
    static Usuario usuario;

    public static void main(String[] args) {

        AppServidor servidor = new AppServidor();
        usuario = servidor.ingresarDatos();
        servidor.conexion();
        
    }

    public Usuario ingresarDatos() {
        String nombre = "";
        System.out.println("Ingrese su nombre");
        Scanner scanner = new Scanner(System.in);
        nombre = scanner.nextLine();
        String numTelefono = "";
        System.out.println("Ingresa tu numero de telefono");
        numTelefono = scanner.nextLine();
        usuario = new Usuario(nombre, numTelefono);
        return usuario;
    }
    @Override
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
                    System.out.println("Usuario.Conexion exitosa");
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