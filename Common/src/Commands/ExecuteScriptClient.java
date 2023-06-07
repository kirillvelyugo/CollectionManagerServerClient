package Commands;

import Expections.WrongArguments;

/**
 * Execute script command. Takes one argument with script file path
 * This command uses collectionManager reference to call "add" method
 */
public class ExecuteScriptClient implements ClientCommand {

    @Override
    public ExecuteScriptClient getNewObject(){
        return new ExecuteScriptClient();
    }

    @Override
    public String getDescription() {
        return "[file_path] Description: execute script in file";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
