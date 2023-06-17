package Commands;


import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;
import Utils.UserData;


public class RemoveAnyByPriceClient implements ClientCommand {
    private double price;

    public double getPrice() {
        return price;
    }

    @Override
    public RemoveAnyByPriceClient getNewObject(){
        return new RemoveAnyByPriceClient();
    }

    @Override
    public String getDescription() {
        return "[price] Description: remove one element from the collection, the value of the price field of which is equivalent to the given one";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if (args.length < 2) throw new WrongArguments("Not enough arguments");

        double price;
        try {
            price = Double.parseDouble(args[1]);
        } catch (NumberFormatException e){
            throw new WrongArguments("Price is not Double");
        }

        this.price = price;
    }

    @Override
    public void acceptResponse(Response response) {
        if (response.getResponseCode().equals(ResponseCodes.OK)) {
            System.out.println("--Removed successfully--");
        } else if (response.getResponseCode().equals(ResponseCodes.OK_WITH_MESSAGE)) {
            System.out.println("Done." + response.getMessage());
        } else {
            System.out.println("Request failed with message " + response.getMessage());
        }
    }

    private UserData userData;

    @Override
    public UserData getUserData() {
        return userData;
    }

    @Override
    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
