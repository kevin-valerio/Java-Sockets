import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ThreadServeurEcho extends Thread {
    private Socket client;

    ThreadServeurEcho(Socket client) {
        this.client = client;
    }

    public void run() {
        try {

            System.out.println("Client : " + client.getInetAddress().getHostAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String chaine;
            while ((chaine = in.readLine()) != null) {
                out.write(chaine.toUpperCase());
                out.newLine();
                out.flush();
            }
            out.close();
            client.close();
        }
        catch (Exception ignored){

        }

    }
}
