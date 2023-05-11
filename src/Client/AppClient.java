package Client;

import Client.Commands.ExitClient;
import Client.Commands.MaxByNameClient;
import Client.Commands.ShowClient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8765);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        MaxByNameClient command = new MaxByNameClient();

        objectOutputStream.writeObject(command);
    }
}
