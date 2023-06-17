package Connection;

import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

import java.io.IOException;
import java.io.Serializable;

public class AuthRequest implements Serializable {

    private UserData userData;


    public AuthRequest(UserData userData) {
        this.userData = userData;
    }

    public UserData getUserData() {
        return userData;
    }

    public AuthStatus auth(UDPClient udpClient){
        try {
            udpClient.sendAuthRequest(this);
            Response response = udpClient.readResponse();
            AuthStatus authStatus = (AuthStatus) response.getPayload();
            return authStatus;
        } catch (IOException | ClassNotFoundException | NullPointerException e){
        System.out.println("Cannot auth user! Cannot connect to server!");
        return AuthStatus.FAILED;
        }
    }


    public enum AuthStatus{
        SUCCESS,
        WRONG_PASS,
        USER_NOT_EXISTS,
        FAILED;
    }

}
