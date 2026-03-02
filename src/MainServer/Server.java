package MainServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;


    Server(int porta)  {
        this.porta = porta;
        try {
            this.serverSocket = new ServerSocket(porta);
        } catch (IOException e) {
            System.err.println("Errore nella creazione del socket");;
        }
    }

    public void attendi()  {
        try {
            this.clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Errore nella connessione");;
        }
    }

    public void scrivi(String mess) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println(mess);
        } catch (IOException e) {
            System.err.println("Errore nella scrittura");;
        }
    }

    public void leggi() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String risposta = reader.readLine();
            System.out.println("SERVER: ricevuto dal client: " + risposta);
        } catch (IOException e) {
            System.err.println("Errore nella lettura");;
        }
    }

    public void chiudi(){
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Errore nella chiusura della connessione");;
        }
    }
}