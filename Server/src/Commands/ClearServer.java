package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

import java.util.Set;

/**
 * Clear command. Delete all items from collection.
 */
public class ClearServer implements ServerCommand {
    private CollectionManager collectionManager;

    public ClearServer(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {

        int userId = command.getUserData().getId();
        Set<String> keySet = collectionManager.getKeySet();
        for (String key : keySet){
            int created_by_id = collectionManager.getByKey(key).getCreatedBy();
            if (created_by_id == userId){
                collectionManager.removeKey(key);
            }
        }

        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: clear the collection";
    }

    @Override
    public String getName() {
        return "Clear";
    }
}
