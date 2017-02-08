import edu.duke.*;
import java.io.*;
/**
 * Write a description of DirReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirReader {
    public void readDir(){
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource image= new ImageResource(f);
        }
    }    
}
