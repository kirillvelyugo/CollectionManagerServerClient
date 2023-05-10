package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;

/**
 * Info command. Prints information about collection
 */
public class Info implements Command{

    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        System.out.println(collectionManager.getInfo());
    }

    @Override
    public String info() {
        return "[] Description: show information about collection";
    }
}
