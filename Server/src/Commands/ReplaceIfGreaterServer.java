package Commands;

import Utils.Response;
import Utils.ResponseCodes;

/**
 * Class replace the value by key if the new value is greater than the old one
 */
public class ReplaceIfGreaterServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public ReplaceIfGreaterServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        CLIManager cliManager = new CLIManager();
//
//        if (args.length < 2) throw new WrongArguments("Not enough arguments");
//        if (!collectionManager.containsKey(args[1])) throw new WrongArguments("Key is not exist");
//
//        Product newProduct = new Product();
//        cliManager.requestProduct(newProduct);
//
//        Product oldProduct = collectionManager.getByKey(args[1]);
//
//        if (newProduct.compareTo(oldProduct) > 0){
//           collectionManager.addObj(args[1], newProduct);
//           System.out.println("--Updated successfully--");
//        }
//        else System.out.println("--Not updated--");
//
//    }

    @Override
    public Response execute(ClientCommand command) {
        System.out.println("ReplaceIfGreater completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[key] Description: replace the value by key if the new value is greater than the old one";
    }
}
