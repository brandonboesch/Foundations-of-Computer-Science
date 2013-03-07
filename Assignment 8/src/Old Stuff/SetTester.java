import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/*  Student information for assignment
*
*  On my honor, <NAME1> ,
*  this programming assignment is my own work.
*
*  Student #1:
*  Name #1:
*  EID #1:
*  email address #1:
*  TA name #1:
*  Unique course ID #1:
*  programming hours #1:
*/

//slip days info
/*
Slip days used on this assignment:
Slip days I think I have used for the term thus far
*/

/**
 * @author scottm
 *
 */
public class SetTester {
	
	public static void main(String[] args){

		ISet s1 = new UnsortedSet();
		s1.add("A");
		s1.add("C");
		s1.add("A");
		s1.add("B");

		//test 1
		if( s1.contains("A") )
			System.out.println("Passed test 1: add and contains methods SortedSet");
		else
			System.out.println("Failed test 1: add and contains methods SortedSet");

		//test 2
		s1.remove("A");
		if( !s1.contains("A") )
			System.out.println("Passed test 2: remove method UnsortedSet");
		else
			System.out.println("Failed test 2: remove method UnsortedSet");

		//test 3
		if( s1.size() == 2 )
			System.out.println("Passed test 3: size method UnsortedSet");
		else
			System.out.println("Failed test 3: size method UnsortedSet");

		ISet s2 = new UnsortedSet();
		s2.add("C");
		s2.add("A");
		s2.add("B");

		//test 4
		if( s2.containsAll(s1) )
			System.out.println("Passed test 4: containsAll method UnsortedSet");
		else
			System.out.println("Failed test 4: containsAll method UnsortedSet");

		//test 5
		if( !s1.containsAll(s2) )
			System.out.println("Passed test 5: containsAll method UnsortedSet");
		else
			System.out.println("Failed test 5: containsAll method UnsortedSet");

		//test 6
		ISet s3 = s2.difference(s1);
		ISet expected = new UnsortedSet();
		expected.add("A");
				
		if( s3.equals(expected))
			System.out.println("Passed test 6: difference and equals methods UnsortedSet");
		else
			System.out.println("Failed test 6: difference and equals methods UnsortedSet");

		//test 7
		s3 = s2.union(s1);
		expected.add("B");
		expected.add("C");
		if( s3.equals(expected))
			System.out.println("Passed test 7: union and equals methods UnsortedSet");
		else
			System.out.println("Failed test 7: union and equals methods UnsortedSet");

		//test 8
		s3 = s2.intersection(s1);
		expected.remove("A");
		if( s3.equals(expected))
			System.out.println("Passed test 8: intersection and equals methods UnsortedSet");
		else
			System.out.println("Failed test 8: intersection and equals methods UnsortedSet");

		//sorted sets
		
		s1 = new SortedSet();
		s1.add("A");
		s1.add("C");
		s1.add("A");
		s1.add("B");
		
		//test 9
		if( s1.contains("A") )
			System.out.println("Passed test 9: add and contains methods SortedSet");
		else
			System.out.println("Failed test 9: add and contains methods SortedSet");

		//test 10
		s1.remove("A");
		if( !s1.contains("A") )
			System.out.println("Passed test 10: remove and contains methods SortedSet");
		else
			System.out.println("Failed test 10: remove and contains methods SortedSet");

		//test 11
		if( s1.size() == 2 )
			System.out.println("Passed test 11: size method SortedSet");
		else
			System.out.println("Failed test 11: size method SortedSet");

		s2 = new SortedSet();
		s2.add("C");
		s2.add("A");
		s2.add("B");

		//test 12
		if( s2.containsAll(s1) )
			System.out.println("Passed test 12: containsAll method SortedSet");
		else
			System.out.println("Failed test 12: containsAll method SortedSet");

		//test 13
		if( !s1.containsAll(s2) )
			System.out.println("Passed test 13: containsAll method SortedSet");
		else
			System.out.println("Failed test 13: containsAll method SortedSet");

		//test 14
		s3 = s2.difference(s1);
		expected = new SortedSet();
		expected.add("A");
		if( s3.equals(expected))
			System.out.println("Passed test 14: difference and equals methods SortedSet");
		else
			System.out.println("Failed test 14: difference and equals methods SortedSet");
		
	      //test 14.1
        s3 = s1.difference(s2);
        expected = new SortedSet();
        if( s3.equals(expected))
            System.out.println("Passed test 14.1: difference and equals methods SortedSet");
        else
            System.out.println("Failed test 14.1: difference and equals methods SortedSet");

		//test 15
		s3 = s1.union(s2);
		expected.add("B");
		expected.add("C");
		expected.add("B");
		if( s3.equals(expected))
			System.out.println("Passed test 15: union and equals methods SortedSet");
		else
			System.out.println("Failed test 15: union and equals methods SortedSet");

		//test 16
		s3 = s1.intersection(s2);
		expected.remove("A");
		if( s3.equals(expected))
			System.out.println("Passed test 16: intersection and equals methods SortedSet");
		else
			System.out.println("Failed test 16: intersection and equals methods SortedSet");
		
		// test 17
        s1.add("A");
        Iterator it1 = s1.iterator();
        Iterator it2 = s2.iterator();
        boolean good = true;
        while( good && it1.hasNext() )
            good = it1.next().equals(it2.next());
        if( good )
            System.out.println("Passed test 17: iterator and add methods SortedSet");
        else
            System.out.println("Failed test 17: iterator and add methods SortedSet");

		Scanner sc = new Scanner(System.in);
		String response = "";
		do{
			largeTest();
			System.out.print("Another file? Enter y to do another file: ");
			response = sc.next();
		}
		while( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") );
	}

	public static void largeTest(){
		String text = convertFileToString();
		processTextCS307Sets(new SortedSet(), text);
		processTextCS307Sets(new UnsortedSet(), text);
		processTextJavaSets( new HashSet<String>(), text);
		processTextJavaSets( new TreeSet<String>(), text);
	}
	
	public static void processTextCS307Sets(ISet set, String text){
		Stopwatch s = new Stopwatch();
		Scanner sc = new Scanner(text);
		s.start();
		while( sc.hasNext() ){
			set.add(sc.next());
		}
		s.stop();
		sc.close();
		
		System.out.println("Time to add the elements in the text to this set: " + s.toString() );
		System.out.println("Number of distinct words in this text " + set.size() );
		System.out.print("Enter y to see the contents of this set: ");
		sc = new Scanner(System.in);
		String response = sc.next();

		if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
			for(Object o : set)
				System.out.println(o);
		}
	}
	
	public static void processTextJavaSets(Set<String> set, String text){
		Stopwatch s = new Stopwatch();
		Scanner sc = new Scanner(text);
		s.start();
		while( sc.hasNext() ){
			set.add(sc.next());
		}
		s.stop();
		sc.close();
		
		System.out.println("Time to add the elements in the text to this set: " + s.toString() );
		System.out.println("Number of distinct words in this text " + set.size() );
		System.out.print("Enter y to see the contents of this set: ");
		sc = new Scanner(System.in);
		String response = sc.next();

		if( response != null && response.length() > 0 && response.substring(0,1).equalsIgnoreCase("y") ){
			for(Object o : set)
				System.out.println(o);
		}
	}
	
	public static String convertFileToString()
	{	//create a GUI window to pick the text to evaluate
		JFileChooser chooser = new JFileChooser(".");
	    StringBuffer text = new StringBuffer();
	    int retval = chooser.showOpenDialog(null);

	    chooser.grabFocus();

	    //read in the file
		if (retval == JFileChooser.APPROVE_OPTION)
		{   File source = chooser.getSelectedFile();
			try
			{   Scanner s = new Scanner( new FileReader( source ) );

				while( s.hasNextLine() )
				{   text.append( s.nextLine() );
					text.append(" ");
				}

				s.close();
			}
			catch(IOException e)
			{   System.out.println("An error occured while trying to read from the file: " + e);
			}
		}

		return text.toString();
	}
}