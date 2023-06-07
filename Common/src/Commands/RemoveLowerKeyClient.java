package Commands;


import Expections.WrongArguments;
import Utils.Response;

/**
 * Class remove all items from the collection whose key is less than the specified one
 */
public class RemoveLowerKeyClient implements ClientCommand {
    @Override
    public RemoveLowerKeyClient getNewObject(){
        return new RemoveLowerKeyClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove all items from the collection whose key is less than the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {

    }
}
