package Client;

import Client.Commands.Show;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8765);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        Show show = new Show();

        objectOutputStream.writeObject(show);
    }
}
