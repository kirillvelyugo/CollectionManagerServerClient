import Connection.AuthRequest;
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

    public static UserData login(UDPClient udpClient){
        UserData userData = requestUserData();
        while (true) {
            AuthRequest authRequest = new AuthRequest(userData);
            AuthRequest.AuthStatus authStatus = authRequest.auth(udpClient);

            if (authStatus.equals(AuthRequest.AuthStatus.SUCCESS)) return userData;

            if (authStatus.equals(AuthRequest.AuthStatus.USER_NOT_EXISTS)) {
                System.out.println("User does not exist. Do you want to create a new one? [yes/no]");
                if (!requestSubmit()) return null;
                userData.setToSignUp(true);
            }

            if (authStatus.equals(AuthRequest.AuthStatus.WRONG_PASS)) {
                System.out.println("Wrong password! Enter again");
                userData = requestUserData();
            }

            if ((authStatus.equals(AuthRequest.AuthStatus.FAILED))) {
                System.out.println("An error uccered");
                return null;
            }
        }

    }

    private static boolean requestSubmit(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("yes")) {
                return true;
            } else if (line.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Enter \"yes\" or \"no\"");
            }
        }
    }

}


