package Commands;

import Expections.WrongArguments;

import java.io.Serializable;

public interface ClientCommand extends Serializable {
    public String getDescription();
    public ClientCommand getNewObject();
    public void prepareRequest(String[] args) throws WrongArguments;
}
