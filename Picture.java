import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.util.Random; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    
    
    public void grayScale(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int blue = pixelObj.getBlue();
                int red = pixelObj.getRed();
                int green = pixelObj.getGreen();
                int average = (red+blue+green)/3;
                pixelObj.setColor(new Color(average, average, average));
            }
        }
    }
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue(){
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                    pixelObj.setGreen(0);
                    pixelObj.setRed(0);    
            }
        }
    }
    
    
    public static void randomCropAndCopy(Picture picture){
        Random r = new Random();
        //int sHeight = r.nextInt(picture.getHeight())     random.nextInt(max + 1 - min) + min;
        int eHeight = r.nextInt(picture.getHeight()+1-10)+10;
        int eWidth = r.nextInt(picture.getWidth()+1-10)+10;
        
        int sHeight = r.nextInt(eHeight+1-10)+10;
        int sWidth = r.nextInt(eWidth+1-10)+10;
        
        if(sHeight<eHeight && sWidth<eWidth){
            picture.cropAndCopy(picture, eHeight, sHeight, eWidth, sWidth, eWidth, eHeight);
        }
            
        else if(sHeight>eHeight && sWidth < eWidth){
            picture.cropAndCopy(picture, eHeight, sHeight, sWidth, eWidth, sWidth, eHeight);
        }
        else if(sHeight<eHeight && sWidth>eWidth){
            picture.cropAndCopy(picture, eHeight, sHeight, eWidth, sWidth, eWidth, eHeight);
        }
        else{
            picture.cropAndCopy(picture, eHeight, sHeight, eWidth, sWidth, eWidth, eHeight);
        }
    }
    
    
    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }
    
    public void mirrorVerticalRightToLeft(){
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = pixels.length-1; row > 0; row--)
        {
            for (int col = pixels[row].length-1; col > width/2 ; col--)
            {
                rightPixel = pixels[row][col];
                leftPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }        
    
    
    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }
    /**
     * Sets each pixel in this picture to the average of the corresponding pixels in the specified
     *      list of pictures.
     *      
     * @param pictures the specifies list of pictures to average
     * 
     * precondition: this picture and all pictures in the list have the same number of rows and cols
     */
    void averagePics(ArrayList<Picture> pictures)
    {
        ArrayList<Pixel[][]> picturesPixels = new ArrayList<Pixel[][]>();
        
        for(Picture picture : pictures)
        {
            Pixel[][] pixels = picture.getPixels2D();
            picturesPixels.add(pixels);
        }
        
        Pixel[][] destPixels = this.getPixels2D();
        
        for(int row = 0; row < destPixels.length; row++)
        {
            for(int col = 0; col < destPixels[row].length; col++)
            {
                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;
                
                for(Pixel[][] srcPixels : picturesPixels)
                {
                    Pixel srcPixel = srcPixels[row][col];
                    redSum += srcPixel.getRed();
                    greenSum += srcPixel.getGreen();
                    blueSum += srcPixel.getBlue();
                }
                
                Pixel destPixel = destPixels[row][col];
                destPixel.setRed(redSum / picturesPixels.size());
                destPixel.setGreen(greenSum / picturesPixels.size());
                destPixel.setBlue(blueSum / picturesPixels.size());
            }
        }
    }
    

    /**
     * Method to copy a region of the specified source Picture object into this Picture object
     *    at the specified location.
     *    
     * @param sourcePicture the picture from which to copy 
     * @param startSourceRow the row in the source picture from which to start copying (inclusive)
     * @param endSourceRow the row in the source picture at which to stop copying (exclusive)
     * @param startSourceCol the column in the source picture from which to start copying (inclusive)
     * @param endSourceCol the column in the source picture at which to stop copying (exclusive)
     * @param startDestRow the row in the destination picture (this picture) into which to start
     *                        copying (inclusive)
     * @param startDestCol the column in the destination picture (this picture) into which to start
     *                        copying (inclusive)
     *    
     * @precondition The destination Picture object must be large enough to fit the copied Picture.
     */
    void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow,
    int startSourceCol, int endSourceCol, int startDestRow, int startDestCol )
    {
        Pixel p; 
        for(int y = startSourceRow; y<endSourceRow; y++){
            for(int x = startSourceCol; x<endSourceCol; x++){
                p = sourcePicture.getPixel(x,y);
                this.getPixel(x-startSourceCol+startDestCol,y-startSourceRow+startDestRow).setColor(sourcePicture.getPixel(x, y).getColor());
            }
            
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
