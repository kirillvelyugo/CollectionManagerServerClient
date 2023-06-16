package CollectionManager;

import Collection.Product;
import Run.DatabaseConnector;
import Utils.Wrapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import javax.naming.NoPermissionException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Class for work with collection
 */
public class CollectionManager {
    private LinkedHashMap <String, Product> products;

    private final DatabaseConnector databaseConnector;

    /**
     * Constructor of class - create Collection Tools
     */
    public CollectionManager (DatabaseConnector databaseConnector){
        this.databaseConnector = databaseConnector;
        products = new LinkedHashMap<>();
    }

    /**
     * Add object in collection
     * @param key Key
     * @param obj Object, which have to add in collection
     */
    public void addObj (String key, Product obj){
        products.put(key, obj);
    }

    /**
     * Remove object by key
     * @param key Key
     */
    public void removeKey (String key){
        products.remove(key);
    }

    /**
     * Checks if the key is in the collection
     * @param key Key
     * @return True or False
     */
    public boolean containsKey (String key){
        return products.containsKey(key);
    }

    /**
     * returns an object with a specific id
     * @param id Id
     * @return Element of product
     */
    public Product findById (int id){
        Iterator<Product> iter = getIterator();
        while (iter.hasNext()){
            Product product = iter.next();
            if (product.getId() == id) return product;
        }
        return null;
    }

    public String getKeyById (int id ){
        for (String key : this.products.keySet()){
            Product product = this.getByKey(key);
            if (product.getId() == id) return key;
        }
        return null;
    }

    /**
     * Update element with spec. id
     * @param key key
     * @param product product
     */
    public void update(String key, Product product) {
        this.products.replace(key, product);
    }

    /**
     * Return iterator
     * @return iterator of product
     */
    public Iterator<Product> getIterator (){
        return products.values().iterator();
    }

    /**
     * Clear collection
     */
    public void clear (){
        this.products.clear();
    }

    /**
     * Return key set of collection
     * @return Key set
     */
    public Set<String> getKeySet(){
        return products.keySet();
    }

    /**
     * Return object from collection by id
     * @param key Key
     * @return Element of product
     */
    public Product getByKey(String key){
        return products.get(key);
    }


    /**
     * Return information about collection
     * @return String with information
     */
    public String getInfo() {
        String info = "";
        info += "Information about collection:\n";
        ZonedDateTime creationDate = null;

        Set<String> keyset = this.getKeySet();

        for (String key : keyset) {
            if (creationDate == null) creationDate = this.getByKey(key).getCreationDate();
            if (this.getByKey(key).getCreationDate().compareTo(creationDate) < 0) {
                creationDate = this.getByKey(key).getCreationDate();
            }
        }

        if (creationDate == null) {
            info += "Cannot spot creation date because collection is empty\n";
        } else {
            info += "Created at " + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + '\n';
            info += "Collection type is " + this.products.getClass().getName() + '\n';
            info += "Amount of items stored in - " + this.products.size() + '\n';
        }

        return info;
    }

    public LinkedHashMap<String, Product> getProducts() {
        return products;
    }
}



