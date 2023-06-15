package Commands;

import Utils.Response;

import java.io.Serializable;

/**
 * Basic interface for ServerCommand
 */
public interface ServerCommand extends Serializable {
    public Response execute(ClientCommand command);
    public String getDescription();
    public String getName();
}
