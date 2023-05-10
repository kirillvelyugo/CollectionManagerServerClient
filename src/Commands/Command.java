package Commands;

import Expections.WrongArguments;

/**
 * Base Command interface. Each command should implement this interface.
 */
public interface Command {
    /**
     * Execute command. Calls each time when command starts execution
     * @param args String array with command arguments. First element is command name
     * @throws WrongArguments when arguments does not math requirements
     */
    public void execute (String[] args) throws WrongArguments;

    /**
     * Get command description for "help" command
     * @return description string
     */
    public String info ();
}
