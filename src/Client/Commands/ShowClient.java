package Client.Commands;

/**
 * Show command. Prints all collection elements.
 */
public class ShowClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "Output to the standard output stream all the elements of the collection in a string representation";
    }
}
