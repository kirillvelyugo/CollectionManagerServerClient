package Client.Commands;

import Client.ExpectionsClient.WrongArguments;

/**
 * Class output elements whose unit Of Measure field value is less than the specified one
 */
public class FilterLessThanUnitOfMeasureClient implements ClientCommand {
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

    }
}