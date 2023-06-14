package Commands;

import Utils.Response;

import java.io.Serializable;

public interface ServerCommand extends Serializable {
    public Response execute(ClientCommand command);
    public String getDescription();
    public String getName();
}
