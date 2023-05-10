package Server;

import Client.Commands.ClientCommand;
import Client.Commands.Show;
import Server.Commands.ServerCommand;
import Server.Commands.ShowServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class AppServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<Type, ServerCommand> map = new HashMap<>();

        map.put(Show.class, new ShowServer());

        ServerSocket serverSocket = new ServerSocket(8765);
        Socket socket = serverSocket.accept();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        ClientCommand clientCommand = (ClientCommand) objectInputStream.readObject();

        ServerCommand serverCommand = map.get(clientCommand.getClass());

        serverCommand.execute();

        serverSocket.close();
        socket.close();
        objectInputStream.close();
    }
}
