package Client.Commands;

import Client.ExpectionsClient.WrongArguments;
import Client.Utils.CLIManager;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class UpdateClient implements ClientCommand {
    private Integer id;

    @Override
    public UpdateClient getNewObject(){
        return new UpdateClient();
    }

    @Override
    public String getDescription() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        CLIManager cliManager = new CLIManager();
        try {
            this.id = Integer.parseInt(args[1]);
        } catch (NumberFormatException e){
            throw new WrongArguments("Id is not Integer");
        }
    }
}
