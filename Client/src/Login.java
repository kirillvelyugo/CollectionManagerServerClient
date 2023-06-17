import Connection.UDPClient;
import Utils.UserData;

import java.util.Scanner;


public class Login {

    private static UserData requestUserData(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username");
        String username = scanner.nextLine();

        System.out.println("Enter password");
        String password = scanner.nextLine();

        UserData userData = new UserData(username, password);
        return userData;
    }

}
