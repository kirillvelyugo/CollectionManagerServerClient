package Commands;


import Expections.WrongArguments;

/**
 * Info command. Prints information about collection
 */
public class InfoClient implements ClientCommand {
    @Override
    public InfoClient getNewObject(){
        return new InfoClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: show information about collection";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
