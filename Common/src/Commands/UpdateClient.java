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
public class UpdateClient implements ClientCommand {
    private Integer id;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public UpdateClient getNewObject(){
        return new UpdateClient();
    }

    @Override
    public String getDescription() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        try {
            this.id = Integer.parseInt(args[1]);
        } catch (NumberFormatException e){
            throw new WrongArguments("Id is not Integer");
        }

        CLIManager cliManager = new CLIManager();
        Product product = new Product();
        cliManager.requestProduct(product);
        this.product = product;
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            System.out.println("Element added successfully");
        } else if (response.getResponseCode().equals(ResponseCodes.OK_WITH_MESSAGE)){
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
