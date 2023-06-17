import Connection.AuthRequest;
import Connection.UDPClient;
import Utils.RequestPort;
import Utils.Response;
import Utils.UserData;

import java.io.IOException;

public class AppClient {
    public static void main(String[] args) throws IOException {
        UDPClient connection = new UDPClient("localhost", RequestPort.getPort());

        // auth user
        UserData userData = Login.login(connection);
        if (userData != null) connection.interactiveMode(userData);
    }
}
