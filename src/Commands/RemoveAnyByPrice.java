package Commands;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import Utils.CLIManager;

public class RemoveAnyByPrice implements Command{

    private final CollectionManager collectionManager;

    public RemoveAnyByPrice(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {

        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        double price;
        try {
            price = Double.parseDouble(args[1]);
        } catch (NumberFormatException e){
            throw new WrongArguments("Price is not Double");
        }

        for(String key : collectionManager.getKeySet()){
            if (collectionManager.getByKey(key).getPrice().equals(price)){
                collectionManager.removeKey(key);
                System.out.println("--Removed successfully--");
                return;
            }
        }
        System.out.println("Nothing to remove");
    }

    @Override
    public String info() {
        return "[price] Description: remove one element from the collection, the value of the price field of which is equivalent to the given one";
    }
}
