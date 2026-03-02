package MainServer;

import java.io.*;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {
        String mess = "";
        Scanner sc = new Scanner(System.in);

        Server server = new Server(3000); // primitive socket e bind
        System.out.println("SERVER: in attesa di connessioni...");
        server.attendi(); // richiamato metodo accept
        System.out.println("SERVER: client connesso!");

        while (!mess.equals("esci")) {
            server.leggi(); // prima legge dal client

            System.out.print("Scrivi messaggio: ");
            mess = sc.nextLine(); // leggi input nel main

            server.scrivi(mess); // passa la stringa al metodo
        }

        server.chiudi();

    }
}