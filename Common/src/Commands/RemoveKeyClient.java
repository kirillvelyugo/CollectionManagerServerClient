package Commands;


import Collection.Product;
import Expections.WrongArguments;
import Utils.CLIManager;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class RemoveKeyClient implements ClientCommand {
    private String key;

    public String getKey() {
        return key;
    }

    @Override
    public RemoveKeyClient getNewObject(){
        return new RemoveKeyClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove an element from a collection by its key";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        this.key = args[1];
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            System.out.println("--Remove successfully--");
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
