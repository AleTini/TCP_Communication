package MainServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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

            String mess = "";

            while (!mess.equals("esci")) {
                // invio messaggio e attesa risposta

                Scanner sc = new Scanner(System.in);
                System.out.print("Scrivi messaggio: ");
                mess = sc.nextLine();


                writer.println(mess);
                writer.flush();

                String risposta2 = reader.readLine();
                System.out.println("SERVER: ricevuto dal client: " + risposta2);
            }
            server.close();
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("Porta non disponibile, errore nella creazione del socket");
        }
    }
}