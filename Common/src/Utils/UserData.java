package Utils;

import java.io.Serializable;

public class UserData implements Serializable {
    private final String username;
    private final String password;
    private boolean toSignUp = false;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isToSignUp() {
        return toSignUp;
    }

    public void setToSignUp(boolean toSignUp) {
        this.toSignUp = toSignUp;
    }

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", toSignUp=" + toSignUp +
                ", id=" + id +
                '}';
    }
}
