package Commands;

import Utils.Response;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class UpdateServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public UpdateServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        if (args.length < 2) throw new WrongArguments("Not enough arguments");
//
//        CLIManager cliManager = new CLIManager();
//        int id;
//        try {
//            id = Integer.parseInt(args[1]);
//        } catch (NumberFormatException e){
//            throw new WrongArguments("Id is not Integer");
//        }
//
//        Product product = collectionManager.findById(id);
//        if (product == null) throw new WrongArguments("Can't find element by id");
//
//        cliManager.requestProduct(product);
//        System.out.println("--Update successfully--");
//    }

    @Override
    public Response execute(ClientCommand command) {
        System.out.println("Update completed");
        return new Response(200);
    }

    @Override
    public String getDescription() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }
}
