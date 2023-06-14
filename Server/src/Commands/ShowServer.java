package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

public class ShowServer implements ServerCommand {
    private CollectionManager collectionManager;

    public ShowServer (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        Response response = new Response();
        response.setPayload(collectionManager.getProducts());
        response.setResponseCode(ResponseCodes.OK);
        return response;
    }

    @Override
    public String getDescription() {
        return "[] Description: output to the standard output stream all the elements of the collection in a string representation";
    }

    @Override
    public String getName() {
        return "Show";
    }
}
