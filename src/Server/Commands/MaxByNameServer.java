package Server.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;
import java.util.Set;

/**
 * Class output any object from the collection whose name field value is the maximum
 */
public class MaxByNameServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public MaxByNameServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        // get max by name
//        Set<String> keyset = collectionManager.getKeySet();
//        String maxName = null;
//        String keyToShow = null;
//        for(String key : keyset){
//            if(maxName == null) {
//                maxName = collectionManager.getByKey(key).getName();
//                keyToShow = key;
//            }
//            if(collectionManager.getByKey(key).getName().compareTo(maxName) > 0){
//                maxName = collectionManager.getByKey(key).getName();
//                keyToShow = key;
//            }
//        }
//        if(maxName == null) System.out.println("Nothing to show");
//        else System.out.println(collectionManager.getByKey(keyToShow));
//    }

    @Override
    public void execute() {
        System.out.println("MaxByName completed");
    }

    @Override
    public String getDescription() {
        return "[] Description: output any object from the collection whose name field value is the maximum";
    }
}
