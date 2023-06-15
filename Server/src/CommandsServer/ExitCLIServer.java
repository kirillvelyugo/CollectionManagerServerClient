package CommandsServer;

import CollectionManager.CollectionManager;
import Expections.WrongArguments;
import jakarta.xml.bind.JAXBException;

import javax.naming.NoPermissionException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExitCLIServer implements ServerCLICommands{
    @Override
    public void execute(String[] args) {
        System.out.println("--Exit interactive mode Server--");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "[] Description: terminate the program (without saving to a file)";
    }

    @Override
    public String getName() {
        return "Exit";
    }
}
