import Connection.UDPClient;
import Utils.RequestPort;
import Utils.UserData;

import java.io.IOException;

public class AppClient {
    public static void main(String[] args) throws IOException {
        UDPClient connection = new UDPClient("localhost", RequestPort.getPort());

        // auth user
        UserData userData = new UserData("username", "pass");

        connection.interactiveMode(userData);
    }
}
