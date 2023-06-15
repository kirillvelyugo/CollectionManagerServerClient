import Expections.WrongArguments;
import Utils.RequestPort;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppClient {
    public static void main(String[] args) throws IOException {
        UDPClient connection = new UDPClient("localhost", RequestPort.getPort());
        connection.interactiveMode();
    }
}
