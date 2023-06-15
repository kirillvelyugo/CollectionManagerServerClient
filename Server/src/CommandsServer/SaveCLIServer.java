package CommandsServer;

import CollectionManager.CollectionManager;
import Commands.ClientCommand;
import Expections.WrongArguments;
import Utils.Response;
import Utils.ResponseCodes;
import jakarta.xml.bind.JAXBException;

import javax.naming.NoPermissionException;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Save collection to file
 */
public class SaveCLIServer implements ServerCLICommands {
    private CollectionManager collectionManager;

    public SaveCLIServer(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        Path path = collectionManager.getDefault_path();
        try{
            if(args.length > 1) {
                path = Paths.get(args[1]);
                if (!path.isAbsolute()) path = path.toAbsolutePath();

                if (Files.isDirectory(path)) throw new WrongArguments("Path should be a regular file.");
                if (!Files.exists(path)) Files.createFile(path);
                if (!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
                if (!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
            }

            if(path == null) throw new WrongArguments("Incorrect path!");
            collectionManager.save(path);
            System.out.println("Collection saved to file " + path + " successfully");
        }
        catch (InvalidPathException e){
            System.out.println("Argument must be a correct file path.");
        }
        catch (NoPermissionException e){
            System.out.println("No enough permissions to " + path + " - " + e.getMessage()); // permissions deny
        }
        catch (IOException | JAXBException e){
            e.printStackTrace();
        } catch (WrongArguments e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDescription() {
        return "[] Description: save collection to file";
    }

    @Override
    public String getName() {
        return "Save";
    }
}
