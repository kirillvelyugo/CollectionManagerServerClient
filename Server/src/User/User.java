package User;

import Connection.AuthRequest;
import Run.DatabaseConnector;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

public class User {
    private String passHash;
    private String username;
    private String salt;
    private int id;


    private static String generateSalt(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    private boolean validatePass(String pass){
        String hash = this.getHash(pass + this.salt);
        return this.passHash.equals(hash);
    }

    public static User auth(UserData userData, DatabaseConnector databaseConnector){
        try {
            User user = databaseConnector.getUser(userData.getUsername());
            if (user == null) return user;

            if (user.validatePass(userData.getPassword())) return user;

            return null; // not valid
        } catch (SQLException e){
            return null;
        }
    }

    public static Response handleAuthRequest(AuthRequest authRequest, DatabaseConnector databaseConnector){
        UserData userData =  authRequest.getUserData();
        if (userData.isToSignUp()){
            try {
                User user = User.createNewUser(userData);
                databaseConnector.addUser(user);
                Response response = new Response(ResponseCodes.OK);
                response.setPayload(AuthRequest.AuthStatus.SUCCESS);
                return response;
            } catch (SQLException e){
                Response response = new Response(ResponseCodes.OK);
                response.setPayload(AuthRequest.AuthStatus.FAILED);
                return response;
            }
        }

        try {
            User user = databaseConnector.getUser(userData.getUsername());
            if (user == null){
                Response response = new Response(ResponseCodes.OK);
                response.setPayload(AuthRequest.AuthStatus.USER_NOT_EXISTS);
                return response;
            }

            if (user.validatePass(userData.getPassword())){
                Response response = new Response(ResponseCodes.OK);
                response.setPayload(AuthRequest.AuthStatus.SUCCESS);
                return response;
            }

            else {
                Response response = new Response(ResponseCodes.OK);
                response.setPayload(AuthRequest.AuthStatus.WRONG_PASS);
                return response;
            }

        } catch (SQLException e){
            Response response = new Response(ResponseCodes.OK);
            response.setPayload(AuthRequest.AuthStatus.FAILED);
            return response;
        }

    }

    private String getHash(String line){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ignored) {}

        byte[] md = messageDigest.digest(line.getBytes());

        BigInteger no = new BigInteger(1, md);

        // Convert message digest into hex value
        String hashtext = no.toString(16);

        return hashtext;
    }

    private static User createNewUser(UserData userData){
        User user = new User();
        user.salt = generateSalt();
        user.passHash = user.getHash(userData.getPassword() + user.salt);
        user.username = userData.getUsername();
        return user;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
