package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

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
        collectionManager.clear();
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
