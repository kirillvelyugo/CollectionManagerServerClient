package Commands;


import Expections.WrongArguments;
import Utils.Response;

/**
 * Class output any object from the collection whose name field value is the maximum
 */
public class MaxByNameClient implements ClientCommand {
    @Override
    public MaxByNameClient getNewObject(){
        return new MaxByNameClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: output any object from the collection whose name field value is the maximum";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {

    }
}
