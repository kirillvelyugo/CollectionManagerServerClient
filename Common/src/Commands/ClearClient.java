package Commands;


import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

/**
 * Clear command. Delete all items from collection.
 */
public class ClearClient implements ClientCommand {

    @Override
    public ClearClient getNewObject(){
        return new ClearClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: clear the collection";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            System.out.println("Collection cleared successfully");
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
