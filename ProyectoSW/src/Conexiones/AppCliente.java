package Conexiones;

import java.net.Socket;
import java.util.Scanner;
import Usuario.Usuario;
import Usuario.Conexion;
import Usuario.Registrarse;


public class AppCliente implements Conexion, Registrarse {

    //Variables a usar
    static Socket socketCliente ;
    //static String nombre = "";
    static Usuario usuario;
    //static String numTelefono;

    public static void main(String[] args) {
        AppCliente cliente = new AppCliente();
        cliente.conexion();
    }
    @Override
    public Usuario ingresarDatos(){
        String nombre = "";
        System.out.println("Ingrese su nombre");
        Scanner scanner = new Scanner(System.in);
        nombre = scanner.nextLine();
        String numTelefono = "";
        System.out.println("Ingrese su numero de telefono");
        numTelefono = scanner.nextLine();
        usuario = new Usuario(nombre,numTelefono);
        return usuario;
    }
    @Override
    public void conexion(){
        AppCliente cliente = new AppCliente();
        usuario = cliente.ingresarDatos();
        try {
            socketCliente = new Socket("127.0.0.1", 1449);
            if (socketCliente.isConnected()){
                System.out.println("Usuario.Conexion exitosa");
            }
        } catch (Exception e) {

        }
        Thread hiloEnviar = new Thread(new EnviarRunnable(socketCliente, usuario));
        Thread hiloRecibir = new Thread(new RecibirRunnable(socketCliente));

        hiloEnviar.start();
        hiloRecibir.start();
    }

}

