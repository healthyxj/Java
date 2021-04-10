import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6789);

        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();

        byte[] byt = new byte[1024];

        is.read(byt);

        String sentence = new String(byt);

        System.out.println(sentence.toUpperCase());
        OutputStream os = socket.getOutputStream();

        os.write("Thanks".getBytes());

        socket.close();
        serverSocket.close();
    }
}
