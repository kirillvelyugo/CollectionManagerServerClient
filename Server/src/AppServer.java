import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Commands.CommandMapper;
import Expections.InvalidValue;
import Run.DatabaseConnector;
import Utils.RequestPort;

import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.Executors;

public class AppServer {
    public static void main(String[] args) throws IOException, SQLException, InvalidValue {

        DatabaseConnector databaseConnector = new DatabaseConnector("jdbc:postgresql://127.0.0.1:5432/products", "alexivanov", "");


        CollectionManager collectionManager = new CollectionManager(databaseConnector);

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        UDPServer udpServer = new UDPServer(RequestPort.getPort());

        Executors.newSingleThreadExecutor().execute(new CommandsServer.CommandExecutor(collectionManager));

        udpServer.interactiveMode(commandExecutor);
    }
}
