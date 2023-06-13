package Commands;

import Collection.Product;
import Expections.WrongArguments;
import Utils.Response;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Show command. Prints all collection elements.
 */
public class ShowClient implements ClientCommand {


    @Override
    public ShowClient getNewObject(){
        return new ShowClient();
    }

    @Override
    public String getDescription() {
        return "Output to the standard output stream all the elements of the collection in a string representation";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {

    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode() == 200) {
            LinkedHashMap<String, Product> products = (LinkedHashMap<String, Product>) response.getPayload();
            if (products.size() == 0) {
                System.out.println("Collection empty");
                return;
            }

            System.out.println("==========Show all collection==========");

            Set<String> keyset = products.keySet();
            for(String key : keyset){
                System.out.println("Key = " + key + "; Value: " + products.get(key));
            }

            System.out.println("==========");
        }
        else {
            System.out.println("Request failed with message " + response.getMessage());
        }
    }
}
