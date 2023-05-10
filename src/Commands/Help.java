package Commands;

import Expections.WrongArguments;
import java.util.HashMap;

/**
 * Help command. Prints info about all available commands
 */
public class Help implements Command{
    private final HashMap<String, Command> commands;

    public Help (HashMap<String, Command> commands){
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        System.out.println("==========Help==========");
        for (String command : commands.keySet()){
            System.out.println(command + " " + commands.get(command).info());
        }
        System.out.println("==========");
    }

    @Override
    public String info() {
        return "[] Description: output help for available commands";
    }
}
