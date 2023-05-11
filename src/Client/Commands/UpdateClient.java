package Client.Commands;

import Server.Collection.Product;
import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;
import Server.Utils.CLIManager;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class UpdateClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }
}
