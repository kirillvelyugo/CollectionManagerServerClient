package Server.CollectionManager;

import Server.Collection.Product;
import Server.Utils.Wrapper;
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

    private final Path default_path;

    /**
     * Constructor of class - create Server.Collection Tools
     */
    public CollectionManager (Path path){
        default_path = path;
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
     * Return default path
     * @return Default path
     */
    public Path getDefault_path(){
        return default_path;
    }

    /**
     * Return information about collection
     * @return String with information
     */
    public String getInfo(){
        String info = "";
        info += "Information about collection:\n";
        ZonedDateTime creationDate = null;

        Set<String> keyset = this.getKeySet();

        for(String key : keyset){
            if (creationDate == null) creationDate = this.getByKey(key).getCreationDate();
            if(this.getByKey(key).getCreationDate().compareTo(creationDate) < 0){
                creationDate = this.getByKey(key).getCreationDate();
            }
        }

        if (creationDate == null){
            info += "Cannot spot creation date because collection is empty\n";
        }else{
            info += "Created at " + creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")) + '\n';
            info += "Server.Collection type is " + this.products.getClass().getName() + '\n';
            info += "Amount of items stored in - " + this.products.size() + '\n';
        }

        return info;
    }

    /**
     * Save collection in file
     * @param path Path to file
     * @throws JAXBException if xml is not correct
     */
    public void save(Path path) throws JAXBException {
        try (FileWriter fileWriter = new FileWriter(path.toFile())) {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class);
            Wrapper wrapper = new Wrapper();
            wrapper.setHashtable(products);
            fileWriter.write(objectToXml(jc, wrapper));
            System.out.println("Saved successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Convert object in Xml
     * @param jaxbContext JaxbContext
     * @param object Object to convert
     * @return Converted data
     * @throws JAXBException if xml is not correct
     */
    public static String objectToXml(JAXBContext jaxbContext, Object object) throws JAXBException
    {
        StringWriter writerTo = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, writerTo);
        return writerTo.toString();
    }

    /**
     * Open file upload data
     * @param path Path to file
     */
    public void load(Path path){
        if (path == null){
            return;
        }
        try{
            if(!path.isAbsolute()) path = path.toAbsolutePath();
            if(!Files.exists(path)) throw new FileNotFoundException("File " + path + " not found");
            if(!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
            if(!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
        }
        catch (InvalidPathException e){
            System.out.println("Argument must be a correct file path. Data not loaded.");
            return;
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage() + ". Data not loaded."); // file does not exist
            return;
        }
        catch (NoPermissionException e){
            System.out.print("No enough permissions to " + path + " - " + e.getMessage() + " Data not loaded."); // permissions deny
            return;
        }

       try (InputStream inputStream = Files.newInputStream(path)) {
           JAXBContext jaxbContext = JAXBContext.newInstance(Wrapper.class);
           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

           Wrapper wrapper = (Wrapper) jaxbUnmarshaller.unmarshal(inputStream);
           LinkedHashMap <String, Product> products = wrapper.getHashtable();
           System.out.println(products.size() + " element(s) loaded from file");

           this.products = products;
       }
       catch (IOException | JAXBException e) {
           System.out.println("Error while reading. Data not loaded.");
       }
    }


}



