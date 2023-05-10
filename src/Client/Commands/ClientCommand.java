package Client.Commands;

import java.io.Serializable;

public interface ClientCommand extends Serializable {
    public String getDescription();
}
