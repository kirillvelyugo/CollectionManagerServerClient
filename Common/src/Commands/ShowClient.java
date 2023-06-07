package Commands;

import Expections.WrongArguments;
import Utils.Response;

/**
 * Show command. Prints all collection elements.
 */
public class ShowClient implements ClientCommand {
    @Override
    public ShowClient getNewObject(){
        return new ShowClient();
    }

    @Override
    public String getDescription() {
        return "Output to the standard output stream all the elements of the collection in a string representation";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {

    }
}
