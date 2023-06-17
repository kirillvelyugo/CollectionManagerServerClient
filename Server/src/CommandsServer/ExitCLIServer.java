package CommandsServer;


public class ExitCLIServer implements ServerCLICommands{
    @Override
    public void execute(String[] args) {
        System.out.println("--Exit interactive mode Server--");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }

    @Override
    public String getName() {
        return "Exit";
    }
}
