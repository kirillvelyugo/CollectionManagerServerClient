package Commands;

import Utils.Response;

public class ShowServer implements ServerCommand {
    @Override
    public Response execute(ClientCommand command) {
        System.out.println("Show is completed");
        return new Response(200);
    }

    @Override
    public String getDescription() {
        return "[] Description: output to the standard output stream all the elements of the collection in a string representation";
    }
}
