package Utils;

import java.util.Scanner;

public class RequestPort {
    public static int getPort(){
        int port;
        System.out.println("Enter port:");
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                String port_line = scanner.nextLine();
                port = Integer.parseInt(port_line);
                break;
            } catch (NumberFormatException e){
                System.out.println("Port should be integer. Try again!");
            }
        }
        return port;
    }
}
