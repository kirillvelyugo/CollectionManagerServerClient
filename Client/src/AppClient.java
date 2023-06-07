import Commands.ClearClient;
import Commands.ClientCommand;
import Commands.UpdateClient;
import Expections.WrongArguments;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class AppClient {
    public static void main(String[] args) throws IOException, WrongArguments, ClassNotFoundException {
//        DatagramSocket datagramSocket = new DatagramSocket();
//
//        args = new String[]{"update", "1"};
//
//        UpdateClient updateClient = new UpdateClient();
//        updateClient.prepareRequest(args);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
//        ObjectOutputStream oos = new ObjectOutputStream(baos);
//        oos.writeObject(updateClient);
//        byte[] data = baos.toByteArray();
//
//        final DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 8375);
//        datagramSocket.send(packet);

        UDPClient connection = new UDPClient("localhost", 3434);
        ClientCommand clear = new ClearClient();
        connection.sendRequest(clear);

        System.out.println(connection.readResponse());

    }
}
