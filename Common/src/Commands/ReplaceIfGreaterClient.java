package Commands;


import Collection.Product;
import Expections.WrongArguments;
import Utils.CLIManager;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;


/**
 * Class replace the value by key if the new value is greater than the old one
 */
public class ReplaceIfGreaterClient implements ClientCommand {
    private Product product;
    private String key;

    public Product getProduct() {
        return product;
    }

    public String getKey() {
        return key;
    }

    @Override
    public ReplaceIfGreaterClient getNewObject(){
        return new ReplaceIfGreaterClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: replace the value by key if the new value is greater than the old one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        CLIManager cliManager = new CLIManager();

        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        this.key = args[1];
        this.product = new Product();
        cliManager.requestProduct(this.product);
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)) {
            System.out.println("--Updated successfully--");
        } else if (response.getResponseCode().equals(ResponseCodes.OK_WITH_MESSAGE)) {
            System.out.println(response.getMessage());
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
