import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ServeurTcpEcho echoServeur = new ServeurTcpEcho
                (20, 50007);
        echoServeur.start();


        ClientTcpEcho echoClient = new ClientTcpEcho
                ("127.0.0.1", 50007);
        echoClient.start();
    }
}
