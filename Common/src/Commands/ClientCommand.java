package Commands;

import Expections.WrongArguments;
import Utils.Response;
import Utils.UserData;

import java.io.Serializable;

/**
 * Command interface to work in server and the data wrapper at the same time.
 */

public interface ClientCommand extends Serializable {

    /**
     * Get command description
     * @return command description
     */
    public String getDescription();

    /**
     * Get new object on ClientCommand interface implementor to save into fields for transmitting to server
     * @return
     */
    public ClientCommand getNewObject();

    /**
     * Do all the thinks before sending this command to server
     * @param args
     * @throws WrongArguments
     */
    public void prepareRequest(String[] args) throws WrongArguments;

    /**
     * Do all the things after receiving an response from server
     * @param response response
     * @see Response
     */
    public void acceptResponse(Response response);

    public UserData getUserData();

    public void setUserData(UserData userData);
}
