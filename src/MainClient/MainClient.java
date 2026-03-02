package MainClient;

import java.io.*;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");
        String mess = "";
        Scanner sc = new Scanner(System.in);

        Client client = new Client("Client1");
        client.connetti("localhost", 3000); // connessione

        while (!mess.equals("esci")) {
            System.out.print("Scrivi messaggio: ");
            mess = sc.nextLine();

            client.scrivi(mess);        // passa la stringa al metodo
            client.leggi();

        }

        client.chiudi();

    }
}