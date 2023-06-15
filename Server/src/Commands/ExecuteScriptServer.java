package Commands;

import Utils.Response;
import Utils.ResponseCodes;

/**
 * Execute script command. Takes one argument with script file path
 * This command uses collectionManager reference to call "add" method
 */
public class ExecuteScriptServer implements ServerCommand {

    @Override
    public Response execute(ClientCommand command) {
        System.out.println("ExecuteScript completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[file_path] Description: execute script in file";
    }

    @Override
    public String getName() {
        return "Execute_script";
    }
}
