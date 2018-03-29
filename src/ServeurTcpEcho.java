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
        BufferedWriter out;
        BufferedReader in;
        String chaine;

        ServerSocket serveur = new ServerSocket(port);

        for (int i = 1; i <= nbClients; ++i) {
            client = serveur.accept();
            System.out.println("Client : " + client.getInetAddress().getHostAddress());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            while ((chaine = in.readLine()) != null) {
                out.write(chaine.toUpperCase());
                out.newLine();
                out.flush();
            }
            out.close();
            client.close();
        }
    }
}
