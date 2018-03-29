import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTcpEcho {

    private Integer nbClients;
    private Integer port;

    public ServeurTcpEcho(Integer nbClients, Integer port) {
        this.nbClients = nbClients;
        this.port = port;
    }

    public void start() throws IOException {

        Socket client;

        ServerSocket serveur = new ServerSocket(port);

        for (int i = 1; i <= nbClients; ++i) {

            client = serveur.accept();
            ThreadServeurEcho thread = new ThreadServeurEcho(client);
            thread.start();


        }
    }
}
