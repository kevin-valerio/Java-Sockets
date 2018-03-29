import java.io.IOException;

public class MainBis {

    public static void main(String[] args) throws IOException {


        ServeurTcpEcho serveurTcpEcho = new ServeurTcpEcho
                (100,  50007);
        serveurTcpEcho.start();
    }
}
