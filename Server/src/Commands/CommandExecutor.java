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

        this.commands.put(HelpClient.class, new HelpServer());
        this.commands.put(InfoClient.class, new InfoServer(collectionManager));
        this.commands.put(ShowClient.class, new ShowServer(collectionManager));
        this.commands.put(InsertClient.class, new InsertServer(collectionManager));
        this.commands.put(UpdateClient.class, new UpdateServer(collectionManager));
        this.commands.put(RemoveKeyClient.class, new RemoveKeyServer());
        this.commands.put(ClearClient.class, new ClearServer(collectionManager));
        this.commands.put(SaveClient.class, new SaveServer());
        this.commands.put(ExecuteScriptClient.class, new ExecuteScriptServer());
        this.commands.put(ExitClient.class, new ExitServer());
        this.commands.put(ReplaceIfGreaterClient.class, new ReplaceIfGreaterServer());
        this.commands.put(RemoveGreaterKeyClient.class, new RemoveGreaterKeyServer());
        this.commands.put(RemoveLowerKeyClient.class, new RemoveLowerKeyServer());
        this.commands.put(RemoveAnyByPriceClient.class, new RemoveAnyByPriceServer());
        this.commands.put(MaxByNameClient.class, new MaxByNameServer());
        this.commands.put(FilterLessThanUnitOfMeasureClient.class, new FilterLessThanUnitOfMeasureServer());
    }

    public Response doCommand (ClientCommand command){
        ServerCommand serverCommand = this.commands.get(command.getClass());
        Response response = serverCommand.execute(command);

        return response;
    }
}
