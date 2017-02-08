
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean   twoOccurrences(String stringa, String stringb){
        int index;
        // find the first occ string a in string b
        index = stringb.indexOf(stringa);
        // if (found) => find the second occ string a in string b
        if(index != -1){
            index = stringb.indexOf(stringa,index+1);
            // if (found) => return true            
            if(index != -1){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public String lastPart (String stringa, String stringb){
        String result ="";
        int index;
        int startIndex;
        int stopIndex;
        // find the index string a in string b
        index = stringb.indexOf(stringa);
        // if(found) return substring(index+1,stringb.length()-(index+1))
        if(index != -1){
            startIndex = index+stringa.length();
            stopIndex = stringb.length();
            return(stringb.substring(startIndex,stopIndex));
        }
        return stringb;
    }
    public void testing (){
        // test twoOccurrences
        System.out.println("test twoOccurrences function *****************");
        // start testing
        String sa = "by";
        String sb = "A story by Abby Long";
        System.out.print("Stringa = " + sa + ",");
        System.out.print("Stringb = " + sb + ",");
        if(twoOccurrences(sa,sb)){
            System.out.println("found 2 occurences");
        }
        else{
            System.out.println("not found");
        }
        String sa1 = "a";
        String sb1 = "banana";
        System.out.print("Stringa = " + sa1 + ",");
        System.out.print("Stringb = " + sb1 + ",");
        if(twoOccurrences(sa1,sb1)){
            System.out.println("found 2 occurences");
        }
        else{
            System.out.println("not found");
        }        
        String sa2 = "atg";
        String sb2 = "ctgtatgta";
        System.out.print("Stringa = " + sa2 + ",");
        System.out.print("Stringb = " + sb2 + ",");
        if(twoOccurrences(sa2,sb2)){
            System.out.println("found 2 occurences");
        }
        else{
            System.out.println("not found");
        }        
        // test lastPart
        System.out.println("test lastPart function *****************");     
        // start testing
        String sa3 = "an";
        String sb3 = "banana";
        System.out.print("Stringa = " + sa3 + ",");
        System.out.print("Stringb = " + sb3 + ",");
        System.out.println("result = " + lastPart(sa3,sb3));
        //test4
        String sa4 = "zoo";
        String sb4 = "forest";
        System.out.print("Stringa = " + sa4 + ",");
        System.out.print("Stringb = " + sb4 + ",");
        System.out.println("result = " + lastPart(sa4,sb4));        
    }
}
