package factorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Hiram
 */
public class SocketCliente {

     public static void main(String[] args) {
        String ip = "127.0.0.1";
        int puerto = 6000;
        System.out.println(" socket " + ip + " " + puerto);
        int numero;
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;
        Scanner sc =new Scanner(System.in);
        try {
            socketCliente = new Socket(ip, puerto);
            System.out.println("Enviando solicitud de conexion...");
            System.out.println("Coloca el numero el cual quieres sacar el factorial");
           numero=Integer.parseInt(sc.nextLine());
            entrada = new BufferedReader( new InputStreamReader(socketCliente.getInputStream()));
            salida = new PrintWriter( new OutputStreamWriter(socketCliente.getOutputStream()), true);
            
           
             salida.println(numero);
            System.out.println("recibiendo ... " + entrada.readLine());
            
            socketCliente.close();
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }
    
}
