/**
 * Find the highest (hottest) temperature in a file of CSV weather data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
	public CSVRecord hottestHourInFile(CSVParser parser) {
		//start with largestSoFar as nothing
		CSVRecord largestSoFar = null;
		//For each row (currentRow) in the CSV File
		for (CSVRecord currentRow : parser) {
			largestSoFar = getLagestOfTwo(currentRow,largestSoFar);
		}
		//The largestSoFar is the answer
		return largestSoFar;
	}

	public CSVRecord hottestInManyDay(DirectoryResource dr){
		CSVRecord largestInManyDay = null;
		for(File f : dr.selectedFiles()){
			FileResource fr = new FileResource(f);
			CSVRecord largestInDay = hottestHourInFile(fr.getCSVParser());
			largestInManyDay = getLagestOfTwo(largestInDay,largestInManyDay);
		}
		return largestInManyDay;
	}
	public CSVRecord getLagestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar){
		//If largestSoFar is nothing
		if (largestSoFar == null) {
			largestSoFar = currentRow;
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp > largestTemp) {
				//If so update largestSoFar to currentRow
				largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}
	public void testHottestInDay () {
		FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
		CSVRecord largest = hottestHourInFile(fr.getCSVParser());
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("TimeEST"));
	}
	public void testHottestInManyDay () {
		DirectoryResource dr = new DirectoryResource();
		CSVRecord largest = hottestInManyDay(dr);
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("TimeEST"));
	}
}
