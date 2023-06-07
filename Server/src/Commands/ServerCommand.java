package Commands;

import java.io.Serializable;

public interface ServerCommand extends Serializable {
    public void execute();
    public String getDescription();
}
