package Collection;

import Expections.InvalidValue;


import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Product class - main class of collections
 */
public class Product implements Comparable<Product>, Serializable {
    private Integer id = -1; // Filed can't be null, Value of field should be grader than 0, value of field should be unique and generate automatic
    private String name; // Filed can't be null, and String shouldn't be empty
    private Coordinates coordinates; // Field can be null
    java.time.ZonedDateTime creationDate; // Field can't be null, value generations automatic
    private Double price; // Field can't be null, Value of field should be grader than 0
    private String partNumber; // Field can be null
    private UnitOfMeasure unitOfMeasure; // Field can be null
    private Organization manufacturer; // Field can be null
    private int createdBy = -1;

    public Product() {
        creationDate = ZonedDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }


    /**
     * Set Id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Set name
     *
     * @param name name of product
     * @throws InvalidValue if name is null or name is empty
     */
    public void setName(String name) throws InvalidValue {
        if (name == null) {
            throw new InvalidValue("name shouldn't be null");
        }
        if (name.length() == 0) {
            throw new InvalidValue("name shouldn't be empty");
        }
        this.name = name;
    }

    /**
     * Set coordinates
     *
     * @param coordinates coordinates of product
     * @throws InvalidValue if coordinates is null
     */
    public void setCoordinates(Coordinates coordinates) throws InvalidValue {
        if (coordinates == null) {
            throw new InvalidValue("coordinates shouldn't be null");
        }
        this.coordinates = coordinates;
    }

    /**
     * Set creation date
     *
     * @param creationDate coordinates of product
     */
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Set price
     *
     * @param price price of product
     * @throws InvalidValue if price < 0 or price is null
     */
    public void setPrice(Double price) throws InvalidValue {
        if (price == null) {
            throw new InvalidValue("price shouldn't be null");
        }
        if (price <= 0) {
            throw new InvalidValue("price shouldn't be less than 0");
        }
        this.price = price;
    }

    /**
     * Set part number
     *
     * @param partNumber partNumber of product
     * @throws InvalidValue if partNumber is null
     */
    public void setPartNumber(String partNumber) throws InvalidValue {
        this.partNumber = partNumber;
    }

    /**
     * Set unit of measure
     *
     * @param unitOfMeasure unitOfMeasure for product
     * @throws InvalidValue if unitOfMeasure is null
     */
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) throws InvalidValue {
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * Set manufacturer
     *
     * @param manufacturer manufacturer
     * @throws InvalidValue if manufacturer is null
     */
    public void setManufacturer(Organization manufacturer) throws InvalidValue {
        if (manufacturer == null) {
            throw new InvalidValue("manufacturer shouldn't be null");
        }
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", partNumber='" + partNumber + '\'' +
                ", unitOfMeasure=" + unitOfMeasure +
                ", manufacturer=" + manufacturer +
                ", createdBy=" + createdBy +
                '}';
    }

    @Override
    public int compareTo(Product oth) {
        return partNumber.compareTo(oth.partNumber);
    }
}
