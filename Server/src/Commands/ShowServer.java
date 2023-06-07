package Commands;

public class ShowServer implements ServerCommand {
    @Override
    public void execute() {
        System.out.println("Show is completed");
    }

    @Override
    public String getDescription() {
        return "[] Description: output to the standard output stream all the elements of the collection in a string representation";
    }
}
