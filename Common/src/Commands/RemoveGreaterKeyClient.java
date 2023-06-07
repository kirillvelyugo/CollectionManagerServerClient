package Commands;


import Expections.WrongArguments;
import Utils.Response;

/**
 * Class remove from the collection all items whose key exceeds the specified one
 */
public class RemoveGreaterKeyClient implements ClientCommand {
    @Override
    public RemoveGreaterKeyClient getNewObject(){
        return new RemoveGreaterKeyClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove from the collection all items whose key exceeds the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {

    }
}
