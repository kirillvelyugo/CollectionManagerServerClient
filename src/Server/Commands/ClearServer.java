package Server.Commands;

/**
 * Clear command. Delete all items from collection.
 */
public class ClearServer implements ServerCommand {

//    private final CollectionManager collectionManager;
//
//    public ClearServer(CollectionManager collectionManager){
//        this.collectionManager = collectionManager;
//    }

    @Override
    public void execute() {
        System.out.println("Clear completed");
    }

    @Override
    public String getDescription() {
        return "[] Description: clear the collection";
    }
}
