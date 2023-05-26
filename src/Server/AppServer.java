package Server;

import Client.Commands.ClientCommand;
import Server.CollectionManager.CollectionManager;
import Server.Commands.CommandExecutor;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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

        DatagramSocket datagramSocket = new DatagramSocket(8375);

        byte[] buffered = new byte[65536];
        DatagramPacket datagramPacket = new DatagramPacket(buffered, buffered.length);

        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();

        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);

        ClientCommand clientCommand = (ClientCommand) ois.readObject();
        System.out.println(clientCommand.getClass());

        commandExecutor.doCommand(clientCommand.getClass());


//        ServerSocket serverSocket = new ServerSocket(8765);
//        Socket socket = serverSocket.accept();
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//
//        ClientCommand clientCommand = (ClientCommand) objectInputStream.readObject();
//        System.out.println(clientCommand);
//
//        commandExecutor.doCommand(clientCommand.getClass());
//
//        serverSocket.close();
//        socket.close();
//        objectInputStream.close();


    }
}
