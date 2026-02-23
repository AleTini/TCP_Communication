package MainClient;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public String nome;
    public Socket socket;

    Client(String nome) {
        this.nome = nome;
    }

    public void connetti(String nomeServer, int portaServer) throws IOException {

        socket = new Socket(nomeServer, portaServer);
    }

    public void scrivi() throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), false);
        writer.println("Ciao!");
        writer.flush();
    }
    public void leggi() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String risposta = reader.readLine();
        System.out.println("CLIENT: ricevuto dal server: " + risposta);
    }
    public void chiudi() throws IOException {
        socket.close();
    }
}
