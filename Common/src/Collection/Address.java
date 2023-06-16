package Collection;

import Expections.InvalidValue;

import java.io.Serializable;

/**
 * Address class - use for store address organization
 */
public class Address implements Serializable {
    private String zipCode; // Field can be null

    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set zipCode
     * @param zipCode Zip Code
     * @throws InvalidValue if zipCode is null
     */
    public void setZipCode(String zipCode) throws InvalidValue {
//        if (zipCode == null){throw new InvalidValue("zipCode shouldn't be null");}
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address: zipCode = " + this.zipCode;
    }
}
