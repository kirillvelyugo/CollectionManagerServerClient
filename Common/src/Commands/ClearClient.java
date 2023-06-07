package Commands;


import Expections.WrongArguments;
import Utils.Response;

/**
 * Clear command. Delete all items from collection.
 */
public class ClearClient implements ClientCommand {

    @Override
    public ClearClient getNewObject(){
        return new ClearClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: clear the collection";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
    @Override
    public void acceptResponse(Response response) {

    }
}
