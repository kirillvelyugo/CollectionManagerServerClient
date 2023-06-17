package Utils;

import java.io.Serializable;

public class UserData implements Serializable {
    private final String username;
    private final String password;
    private boolean toSignUp = false;

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

}
