package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

import java.util.HashSet;
import java.util.Set;

/**
 * Class remove from the collection all items whose key exceeds the specified one
 */
public class RemoveGreaterKeyClient implements ClientCommand {
@Override
    public String getDescription() {
        return "[key] Description: remove from the collection all items whose key exceeds the specified one";
    }
}
