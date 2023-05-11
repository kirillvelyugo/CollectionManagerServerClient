package Client.Commands;

import Server.Expections.WrongArguments;

/**
 * Exit command. Stops program execution without saving any data to file
 */
public class ExitClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }
}
