package Client.Commands;

/**
 * Help command. Prints info about all available commands
 */
public class HelpClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }
}
