package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Hiram
 */
public class SocketServidor {


    public static void main(String[] args) throws IOException {
        
        BufferedReader entrada = null;
        PrintWriter salida = null;

        double factorial = 1;

        double numero;
        Socket socket = null;
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Esperando conexion de cliente en el puerto...");
        
        while (true) {
            try {
                socket = serverSocket.accept();
                
                System.out.println("Conexion establecida desde la IP: " + socket.getInetAddress());
                
               entrada = new BufferedReader( new InputStreamReader(socket.getInputStream()));
               salida = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()), true);
               
               
               numero= Integer.parseInt(entrada.readLine());
               while ( numero!=0) {
            factorial=factorial*numero;
                     numero--;
                }
            
               
                String saludoServer = factorial + "!!";
                salida.println(saludoServer);
                socket.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
}
