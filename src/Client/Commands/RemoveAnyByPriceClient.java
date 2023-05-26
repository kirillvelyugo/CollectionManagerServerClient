package Client.Commands;

import Client.ExpectionsClient.WrongArguments;

public class RemoveAnyByPriceClient implements ClientCommand {
    @Override
    public RemoveAnyByPriceClient getNewObject(){
        return new RemoveAnyByPriceClient();
    }

    @Override
    public String getDescription() {
        return "[price] Description: remove one element from the collection, the value of the price field of which is equivalent to the given one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }
}
