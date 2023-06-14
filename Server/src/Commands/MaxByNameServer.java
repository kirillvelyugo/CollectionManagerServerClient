package Commands;

import Utils.Response;
import Utils.ResponseCodes;

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
    public Response execute(ClientCommand command) {
        System.out.println("MaxByName completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: output any object from the collection whose name field value is the maximum";
    }
}
