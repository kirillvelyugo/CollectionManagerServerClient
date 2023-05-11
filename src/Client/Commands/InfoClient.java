package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

/**
 * Info command. Prints information about collection
 */
public class InfoClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[] Description: show information about collection";
    }
}
