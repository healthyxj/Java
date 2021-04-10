import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        String sentence;
        //String modifiedsentence;

        Socket clientsocket = new Socket("127.0.0.1",6789);

        OutputStream get = clientsocket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        sentence = scanner.nextLine();

        get.write(sentence.getBytes());

        InputStream push = clientsocket.getInputStream();
        byte[] byt = new byte[1024];

        int num = push.read(byt);

        System.out.println(new String(byt));

        clientsocket.close();
    }
}
