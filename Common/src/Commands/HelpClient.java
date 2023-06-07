package Commands;

import Expections.WrongArguments;
import Utils.Response;

/**
 * Help command. Prints info about all available commands
 */
public class HelpClient implements ClientCommand {
    @Override
    public HelpClient getNewObject(){
        return new HelpClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {

    }
}
