package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

import java.util.HashSet;
import java.util.Set;

/**
 * Class remove all items from the collection whose key is less than the specified one
 */
public class RemoveLowerKeyServer implements ServerCommand {
    private CollectionManager collectionManager;

    public RemoveLowerKeyServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        RemoveLowerKeyClient removeLowerKeyClient = (RemoveLowerKeyClient) command;
        String key = removeLowerKeyClient.getKey();

        int userId = command.getUserData().getId();

        int counter = 0;
        Set<String> keyset = collectionManager.getKeySet();
        Set<String> toRemove = new HashSet<>();
        for(String k : keyset){
            if(collectionManager.getByKey(key).getCreatedBy() == userId) {
                if (k.compareTo(key) < 0) {
                    toRemove.add(k);
                    counter += 1;
                }
            }
        }
        collectionManager.getKeySet().removeAll(toRemove);

        Response response = new Response();
        response.setResponseCode(ResponseCodes.OK);
        response.setPayload(counter);

        return response;
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove all items from the collection whose key is less than the specified one";
    }

    @Override
    public String getName() {
        return "Remove_lower_key";
    }
}
