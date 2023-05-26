package Server.Commands;

/**
 * Help command. Prints info about all available commands
 */
public class HelpServer implements ServerCommand {
//    private final HashMap<String, Command> commands;
//
//    public HelpServer(HashMap<String, Command> commands){
//        this.commands = commands;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        System.out.println("==========Help==========");
//        for (String command : commands.keySet()){
//            System.out.println(command + " " + commands.get(command).info());
//        }
//        System.out.println("==========");
//    }

    @Override
    public void execute() {
        System.out.println("Help completed");
    }

    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }
}
