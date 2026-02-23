package MainClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");
        try {
            Client client = new Client("localhost");
            client.connetti("localhost", 3000);
            client.scrivi();
            client.leggi();
            client.chiudi();
        } catch (IOException e) {
            System.out.println("Errore nella connessione con il server");
        }
    }
}