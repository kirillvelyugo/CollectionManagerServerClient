package Client.Commands;

import Client.ExpectionsClient.WrongArguments;

/**
 * Save collection to file
 */
public class SaveClient implements ClientCommand {
    @Override
    public SaveClient getNewObject(){
        return new SaveClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: save collection to file";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
