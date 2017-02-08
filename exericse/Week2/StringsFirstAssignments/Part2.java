
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon ){
        String result = "";
        String upperDna = dna.toUpperCase();
        
        int startIndex = upperDna.indexOf(startCodon);
        if(startIndex == -1){
            return ("no" + startCodon);
        }
        int stopIndex = upperDna.indexOf(stopCodon,startIndex+3);
        if(stopIndex == -1){
            return "no" + stopCodon;
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
        System.out.println("=> gene = " + findSimpleGene(dna,"ATG","TAA"));
        //test1
        String dna1 = "ATGATTAGAAAAAATAAAAAAAAAAAAGGGGGGGG";
        System.out.println("DNA = " + dna1);
        System.out.println("=> gene = " + findSimpleGene(dna1,"ATG","TAA"));        
        //test2
        String dna2 = "AAAAAAAATTTTTTTTGGGGGGGATG";
        System.out.println("DNA = " + dna2);
        System.out.println("=> gene = " + findSimpleGene(dna2,"ATG","TAA"));         
        //test3
        String dna3 = "ATTTTTTTTTTTTTTTTTAAGAAAAAAAA";
        System.out.println("DNA = " + dna3);
        System.out.println("=> gene = " + findSimpleGene(dna3,"ATG","TAA"));         
        //test4
        String dna4 = "atgtttgggtaa";
        System.out.println("DNA = " + dna4);
        System.out.println("=> gene = " + findSimpleGene(dna4,"ATG","TAA"));        
    }
}
