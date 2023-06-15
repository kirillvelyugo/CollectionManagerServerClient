package CommandsServer;

public interface ServerCLICommands {
    public void execute(String[] args);
    public String getDescription();
    public String getName();
}
