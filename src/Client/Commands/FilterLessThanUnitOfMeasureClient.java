package Client.Commands;

/**
 * Class output elements whose unit Of Measure field value is less than the specified one
 */
public class FilterLessThanUnitOfMeasureClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[KILOGRAMS METERS CENTIMETERS SQUARE_METERS GRAMS] Description: output elements whose unit Of Measure field value is less than the specified one";
    }
}
