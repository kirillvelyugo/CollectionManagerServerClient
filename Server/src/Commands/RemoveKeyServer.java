package Commands;

import Utils.Response;
import Utils.ResponseCodes;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class RemoveKeyServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public RemoveKeyServer(CollectionManager collectionManager){
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        if (args.length < 2) throw new WrongArguments("Not enough arguments");
//
//        if (!collectionManager.containsKey(args[1])) throw new WrongArguments("Key is not exist");
//
//        collectionManager.removeKey(args[1]);
//
//        System.out.println("--Remove successfully--");
//    }

    @Override
    public Response execute(ClientCommand command) {
        System.out.println("RemoveKey completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove an element from a collection by its key";
    }
}
