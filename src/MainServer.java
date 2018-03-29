import java.io.IOException;

public class MainServer {

    public static void main(String[] args) throws IOException {


        ClientTcpEcho echoClient = new ClientTcpEcho
                ("127.0.0.1", 50007);
        echoClient.start();
    }
}
