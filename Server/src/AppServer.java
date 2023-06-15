import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import CommandsServer.ServerCLICommands;
import Utils.RequestPort;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executors;

public class AppServer {
    public static void main(String[] args) throws IOException {
        Path path = null;
        String path_str = System.getenv("path");

        if(path_str == null){
            System.out.println("No path specified. Data not loaded.");
        }
        else {
            path = Paths.get(path_str);
        }

        CollectionManager collectionManager = new CollectionManager(null);
        collectionManager.load(path);

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        UDPServer udpServer = new UDPServer(RequestPort.getPort());

        Executors.newSingleThreadExecutor().execute(new CommandsServer.CommandExecutor(collectionManager));

        udpServer.interactiveMode(commandExecutor);
    }
}
