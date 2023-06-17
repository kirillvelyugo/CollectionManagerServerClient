package Commands;

import Expections.WrongArguments;
import Utils.Response;
import Utils.UserData;

/**
 * Exit command. Stops program execution without saving any data to file
 */
public class ExitClient implements ClientCommand {
    @Override
    public ExitClient getNewObject(){
        return new ExitClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        System.out.println("--Exit. See you later.--");
        System.exit(0);
    }

    @Override
    public void acceptResponse(Response response) {

    }

    private UserData userData;

    @Override
    public UserData getUserData() {
        return userData;
    }

    @Override
    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
