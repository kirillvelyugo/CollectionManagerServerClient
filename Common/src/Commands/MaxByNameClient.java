package Commands;


import Collection.Product;
import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Class output any object from the collection whose name field value is the maximum
 */
public class MaxByNameClient implements ClientCommand {
    @Override
    public MaxByNameClient getNewObject(){
        return new MaxByNameClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: output any object from the collection whose name field value is the maximum";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)) {
            System.out.println(response.getPayload());
        } else if (response.getResponseCode().equals(ResponseCodes.OK_WITH_MESSAGE)) {
            System.out.println("Done." + response.getMessage());
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
