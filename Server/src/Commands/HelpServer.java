package Commands;

import Utils.Response;
import Utils.ResponseCodes;

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
    public Response execute(ClientCommand command) {
        System.out.println("Help completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }
}
