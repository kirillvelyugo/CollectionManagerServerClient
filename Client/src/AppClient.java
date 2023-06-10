import Commands.*;
import Expections.WrongArguments;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class AppClient {
    public static void main(String[] args) throws IOException, WrongArguments, ClassNotFoundException {
        UDPClient connection = new UDPClient("localhost", 3434);

        ClientCommand insert = new InsertClient();
        args = new String[]{"update", "1"};
        insert.prepareRequest(args);

        connection.sendRequest(insert);
        insert.acceptResponse(connection.readResponse());

    }
}
