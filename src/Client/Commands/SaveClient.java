package Client.Commands;

import Server.CollectionManager.CollectionManager;
import Server.Expections.WrongArguments;
import jakarta.xml.bind.JAXBException;

import javax.naming.NoPermissionException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Save collection to file
 */
public class SaveClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[] Description: save collection to file";
    }
}
