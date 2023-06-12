import CollectionManager.CollectionManager;
import Commands.CommandExecutor;

import java.io.*;

public class AppServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // endless command reading
        // endless connection establish
        // parsing arguments
        // executing command
        // sending response

        // if server unavailable
        // error handing

        CollectionManager collectionManager = new CollectionManager(null);
        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        UDPServer udpServer = new UDPServer(7654);
        udpServer.interactiveMode(commandExecutor);
//        DatagramPacket requestPacket = udpServer.readRequest();
//        ClientCommand clientCommand = (ClientCommand) udpServer.getRequest(requestPacket);
//
//        System.out.println(clientCommand);
//
//        Response response = new Response(1);
//        udpServer.sendResponse(response, requestPacket);
    }
}
