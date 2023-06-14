package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Class replace the value by key if the new value is greater than the old one
 */
public class ReplaceIfGreaterServer implements ServerCommand {
    private CollectionManager collectionManager;

    public ReplaceIfGreaterServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        ReplaceIfGreaterClient replaceIfGreaterClient = (ReplaceIfGreaterClient) command;
        Response response = new Response();

        String key = replaceIfGreaterClient.getKey();

        if (!collectionManager.containsKey(key)) {
            response.setMessage("key is not exist");
            response.setResponseCode(ResponseCodes.ERROR);
            return response;
        }

        Product oldProduct = collectionManager.getByKey(key);
        Product newProduct = replaceIfGreaterClient.getProduct();

        if (newProduct.compareTo(oldProduct) > 0){
           collectionManager.addObj(key, newProduct);
           response.setResponseCode(ResponseCodes.OK);
        } else {
            response.setMessage("--Value of Products didn't update--");
            response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);
        }

        return response;
    }

    @Override
    public String getDescription() {
        return "[key] Description: replace the value by key if the new value is greater than the old one";
    }

    @Override
    public String getName() {
        return "Replace_if_greater";
    }
}
