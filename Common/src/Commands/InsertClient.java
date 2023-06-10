package Commands;


import Collection.Product;
import Expections.WrongArguments;
import Utils.CLIManager;
import Utils.Response;

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
        if (response.getResponseCode() == 200){
            System.out.println("Inserted successfully");
        } else {
            System.out.println(response.getMessage());
        }
    }
}
