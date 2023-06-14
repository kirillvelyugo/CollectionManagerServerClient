package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

import java.util.HashSet;
import java.util.Set;

/**
 * Class remove from the collection all items whose key exceeds the specified one
 */
public class RemoveGreaterKeyServer implements ServerCommand {
    private CollectionManager collectionManager;

    public RemoveGreaterKeyServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        RemoveGreaterKeyClient removeGreaterKeyClient = (RemoveGreaterKeyClient) command;
        String key = removeGreaterKeyClient.getKey();

        int counter = 0;
        Set<String> keyset = collectionManager.getKeySet();
        Set<String> toRemove = new HashSet<>();
        for(String k : keyset){
            if (k.compareTo(key) > 0){
                toRemove.add(k);
                counter += 1;
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
        return "[key] Description: remove from the collection all items whose key exceeds the specified one";
    }

    @Override
    public String getName() {
        return "Remove_greater_key";
    }
}
