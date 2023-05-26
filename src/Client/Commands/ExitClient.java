package Client.Commands;

import Client.ExpectionsClient.WrongArguments;

/**
 * Exit command. Stops program execution without saving any data to file
 */
public class ExitClient implements ClientCommand {

    @Override
    public ExitClient getNewObject(){
        return new ExitClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
