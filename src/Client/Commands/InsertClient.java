package Client.Commands;

/**
 * Add command. Request element from CLI and add it to collection.
 */
public class InsertClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[key] Description: add a new element with the specified key";
    }
}
