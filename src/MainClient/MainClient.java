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
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("CLIENT: ciao!");

            // Lettura risposta
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String risposta = reader.readLine();
            System.out.println("CLIENT: ricevuto dal server: " + risposta);

            // Chiusura comunicazione
            socket.close();

        } catch (IOException e) {
            System.out.println("Errore nella connessione con il server");
        }
    }
}