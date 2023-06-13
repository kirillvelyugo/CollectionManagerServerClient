package Commands;

import Collection.Product;
import CollectionManager.CollectionManager;
import Expections.InvalidValue;
import Utils.Response;

/**
 * Class update the value of a collection item whose id is equal to the specified one
 */
public class UpdateServer implements ServerCommand {
    private CollectionManager collectionManager;

    public UpdateServer (CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(ClientCommand command) {
        UpdateClient clientCommand = (UpdateClient) command;
        Product productNew = clientCommand.getProduct();
        Integer id = clientCommand.getId();

        Product productCurrent = collectionManager.findById(id);

        if(productCurrent == null) {
            Response response = new Response(400);
            response.setMessage("No element with such id");
            return response;
        }

        try {
            productCurrent.setName(productNew.getName());
            productCurrent.setCoordinates(productNew.getCoordinates());
            productCurrent.setPrice(productNew.getPrice());
            productCurrent.setUnitOfMeasure(productNew.getUnitOfMeasure());
            productCurrent.setManufacturer(productNew.getManufacturer());
            productCurrent.setPartNumber(productNew.getPartNumber());
        } catch (InvalidValue ignored){

        }

        return new Response(200);
    }

    @Override
    public String getDescription() {
        return "[id] Description: update the value of a collection item whose id is equal to the specified one";
    }
}
