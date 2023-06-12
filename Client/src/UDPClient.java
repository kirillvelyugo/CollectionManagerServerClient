import Commands.ClientCommand;
import Commands.CommandExecutor;
import Expections.WrongArguments;
import Utils.Response;

import java.io.*;
import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


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
                    clientCommand.acceptResponse(this.readResponse());
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

