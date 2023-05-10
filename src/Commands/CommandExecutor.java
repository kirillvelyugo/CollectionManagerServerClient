package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

import java.util.*;

/**
 * Class for interactive CLI mode.
 */
public class CommandExecutor {
    private final CollectionManager collectionManager;
    private final HashMap<String, Command> commands;

    public CommandExecutor (CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        this.commands = new HashMap<>();

        this.commands.put("help", new Help(this.commands));
        this.commands.put("info", new Info(this.collectionManager));
        this.commands.put("show", new Show(this.collectionManager));
        this.commands.put("insert", new Insert(this.collectionManager));
        this.commands.put("update", new Update(this.collectionManager));
        this.commands.put("remove_key", new RemoveKey(this.collectionManager));
        this.commands.put("clear", new Clear(this.collectionManager));
        this.commands.put("save", new Save(this.collectionManager));
        this.commands.put("execute_script", new ExecuteScript(this.commands));
        this.commands.put("exit", new Exit());
        this.commands.put("replace_if_greater", new ReplaceIfGreater(this.collectionManager));
        this.commands.put("remove_greater_key", new RemoveGreaterKey(this.collectionManager));
        this.commands.put("remove_lower_key", new RemoveLowerKey(this.collectionManager));
        this.commands.put("remove_any_by_price", new RemoveAnyByPrice(this.collectionManager));
        this.commands.put("max_by_name", new MaxByName(this.collectionManager));
        this.commands.put("filter_less_than_unit_of_measure", new FilterLessThanUnitOfMeasure(this.collectionManager));
    }

    /**
     * Enter an interactive mode with CLI commands execution
     */
    public void interactiveMode (){
        while (true){
            Scanner console = new Scanner(System.in);
            try {
                String line = console.nextLine();

                String[] args = line.split(" ");
                args[0] = args[0].toLowerCase().strip();

                if (commands.containsKey(args[0])) {
                    try {
                        commands.get(args[0]).execute(args);
                    } catch (WrongArguments e) {
                        System.out.println("Incorrect arguments. Try again. " + e.getMessage());
                    }
                } else {
                    System.out.println("Command not found. Try again or read help");
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Exit interactive mode");
                return;
            }
        }
    }
}
