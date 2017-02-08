import edu.duke.*;

/**
 * Write a description of FindGeneAndTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "no ATG";
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(stopIndex == -1){
            return "no TAA";
        }
        result = dna.substring(startIndex,stopIndex+3);
        if((result.length()%3) == 0){
            return result;
        }
        return "invalid gene";
    }
    public void testSimpleGene(){
        // test
        String dna = "ATGTTTTAAGGGGGGG";
        System.out.println("DNA = " + dna);
        System.out.println("=> gene = " + findSimpleGene(dna));
        //test1
        String dna1 = "ATGATTAGAAAAAATAAAAAAAAAAAAGGGGGGGG";
        System.out.println("DNA = " + dna1);
        System.out.println("=> gene = " + findSimpleGene(dna1));        
        //test2
        String dna2 = "AAAAAAAATTTTTTTTGGGGGGGATG";
        System.out.println("DNA = " + dna2);
        System.out.println("=> gene = " + findSimpleGene(dna2));         
        //test3
        String dna3 = "ATTTTTTTTTTTTTTTTTAAGAAAAAAAA";
        System.out.println("DNA = " + dna3);
        System.out.println("=> gene = " + findSimpleGene(dna3));         
    }
}
