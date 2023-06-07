package Commands;

import Collection.Product;
import Expections.WrongArguments;
import Utils.CLIManager;
import Utils.Response;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class UpdateClient implements ClientCommand {
    private Integer id;
    private Product product;

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

    }
}
