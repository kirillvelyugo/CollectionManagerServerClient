package Client.Commands;

public class Show implements ClientCommand {
    @Override
    public String getDescription() {
        return "Output to the standard output stream all the elements of the collection in a string representation";
    }
}
