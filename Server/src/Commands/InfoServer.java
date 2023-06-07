package Commands;

/**
 * Info command. Prints information about collection
 */
public class InfoServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public InfoServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        System.out.println(collectionManager.getInfo());
//    }

    @Override
    public void execute() {
        System.out.println("Info completed");
    }

    @Override
    public String getDescription() {
        return "[] Description: show information about collection";
    }
}
