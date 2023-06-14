package Commands;

import Utils.Response;
import Utils.ResponseCodes;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Help command. Prints info about all available commands
 */
public class HelpServer implements ServerCommand {
    private final HashMap<Type, ServerCommand> commands;

    public HelpServer(HashMap<Type, ServerCommand> commands) {
        this.commands = commands;
    }

    @Override
    public Response execute(ClientCommand command) {
        StringBuilder res = new StringBuilder();
        for(Type el : this.commands.keySet()){
            res.append(this.commands.get(el).getName()).append(this.commands.get(el).getDescription()).append("\n");
//            if use this -- help returns null
//            res.append(String.format("%-35s - %s\n", this.commands.get(el).getName(), this.commands.get(el).getDescription()));
        }
        Response response = new Response(ResponseCodes.OK);
        response.setPayload(res.toString());
        return response;
    }

    @Override
    public String getDescription() {
        return "[] Description: output help for available commands";
    }

    @Override
    public String getName() {
        return "Help";
    }
}
