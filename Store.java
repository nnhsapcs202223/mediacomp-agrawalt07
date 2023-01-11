import java.util.ArrayList;

/**
 * Write a description of class Customers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store
{
    // instance variables - replace the example below with your own
    private ArrayList<Double> sales;
    private ArrayList<String> names;

    /**
     * Constructor for objects of class Customers
     */
    public Store()
    {
        // initialise instance variables
        sales = new ArrayList<Double>();
        names = new ArrayList<String>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addSale(String customerName, double amount)
    {
        this.sales.add(amount);
        this.names.add(customerName);
    }
    
    public String bestCustomer(){
        int prices = 0;
        for(int x = 0; )
    }
}
