/*
 * Prompt user for a binary string, and convert into its equivalent decimal number.
 */
import java.util.Scanner;
public class Bin2Dec {
   public static void main(String[] args) {
      String binStr;  // The input binary string
      int binStrLen;  // The length of binStr
      int dec = 0;    // The decimal equivalent, accumulate from 0
 
      // Read input
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a binary string: ");
      binStr = in.next();
      binStrLen = binStr.length();
 
      // Process char by char from the right (i.e. Least-significant bit)
      for (int exp = 0; exp < binStrLen ; ++exp) {
         int charPos = binStrLen - 1 - exp;     // charAt(pos)
         char binChar = binStr.charAt(charPos);
         // 3 cases: '1' (add to dec), '0' (do nothing), other (error)
         if (binChar == '1') {
            dec += (int)Math.pow(2, exp);  // cast the double result back to int
         } else if (binChar != '0') {
            System.out.println("Error: Invalid binary string \"" + binStr + "\"");
            System.exit(1);   // quit
         }
      }

      // Print result
      System.out.println("The equivalent decimal for \"" + binStr + "\" is " + dec);
      in.close();
   }
}
