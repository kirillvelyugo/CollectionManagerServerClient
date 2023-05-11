package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

import java.util.Set;

/**
 * Class output any object from the collection whose name field value is the maximum
 */
public class MaxByNameClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[] Description: output any object from the collection whose name field value is the maximum";
    }
}
