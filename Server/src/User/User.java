package User;

import Utils.UserData;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class User {
    private String passHash;
    private String username;
    private String salt;
    private int id;

    private String generateSalt(){
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
        return this.passHash.equals(this.getHash(pass + salt));
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

    private User createUser(UserData userData){
        User user = new User();
        user.salt = this.generateSalt();
        user.passHash = this.getHash(userData.getPassword() + this.salt);
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
