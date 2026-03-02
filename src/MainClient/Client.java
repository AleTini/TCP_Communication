package MainClient;

import java.io.*;
import java.net.Socket;

public class Client {
    public String nome;
    public Socket socket;

    Client(String nome) {
        this.nome = nome;
    }

    public void connetti(String nomeServer, int portaServer) throws IOException {
        socket = new Socket(nomeServer, portaServer);
    }

    public void scrivi(String mess) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(mess);
    }

    public void leggi() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String risposta = reader.readLine();
        System.out.println("CLIENT: ricevuto dal server: " + risposta);
    }

    public void chiudi() throws IOException {
        socket.close();
    }
}