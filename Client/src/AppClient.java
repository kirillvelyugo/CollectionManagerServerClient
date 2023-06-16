import Connection.UDPClient;
import Utils.RequestPort;

import java.io.IOException;

public class AppClient {
    public static void main(String[] args) throws IOException {
        UDPClient connection = new UDPClient("localhost", RequestPort.getPort());
        connection.interactiveMode();
    }
}
