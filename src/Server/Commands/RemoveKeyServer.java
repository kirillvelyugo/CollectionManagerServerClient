package Server.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;

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
    public void execute() {
        System.out.println("RemoveKey completed");
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove an element from a collection by its key";
    }
}
