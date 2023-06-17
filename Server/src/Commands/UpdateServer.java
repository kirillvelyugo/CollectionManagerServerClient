package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.InvalidValue;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class UpdateServer implements ServerCommand {
    private CollectionManager collectionManager;

    public UpdateServer (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        UpdateClient clientCommand = (UpdateClient) command;
        Product productNew = clientCommand.getProduct();
        Integer id = clientCommand.getId();

        String key = collectionManager.getKeyById(id);

        if(key == null) {
            Response response = new Response(ResponseCodes.ERROR);
            response.setMessage("No element with such id");
            return response;
        }

        if (collectionManager.getByKey(key).getCreatedBy() != command.getUserData().getId()) {
            Response response = new Response(ResponseCodes.OK_WITH_MESSAGE);
            response.setMessage("you don't have permissions to remove it element");
            return response;
        }

        productNew.setId(id);
        collectionManager.update(key, productNew);

        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }

    @Override
    public String getName() {
        return "Update";
    }
}
