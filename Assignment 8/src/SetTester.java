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
*  On my honor, Jesse Campos , Zachary Tschirhart.
*  this programming assignment is my own work.
*
*  Student #1: 
*  Name #1: Jesse Campos
*  EID #1: jpc639
*  email address #1: jesse.campos@mail.utexas.edu
*  TA name #1: Xiuming
*  Unique course ID #1: 54022
*  programming hours #1: 20
*  
*  *  Student #2: 
*  Name #2: Zachary Tschirhart
*  EID #2: zst75
*  email address #2: ztschir@gmail.com
*  TA name #2: Xiuming
*  Unique course ID #2:54022
*  programming hours #2: 20
*/

//slip days info
/*
Slip days used on this assignment: 0
Slip days I think I have used for the term thus far: 1
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
		
		
		//Additional UnsortedSet tests
		UnsortedSet u1, u2, u3;
		u2 = new UnsortedSet();
		u2.add("D");
		u2.add("F");
		u2.add("G");
		u2.add("H");
		u2.add("C");
		u2.add("Z");
		u1 = new UnsortedSet();
		u1.add("C");
		u1.add("Z");
		u1.add("B");
		u1.add("A");
		good = u1.addAll(u2);
		u3 = new UnsortedSet();
		u3.add("Z");
		u3.add("B");
		u3.add("H");
		u3.add("A");
		u3.add("C");
		u3.add("D");
		u3.add("G");
		u3.add("F");
		if( u1.equals(u3) && good)
			System.out.println("Passed unsorted test constructor, add, addAll, and equals");
		else
			System.out.println("Failed unsorted test constructor, add, addAll, and equals");

		u1.remove("D");
		u1.remove("F");
		u1.remove("G");
		u1.remove("H");
		ISet u4 = u2.union(u1);
		if( u4.equals(u3))
			System.out.println("Passed unsorted test add, remove, union, and equals");
		else
			System.out.println("Failed unsorted test add, remove, union, and equals");

		u4 = u2.difference(u1);
		u3.remove("C");
		u3.remove("Z");
		u3.remove("A");
		u3.remove("B");
		if( u4.equals(u3))
			System.out.println("Passed unsorted test remove, difference, and equals");
		else
			System.out.println("Failed unsorted test remove, difference, and equals");

		u4 = u1.difference(u2);
		u3.remove("D");
		u3.remove("F");
		u3.remove("G");
		u3.remove("H");
		u3.add("A");
		u3.add("B");
		if( u4.equals(u3))
			System.out.println("Passed unsorted test add, remove, difference, and equals");
		else
			System.out.println("Failed unsorted test add, remove, difference, and equals");

		u4 = u1.intersection(u2);
		u3.remove("A");
		u3.remove("B");
		u3.add("C");
		u3.add("Z");
		if( u4.equals(u3))
			System.out.println("Passed unsorted test add, remove, intersection, and equals");
		else
			System.out.println("Failed unsorted test add, remove, intersection, and equals");

		u4 = u2.intersection(u1);
		u3.remove("A");
		u3.remove("B");
		u3.add("C");
		u3.add("Z");
		
		if( !u4.containsAll(u3) && !u3.containsAll(u4))
			System.out.println("Passed unsorted test add, remove, intersection, and containsAll");
		else
			System.out.println("Failed unsorted test add, remove, intersection, and containsAll");

		u2 = new UnsortedSet();
		u2.add("D");
		u2.add("Z");
		u1 = new UnsortedSet();
		u1.add("C");
		u1.add("Z");
		good = u1.addAll(u2);

		u3 = new UnsortedSet();
		u3.add("Z");
		u3.add("C");
		u3.add("D");
		if( u1.equals(u3) && good)
			System.out.println("Passed unsorted test constructor, add, addAll, and equals");
		else
			System.out.println("Failed unsorted test constructor, add, addAll, and equals");

		u1.remove("D");
		u4 = u2.union(u1);
		if( !u4.containsAll(u3) )
			System.out.println("Passed unsorted test remove, union, and containsAll");
		else
			System.out.println("Failed unsorted test remove, union, and containsAll");

		
		it1 = u1.iterator();
		it2 = u2.iterator();
		if (!it1.next().equals(it2.next()))
			System.out.println("Passed unsorted test iterator");
		else
			System.out.println("Failed unsorted test iterator");

		it1 = u3.union(u4).iterator();
		it2 = u4.union(u3).iterator();
		int count = 0;
		while (it1.hasNext() && it2.hasNext()){
			count++;
			it1.next();
			it2.next();
		}
		if (count == 3 && !it1.hasNext() && !it2.hasNext())
			System.out.println("Passed unsorted test iterator");
		else
			System.out.println("Failed unsorted test iterator");



		u1.clear();
		u2.clear();
		if( u1.size() == 0 && u2.size() == 0)
			System.out.println("Passed unsorted test clear and size");
		else
			System.out.println("Failed unsorted test clear and size");

		u3.clear();
		u4.clear();
		if( u3.size() == 0 && u4.size() == 0)
			System.out.println("Passed unsorted test clear and size");
		else
			System.out.println("Failed unsorted test clear and size");

		u1 = new UnsortedSet();
		u2 = new UnsortedSet();
		u3 = new UnsortedSet();
		u4 = new UnsortedSet();
		
		u1.add("A");
		u1.add("Z");
		u1.add("C");
		u1.add("X");
		u1.add("E");
		u1.add("V");
		u1.add("F");
		u2.add("Z");
		u2.add("A");
		u2.add("X");
		u2.add("C");
		u2.add("V");
		u2.add("E");
		u2.add("F");
		u3.add(new Integer(1));
		u3.add(new Integer(2));
		u3.add(new Integer(3));
		u3.add(new Integer(4));
		u3.add(new Integer(5));
		u4.add(new Integer(5));
		u4.add(new Integer(1));
		u4.add(new Integer(3));
		u4.add(new Integer(2));
		u4.add(new Integer(4));


		//End Additional UnsortedSet tests */


		s1.clear();
		s2.clear();
		s3.clear();
		
		//Additional SortedSet tests
		s1 = new SortedSet(u1);		
		s2 = new SortedSet(u2);		
		s3 = new SortedSet(u3);
		ISet s4 = new SortedSet((UnsortedSet)u4);
		
		
		if (((SortedSet)s1).equals((SortedSet)s2))
			System.out.println("Passed sorted test constructor");
		else
			System.out.println("Failed sorted test constructor");
		
		if (((SortedSet)s3).equals((SortedSet)s4) && !s1.addAll(s3))
			System.out.println("Passed sorted test constructor");
		else
			System.out.println("Failed sorted test constructor");


		s2 = new SortedSet();
		s2.add("D");
		s2.add("F");
		s2.add("G");
		s2.add("H");
		s2.add("C");
		s2.add("Z");
		s1 = new SortedSet();
		s1.add("C");
		s1.add("Z");
		s1.add("B");
		s1.add("A");
		boolean changed = s1.addAll(s2);

		s3 = new SortedSet();
		s3.add("Z");
		s3.add("B");
		s3.add("H");
		s3.add("A");
		s3.add("C");
		s3.add("D");
		s3.add("G");
		s3.add("F");
		if( s1.equals(s3) && changed)
			System.out.println("Passed sorted test def-constructor, add, addAll, and equals");
		else
			System.out.println("Failed sorted test def-constructor, add, addAll, and equals");

		s1.remove("D");
		s1.remove("F");
		s1.remove("G");
		s1.remove("H");
		s4 = s2.union(s1);
		if( s4.equals(s3))
			System.out.println("Passed sorted test add, remove, union, and equals");
		else
			System.out.println("Failed sorted test add, remove, union, and equals");

		s4 = s2.difference(s1);
		s3.remove("C");
		s3.remove("Z");
		s3.remove("A");
		s3.remove("B");
		if( s4.equals(s3))
			System.out.println("Passed sorted test remove, difference, and equals");
		else
			System.out.println("Failed sorted test remove, difference, and equals");

		s4 = s1.difference(s2);
		s3.remove("D");
		s3.remove("F");
		s3.remove("G");
		s3.remove("H");
		s3.add("A");
		s3.add("B");
		if( s4.equals(s3))
			System.out.println("Passed sorted test add, remove, difference, and equals");
		else
			System.out.println("Failed sorted test add, remove, difference, and equals");

		s4 = s1.intersection(s2);
		s3.remove("A");
		s3.remove("B");
		s3.add("C");
		s3.add("Z");
		if( s4.equals(s3))
			System.out.println("Passed sorted test add, remove, intersection, and equals");
		else
			System.out.println("Failed sorted test add, remove, intersection, and equals");

		s4 = s2.intersection(s1);
		s3.remove("A");
		s3.remove("B");
		s3.add("C");
		s3.add("Z");
		
		
		if(! s4.containsAll(s3) && !s3.containsAll(s4))
			System.out.println("Passed sorted test add, remove, intersection, and containsAll");
		else
			System.out.println("Failed sorted test add, remove, intersection, and containsAll");

		s2 = new SortedSet();
		s2.add("D");
		s2.add("Z");
		s1 = new SortedSet();
		s1.add("C");
		s1.add("Z");
		changed = s1.addAll(s2);

		s3 = new SortedSet();
		s3.add("Z");
		s3.add("C");
		s3.add("D");
		if( s1.equals(s3) && changed)
			System.out.println("Passed sorted test def-constructor, add, addAll, and equals");
		else
			System.out.println("Failed sorted test def-constructor, add, addAll, and equals");

		s1.remove("D");
		s4 = s2.union(s1);
		
		if( !s4.containsAll(s3) && s3.containsAll(s4))
			System.out.println("Passed sorted test remove, union, and containsAll");
		else
			System.out.println("Failed sorted test remove, union, and containsAll");

		if( !s1.contains("C") )
			System.out.println("Passed sorted test contains and addAll");
		else
			System.out.println("Failed sorted test contains and addAll");

		if( !s2.contains("C"))
			System.out.println("Passed sorted test contains and addAll");
		else
			System.out.println("Failed sorted test contains and addAll");

		it1 = s1.iterator();
		it2 = s2.iterator();
		if (it1.next().equals(it2.next()))
			System.out.println("Passed sorted test iterator");
		else
			System.out.println("Failed sorted test iterator");

		it1 = s3.union(s4).iterator();
		it2 = s4.union(s3).iterator();
		boolean flag = true;
		while (it1.hasNext() && it2.hasNext() && flag)
			flag = it1.next().equals(it2.next());
		if (flag && !it1.hasNext() && !it2.hasNext())
			System.out.println("Passed sorted test iterator");
		else
			System.out.println("Failed sorted test iterator");



		s1.clear();
		s2.clear();
		if( s1.size() == 0 && s2.size() == 0)
			System.out.println("Passed sorted test clear and size");
		else
			System.out.println("Failed sorted test clear and size");

		s3.clear();
		s4.clear();
		if( s3.size() == 0 && s4.size() == 0)
			System.out.println("Passed sorted test clear and size");
		else
			System.out.println("Failed sorted test clear and size");

		//End Additional Sorted tests */

		
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