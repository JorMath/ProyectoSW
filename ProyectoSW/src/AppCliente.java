import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class AppCliente {

    //Variables a usar
    static Socket socketCliente ;
    //static String nombre = "";
    static Usuario usuario;
    //static String numTelefono;

    public static void main(String[] args) {
        String nombre = "";
        System.out.println("Ingrese su nombre");
        Scanner scanner = new Scanner(System.in);
        nombre = scanner.nextLine();
        String numTelefono = "";
        System.out.println("Ingrese su numero de telefono");
        numTelefono = scanner.nextLine();
        usuario = new Usuario(nombre,numTelefono);
        try {
            socketCliente = new Socket("127.0.0.1", 1449);
            if (socketCliente.isConnected()){
                System.out.println("Conexion exitosa");
            }
        } catch (Exception e) {

        }

        Thread hiloEnviar = new Thread(new EnviarRunnable(socketCliente, usuario));
        Thread hiloRecibir = new Thread(new RecibirRunnable(socketCliente));

        hiloEnviar.start();
        hiloRecibir.start();
    }
    public static void conexion(){

    }

}

