import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.util.*;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Scanner;

// Have to have main
class Circle
{
	private float radius;

	Circle (){}

	Circle ( int radius )
	{
		this.radius = radius;
	}
}

// java package = organisation for classes and interfaces
// Java has class nesting
// extends a class with: public class Child extends Parent {}
// has applet

// JAVA DEVELOPMENT KIT = JDK
// JAVA RUNTIME ENVIRONMENT = JRE
// JAVA VIRTUAL MACHINE = JVM

class File
{
	private static FileInputStream fi = null;
	private static FileOutputStream fo = null;
	private static String filename = "";
	private static String text = "";

	File ( String filename )
	{
		this.filename = filename;
	}

	public static void get ()
	{
	       try
	       {
		fi = new FileInputStream( filename );
		text = "";

		int fi_char;
         while ((fi_char = fi.read()) != -1) {
		text = text + fi_char;
		fo.close();
         }
	       }
	catch (IOException ex) {
            // do something or re-throw...
        }
	}

	public static void set ()
	{
	    try
	    {
    		fo = new FileOutputStream( filename );
    		fo.write( text.getBytes() );
    		fo.close();
	    }
	catch (IOException ex) {
            // do something or re-throw...
        }
	}

	
}


// Have to have Main
// Public classes have to have theor own code file
public class Main
{
	String a = "a " + "b"; // Strings are Oop named

	int arr1[]; // not preffered
	int[] arr2; // preferred
	// initialisations also with new

	ArrayList<Integer> arrli = new ArrayList<Integer>( 10 ); 
	// ArrayList<Integer> arrli = new ArrayList<Integer>( { 1, 2, 3, 4, 5 } ); // Also construct with collection object 
	// arrli.add( 5 ); // adds 5 to list of integers
	// arrli.add( 2, 5 ); // adds 5 to list of integers at index 2
	// arrli.remove( 2 ); // removes at index 2 / remove all with value 2 ( not problematic i it was not arraylist of integers )
	// Even so, Arraylists cannot be used with primitive types! ( since it is a list in memory )
	// arrli.get( 2 ); // returns item at index to
	// arrli.set( 2, 7 ); // sets item at index 2 to 7
	// Also: addAll( Collection a ), clear(), clone(), contains(), forEach(), indexOf(), isEmpty(), lastIndexOf(), removeAll( Collection a ), retainAll( Collection a ), size(), toArray()

	int[] parr = { 1, 2, 3, 4, 5 }; // primitive array
	// Array.asList( parr ) // Instead of toString(), since not object
	// Array.binarySearch( parr ); // Get item by value
	// Array.compare( parr, parr ); // Compare 2 arrays, item by item ( has to have same value and be in the same place )
	// int[] copy = Array.copyOf( parr, 2 ) // Copies and trumchates to length of 2
	// int[] copy = Array.copyOfRange( parr, 1, 4 ) // Copies and trumchates to indexes
	// Array.deepEquals( parr, parr ); // have to be identical in values and value indexes ( for [][], deep since { {} }   )
	// Array.equals( parr, parr ); // have to be identical in values and value indexes
	// Array.fill( parr, 10 ); // maks every item 10
	// Array.mispatch( parr, parr ); // returns index of 1st difference in arrays
	// Array.parallelSort( parr ); // sort array
	// Array.setAll( parr, 10 ); // set all to 10 
	// Array.sort( parr ); // sorts array
	// Array.spliterator( parr, 1, 4 ) // splits array by iterators

	HashMap<String, Integer> mp = new HashMap<>(15); // maps strings to integers
	// mp.put( "string", 5 ); // add / modify string mapped with 5
	// mp.remove( 5 ); // remove what is mapped to 5
	// 'Iterate'
	// for (Map.Entry<String, Integer> e : mp.entrySet()) 
        //    System.out.println("Key: " + e.getKey() + " Value: " + e.getValue()); 
	// Also: isEmpty(), putAll(), size(), values(), equals(), forEach(), putIfAbsent(), replace(), replaceAll(), getOrDefault()

	HashSet<String> h = new HashSet<String>();
	// h.add( "string" ) // add / change item
	// h.remove( 2 ); // remove by index
        // Iterating though the HashSet 
	// Iterator itr = h.iterator();
	//  while (itr.hasNext()) 
        //     System.out.print(itr.next() + ", "); 
        // System.out.println(); 
        // Same using enhanced for loop 
        // for (String s : hs) 
        //    System.out.print(s + ", "); 
	// Also: clear(), contains(), isEmpty(), size(), clone(), equals(), removeAll(), addAll(), containsAll(), retainAll(), toArray(), removeIf(), forEach(), 

	// Functions have to be static
	public static int sum ( int a, int b )
	{
		return a + b;
	}

	// Have to have Main
	public static void main(String[] args) 
	{
		String compare = "string";
		if ( compare.equals( "string" ) )
		{
			// Do not compare Strings with =! That compares as objects
			// Use .equals()
		}

		System.out.print( "java " );
		System.out.println( "main " );
		System.out.println( sum( 1, 4 ) );
	}
}
