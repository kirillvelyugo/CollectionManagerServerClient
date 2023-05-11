package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

import java.util.HashSet;
import java.util.Set;

/**
 * Class remove all items from the collection whose key is less than the specified one
 */
public class RemoveLowerKeyClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[key] Description: remove all items from the collection whose key is less than the specified one";
    }
}
