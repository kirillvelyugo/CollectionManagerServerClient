package Commands;

import Collection.Product;
import Collection.UnitOfMeasure;
import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;

import java.util.ArrayList;

/**
 * Class output elements whose unit Of Measure field value is less than the specified one
 */
public class FilterLessThanUnitOfMeasureClient implements ClientCommand {
    private UnitOfMeasure bound;

    public UnitOfMeasure getBound() {
        return bound;
    }

    @Override
    public FilterLessThanUnitOfMeasureClient getNewObject(){
        return new FilterLessThanUnitOfMeasureClient();
    }

    @Override
    public String getDescription() {
        return "[KILOGRAMS METERS CENTIMETERS SQUARE_METERS GRAMS] Description: output elements whose unit Of Measure field value is less than the specified one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        try {
            this.bound = UnitOfMeasure.valueOf(args[1].toUpperCase());
        }
        catch (IllegalArgumentException e){
            throw new WrongArguments("No such unit of measure");
        }
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)) {
            ArrayList<Product> arrayList = (ArrayList<Product>) response.getPayload();

            for (Product p : arrayList ){
                System.out.println(p);
            }

        } else if (response.getResponseCode().equals(ResponseCodes.OK_WITH_MESSAGE)) {
            System.out.println("Done." + response.getMessage());
        }
    }
}
