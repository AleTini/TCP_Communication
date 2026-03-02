package MainServer;

import java.io.*;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        String mess = "";
        Scanner sc = new Scanner(System.in);

        try {
            Server server = new Server(3000);
            System.out.println("SERVER: in attesa di connessioni...");
            server.attendi(); // connessione
            System.out.println("SERVER: client connesso!");

            while (!mess.equals("esci")) {
                server.leggi(); // prima legge dal client

                System.out.print("Scrivi messaggio: ");
                mess = sc.nextLine(); // leggi input nel main

                server.scrivi(mess); // passa la stringa al metodo
            }
            server.chiudi();

        } catch (IOException e) {
            System.out.println("Errore nel server: " + e.getMessage());
        }
    }
}