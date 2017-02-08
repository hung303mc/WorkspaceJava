import edu.duke.*;
import java.io.*;
/**
 * Write a description of PrintFile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrintFile {
    public void printFileName(File folder){
        for(File f: folder.listFiles()){
            if(f.isDirectory()){
                printFileName(f);
            }
            else if(f.isFile()){
                String name = f.getName();
                String lowerName;
                int index;
                // print file name for fun
                //System.out.println(name);
                // convert name to lowerName
                lowerName = name.toLowerCase();
                // get index "readme" from name of file
                index = lowerName.indexOf("readme");
                // if(found) 
                if(index != -1){
                    // => delete file
                    if(f.delete()){
                        // print deleted Readme
                        System.out.printf("Deleted %s file successed!!! %n",name);
                    }    
                }
            }
        }
    }
    public void testPrint(){
        File folder = new File("D:\\Project\\Java\\exericse\\Week2\\test");
        printFileName(folder);
    }
}
