package MainClient;

import java.io.*;
import java.net.Socket;

public class Client {
    public String nome;
    public Socket socket;

    Client(String nome) {
        this.nome = nome;
    }

    public void connetti(String nomeServer, int portaServer) {
        try {
            socket = new Socket(nomeServer, portaServer);
        } catch (IOException e) {
            System.err.println("Errore nella connessione");
        }
    }

    public void scrivi(String mess) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(mess);
        } catch (IOException e) {
            System.err.println("Errore nella scrittura");
        }
    }

    public void leggi() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String risposta = reader.readLine();
            System.out.println("CLIENT: ricevuto dal server: " + risposta);
        } catch (IOException e) {
            System.err.println("Errore sulla lettura");
        }
    }

    public void chiudi() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Errore nella chiusura");
        }
    }
}