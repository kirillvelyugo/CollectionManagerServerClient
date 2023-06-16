package CommandsServer;

import CollectionManager.CollectionManager;
import Commands.*;
import Expections.WrongArguments;
import Utils.Response;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for interactive CLI mode.
 */
public class CommandExecutor implements Runnable{
    private final CollectionManager collectionManager;
    private final HashMap<String, ServerCLICommands> commands;

    public CommandExecutor(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        this.commands = new HashMap<>();

        this.commands.put("save", new SaveCLIServer(collectionManager));
        this.commands.put("exit", new ExitCLIServer());
        this.commands.put("help", new HelpCLIServer(commands));
    }

    public void run (){
        System.out.println("--Start interactive mode Server--");
        while (true){
            Scanner console = new Scanner(System.in);
            try {
                String line = console.nextLine();

                String[] args = line.split(" ");
                args[0] = args[0].toLowerCase().strip();

                if (commands.containsKey(args[0])) {
                    commands.get(args[0]).execute(args);
                } else {
                    System.out.println("Command not found. Try again or read help");
                }
            }
            catch (NoSuchElementException e){
                System.out.println("--Exit interactive mode Server--");
                return;
            }
        }
    }
}
