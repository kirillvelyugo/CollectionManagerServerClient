package Client;

import Client.Commands.ShowClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class AppClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();

        ShowClient show = new ShowClient();

        ByteArrayOutputStream baos = new ByteArrayOutputStream(6400);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(show);
        byte[] data = baos.toByteArray();

        final DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 8375);
        datagramSocket.send(packet);
    }
}
