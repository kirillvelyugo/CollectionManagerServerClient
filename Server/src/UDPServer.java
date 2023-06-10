import Commands.ClientCommand;
import Commands.CommandExecutor;
import Utils.Response;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    private int serverPort;
    private DatagramSocket datagramSocket;

    public UDPServer (int serverPort) throws SocketException {
        this.serverPort = serverPort;
        DatagramSocket datagramSocket = new DatagramSocket(this.serverPort);
        this.datagramSocket = datagramSocket;
    }

    public void sendResponse (Response response, DatagramPacket datagramPacket) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(response);
        byte[] data = baos.toByteArray();

        DatagramPacket packet = new DatagramPacket(data, data.length, datagramPacket.getAddress(), datagramPacket.getPort());
        datagramSocket.send(packet);
    }

    public DatagramPacket readRequest () throws IOException {
        byte[] buffered = new byte[2048];
        DatagramPacket datagramPacket = new DatagramPacket(buffered, buffered.length);

        datagramSocket.receive(datagramPacket);

        return datagramPacket;
    }

    public ClientCommand getRequest (DatagramPacket datagramPacket) throws IOException, ClassNotFoundException {
        byte[] data = datagramPacket.getData();

        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);

        ClientCommand clientCommand = (ClientCommand) ois.readObject();
        return clientCommand;
    }

    public void interactiveMode (CommandExecutor commandExecutor) {
        while (true){
            try {
                DatagramPacket datagramPacket = this.readRequest();
                ClientCommand command = this.getRequest(datagramPacket);

                Response response = commandExecutor.doCommand(command);

                this.sendResponse(response, datagramPacket);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

}
