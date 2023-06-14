package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Info command. Prints information about collection
 */
public class InfoServer implements ServerCommand {
    private CollectionManager collectionManager;

    public InfoServer (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        Response response = new Response();
        response.setPayload(collectionManager.getInfo());
        response.setResponseCode(ResponseCodes.OK);
        return response;
    }

    @Override
    public String getDescription() {
        return "[] Description: show information about collection";
    }
}
