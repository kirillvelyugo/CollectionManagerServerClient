package Commands;

/**
 * Exit command. Stops program execution without saving any data to file
 */
public class ExitServer implements ServerCommand {
    @Override
    public void execute() {
        System.out.println("Exit completed");
    }

    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }
}
