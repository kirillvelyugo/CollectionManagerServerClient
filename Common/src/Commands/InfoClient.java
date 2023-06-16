package Commands;


import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;

/**
 * Info command. Prints information about collection
 */
public class InfoClient implements ClientCommand {
    @Override
    public InfoClient getNewObject(){
        return new InfoClient();
    }

    @Override
    public String getDescription() {
        return "[] Description: show information about collection";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)){
            System.out.println(response.getPayload());
        } else {
            System.out.println("Request failed with message " + response.getMessage());
        }
    }
}
