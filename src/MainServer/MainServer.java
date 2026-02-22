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
            System.out.println("SERVER: client connesso");

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Prima ricezione e risposta
            String messaggio1 = reader.readLine();
            System.out.println("SERVER: ricevuto dal client: " + messaggio1);
            writer.println("Ciao anche a te!");

            // Seconda ricezione e risposta
            String messaggio2 = reader.readLine();
            System.out.println("SERVER: ricevuto dal client: " + messaggio2);
            writer.println("Bene!");

            clientSocket.close();
            server.close();

        } catch (IOException e) {
            System.err.println("Porta non disponibile, errore nella creazione del socket");
        }
    }
}