package Commands;

/**
 * Class output elements whose unit Of Measure field value is less than the specified one
 */
public class FilterLessThanUnitOfMeasureServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public FilterLessThanUnitOfMeasureServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//        if (args.length < 2) throw new WrongArguments("Not enough arguments");
//        UnitOfMeasure bound;
//        try {
//            bound = UnitOfMeasure.valueOf(args[1].toUpperCase());
//        }
//        catch (IllegalArgumentException e){
//            throw new WrongArguments("No such unit of measure");
//        }
//
//        Set<String> keyset = collectionManager.getKeySet();
//        for(String key : keyset){
//            if (collectionManager.getByKey(key).getUnitOfMeasure() != null){
//                if (collectionManager.getByKey(key).getUnitOfMeasure().compareTo(bound) < 0) {
//                    System.out.println(collectionManager.getByKey(key));
//                }
//            }
//        }
//
//    }

    @Override
    public void execute() {
        System.out.println("FilterLessThanUnitOfMeasure completed");
    }

    @Override
    public String getDescription() {
        return "[KILOGRAMS METERS CENTIMETERS SQUARE_METERS GRAMS] Description: output elements whose unit Of Measure field value is less than the specified one";
    }
}
