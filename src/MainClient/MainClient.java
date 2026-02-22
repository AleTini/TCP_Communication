package MainClient;

import java.io.*;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");
        try {
            // Richiesta connessione
            Socket socket = new Socket("localhost", 3000);

            // Invio richiesta
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), false);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Primo messaggio
            writer.println("Ciao!");
            writer.flush();

            String risposta = reader.readLine();
            System.out.println("CLIENT: ricevuto dal server: " + risposta);

            // Secondo messaggio
            writer.println("Come stai?");
            writer.flush();

            String risposta2 = reader.readLine();
            System.out.println("CLIENT: ricevuto dal server: " + risposta2);

            socket.close();

        } catch (IOException e) {
            System.out.println("Errore nella connessione con il server");
        }
    }
}