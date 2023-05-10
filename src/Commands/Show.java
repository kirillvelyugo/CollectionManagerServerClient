package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import java.util.Iterator;
import java.util.Set;

/**
 * Show command. Prints all collection elements.
 */
public class Show implements Command{

    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        Iterator<Product> iter = collectionManager.getIterator();
        if (!iter.hasNext()){
            System.out.println("Collection empty");
            return;
        }

        System.out.println("==========Show all collection==========");

       Set<String> keyset = collectionManager.getKeySet();
       for(String key : keyset){
           System.out.println("Key = " + key + "; Value: " + collectionManager.getByKey(key));
       }

       System.out.println("==========");
    }

    @Override
    public String info() {
        return "[] Description: output to the standard output stream all the elements of the collection in a string representation";
    }
}
