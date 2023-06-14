package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Add command. Request element from CLI and add it to collection.
 */
public class InsertServer implements ServerCommand {
    private final CollectionManager collectionManager;

    public InsertServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        InsertClient insertClient = (InsertClient) command;
        String key = insertClient.getKey();
        Product product = insertClient.getProduct();

        if (collectionManager.containsKey(key)) {
            Response response = new Response(ResponseCodes.ERROR);
            response.setMessage("Key already exists!");
            return response;
        }

        this.collectionManager.addObj(key, product);

        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[key] Description: add a new element with the specified key";
    }
}
