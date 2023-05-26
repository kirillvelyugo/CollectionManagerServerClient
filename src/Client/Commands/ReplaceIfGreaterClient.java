package Client.Commands;

import Client.ExpectionsClient.WrongArguments;

/**
 * Class replace the value by key if the new value is greater than the old one
 */
public class ReplaceIfGreaterClient implements ClientCommand {
    @Override
    public ReplaceIfGreaterClient getNewObject(){
        return new ReplaceIfGreaterClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: replace the value by key if the new value is greater than the old one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
