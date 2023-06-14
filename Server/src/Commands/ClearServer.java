package Commands;

import Utils.Response;
import Utils.ResponseCodes;

/**
 * Clear command. Delete all items from collection.
 */
public class ClearServer implements ServerCommand {

//    private final CollectionManager collectionManager;
//
//    public ClearServer(CollectionManager collectionManager){
//        this.collectionManager = collectionManager;
//    }

    @Override
    public Response execute(ClientCommand command) {
        System.out.println("Clear completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: clear the collection";
    }
}
