package MainServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        System.out.println("SERVER: inizio comunicazione");
        try {
            // Avvio server
            ServerSocket server = new ServerSocket(3000);
            System.out.println("SERVER: pronto in attesa di richieste dei client");

            // Connessione con il client
            Socket clientSocket = server.accept();
            System.out.println("SERVER: connesso al client");

            // Lettura richiesta del client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String richiesta = reader.readLine();
            System.out.println("SERVER: ricevuto dal client: " + richiesta);

            // Invio risposta al client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println("SERVER: messaggio ricevuto!");

            // Chiusura comunicazione
            clientSocket.close();
            // Chiusura server
            server.close();

        } catch (IOException e) {
            System.err.println("Porta non disponibile, errore nella creazione del socket");
        }
    }
}