import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Run.DatabaseConnector;
import Utils.RequestPort;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class AppServer {
    public static void main(String[] args) throws IOException, SQLException {

        // read database password from file

        Path path = Paths.get("/home/studs/s367971/.pgpass");
        Scanner scanner = new Scanner(path);
        String pass = scanner.nextLine().split(":")[4];

        DatabaseConnector databaseConnector = new DatabaseConnector("jdbc:postgresql://pg/studs", "s367971", pass);

        CollectionManager collectionManager = new CollectionManager(databaseConnector);

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        UDPServer udpServer = new UDPServer(RequestPort.getPort());

        Executors.newSingleThreadExecutor().execute(new CommandsServer.CommandExecutor(collectionManager));

        udpServer.interactiveMode(commandExecutor, databaseConnector);
    }
}
