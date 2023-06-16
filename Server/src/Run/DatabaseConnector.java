package Run;

import Collection.*;
import Expections.InvalidValue;

import java.net.InetAddress;
import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;

public class DatabaseConnector {
    private final Connection connection;

    /**
     * Create and check connection to database
     *
     * @param host hoar URI
     * @param user username
     * @param pass password
     * @throws SQLException when connection issues
     */
    public DatabaseConnector(String host, String user, String pass) throws SQLException {

        try {
            this.connection = DriverManager.getConnection(host, user, pass);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            throw new SQLException("Cannot connect");
        }

        if (connection != null) {
            System.out.println("Successfully connected to database");
        } else {
            throw new SQLException("Failed to make connection to database");
        }
    }

    public Address readAddress(int id) throws SQLException, InvalidValue {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT * FROM address WHERE id = %s", id);
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        Address address = new Address();
        address.setZipCode(resultSet.getString("zip_code"));

        return address;
    }

    public int addAddress(Address address) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("INSERT INTO address(zip_code) VALUES(%s) ", address.getZipCode());

        statement.executeUpdate(sql_command);

        return this.getId("address");
    }

    public Coordinates readCoordinates(int id) throws SQLException, InvalidValue {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT * FROM coordinates WHERE id = %s", id);
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        Coordinates coordinates = new Coordinates();
        coordinates.setY(resultSet.getLong("y"));
        coordinates.setX(resultSet.getDouble("x"));

        return coordinates;
    }

    public int addCoordinates(Coordinates coordinates) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("INSERT INTO coordinates(x, y) VALUES('%s', %d) ", coordinates.getX(), coordinates.getY());

        statement.executeUpdate(sql_command);

        return this.getId("coordinates");
    }

    public Organization readOrganization(int id) throws SQLException, InvalidValue {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT * FROM organization WHERE id = %s", id);
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        Organization organization = new Organization();
        organization.setType(this.readOrganizationType(resultSet.getInt("organization_type_id")));
        organization.setName(resultSet.getString("name"));
        organization.setEmployeesCount(resultSet.getLong("employees_count"));
        organization.setOfficialAddress(this.readAddress(resultSet.getInt("address_id")));

        return organization;
    }

    public int addOrganization(Organization organization) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("INSERT INTO organization(organization_type_id, name, employees_count, address_id) " +
                        "VALUES(%d, '%s', %d, %d) ",
                this.getOrganizationTypeID(organization.getType()),
                organization.getName(), organization.getEmployeesCount(),
                this.addAddress(organization.getOfficialAddress()));

        statement.executeUpdate(sql_command);

        return this.getId("organization");
    }

    public OrganizationType readOrganizationType(int id) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT * FROM organization_type WHERE id = %s", id);
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        return OrganizationType.valueOf(resultSet.getString("name"));
    }

    public int getOrganizationTypeID(OrganizationType organizationType) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT id FROM organization_type WHERE name = '%s'", organizationType.toString());
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        return resultSet.getInt("id");
    }

    public UnitOfMeasure readUnitOfMeasure(int id) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT * FROM unit_of_measure WHERE id = %s", id);
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        return UnitOfMeasure.valueOf(resultSet.getString("name"));
    }
    
    public int getUnitOfMeasureID(UnitOfMeasure unitOfMeasure) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT id FROM unit_of_measure WHERE name = '%s'", unitOfMeasure.toString());
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        return resultSet.getInt("id");
    }

    public Product readProduct(String key) throws SQLException, InvalidValue {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT * FROM product WHERE key = '%s'", key);
        ResultSet resultSet = statement.executeQuery(sql_command);

        resultSet.next();

        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setCoordinates(this.readCoordinates(resultSet.getInt("coordinates_id")));
        product.setManufacturer(this.readOrganization(resultSet.getInt("manufacturer_id")));
        product.setPartNumber(resultSet.getString("part_number"));
        product.setCreationDate(resultSet.getTimestamp("creation_date").toLocalDateTime().atZone(ZoneId.of("Europe/Moscow")));
        product.setUnitOfMeasure(this.readUnitOfMeasure(resultSet.getInt("unit_of_measure_id")));

        return product;
    }

    public int addProduct(Product product, String key) throws SQLException {
        this.updateProduct(product, key); // if already exists
        Statement statement = this.connection.createStatement();

        // if not exists
        String sql_command = String.format("INSERT INTO product(key, name, price, coordinates_id, manufacturer_id, part_number, creation_date, unit_of_measure_id) SELECT '%s', '%s', '%s', %d, %d, '%s', '%s', %d " +
                        "WHERE NOT EXISTS (SELECT 1 FROM product WHERE key='%s')",
                key, product.getName(), product.getPrice(), this.addCoordinates(product.getCoordinates()), this.addOrganization(product.getManufacturer()),
                product.getPartNumber(), product.getCreationDate().toLocalDateTime(), this.getUnitOfMeasureID(product.getUnitOfMeasure()), key);
        int numberAdded = statement.executeUpdate(sql_command);
        
        if (numberAdded != 0) return  this.getId("product");

        sql_command = String.format("SELECT id FROM product WHERE key = '%s'", key);
        ResultSet resultSet = statement.executeQuery(sql_command);
        resultSet.next();
        return resultSet.getInt("id");
        
    }
    
    public void updateProduct(Product product, String key) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("UPDATE product SET name = '%s', price = '%s', coordinates_id = %d, manufacturer_id = %d, part_number = '%s', unit_of_measure_id = %d WHERE key = '%s'",
                product.getName(), product.getPrice(), this.addCoordinates(product.getCoordinates()), this.addOrganization(product.getManufacturer()),
                product.getPartNumber(), this.getUnitOfMeasureID(product.getUnitOfMeasure()), key);

        statement.executeUpdate(sql_command);
    }
    
    public void removeProduct(String key) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("DELETE FROM product WHERE key = '%s'", key);

        statement.executeUpdate(sql_command);
    }

    /**
     * Get id of last added element
     *
     * @return id of last added element
     * @throws SQLException when connection issues
     */
    private int getId(String table) throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = String.format("SELECT currval(pg_get_serial_sequence('%s', 'id'))", table);
        ResultSet resultSet = statement.executeQuery(sql_command);
        resultSet.next();
        int id = resultSet.getInt("currval");
        return id;
    }

    /**
     * Clear database method. Drops all data in all the tables
     *
     * @throws SQLException when connection issues
     */
    public void clearDatabase() throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = "DELETE FROM product";
        statement.executeUpdate(sql_command);

        sql_command = "DELETE FROM organization";
        statement.executeUpdate(sql_command);

        sql_command = "DELETE FROM address";
        statement.executeUpdate(sql_command);

        sql_command = "DELETE FROM coordinates";
        statement.executeUpdate(sql_command);
        
        System.out.println("Collection cleared");
    }

    /**
     * Get all the products id's in database
     * @return id's ArrayList
     * @throws SQLException when connection issues
     */
    public ArrayList<Integer> getProductsIDs() throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = "SELECT id FROM product";
        ResultSet resultSet = statement.executeQuery(sql_command);

        ArrayList<Integer> ids = new ArrayList<Integer>();

        while (resultSet.next()) {
            ids.add(resultSet.getInt("id"));
        }

        return ids;
    }

    /**
     * Get all the products keys in database
     * @return keys ArrayList
     * @throws SQLException when connection issues
     */
    public ArrayList<String> getProductsKeys() throws SQLException {
        Statement statement = this.connection.createStatement();

        String sql_command = "SELECT key FROM product";
        ResultSet resultSet = statement.executeQuery(sql_command);

        ArrayList<String> keys = new ArrayList<String>();

        while (resultSet.next()) {
            keys.add(resultSet.getString("key"));
        }

        return keys;
    }


}