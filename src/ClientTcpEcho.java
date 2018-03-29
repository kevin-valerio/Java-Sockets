import java.io.*;
import java.net.Socket;

public class ClientTcpEcho {

    private String hostname;
    private Integer port;

    ClientTcpEcho(String host, Integer port) {

        this.hostname = host;
        this.port = port;
    }


    public void start() {

        try {

            Socket echoSocket = new   Socket(hostname, port);
            String bufSend, bufReceived;

            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(echoSocket.getOutputStream()));

            while(true){

                bufSend = clavier.readLine();
                if(bufSend.equals("quit")) break;

                else{
                    out.write(bufSend);
                    out.newLine();
                    out.flush();
                    bufReceived = in.readLine();
                    System.out.print(bufReceived);

                }
            }

            echoSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
