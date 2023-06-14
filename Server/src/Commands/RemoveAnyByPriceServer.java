package Commands;

import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

public class RemoveAnyByPriceServer implements ServerCommand {
    private CollectionManager collectionManager;

    public RemoveAnyByPriceServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//
//
//
//        for(String key : collectionManager.getKeySet()){
//            if (collectionManager.getByKey(key).getPrice().equals(price)){
//                collectionManager.removeKey(key);
//                System.out.println("--Removed successfully--");
//                return;
//            }
//        }
//        System.out.println("Nothing to remove");
//    }

    @Override
    public Response execute(ClientCommand command) {
        RemoveAnyByPriceClient removeAnyByPriceClient = (RemoveAnyByPriceClient) command;
        Response response = new Response();

        for(String key : collectionManager.getKeySet()){
            if (collectionManager.getByKey(key).getPrice().equals(removeAnyByPriceClient.getPrice())){
                collectionManager.removeKey(key);
                response.setResponseCode(ResponseCodes.OK);
                return response;
            }
        }

        response.setMessage(" Nothing to remove");
        response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);

        return response;
    }

    @Override
    public String getDescription() {
        return "[price] Description: remove one element from the collection, the value of the price field of which is equivalent to the given one";
    }

    @Override
    public String getName() {
        return "Remove_any_by_price";
    }
}
