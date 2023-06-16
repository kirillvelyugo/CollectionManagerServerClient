package CommandsServer;

import java.util.HashMap;

public class HelpCLIServer implements ServerCLICommands {
    private final HashMap<String, ServerCLICommands> commands;

    public HelpCLIServer(HashMap<String, ServerCLICommands> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("==========Help Server side==========");
        for (String command : commands.keySet()){
            System.out.printf("%-35s - %s\n", this.commands.get(command).getName(), this.commands.get(command).getDescription());

        }
        System.out.println("==========");
    }

    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }

    @Override
    public String getName() {
        return "Help";
    }
}


//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        System.out.println("==========Help==========");
//        for (String command : commands.keySet()){
//            System.out.println(command + " " + commands.get(command).info());
//        }
//        System.out.println("==========");
//    }
//
//    @Override
//    public String info() {
//        return "[] Description: output help for available commands";
//    }