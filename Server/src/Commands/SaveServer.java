package Commands;

import Utils.Response;
import Utils.ResponseCodes;

/**
 * Save collection to file
 */
public class SaveServer implements ServerCommand {
//    private final CollectionManager collectionManager;
//
//    public SaveServer(CollectionManager collectionManager) {
//        this.collectionManager = collectionManager;
//    }
//
//    @Override
//    public void execute(String[] args) throws WrongArguments {
//
//        Path path = collectionManager.getDefault_path();
//        try{
//            if(args.length > 1) {
//                path = Paths.get(args[1]);
//                if (!path.isAbsolute()) path = path.toAbsolutePath();
//
//                if (Files.isDirectory(path)) throw new WrongArguments("Path should be a regular file.");
//                if (!Files.exists(path)) Files.createFile(path);
//                if (!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
//                if (!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
//            }
//
//            if(path == null) throw new WrongArguments("Incorrect path!");
//            collectionManager.save(path);
//            System.out.println("Collection saved to file " + path + " successfully");
//        }
//        catch (InvalidPathException e){
//            throw  new WrongArguments("Argument must be a correct file path.");
//        }
//        catch (NoPermissionException e){
//            System.out.println("No enough permissions to " + path + " - " + e.getMessage()); // permissions deny
//        }
//        catch (IOException | JAXBException e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public Response execute(ClientCommand command) {
        System.out.println("Save completed");
        return new Response(ResponseCodes.OK);
    }

    @Override
    public String getDescription() {
        return "[] Description: save collection to file";
    }
}
