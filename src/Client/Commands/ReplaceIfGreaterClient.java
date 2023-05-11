package Client.Commands;

import Server.Collection.Product;
import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;
import Server.Utils.CLIManager;

/**
 * Class replace the value by key if the new value is greater than the old one
 */
public class ReplaceIfGreaterClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[key] Description: replace the value by key if the new value is greater than the old one";
    }
}
