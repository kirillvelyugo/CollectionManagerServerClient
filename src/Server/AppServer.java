package Server;

import Client.Commands.ClientCommand;
import Client.Commands.ShowClient;
import Server.CollectionManager.CollectionManager;
import Server.Commands.CommandExecutor;
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
        CollectionManager collectionManager = new CollectionManager(null);
        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);


        ServerSocket serverSocket = new ServerSocket(8765);
        Socket socket = serverSocket.accept();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        ClientCommand clientCommand = (ClientCommand) objectInputStream.readObject();
        System.out.println(clientCommand);

        commandExecutor.doCommand(clientCommand.getClass());

        serverSocket.close();
        socket.close();
        objectInputStream.close();
    }
}
