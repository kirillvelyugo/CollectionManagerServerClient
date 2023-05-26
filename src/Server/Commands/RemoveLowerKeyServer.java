package Server.Commands;

/**
 * Class remove all items from the collection whose key is less than the specified one
 */
public class RemoveLowerKeyServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public RemoveLowerKeyServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        if (args.length < 2) throw new WrongArguments("Not enough arguments");
//
//        int counter = 0;
//        Set<String> keyset = collectionManager.getKeySet();
//        Set<String> toRemove = new HashSet<>();
//        for(String key : keyset){
//            if (key.compareTo(args[1]) < 0){
//                toRemove.add(key);
//                counter += 1;
//            }
//        }
//        collectionManager.getKeySet().removeAll(toRemove);
//        System.out.println("--Removed " + counter + " elements--");
//    }

    @Override
    public void execute() {
        System.out.println("RemoveLowerKey completed");
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove all items from the collection whose key is less than the specified one";
    }
}
