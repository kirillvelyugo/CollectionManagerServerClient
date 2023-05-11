package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

/**
 * Clear command. Delete all items from collection.
 */
public class ClearClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[] Description: clear the collection";
    }
}
