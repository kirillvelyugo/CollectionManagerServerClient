package Commands;


import Expections.WrongArguments;
import Utils.Response;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class RemoveKeyClient implements ClientCommand {
    @Override
    public RemoveKeyClient getNewObject(){
        return new RemoveKeyClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove an element from a collection by its key";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {

    }
}
