package Commands;

import Connection.UDPClient;
import Expections.WrongArguments;
import Utils.Response;
import Utils.UserData;

import javax.naming.NoPermissionException;
import java.beans.Transient;
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
 * This command uses collectionManager
 */
public class ExecuteScriptClient implements ClientCommand {
    HashMap<String, ClientCommand> commands;
    private final ArrayList<Integer> history;
    transient private UDPClient udpClient;

    public ExecuteScriptClient(HashMap<String, ClientCommand> commands, UDPClient udpClient) {
        this.commands = commands;
        this.history = new ArrayList<>();
        this.udpClient = udpClient;
    }

    @Override
    public ExecuteScriptClient getNewObject(){
        return new ExecuteScriptClient(this.commands, this.udpClient);
    }

    @Override
    public String getDescription() {
        return "[file_path] Description: execute script in file";
    }

    @Override
    public void prepareRequest(String[] args) throws WrongArguments {
        if(args.length < 2) throw new WrongArguments("Not enough arguments");
        Path path = Paths.get(args[1]);
        history.add(args[1].hashCode());
        try{
            if(!Files.exists(path)) throw new FileNotFoundException("File " + path + " not found");
            if(!Files.isReadable(path)) throw new NoPermissionException("Cannot read files");
            if(!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file");
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }
        catch (NoPermissionException e){
            System.out.print("No permissions " + e.getMessage());
            return;
        }

        try(InputStream inputStream = Files.newInputStream(path)){
            Scanner reader = new Scanner(inputStream);
            System.out.println("Running " + path);
            run(reader);
            history.clear();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void run(Scanner scanner) throws IOException {

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line == null) return;

            String[] args = line.split(" ");
            args[0] = args[0].toLowerCase().strip();
            if (commands.containsKey(args[0])){
                try {
                   ClientCommand command = commands.get(args[0]);
                   command.setUserData(userData);
                    if (command.getClass() == ExecuteScriptClient.class) {
                        if (this.history.contains(args[1].hashCode())) {
                            System.out.println("Recursion! Command skipped!");
                            continue;
                        }
                        this.history.add(args[0].hashCode());
                    }
                    command.prepareRequest(args);
                    this.udpClient.sendRequest(command);
                    Response response = this.udpClient.readResponse();
                    command.acceptResponse(response);
                }
                catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (WrongArguments e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println(args[0] + " is not a command. Try again");
            }
        }
    }

    @Override
    public void acceptResponse(Response response) {

    }

    private UserData userData;

    @Override
    public UserData getUserData() {
        return userData;
    }

    @Override
    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
