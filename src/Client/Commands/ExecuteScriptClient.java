package Client.Commands;

import Server.Expections.WrongArguments;

import javax.naming.NoPermissionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Execute script command. Takes one argument with script file path
 * This command uses collectionManager reference to call "add" method
 */
public class ExecuteScriptClient implements ClientCommand {
    @Override
    public String getDescription() {
        return "[file_path] Description: execute script in file";
    }
}
