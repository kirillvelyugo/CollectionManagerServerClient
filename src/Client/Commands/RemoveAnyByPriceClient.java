package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

public class RemoveAnyByPriceClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[price] Description: remove one element from the collection, the value of the price field of which is equivalent to the given one";
    }
}
