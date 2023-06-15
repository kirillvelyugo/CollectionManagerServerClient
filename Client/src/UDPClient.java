import Commands.ClientCommand;
import Commands.CommandExecutor;
import Expections.WrongArguments;
import Utils.Response;

import java.io.*;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for connecting with Server
 */
public class UDPClient {
    private final DatagramSocket datagramSocket;
    private final InetSocketAddress inetSocketAddress;

    /**
     * Basic constructor for UDPClient
     * @param address server addres
     * @param port server port
     * @throws UnknownHostException
     * @throws SocketException
     */
    public UDPClient(String address, int port) throws UnknownHostException, SocketException {
        this.inetSocketAddress = new InetSocketAddress(InetAddress.getByName(address), port);
        this.datagramSocket = new DatagramSocket();
    }

    /**
     * Method which send Datagram to Server
     * @param command executable command
     * @throws IOException
     */
    public void sendRequest(ClientCommand command) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(command);
        byte[] data = baos.toByteArray();

        DatagramPacket packet = new DatagramPacket(data, data.length, this.inetSocketAddress);
        datagramSocket.send(packet);
    }

    /**
     * Method which get responde from Server
     * @return Response response from Server
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Response readResponse() throws IOException, ClassNotFoundException {
        byte[] buffered = new byte[16384];
        DatagramPacket datagramPacket = new DatagramPacket(buffered, buffered.length);

        datagramSocket.setSoTimeout(1000);
        try {
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();

            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);

            Response response = (Response) ois.readObject();
            return response;
        } catch (SocketTimeoutException e) {
            return null;
        }
    }

    /**
     * Interactive mode on Client side
     */
    public void interactiveMode (){
        CommandExecutor commandExecutor = new CommandExecutor();

        while (true){
            Scanner console = new Scanner(System.in);
            try {
                String line = console.nextLine();

                String[] args = line.split(" ");
                args[0] = args[0].toLowerCase().strip();

                try {
                    ClientCommand clientCommand = commandExecutor.getCommand(args[0]);
                    if (clientCommand == null) {
                        System.out.println("No such command");
                        continue;
                    }
                    clientCommand = clientCommand.getNewObject();
                    clientCommand.prepareRequest(args);

                    this.sendRequest(clientCommand);
                    Response response = this.readResponse();
                    if (response != null) clientCommand.acceptResponse(response);
                    else System.out.println("Cannot get connection with Server");

                } catch (WrongArguments e){
                    System.out.println("Incorrect arguments. Try again. " + e.getMessage());
                } catch (IOException | ClassNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Exit interactive mode");
                return;
            }
        }
    }





}

