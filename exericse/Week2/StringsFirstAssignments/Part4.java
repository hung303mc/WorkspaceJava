import edu.duke.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void readAndPrintURL(){
        URLResource file = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String item: file.words()){
            System.out.println(item);
        }
    }
    public String findYoutube(String s){
        int index;
        int startIndex, stopIndex;
        String lowerS;
        String result = "";
        // convert string to lower case
        lowerS = s.toLowerCase();
        // find youtube.com in string s
        index = lowerS.indexOf("youtube.com");
        // if(found): 
        if(index != -1){
            // search "\"" for the " occur befor youtube.com => startIndex    
            startIndex = lowerS.lastIndexOf("\"",index-1);
            // search "\"" for the " occur after youtube.com => stopIndex            
            stopIndex = lowerS.indexOf("\"",index+11);
            if((startIndex == -1)|(stopIndex == -1)){
                return  "invalid URL youtube.com";
            }
            else{
                // return URL page link to youtube.com
                return s.substring(startIndex+1, stopIndex);
            }
        }
        return "";
    }
    public void testFindFuncSimple(){
        String s = "a=\"https://www.YoutUbe.com/watch?v=wHF3Jv6Gk2o\"12345678";
        System.out.println("string = " + s);
        System.out.println("URL = " + findYoutube(s));        
    }
    public void testFindYoutube(){
        URLResource file = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String item: file.words()){
            String s = findYoutube(item);
            if(s != ""){
                System.out.println(s);
            }
        }        
    }
}
