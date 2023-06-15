package CommandsServer;

/**
 * Basic interface for ServerCommand in CLI mode
 */
public interface ServerCLICommands {
    public void execute(String[] args);
    public String getDescription();
    public String getName();
}
