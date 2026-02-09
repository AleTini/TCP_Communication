package MainServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: inizio comunicazione");
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: pronto in attesa di richieste dei client");
            Socket clientSocket = server.accept();
            System.out.println("SERVER: connesso al client");
            // comunicazione
            clientSocket.close(); // chiusura data socket
            server.close(); // chiusura connection socket


        } catch (IOException e) {
            System.err.println("Porta non disponibile, errore nella " +
                    "creazione del socket");
        }
    }
}
