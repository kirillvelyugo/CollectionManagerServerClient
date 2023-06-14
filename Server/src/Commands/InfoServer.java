package Commands;

import Utils.Response;
import Utils.ResponseCodes;

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
    public Response execute(ClientCommand command) {
        System.out.println("Info completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: show information about collection";
    }
}
