package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Utils.Response;
import Utils.ResponseCodes;

import java.util.ArrayList;
import java.util.Set;

/**
 * Class output elements whose unit Of Measure field value is less than the specified one
 */
public class FilterLessThanUnitOfMeasureServer implements ServerCommand {
    private CollectionManager collectionManager;

    public FilterLessThanUnitOfMeasureServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        FilterLessThanUnitOfMeasureClient filterLessThanUnitOfMeasureClient = (FilterLessThanUnitOfMeasureClient) command;
        Response response = new Response();
        ArrayList<Product> arrayList = new ArrayList<>();

        Set<String> keyset = collectionManager.getKeySet();
        for(String key : keyset){
            if (collectionManager.getByKey(key).getUnitOfMeasure() != null){
                if (collectionManager.getByKey(key).getUnitOfMeasure().compareTo(filterLessThanUnitOfMeasureClient.getBound()) < 0) {
                    arrayList.add(collectionManager.getByKey(key));
                }
            }
        }

        if (arrayList.size() > 0){
            response.setPayload(arrayList);
            response.setResponseCode(ResponseCodes.OK);
        }else {
            response.setMessage(" No such elements");
            response.setResponseCode(ResponseCodes.OK_WITH_MESSAGE);
        }

        return response;
    }

    @Override
    public String getDescription() {
        return "[KILOGRAMS METERS CENTIMETERS SQUARE_METERS GRAMS] Description: output elements whose unit Of Measure field value is less than the specified one";
    }

    @Override
    public String getName() {
        return "Filter_less_than_unit_of_measure";
    }
}
