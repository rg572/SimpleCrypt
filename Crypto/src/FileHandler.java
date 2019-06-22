import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileHandler {

    public FileHandler(){

    }

    public String fileToString(String path){
        StringBuilder sbuild = new StringBuilder();

        try(Stream<String> stream = Files.lines(Paths.get(path))){
            stream.forEach(s -> sbuild.append(s).append('\n'));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return sbuild.toString();
    }

    public Boolean StringToFile(String s, String path){
        try(PrintWriter out = new PrintWriter(path)){
            out.print(s);
            return true;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }
}
