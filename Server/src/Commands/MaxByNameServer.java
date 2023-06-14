package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

import java.util.Set;

/**
 * Class output any object from the collection whose name field value is the maximum
 */
public class MaxByNameServer implements ServerCommand {
    private final CollectionManager collectionManager;

    public MaxByNameServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        Set<String> keyset = collectionManager.getKeySet();

        String maxName = null;
        String key = null;
        for(String k : keyset){
            if(maxName == null) {
                maxName = collectionManager.getByKey(k).getName();
                key = k;
            }
            if(collectionManager.getByKey(k).getName().compareTo(maxName) > 0){
                maxName = collectionManager.getByKey(k).getName();
                key = k;
            }
        }

        Response response = new Response();
        if (maxName == null){
            response.setMessage(" Nothing to show");
            response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);
        }
        else {
            response.setPayload(collectionManager.getByKey(key));
            response.setResponseCode(ResponseCodes.OK);
        }

        return response;
    }

    @Override
    public String getDescription() {
        return "[] Description: output any object from the collection whose name field value is the maximum";
    }

    @Override
    public String getName() {
        return "Max_by_name";
    }
}
