package Commands;

/**
 * Add command. Request element from CLI and add it to collection.
 */
public class InsertServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public InsertServer(CollectionManager collectionManager){
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        CLIManager cliManager = new CLIManager();
//
//        if (args.length < 2) throw new WrongArguments("Not enough arguments");
//        if (collectionManager.containsKey(args[1])) throw new WrongArguments("Key already exist");
//        Product product = new Product();
//        cliManager.requestProduct(product);
//        collectionManager.addObj(args[1], product);
//
//        System.out.println("--Insert successfully--");
//    }

    @Override
    public void execute() {
        System.out.println("Insert completed");
    }

    @Override
    public String getDescription() {
        return "[key] Description: add a new element with the specified key";
    }
}
