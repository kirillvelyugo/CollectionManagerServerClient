package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import Utils.CLIManager;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class Update implements Command{
    private final CollectionManager collectionManager;

    public Update(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        CLIManager cliManager = new CLIManager();
        int id;
        try {
            id = Integer.parseInt(args[1]);
        } catch (NumberFormatException e){
            throw new WrongArguments("Id is not Integer");
        }

        Product product = collectionManager.findById(id);
        if (product == null) throw new WrongArguments("Can't find element by id");

        cliManager.requestProduct(product);
        System.out.println("--Update successfully--");
    }

    @Override
    public String info() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }
}
