package Commands;


import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

/**
 * Class remove from the collection all items whose key exceeds the specified one
 */
public class RemoveGreaterKeyClient implements ClientCommand {
    private String key;

    public String getKey() {
        return key;
    }

    @Override
    public RemoveGreaterKeyClient getNewObject(){
        return new RemoveGreaterKeyClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove from the collection all items whose key exceeds the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        this.key = args[1];
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            int counter = (int) response.getPayload();
            System.out.println("--Removed " + counter + " elements--");
        } else {
            System.out.println(response.getMessage());
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
