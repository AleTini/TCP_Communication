package MainClient;

import java.io.IOException;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainClient {
    public static void main(String[] args) {
        System.out.println("CLIENT: avvio del client!");
        try {
            Socket socket = new Socket("localhost",3000);
        } catch (IOException e) {
            System.out.println("Errore nella connessione con il server");
        }
    }
}