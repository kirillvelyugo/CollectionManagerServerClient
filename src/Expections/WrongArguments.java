package Expections;

/**
 * Exception that throws when command argument value does not math type
 */
public class WrongArguments extends Exception{
    public WrongArguments (String message){
        super(message);
    }
}
