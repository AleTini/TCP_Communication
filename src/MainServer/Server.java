package MainServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket clientSocket;
    int porta;

    Server(int porta) throws IOException {
        this.porta = porta;
        this.serverSocket = new ServerSocket(porta);
    }

    public Socket attendi() throws IOException {
        this.clientSocket = serverSocket.accept();
        return clientSocket;
    }
    public void scrivi() throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        writer.println("Ciao!");
        writer.flush();
    }
    public void leggi() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String risposta = reader.readLine();
        System.out.println("CLIENT: ricevuto dal server: " + risposta);
    }
    public void chiudi() throws IOException {
        clientSocket.close();
        serverSocket.close();
    }
    public void termina() throws  IOException{
        serverSocket.close();
    }
}
