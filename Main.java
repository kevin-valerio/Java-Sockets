import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws Exception {
        String screenName = args[0];
        String host       = args[1];
        int port          = 4444;

         Socket socket = new Socket(host, port);
        In     stdin  = new In();
        In     in     = new In(socket);
        Out    out    = new Out(socket);
        System.err.println("Connected to " + host + " on port " + port);

         while (!stdin.hasNextLine()) {

             String s = stdin.readLine();
             out.println("[" + screenName + "]: " + s);
             StdOut.println(in.readLine());
        }

         System.err.println("Closing connection to " + host);
        out.close();
        in.close();
        socket.close();
    }
}
