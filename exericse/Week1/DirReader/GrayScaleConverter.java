import edu.duke.*;
import java.io.*;

/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrayScaleConverter {
    // start with image I want
    public ImageResource makeGray(ImageResource inImage){
        // I make a blank image
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        // for each pixel: compute grayscale
        for(Pixel pixel: outImage.pixels()){
            // local coresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            // calculate outImage base on inImage
            int avrVal = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            // assign new value to pixel in outImage
            pixel.setRed(avrVal);pixel.setGreen(avrVal);pixel.setBlue(avrVal);
           
        }
        // outImage
        return outImage;
    }
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    public void selectAndConvert(){
        DirectoryResource dirResource = new DirectoryResource();
        for(File f : dirResource.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            String fileName = inImage.getFileName();
            // set file name for gray image
            String newName = "gray-"+fileName;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }        
    }    
}
