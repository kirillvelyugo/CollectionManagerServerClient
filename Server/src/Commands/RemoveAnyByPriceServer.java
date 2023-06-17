package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Remove_any_by_price command
 */
public class RemoveAnyByPriceServer implements ServerCommand {
    private CollectionManager collectionManager;

    public RemoveAnyByPriceServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        RemoveAnyByPriceClient removeAnyByPriceClient = (RemoveAnyByPriceClient) command;
        Response response = new Response();

        int userId = command.getUserData().getId();

        for(String key : collectionManager.getKeySet()){
            if (collectionManager.getByKey(key).getCreatedBy() == userId) {
                if (collectionManager.getByKey(key).getPrice().equals(removeAnyByPriceClient.getPrice())) {
                    collectionManager.removeKey(key);
                    response.setResponseCode(ResponseCodes.OK);
                    return response;
                }
            }
        }

        response.setMessage(" Nothing to remove");
        response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);

        return response;
    }

    @Override
    public String getDescription() {
        return "[price] Description: remove one element from the collection, the value of the price field of which is equivalent to the given one";
    }

    @Override
    public String getName() {
        return "Remove_any_by_price";
    }
}
