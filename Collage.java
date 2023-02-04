import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.Canvas;

/**
 * Write a description of class Collage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Collage extends Picture
{
    static public void collage(){
    Picture source = new Picture("redMotorcycle.jpg");
    Picture destination = new Picture(source.getWidth()*4,source.getHeight()*4); 
    destination.cropAndCopy(source,0 ,source.getHeight() ,0 ,source.getWidth(),0,0);
    //destination.explore();
    
    source.grayScale(); 
    
    destination.cropAndCopy(source,0, source.getHeight(), 0, source.getWidth(),source.getHeight(), 0);
    //source.explore();
    //destination.explore(); 
    


    
    Picture source3 = new Picture("redMotorcycle.jpg");
    source3.mirrorVerticalRightToLeft();
    
    destination.cropAndCopy(source3, 0, source3.getHeight(), 0, source3.getHeight(), source.getHeight(), source.getWidth()); 

    
    
    
    
    
    
    
    ArrayList<Picture> pics = new ArrayList<Picture>();
    
    Picture source4 = new Picture("redMotorcycle.jpg");
    Picture source5 = new Picture("redMotorcycle.jpg");
    source4.grayScale();
    source5.mirrorVerticalRightToLeft();
      pics.add(source4);
      pics.add(source5);      
      Picture averagePic = new Picture(pics.get(0).getHeight(), pics.get(0).getWidth());
      averagePic.averagePics(pics);
    
    averagePic.mirrorVerticalRightToLeft();

      
      
    destination.cropAndCopy(averagePic,0, averagePic.getHeight(), 0, averagePic.getWidth(),0, source.getWidth());
    destination.explore();
}
    }

