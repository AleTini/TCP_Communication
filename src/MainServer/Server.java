package MainServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    Server(int porta) throws IOException {
        this.porta = porta;
        this.serverSocket = new ServerSocket(porta);
    }

    public void attendi() throws IOException {
        this.clientSocket = serverSocket.accept();
    }

    public void scrivi(String mess) throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        writer.println(mess);
    }

    public void leggi() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String risposta = reader.readLine();
        System.out.println("SERVER: ricevuto dal client: " + risposta);
    }

    public void chiudi() throws IOException {
        clientSocket.close();
        serverSocket.close();
    }
}