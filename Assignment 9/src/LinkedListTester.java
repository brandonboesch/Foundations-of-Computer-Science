/*  Student information for assignment
*
*  Name: Zachary Tschirhart	
*  EID: zst75
*  email address: ztschir@gmail.com	
*  TA name: Xiuming 
*  On honor Zachary this assignment is my 
*  own work.
*/

//slip days info
/*
Slip days used on this assignment: 0
Slip days I think I have used for the term thus far: 1
*/

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester
{
	public static void main(String[] args)
	{       
    	LinkedList<String> l = new LinkedList<String>();
    	Object[] actual;
    	Object[] expected;
    	
    	//test 0
    	System.out.println("\nTest 0: initial list is empty");
    	if( l.toString().equals("[]") )
    	    System.out.println("Passed test 0");
    	else
    	    System.out.println("Failed test 0");
    	
        //test 0.1
        System.out.println("\nTest 0.1: add to end");
        l.add("A");
        if( l.get(0).equals("A") )
            System.out.println("Passed test 0.1");
        else
            System.out.println("Failed test 0.1");  
        
        //test 0.2
        System.out.println("\nTest 0.2: size");
        if( l.size() == 1 )
            System.out.println("Passed test 0.2");
        else
            System.out.println("Failed test 0.2"); 
        
        //test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        l.remove(0);
        if( l.toString().equals("[]") )
            System.out.println("Passed test 0.3");
        else
            System.out.println("Failed test 0.3");  

        //test 0.4
        System.out.println("\nTest 0.4: size");
        if( l.size() == 0 )
            System.out.println("Passed test 0.4");
        else
            System.out.println("Failed test 0.4"); 
        
        //test 0.5
        System.out.println("\nTest 0.5: add and toString");
        l.add("A");
        l.add("B");
        if( l.toString().equals("[A, B]") )
            System.out.println("Passed test 0.5");
        else
            System.out.println("Failed test 0.5");  
        
        //test 0.6
        System.out.println("\nTest 0.6: size");
        if( l.size() == 2 )
            System.out.println("Passed test 0.6");
        else
            System.out.println("Failed test 0.6");
       

        //test 1
		System.out.println("\nTest 1: Adding at end");
		l.add("A");
		actual = toArray(l);
		expected = new Object[]{"A", "B", "A"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );		
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 1");
		else
			System.out.println("Failed test 1");
		

		//test 2
		System.out.println("\nTest 2: making empty");
		l.makeEmpty();
		actual = toArray(l);
		expected = new Object[] {};
	    System.out.println( "Expected result: " + Arrays.toString(expected) );
	    System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 2");
		else
			System.out.println("Failed test 2");
		

		//test 3
		System.out.println("\nTest 3: Adding at pos 0 in empty list");
		l.add(0, "A");
		actual = toArray(l);
		expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  		
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 3");
		else
			System.out.println("Failed test 3");
		


		//test 4
		System.out.println("\nTest 4: Adding at front");
		l = new LinkedList<String>();
		l.addFirst("A");
		actual = toArray(l);
		expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 4");
		else
			System.out.println("Failed test 4");
		


		//test 5
		System.out.println("\nTest 5: Removing from front");
		l.removeFirst();
		actual = toArray(l);
		expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 5");
		else
		    System.out.println("Failed test 5");
		

		//test 6
		l = new LinkedList<String>();
 		System.out.println("\nTest 6: Adding at end");
		l.addLast("A");
		actual = toArray(l);
		expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
		    System.out.println("Passed test 6");
		else
		    System.out.println("Failed test 6");


		//test 7
 		System.out.println("\nTest 7: Removing from back");
		l.removeLast();
		actual = toArray(l);
		expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 7");
		else
			System.out.println("Failed test 7");

		//test 8
		System.out.println("\nTest 8: Adding at middle");
		l = new LinkedList<String>();
		l.add("A");
		l.add("C");
		l.add(1, "B");
		actual = toArray(l);
		expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 8");
		else
			System.out.println("Failed test 8");


		//test 9
		System.out.println("\nTest 9: Setting");
		l = new LinkedList<String>();
		l.add("A");
		l.add("D");
		l.add("C");
		l.set(1, "B");
		actual = toArray(l);
		expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 9");
		else
			System.out.println("Failed test 9");


		//test 10
        System.out.println("\nTest 10: Removing");
		l = new LinkedList<String>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.remove(0);
		l.remove( l.size() - 1 );
		actual = toArray(l);
		expected = new Object[] {"B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 10");
		else
			System.out.println("Failed test 10");
	
		
		studentTests();
		// uncomment the following line to run tests comparing
		// your LinkedList class to the java ArrayList class.
		//comparison();
    }

    private static Object[] toArray(LinkedList<String> list)
    {	Object[] result = new Object[list.size()];
    	Iterator<String> it = list.iterator();
    	int index = 0;
    	while( it.hasNext() ){
    		result[index] = it.next();
    		index++;
		}
		return result;
	}

	//pre: none
	private static boolean arraysSame(Object[] one, Object[] two)
	{	boolean same;
		
		if( one == null || two == null )
		{	same = (one == two);
		}
		else
		{	//neither one or two are null
			assert one != null && two != null;
			same = one.length == two.length;
			if( same )
			{	int index = 0;
				while( index < one.length && same )
				{	same = ( one[index] == two[index] );
					index++;
				}
			}
		}
		return same;
	}

	// A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    public static void comparison(){
        Stopwatch s = new Stopwatch();
        int initialN = 50000;
        int numTests = 5;
        

        addEndArrayList(s, initialN, numTests);
        addEndLinkedList(s, initialN, numTests);

        initialN = 10000;
        addFrontArrayList(s, initialN, numTests);
        addFrontLinkedList(s, initialN, numTests);
        
        removeFrontArrayList(s, initialN, numTests);
        removeFrontLinkedList(s, initialN, numTests);

        getRandomArrayList(s, initialN, numTests);
        getRandomLinkedList(s, initialN, numTests);
        
    }
    
    public static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at end: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
            
            //empty out the list and run garbage collector
            javaList.clear();
            javaList.trimToSize();
            System.gc();
        }
    }
    
    public static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at end: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
            
            // empty out the list and run garbage collector
            studentList.makeEmpty();
            System.gc();
        }
    }
    
    public static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
            
            //empty out the list and run garbage collector
            javaList.clear();
            javaList.trimToSize();
            System.gc();
        }
    }
    
    public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.add(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
            
            // empty out the list and run garbage collector
            studentList.makeEmpty();
            System.gc();
        }
    }
    
    public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Removing from front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of an ArrayList. ");
            
            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            while( !javaList.isEmpty())
                javaList.remove(0);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
            
            //empty out the list and run garbage collector
            javaList.clear();
            javaList.trimToSize();
            System.gc();
        }
    }
    
    public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("removing from front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            while( studentList.size() != 0 )
                studentList.removeFirst();
            s.stop();
            System.out.println("Time to remove: " + s);
            n *= 2;
            
            // empty out the list and run garbage collector
            studentList.makeEmpty();
            System.gc();
        }
    }
    
    public static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting random: ArrayList");
        int n = initialN;
        int limit;
        int total = 0;
        Random r = new Random();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + (n * 3) + " elements from random locations in an ArrayList. ");
            
            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            limit = n * 3;
            for(int j = 0; j < limit; j++){
                total++;
                javaList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
            
            //empty out the list and run garbage collector
            javaList.clear();
            javaList.trimToSize();
            System.gc();
        }
    }
    
    public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting random: LinkedList");
        int n = initialN;
        int limit;
        int total = 0;
        Random r = new Random();
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + (n * 3) + " elements from random locations in a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j, 0);
            s.start();
            limit = n * 3;
            for(int j = 0; j < limit; j++){
                total++;
                studentList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
            
            // empty out the list and run garbage collector
            studentList.makeEmpty();
            System.gc();
        }
    }
    
    public static void getAllArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all: ArrayList");
        int n = initialN;
        int total = 0;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all" + n + " elements from an ArrayList. ");
            
            for(int j = 0; j < n; j++)
                javaList.add(j);
            
            Iterator<Integer> it = javaList.iterator();
            s.start();
            while( it.hasNext() ){
                total++;
                it.next();
            }
            s.start();
            
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
            
            //empty out the list and run garbage collector
            javaList.clear();
            javaList.trimToSize();
            System.gc();
        }
    }
    
    public static void getAllLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all: LinkedList");
        int n = initialN;
        int total = 0;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all" + n + " elements from front of an LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j, 0);
            Iterator<Integer> it = studentList.iterator();
            
            s.start();
            while(it.hasNext()){
                total++;
                it.next();
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
            
            // empty out the list and run garbage collector
            studentList.makeEmpty();
            System.gc();
        }
    }
////////////////////******FYI******///////////////////////////////////////////////////////////////////////////////////////////
//    Adding at end: ArrayList
//    Adding 50000 elements to end of an ArrayList. Time to add: elapsed time: 0.050932778 seconds.
//    Adding 100000 elements to end of an ArrayList. Time to add: elapsed time: 0.014319386 seconds.
//    Adding 200000 elements to end of an ArrayList. Time to add: elapsed time: 0.028614532 seconds.
//    Adding 400000 elements to end of an ArrayList. Time to add: elapsed time: 0.075316751 seconds.
//    Adding 800000 elements to end of an ArrayList. Time to add: elapsed time: 0.142225607 seconds.
//    Adding at end: LinkedList
//    Adding 50000 elements to end of a LinkedList. Time to add: elapsed time: 0.013720258 seconds.
//    Adding 100000 elements to end of a LinkedList. Time to add: elapsed time: 0.002524734 seconds.
//    Adding 200000 elements to end of a LinkedList. Time to add: elapsed time: 0.015859905 seconds.
//    Adding 400000 elements to end of a LinkedList. Time to add: elapsed time: 0.00931617 seconds.
//    Adding 800000 elements to end of a LinkedList. Time to add: elapsed time: 0.038615142 seconds.
//    Adding at front: ArrayList
//    Adding 10000 elements to front of an ArrayList. Time to add: elapsed time: 0.053424597 seconds.
//    Adding 20000 elements to front of an ArrayList. Time to add: elapsed time: 0.211769369 seconds.
//    Adding 40000 elements to front of an ArrayList. Time to add: elapsed time: 0.888285746 seconds.
//    Adding 80000 elements to front of an ArrayList. Time to add: elapsed time: 3.668675063 seconds.
//    Adding 160000 elements to front of an ArrayList. Time to add: elapsed time: 15.696442581 seconds.
//    Adding at front: LinkedList
//    Adding 10000 elements to front of a LinkedList. Time to add: elapsed time: 0.009838772 seconds.
//    Adding 20000 elements to front of a LinkedList. Time to add: elapsed time: 0.004254674 seconds.
//    Adding 40000 elements to front of a LinkedList. Time to add: elapsed time: 0.010029483 seconds.
//    Adding 80000 elements to front of a LinkedList. Time to add: elapsed time: 0.003154478 seconds.
//    Adding 160000 elements to front of a LinkedList. Time to add: elapsed time: 0.013344151 seconds.
//    Removing from front: ArrayList
//    Removing 10000 elements from front of an ArrayList. Time to add: elapsed time: 0.048868469 seconds.
//    Removing 20000 elements from front of an ArrayList. Time to add: elapsed time: 0.238911033 seconds.
//    Removing 40000 elements from front of an ArrayList. Time to add: elapsed time: 0.813222904 seconds.
//    Removing 80000 elements from front of an ArrayList. Time to add: elapsed time: 3.472518905 seconds.
//    Removing 160000 elements from front of an ArrayList. Time to add: elapsed time: 15.329521304 seconds.
//    removing from front: LinkedList
//    Removing 10000 elements from front of a LinkedList. Time to remove: elapsed time: 0.00266398 seconds.
//    Removing 20000 elements from front of a LinkedList. Time to remove: elapsed time: 0.00395014 seconds.
//    Removing 40000 elements from front of a LinkedList. Time to remove: elapsed time: 0.001131589 seconds.
//    Removing 80000 elements from front of a LinkedList. Time to remove: elapsed time: 0.002068563 seconds.
//    Removing 160000 elements from front of a LinkedList. Time to remove: elapsed time: 0.004863795 seconds.
//    Getting random: ArrayList
//    Getting 30000 elements from random locations in an ArrayList. Time to get: elapsed time: 0.013136756 seconds.
//    Getting 60000 elements from random locations in an ArrayList. Time to get: elapsed time: 0.008206752 seconds.
//    Getting 120000 elements from random locations in an ArrayList. Time to get: elapsed time: 0.005638451 seconds.
//    Getting 240000 elements from random locations in an ArrayList. Time to get: elapsed time: 0.041669874 seconds.
//    Getting 480000 elements from random locations in an ArrayList. Time to get: elapsed time: 0.019589298 seconds.
//    Getting random: LinkedList
//    Getting 30000 elements from random locations in a LinkedList. Time to get: elapsed time: 0.234781233 seconds.
//    Getting 60000 elements from random locations in a LinkedList. Time to get: elapsed time: 1.137547061 seconds.
//    Getting 120000 elements from random locations in a LinkedList. Time to get: elapsed time: 6.482164807 seconds.
//    Getting 240000 elements from random locations in a LinkedList. Time to get: elapsed time: 42.469825141 seconds.
//    Getting 480000 elements from random locations in a LinkedList. Time to get: elapsed time: 244.674896039 seconds.    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
        private static void studentTests(){
    	        LinkedList<String> l = new LinkedList<String>();
    	        Object[] actual;
    	        Object[] expected;

    	        Iterator it = l.iterator();
    	//add     
    	        l.add("B");
    	        if (l.get(0).equals("B"))
    	            System.out.println("Passed add test 1");
    	        else
    	            System.out.println("Failed add test 1");
    	        l.makeEmpty();
    	        l.add("A");
    	        l.add("B");
    	        l.add("Z");
    	        if (l.get(2).equals("Z"))
    	            System.out.println("Passed add test 2");
    	        else
    	            System.out.println("Failed add test 2");
    	        if (l.get(1).equals("B"))
    	            System.out.println("Passed add test 3");
    	        else
    	            System.out.println("Failed add test 3");

    	//iterator
    	        if (!it.hasNext())
    	            System.out.println("Passed iterator test 1");
    	        else
    	            System.out.println("Failed iterator test 1");
    	       
    	        it = l.iterator();
    	        if (it.hasNext())
    	            if (it.next().equals("A"))
    	                System.out.println("Passed iterator test 2");
    	        if (it.hasNext())
    	            System.out.println("Passed iterator test 3");
    	        else
    	            System.out.println("Failed iterator test 3");
    	       
    	//toString()
    	        if( l.toString().equals("[A, B, Z]") )
    	            System.out.println("Passed toString test 1");
    	        else
    	            System.out.println("Failed toString test 1");
    	        l.add(",");
    	        l.add(">");
    	        if (l.toString().equals("[A, B, Z, ,, >]"))
    	            System.out.println("Passed toString test 2");
    	        else
    	            System.out.println("Failed toString test 2");
    	        l.add("3");
    	        if (l.toString().equals("[A, B, Z, ,, >, 3]"))
    	            System.out.println("Passed toString test 3");
    	        else
    	            System.out.println("Failed toString test 3");
    	       
    	//size       
    	        if( l.size() == 6 )
    	            System.out.println("Passed size test 1");
    	        else
    	            System.out.println("Failed size test 1");
    	        l.remove(3);
    	        if( l.size() == 5 )
    	            System.out.println("Passed size & remove test 2");
    	        else
    	            System.out.println("Failed size & remove test 2");
    	        l.removeLast();
    	        if( l.size() == 4 )
    	            System.out.println("Passed size & removelast test 3");
    	        else
    	            System.out.println("Failed size & removelast test 3");
    	//add(pos, item)
    	        l.makeEmpty();
    	        l.add("A");
    	        l.add("C");
    	        l.add("F");
    	        l.add(1, "B");
    	        l.add(3, "D");
    	        l.add(4, "E");
    	        if (l.toString().equals("[A, B, C, D, E, F]"))
    	            System.out.println("Passed add(pos, item) test 1");
    	        else
    	            System.out.println("Failed add(pos, item) test 1");
    	        l.add(0, "1");
    	        if (l.toString().equals("[1, A, B, C, D, E, F]"))
    	            System.out.println("Passed add(pos, item) test 2");
    	        else
    	            System.out.println("Failed add(pos, item) test 2");
    	        l.add(7, "T");
    	        if (l.toString().equals("[1, A, B, C, D, E, F, T]"))
    	            System.out.println("Passed add(pos, item) test 3");
    	        else
    	            System.out.println("Failed add(pos, item) test 3");
    	//set(pos, item) 
    	        l.set(0, "KK");
    	        if (l.toString().equals("[KK, A, B, C, D, E, F, T]"))
    	            System.out.println("Passed set(pos, item) test 1");
    	        else
    	            System.out.println("Failed set(pos, item) test 1");
    	        l.set(3, "AA");
    	        if (l.toString().equals("[KK, A, B, AA, D, E, F, T]"))
    	            System.out.println("Passed set(pos, item) test 2");
    	        else
    	            System.out.println("Failed set(pos, item) test 2");
    	        l.set(7, "G");
    	        l.set(7, "P");
    	        l.set(7, "G");
    	        if (l.toString().equals("[KK, A, B, AA, D, E, F, G]"))
    	            System.out.println("Passed set(pos, item) test 3");
    	        else
    	            System.out.println("Failed set(pos, item) test 3");
    	//get(pos)
    	        if (l.get(0).equals("KK"))
    	            System.out.println("Passed get(pos) test 1");
    	        else
    	            System.out.println("Failed get(pos) test 1");
    	        if (l.get(7).equals("G"))
    	            System.out.println("Passed get(pos) test 2");
    	        else
    	            System.out.println("Failed get(pos) test 2");
    	        if (l.get(3).equals("AA"))
    	            System.out.println("Passed get(pos) test 3");
    	        else
    	            System.out.println("Failed get(pos) test 3");
    	//remove(pos)
    	        l.remove(3);
    	        if (l.toString().equals("[KK, A, B, D, E, F, G]") && l.size() == 7)
    	            System.out.println("Passed remove(pos) test 1");
    	        else
    	            System.out.println("Failed remove(pos) test 1");
    	        l.remove(0);
    	        if (l.toString().equals("[A, B, D, E, F, G]"))
    	            System.out.println("Passed remove(pos) test 2");
    	        else
    	            System.out.println("Failed remove(pos) test 2");
    	        l.remove(6);
    	        if (l.toString().equals("[A, B, D, E, F, G]"))
    	            System.out.println("Passed remove(pos) test 3");
    	        else
    	            System.out.println("Failed remove(pos) test 3");
    	        l.remove(5);
    	        if (l.toString().equals("[A, B, D, E, F]") && l.size() == 5)
    	            System.out.println("Passed remove(pos) test 4");
    	        else
    	            System.out.println("Failed remove(pos) test 4");
    	//remove(obj)
    	        l.add("A");
    	        l.add("F");
    	        l.add("TT");
    	        l.add(0, "TT");
    	        l.remove("F");
    	        if (l.toString().equals("[TT, A, B, D, E, A, F, TT]") && l.size() == 8)
    	            System.out.println("Passed remove(obj) test 1");
    	        else
    	            System.out.println("Failed remove(obj) test 1");
    	        l.remove("TT");
    	        if (l.toString().equals("[A, B, D, E, A, F, TT]") && l.size() == 7)
    	            System.out.println("Passed remove(obj) test 2");
    	        else
    	            System.out.println("Failed remove(obj) test 2");
    	        l.remove("ASDF");
    	        if (l.toString().equals("[A, B, D, E, A, F, TT]") && l.size() == 7)
    	            System.out.println("Passed remove(obj) test 3");
    	        else
    	            System.out.println("Failed remove(obj) test 3");
    	//getSubList(int start, int stop)
    	        IList sub = l.getSubList(0, 7);
    	        if (sub.equals(l))
    	            System.out.println("Passed getSublist test 1");
    	        else
    	            System.out.println("Failed getSublist test 1");
    	        sub = l.getSubList(3, 4);
    	        if (sub.toString().equals("[E]") && l.toString().equals("[A, B, D, E, A, F, TT]"))
    	            System.out.println("Passed getSublist test 2");
    	        else
    	            System.out.println("Failed getSublist test 2");
    	        sub = l.getSubList(3, 3);
    	        if (sub.toString().equals("[]") && l.toString().equals("[A, B, D, E, A, F, TT]"))
    	            System.out.println("Passed getSublist test 3");
    	        else
    	            System.out.println("Failed getSublist test 3");
    	//indexOf(E item)
    	        if (l.indexOf("A") == 0)
    	            System.out.println("Passed indexOf(E item) test 1");
    	        else
    	            System.out.println("Failed indexOf(E item) test 1");
    	        if (l.indexOf("TT") == 6)
    	            System.out.println("Passed indexOf(E item) test 2");
    	        else
    	            System.out.println("Failed indexOf(E item) test 2");
    	        if (l.indexOf("Z") == -1)
    	            System.out.println("Passed indexOf(E item) test 3");
    	        else
    	            System.out.println("Failed indexOf(E item) test 3");
    	//indexOf(E item, int pos)
    	        if (l.indexOf("A", 1) == 4)
    	            System.out.println("Passed indexOf(E item, int pos) test 1");
    	        else
    	            System.out.println("Failed indexOf(E item, int pos) test 1");
    	        if (l.indexOf("B", 1) == 1)
    	            System.out.println("Passed indexOf(E item, int pos) test 2");
    	        else
    	            System.out.println("Failed indexOf(E item, int pos) test 2");
    	        if (l.indexOf("T", 2) == -1)
    	            System.out.println("Passed indexOf(E item, int pos) test 3");
    	        else
    	            System.out.println("Failed indexOf(E item, int pos) test 3");
    	//removeRange(int start, int stop)
    	        l.removeRange(0, 1);
    	        if (l.toString().equals("[B, D, E, A, F, TT]"))
    	            System.out.println("Passed removeRange test 1");
    	        else
    	            System.out.println("Failed removeRange test 1");
    	        l.removeRange(2, 5);
    	        if (l.toString().equals("[B, D, TT]"))
    	            System.out.println("Passed removeRange test 2");
    	        else
    	            System.out.println("Failed removeRange test 2");
    	        l.removeRange(0, 3);
    	        if (l.toString().equals("[]"))
    	            System.out.println("Passed removeRange test 3");
    	        else
    	            System.out.println("Failed removeRange test 3");
    	//addFirst(E item)
    	        l.addFirst("ASDF");
    	        if (l.toString().equals("[ASDF]"))
    	            System.out.println("Passed addFirst test 1");
    	        else
    	            System.out.println("Failed addFirst test 1");
    	        l.add("T");
    	        l.addFirst("OP");
    	        if (l.toString().equals("[OP, ASDF, T]"))
    	            System.out.println("Passed addFirst test 2");
    	        else
    	            System.out.println("Failed addFirst test 2");
    	        l.addFirst("ASDF");
    	        if (l.toString().equals("[ASDF, OP, ASDF, T]"))
    	            System.out.println("Passed addFirst test 3");
    	        else
    	            System.out.println("Failed addFirst test 3");
    	//addLast(E item)
    	        l.addLast("LAST");
    	        if (l.toString().equals("[ASDF, OP, ASDF, T, LAST]"))
    	            System.out.println("Passed addLast test 1");
    	        else
    	            System.out.println("Failed addLast test 1");
    	        l.makeEmpty();
    	        l.addLast("H");
    	        if (l.toString().equals("[H]"))
    	            System.out.println("Passed addLast test 2");
    	        else
    	            System.out.println("Failed addLast test 2");
    	        l.addLast("I");
    	        if (l.toString().equals("[H, I]"))
    	            System.out.println("Passed addLast test 3");
    	        else
    	            System.out.println("Failed addLast test 3");
    	        l.add("J");
    	        l.addLast("K");
    	        if (l.toString().equals("[H, I, J, K]"))
    	            System.out.println("Passed addLast test 4");
    	        else
    	            System.out.println("Failed addLast test 4");
    	//removeFirst()
    	        l.removeFirst();
    	        if (l.toString().equals("[I, J, K]"))
    	            System.out.println("Passed removeFirst test 1");
    	        else
    	            System.out.println("Failed removeFirst test 1");
    	        l.removeFirst();
    	        if (l.toString().equals("[J, K]"))
    	            System.out.println("Passed removeFirst test 2");
    	        else
    	            System.out.println("Failed removeFirst test 2");
    	        l.removeFirst();
    	        if (l.toString().equals("[K]"))
    	            System.out.println("Passed removeFirst test 3");
    	        else
    	            System.out.println("Failed removeFirst test 3");
    	        l.removeFirst();
    	        if (l.toString().equals("[]"))
    	            System.out.println("Passed removeFirst test 4");
    	        else
    	            System.out.println("Failed removeFirst test 4");
    	//removeLast() 
    	        l.add("A");
    	        l.add("B");
    	        l.add("K");
    	        l.removeLast();
    	        if (l.toString().equals("[A, B]"))
    	            System.out.println("Passed removeLast test 1");
    	        else
    	            System.out.println("Failed removeLast test 1");
    	        l.addFirst("D");
    	        l.removeLast();
    	        if (l.toString().equals("[D, A]") && l.size() == 2)
    	            System.out.println("Passed removeLast test 2");
    	        else
    	            System.out.println("Failed removeLast test 2");
    	        l.removeLast();
    	        l.removeLast();
    	        if (l.toString().equals("[]") && l.size() == 0)
    	            System.out.println("Passed removeLast test 3");
    	        else
    	            System.out.println("Failed removeLast test 3");
    	//equals(Object other)      
    	        LinkedList l2 = new LinkedList();
    	        if (l.equals(l2))
    	            System.out.println("Passed equals test 1");
    	        else
    	            System.out.println("Failed equals test 1");
    	        l.add("1");
    	        l.add("2");
    	        l.addFirst("B");
    	        l.addLast("3");
    	        l.add(0, "A");
    	        l.add(2, "C");
    	        if (!l.equals(l2))
    	            System.out.println("Passed equals test 2");
    	        else
    	            System.out.println("Failed equals test 2");
    	        l2.add("A");
    	        l2.add("B");
    	        l2.add("C");
    	        l2.add("1");
    	        l2.add("2");
    	        l2.add("3");
    	        if (l.equals(l2))
    	            System.out.println("Passed equals test 3");
    	        else
    	            System.out.println("Failed equals test 3");
    	        l2.set(4, "K");
    	        if (!l.equals(l2))
    	            System.out.println("Passed equals test 4");
    	        else
    	            System.out.println("Failed equals test 4");
    	        l2.removeRange(2, 5);
    	        if (!l.equals(l2))
    	            System.out.println("Passed equals test 5");
    	        else
    	            System.out.println("Failed equals test 5");
    	        l.removeRange(2, 5);
    	        if (l.equals(l2))
    	            System.out.println("Passed equals test 6");
    	        else
    	            System.out.println("Failed equals test 6");
    	       
    	       
    	    }

    

}
