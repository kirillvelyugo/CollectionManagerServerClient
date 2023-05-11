package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class RemoveKeyClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[key] Description: remove an element from a collection by its key";
    }
}
