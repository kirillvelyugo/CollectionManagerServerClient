import Collection.*;
import CollectionManager.CollectionManager;
import Commands.CommandExecutor;
import Expections.InvalidValue;
import Run.DatabaseConnector;
import Utils.RequestPort;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.concurrent.Executors;

public class AppServer {
    public static void main(String[] args) throws IOException, SQLException, InvalidValue {

        DatabaseConnector databaseConnector = new DatabaseConnector("jdbc:postgresql://127.0.0.1:5432/products", "alexivanov", "");

        Product product = new Product();
        product.setUnitOfMeasure(UnitOfMeasure.GRAMS);
        product.setPartNumber("ppppppp");
        Organization organization = new Organization();
        organization.setName("org name");
        organization.setType(OrganizationType.COMMERCIAL);
        organization.setEmployeesCount(123L);
        Address address = new Address();
        address.setZipCode("132123123");
        organization.setOfficialAddress(address);
        product.setManufacturer(organization);
        product.setPrice(123.123);
        Coordinates coordinates = new Coordinates();
        coordinates.setX(123123D);
        coordinates.setY(123L);
        product.setCoordinates(coordinates);
        product.setName("pname");

        int id = databaseConnector.addProduct(product, "jaba1");

        Product product1 = databaseConnector.readProduct("jaba1");
        System.out.println(product1);

        databaseConnector.removeProduct("jaba1");

        System.out.println(databaseConnector.getProductsKeys());

        CollectionManager collectionManager = new CollectionManager(databaseConnector);

        CommandExecutor commandExecutor = new CommandExecutor(collectionManager);

        UDPServer udpServer = new UDPServer(RequestPort.getPort());

        Executors.newSingleThreadExecutor().execute(new CommandsServer.CommandExecutor(collectionManager));

        udpServer.interactiveMode(commandExecutor);
    }
}
