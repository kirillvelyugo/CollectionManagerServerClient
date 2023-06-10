import Commands.ClientCommand;
import Utils.Response;

import java.io.*;
import java.net.*;
import java.nio.channels.DatagramChannel;

public class UDPClient {
    private final DatagramSocket datagramSocket;
    private final InetSocketAddress inetSocketAddress;

    public UDPClient(String address, int port) throws UnknownHostException, SocketException {
        this.inetSocketAddress = new InetSocketAddress(InetAddress.getByName(address), port);
        datagramSocket = new DatagramSocket();
    }

    public void sendRequest(ClientCommand command) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(command);
        byte[] data = baos.toByteArray();

        DatagramPacket packet = new DatagramPacket(data, data.length, this.inetSocketAddress);
        datagramSocket.send(packet);
    }

    public Response readResponse() throws IOException, ClassNotFoundException {

        byte[] buffered = new byte[2048];
        DatagramPacket datagramPacket = new DatagramPacket(buffered, buffered.length);

        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();

        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Response response = (Response) ois.readObject();
        return response;
    }




}

