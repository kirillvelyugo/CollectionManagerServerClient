package Commands;

import Utils.Response;
import Utils.ResponseCodes;

/**
 * Exit command. Stops program execution without saving any data to file
 */
public class ExitServer implements ServerCommand {
    @Override
    public Response execute(ClientCommand command) {
        System.out.println("Exit completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }
}
