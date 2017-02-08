import edu.duke.*;
import java.io.File;

/**
 * Write a description of DirReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirReader {
    public void checkDir(){
        DirectoryResource dirResource = new DirectoryResource();
        for(File f : dirResource.selectedFiles()){
            System.out.println(f);
        }
    }
}
