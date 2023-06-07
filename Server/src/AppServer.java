import Commands.ClientCommand;
import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Utils.Response;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class AppServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // endless command reading
        // endless connection establish
        // parsing arguments
        // executing command
        // sending response

        // if server unavailable
        // error handing

//        CollectionManager collectionManager = new CollectionManager(null);
//        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);
//
//        DatagramSocket datagramSocket = new DatagramSocket(3434);
//
//        byte[] buffered = new byte[2048];
//        DatagramPacket datagramPacket = new DatagramPacket(buffered, buffered.length);
//
//        datagramSocket.receive(datagramPacket);
//        byte[] data = datagramPacket.getData();
//
//        ByteArrayInputStream bais = new ByteArrayInputStream(data);
//        ObjectInputStream ois = new ObjectInputStream(bais);
//
//        ClientCommand clientCommand = (ClientCommand) ois.readObject();
//
//        System.out.println(clientCommand.getClass());
//        System.out.println();
//
//        commandExecutor.doCommand(clientCommand.getClass());
//
//        Response response = new Response(1);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(response);
//        byte[] responseData = baos.toByteArray();
//
//        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, datagramPacket.getAddress(), datagramPacket.getPort());
//        datagramSocket.send(responsePacket);

        UDPServer udpServer = new UDPServer(3434);
        DatagramPacket requestPacket = udpServer.readRequest();
        ClientCommand clientCommand = (ClientCommand) udpServer.getRequest(requestPacket);

        System.out.println(clientCommand);

        Response response = new Response(1);
        udpServer.sendResponse(response, requestPacket);
    }
}
