package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class RemoveKey implements Command {
    private final CollectionManager collectionManager;

    public RemoveKey(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        if (!collectionManager.containsKey(args[1])) throw new WrongArguments("Key is not exist");

        collectionManager.removeKey(args[1]);

        System.out.println("--Remove successfully--");
    }

    @Override
    public String info() {
        return "[key] Description: remove an element from a collection by its key";
    }
}
