import java.util.ArrayList;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  
    /** Method to test zeroBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test averagePics */
  public static void testAveragePics()
  {
      ArrayList<Picture> pics = new ArrayList<Picture>();
      pics.add(new Picture("faces/alex.jpg"));
      pics.add(new Picture("faces/alexander.jpg"));
      pics.add(new Picture("faces/alfred.jpg"));
      pics.add(new Picture("faces/ambroz.jpg"));
      
      Picture averagePic = new Picture(pics.get(0).getHeight(), pics.get(0).getWidth());
      averagePic.averagePics(pics);
      averagePic.explore();
      pics.remove("faces/alex.jpg");
      pics.remove("faces/alexander.jpg");
      pics.remove("faces/alfred.jpg");
      pics.remove("faces/ambroz.jpg");
      
    pics.add(new Picture("faces/zora.jpg"));
      pics.add(new Picture("faces/zlatica.jpg"));
      pics.add(new Picture("faces/zlata.jpg"));
      pics.add(new Picture("faces/zita.jpg"));
      averagePic = new Picture(pics.get(0).getHeight(), pics.get(0).getWidth());
      averagePic.averagePics(pics);
      averagePic.explore();      

  }
  
  /** Method to test cropAndCopy */
  public static void testCropAndCopy()
  {
    Picture source = new Picture("testImageSrc.png");
    Picture destination = new Picture("testImageDest.png");
    source.explore();
    destination.cropAndCopy(source,
            250 /* startSourceRow */,
            350 /* endSourceRow */,
            100 /* startSourceCol */,
            300 /* endSourceCol */, 
            100 /* startDestRow */,
            50 /* startDestCol */ );
    
    /* visually inspect the image to ensure no part of the yellow border
     *      is copied
     */
    destination.explore();
    destination.cropAndCopy(source,
            250 /* startSourceRow */,
            350 /* endSourceRow */,
            100 /* startSourceCol */,
            300 /* endSourceCol */, 
            150 /* startDestRow */,
            300 /* startDestCol */ );
    
    /* visually inspect the image to ensure that the orange rectangle is
     *      in the lower-right corner and no exceptions are generated
     */
    destination.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}