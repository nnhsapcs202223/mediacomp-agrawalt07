import java.util.ArrayList;

public class ArrayListRunner
{
   public static void main(String[] args)
   {
       ArrayList<String> names = new ArrayList<String>();
       System.out.println(names);
       String[] input = new String[] {"Alice", "Bob", "Connie", "David", "Edward", "Fran", "Gomez", "Harry"};
       for(String name : input ) {names.add(name);}
       System.out.println("First: " + names.get(0) + "\t\tLast: " + names.get(names.size()-1));
       System.out.println("Size: " + names.size());
       names.set(names.indexOf("Alice"), "Alice B. Toklas");    System.out.println(names);
       names.add(names.indexOf("David")+1,"Doug");
       System.out.println(names);
       for(String name: names){
           System.out.println(name);
       }
       ArrayList<String> names2 = new ArrayList<String>(names);
       names.remove(0);
   }
} 