package MainServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        try {
            Server server = new Server(3000);
            System.out.println("SERVER: in attesa di connessioni...");
            server.attendi(); // si blocca qui finché il client non si connette
            System.out.println("SERVER: client connesso!");
            server.leggi();
            server.scrivi();
            server.chiudi();
        } catch (IOException e) {
            System.out.println("Errore nel server: " + e.getMessage());
        }
    }
}