package Commands;


import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Class remove all items from the collection whose key is less than the specified one
 */
public class RemoveLowerKeyClient implements ClientCommand {
    private String key;

    public String getKey() {
        return key;
    }

    @Override
    public RemoveLowerKeyClient getNewObject(){
        return new RemoveLowerKeyClient();
    }

    @Override
    public String getDescription() {
        return "[key] Description: remove all items from the collection whose key is less than the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        this.key = args[1];
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            int counter = (int) response.getPayload();
            System.out.println("--Removed " + counter + " elements--");
        } else {
            System.out.println(response.getMessage());
        }
    }
}
