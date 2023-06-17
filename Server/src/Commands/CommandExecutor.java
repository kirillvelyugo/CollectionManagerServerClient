package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Class for interactive CLI mode.
 */
public class CommandExecutor {
    private final CollectionManager collectionManager;
    private final HashMap<Type, ServerCommand> commands;

    public CommandExecutor (CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        this.commands = new HashMap<>();

        this.commands.put(HelpClient.class, new HelpServer(this.commands));
        this.commands.put(InfoClient.class, new InfoServer(collectionManager));
        this.commands.put(ShowClient.class, new ShowServer(collectionManager));
        this.commands.put(InsertClient.class, new InsertServer(collectionManager));
        this.commands.put(UpdateClient.class, new UpdateServer(collectionManager));
        this.commands.put(RemoveKeyClient.class, new RemoveKeyServer(collectionManager));
        this.commands.put(ClearClient.class, new ClearServer(collectionManager));
        this.commands.put(ExecuteScriptClient.class, new ExecuteScriptServer());
        this.commands.put(ReplaceIfGreaterClient.class, new ReplaceIfGreaterServer(collectionManager));
        this.commands.put(RemoveGreaterKeyClient.class, new RemoveGreaterKeyServer(collectionManager));
        this.commands.put(RemoveLowerKeyClient.class, new RemoveLowerKeyServer(collectionManager));
        this.commands.put(RemoveAnyByPriceClient.class, new RemoveAnyByPriceServer(collectionManager));
        this.commands.put(MaxByNameClient.class, new MaxByNameServer(collectionManager));
        this.commands.put(FilterLessThanUnitOfMeasureClient.class, new FilterLessThanUnitOfMeasureServer(collectionManager));
    }

    public Response doCommand (ClientCommand command){
        ServerCommand serverCommand = this.commands.get(command.getClass());
        Response response = serverCommand.execute(command);
        System.out.println("Command from user " + command.getUserData());

        return response;
    }
}
