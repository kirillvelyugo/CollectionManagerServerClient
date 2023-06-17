package Commands;

import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

/**
 * Help command. Prints info about all available commands
 */
public class HelpClient implements ClientCommand {
    @Override
    public HelpClient getNewObject(){
        return new HelpClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            System.out.println(response.getPayload());
        } else {
            System.out.println("Request failed with message " + response.getMessage());
        }
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
