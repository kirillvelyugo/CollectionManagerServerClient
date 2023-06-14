package Commands;

import java.util.HashMap;

public class CommandExecutor {
    private final HashMap<String, ClientCommand> commands;

    public CommandExecutor () {
        this.commands = new HashMap<>();

        this.commands.put("help", new HelpClient());
        this.commands.put("info", new InfoClient());
        this.commands.put("show", new ShowClient());
        this.commands.put("insert", new InsertClient());
        this.commands.put("update", new UpdateClient());
        this.commands.put("remove_key", new RemoveLowerKeyClient());
        this.commands.put("clear", new ClearClient());
        this.commands.put("save", new SaveClient());
        this.commands.put("execute_script", new ExecuteScriptClient());
        this.commands.put("exit", new ExitClient());
        this.commands.put("replace_if_greater", new ReplaceIfGreaterClient());
        this.commands.put("remove_greater_key", new RemoveGreaterKeyClient());
        this.commands.put("remove_lower_key", new RemoveLowerKeyClient());
        this.commands.put("remove_any_by_price", new RemoveAnyByPriceClient());
        this.commands.put("max_by_name", new MaxByNameClient());
        this.commands.put("filter_less_than_unit_of_measure", new FilterLessThanUnitOfMeasureClient());
    }

    public ClientCommand getCommand(String command) {
        return this.commands.get(command);
    }
}
