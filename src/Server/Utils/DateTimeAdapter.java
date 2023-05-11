package Server.Utils;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class for marshalling abd unmarshalling dates
 */
public class DateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override public ZonedDateTime unmarshal(String xml) throws Exception { return ZonedDateTime.parse(xml, formatter);}

    @Override public String marshal(ZonedDateTime object) throws Exception { return formatter.format(object);
    }
}
