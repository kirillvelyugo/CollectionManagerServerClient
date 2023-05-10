package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

/**
 * Clear command. Delete all items from collection.
 */
public class Clear implements Command {

    private final CollectionManager collectionManager;

    public Clear (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        collectionManager.clear();
        System.out.println("The collection has been cleared");
    }

    @Override
    public String info() {
        return "[] Description: clear the collection";
    }
}
