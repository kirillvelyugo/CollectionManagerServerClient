package Commands;


import Collection.Product;
import Expections.WrongArguments;
import Utils.CLIManager;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;

/**
 * Add command. Request element from CLI and add it to collection.
 */
public class InsertClient implements ClientCommand {
    private Product product;
    private String key;

    public Product getProduct() {
        return product;
    }

    public String getKey() {
        return key;
    }

    @Override
    public InsertClient getNewObject(){
        return new InsertClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: add a new element with the specified key";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        CLIManager cliManager = new CLIManager();

        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        Product product = new Product();
        cliManager.requestProduct(product);
        this.product = product;
        this.key = args[1];
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            System.out.println("Inserted successfully");
        } else if (response.getResponseCode().equals(ResponseCodes.OK_WITH_MESSAGE)) {
            System.out.println(response.getMessage());
        } else {
            System.out.println("Request failed with message: " + response.getMessage());
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
