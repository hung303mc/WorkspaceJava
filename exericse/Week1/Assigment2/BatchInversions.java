import edu.duke.*;
import java.io.*;

/**
 * Write a description of InverterImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage){
      // - copy blank image from input image
      ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
      // - Loop from every pixel
      for(Pixel outPixel: outImage.pixels()){
        //   - calculate new value for RGB pixel from input pixel
        //   - Update new value
        Pixel inPixel = inImage.getPixel(outPixel.getX(),outPixel.getY());
        outPixel.setRed(255-inPixel.getRed());
        outPixel.setGreen(255-inPixel.getGreen());
        outPixel.setBlue(255-inPixel.getBlue());
      }
      return outImage;
    }
    public void selectAndConvert (){
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource image= new ImageResource(f);
            ImageResource invImage = makeInversion(image);
            String iName = image.getFileName();
            String newName = "inverted-"+iName;
            invImage.setFileName(newName);
            invImage.draw();
            invImage.save();
        }        
    }
}
