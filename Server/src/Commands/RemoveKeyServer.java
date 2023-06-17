package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class RemoveKeyServer implements ServerCommand {
    private CollectionManager collectionManager;

    public RemoveKeyServer (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        RemoveKeyClient removeKeyClient = (RemoveKeyClient) command;
        String key = removeKeyClient.getKey();
        Response response = new Response();

        if (!collectionManager.containsKey(key)){
            response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);
            response.setMessage("no element with this key in the collection");
            return response;
        }
        if (collectionManager.getByKey(key).getCreatedBy() != command.getUserData().getId()) {
            response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);
            response.setMessage("you don't have permissions to remove it element");
            return response;
        }

        collectionManager.removeKey(removeKeyClient.getKey());
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove an element from a collection by its key";
    }

    @Override
    public String getName() {
        return "Remove_key";
    }
}
