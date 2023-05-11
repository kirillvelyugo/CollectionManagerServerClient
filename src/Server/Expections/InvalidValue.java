package Server.Expections;

/**
 * Exception that throws when value does not math to requirements
 */
public class InvalidValue extends Exception{
    public InvalidValue(String message) {
        super(message);
    }
}
