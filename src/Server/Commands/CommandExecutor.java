package Server.Commands;

import Client.Commands.*;
import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

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
        this.commands.put(InfoClient.class, new InfoServer());
        this.commands.put(ShowClient.class, new ShowServer());
        this.commands.put(InsertClient.class, new InsertServer());
        this.commands.put(UpdateClient.class, new UpdateServer());
        this.commands.put(RemoveKeyClient.class, new RemoveKeyServer());
        this.commands.put(ClearClient.class, new ClearServer());
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

    public void doCommand (Type type){
        ServerCommand command = this.commands.get(type);
        command.execute();
    }

//    /**
//     * Enter an interactive mode with CLI commands execution
//     */
//    public void interactiveMode (){
//        while (true){
//            Scanner console = new Scanner(System.in);
//            try {
//                String line = console.nextLine();
//
//                String[] args = line.split(" ");
//                args[0] = args[0].toLowerCase().strip();
//
//                if (commands.containsKey(args[0])) {
//                    try {
//                        commands.get(args[0]).execute(args);
//                    } catch (WrongArguments e) {
//                        System.out.println("Incorrect arguments. Try again. " + e.getMessage());
//                    }
//                } else {
//                    System.out.println("Command not found. Try again or read help");
//                }
//            }
//            catch (NoSuchElementException e){
//                System.out.println("Exit interactive mode");
//                return;
//            }
//        }
//    }
}
