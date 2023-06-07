package Commands;


import Expections.WrongArguments;

/**
 * Add command. Request element from CLI and add it to collection.
 */
public class InsertClient implements ClientCommand {
    @Override
    public InsertClient getNewObject(){
        return new InsertClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: add a new element with the specified key";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
