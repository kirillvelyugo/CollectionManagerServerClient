package Server.Utils;

import Server.Collection.Product;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashMap;

/**
 * Wrapper class to saving LinkedHashMap to Xml
 */
@XmlRootElement
public class Wrapper {

    private LinkedHashMap<String, Product> hashtable;

    public LinkedHashMap<String, Product> getHashtable() {
        return hashtable;
    }

    public void setHashtable(LinkedHashMap<String, Product> hashtable) {
        this.hashtable = hashtable;
    }

}