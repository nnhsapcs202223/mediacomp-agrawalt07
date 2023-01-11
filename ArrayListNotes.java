import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class ArrayListNotes here.
 *
 * @author gcschmit
 * @version 
 */
public class ArrayListNotes
{
    public static void main(String[] args)
    {
     /*
      * Arraylist is a Java Generic
      * 
      * We have to specify the class type of the elements in the list in angle 
      *     brackets (i.e., <>) after every ArrayList identifier
      *     
      * Primitives (e.g., int, double, boolean) are not classes and cannot be 
      *      specified as the type of the element in a generic. Instead, we can 
      *      use the corresponding Wrapper Classes (e.g., Integer, Double, Boolean)
      *     
      */   
     
     sumList(createRandomIntegerList(10,2));
    }
    
    /**
     * Creates and returns a reference to an ArrayList of the specified number of
     *      Integer elements where each element is assigned a random value between
     *      1 and range.
     *      
     *  @param size     the number of Integer elements to add to the list
     *  @param range    the range of random values to assign to each element [1, range]
     *  
     *  @return a reference to the newly created and initialized list
     */
    public static ArrayList<Integer> createRandomIntegerList(int size, int range)
    {
        Random r = new Random();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int x = 0; x<size;x++){
            /*
             * The add method adds the specified object to the end of the list
             * 
             * Autoboxing:
             *  Primitive values are automatically converted to their corresponding 
             *          Wrapper class. However, type promotion does not occur.
             */
            list.add(r.nextInt(range)+1);
        }
        System.out.println(list);
        return list;
    }
         
    
    /**
     * Removes even numbers from the specified list.
     * 
     * @param list  the list of number of potentially remove
     */
    public static void removeEvens(ArrayList<Integer> list)
    {
        /*
         * The size method returns the number of elements in the list
         */
        int size = list.size();
        
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)%2==0){
                /*
                 * The remove method deletes the element at the specified index
                 */
                list.remove(i);
                i--;
            }
        }
    }
    
    public static void removeEvensAlt(ArrayList<Integer> list)
    {
        int size = list.size();
        for(int i = size-1; i>=0; i--){
            if(list.get(i)%2==0){
                /*
                 * The remove method deletes the element at the specified index
                 */
                list.remove(i);
            }
        }
        System.out.println(list);
    }
    
    public static int sumList(ArrayList<Integer> list)
    {
        int sum = 0;
        /*
         * arrayLists work with enhanced for loops too. 
         * 
         * Java will automatically unbox wrapper class objects to fit with the primitive types.
         * Do not add or remove anything with an enhanced for loop. ConcurrentModificationException
         * 
         * 
         * for(int x = 0; x<list.size(); x++){
             sum+=list.get(x);
            }
            
            
            
         */ 
        
        
        for(int x : list){
            sum+=x;
        }
         
         
         
        System.out.println(sum);
        return sum;
        
        
        
    }
}