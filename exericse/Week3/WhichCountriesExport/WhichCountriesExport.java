import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of FirstCSVExample here.
 * 
 * @author (Hung303mc) 
 * @version Feb 3, 2017
 */
public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        // for each record from in CSV file
        for(CSVRecord record : parser){
            // look at export column
            String export = record.get("Exports");
            // check if contain export interest
            export = export.toLowerCase();
            exportOfInterest = exportOfInterest.toLowerCase();
            if(export.contains(exportOfInterest)){
              // if(found) => write down country name            
              String country = record.get("Country");
              System.out.println(country);  
            }
        }
   }
   public void whoExportCoffee(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    // listExporters(parser,"Coffee");
    // countryInfo(parser);
    // whoExportBoth(parser,"fish","nuts");
    // int num = numExport(parser,"gold");
    // System.out.println(num);
    whoBig(parser,"$999,999,999,999");
    System.out.println("finished");
   }
   public void countryInfo(CSVParser parser){
        // for each record from in CSV file
        for(CSVRecord record : parser){
          if(record.get("Country") == ""){
            System.out.println("Not found");
          }
          else{
            System.out.print(record.get("Country") + " : ");
            System.out.print(record.get("Exports") + " : ");
            System.out.println(record.get("Value (dollars)"));
          }
        }    
   }
   public void whoExportBoth(CSVParser parser, String exportOfInterest1, 
                              String exportOfInterest2){
        // for each record from in CSV file
        for(CSVRecord record : parser){
            // look at export column
            String export = record.get("Exports");
            // check if contain export interest
            export = export.toLowerCase();
            exportOfInterest1 = exportOfInterest1.toLowerCase();
            exportOfInterest2 = exportOfInterest2.toLowerCase();
            if(export.contains(exportOfInterest1) 
            && export.contains(exportOfInterest2)){
              // if(found) => write down country name            
              String country = record.get("Country");
              System.out.println(country);  
            }
        }    
   }    
   public int numExport(CSVParser parser, String exportOfInterest){
        int count = 0;
        // for each record from in CSV file
        for(CSVRecord record : parser){
            // look at export column
            String export = record.get("Exports");
            // check if contain export interest
            export = export.toLowerCase();
            exportOfInterest = exportOfInterest.toLowerCase();
            if(export.contains(exportOfInterest)){
              // if(found) => write down country name            
                count++;
            }
        }        
        return count;
   }
   public void whoBig(CSVParser parser, String exportOfInterest){
        // for each record from in CSV file
        for(CSVRecord record : parser){
            // look at export column
            String value = record.get("Value (dollars)");
            // check if contain value interest
            value = value.toLowerCase();
            exportOfInterest = exportOfInterest.toLowerCase();
            if(value.length()>exportOfInterest.length()){
              // if(found) => write down country name            
              String country = record.get("Country");
              System.out.println(country);  
            }
        }        
   }
}
