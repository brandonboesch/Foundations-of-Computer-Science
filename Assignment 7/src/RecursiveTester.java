/*  Student information for assignment
 * 
 *  On <our|my> honor, <NAME1> and <NAME2>, 
 *  this programming assignment is <our|my> own work.
 *
 *  Student #1:
 *  Name #1:  Jessse Campos
 *  EID #1: jpc639
 *  email address #1:  jesse.campos@mail.utexas.edu
 *  TA name #1: Xiuming
 *  Unique course ID #1:  54022
 *  programming hours #1:  8
 *
 *  Slip days used on this assignment: 1
 *  Slip days used so far: 0 
 *
 *  Student #2:
 *  Name #2:  Zachary Tschirhart
 *  EID #2:  zst75
 *  email address #2:  ztschir@gmail.com
 *  TA name #2:  Xiuming
 *  Unique course ID #2:  54022
 *  programming hours #2:  8
 * 	
 *	Slip days used on this assignment: 1
 *  Slip days used so far: 0 
 *
 *
 * Lines of Code:  250
*/

import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester
{	public static void main(String[] args)
	{	Recursive r = new Recursive();

		boolean passedAll = true;
		for(int i = 1; i <= 101 && passedAll; i++)
			passedAll = r.mcCarthy91(i) == 91;
	
		if(passedAll)
			System.out.println( "Test 1 passed");
		else
			System.out.println( "Test 1 failed");
		
		if( r.mcCarthy91(102) == 92)
			System.out.println( "Test 2 passed");
		else
			System.out.println( "Test 2 failed");
		
		if( r.mcCarthy91(10000) == 9990)
			System.out.println( "Test 3 passed");
		else
			System.out.println( "Test 3 failed");	
		
		if( r.mcCarthy91(2) == 91)
			System.out.println( "Test 3.1 passed");
		else
			System.out.println( "Test 3.1 failed");
		
		if( r.mcCarthy91(40) == 91)
			System.out.println( "Test 3.2 passed");
		else
			System.out.println( "Test 3.2 failed");
		
		if( r.mcCarthy91(50) == 91)
			System.out.println( "Test 3.3 passed");
		else
			System.out.println( "Test 3.3 failed");
		
		if( r.mcCarthy91(83) == 91)
			System.out.println( "Test 3.4 passed");
		else
			System.out.println( "Test 3.4 failed");


		ArrayList<String> mnemonics = r.listMnemonics("1");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("1");
		if( mnemonics.equals(expected))
			System.out.println( "Test 4 passed");
		else
			System.out.println( "Test 4 failed");

		mnemonics = r.listMnemonics("22");
		Collections.sort(mnemonics);
		expected.clear();
		expected.add("AA");
		expected.add("AB");
		expected.add("AC");
		expected.add("BA");
		expected.add("BB");
		expected.add("BC");
		expected.add("CA");
		expected.add("CB");
		expected.add("CC");
		Collections.sort(expected);
		if( mnemonics.equals(expected))
			System.out.println( "Test 5 passed");
		else
			System.out.println( "Test 5 failed");
		
		ArrayList<String> mnemonics1 = r.listMnemonics("00001111");
		ArrayList<String> expected1 = new ArrayList<String>();
		expected1.add("00001111");
		if( mnemonics1.equals(expected1))
			System.out.println( "Test 5.1 passed");
		else
			System.out.println( "Test 5.1 failed");
		
		ArrayList<String> mnemonics2 = r.listMnemonics("2");
		ArrayList<String> expected2 = new ArrayList<String>();
		expected2.add("A");
		expected2.add("B");
		expected2.add("C");
		if( mnemonics2.equals(expected2))
			System.out.println( "Test 5.2 passed");
		else
			System.out.println( "Test 5.2 failed");
		
		ArrayList<String> mnemonics3 = r.listMnemonics("3");
		ArrayList<String> expected3 = new ArrayList<String>();
		expected3.add("D");
		expected3.add("E");
		expected3.add("F");
		if( mnemonics3.equals(expected3))
			System.out.println( "Test 5.3 passed");
		else
			System.out.println( "Test 5.3 failed");
		
		ArrayList<String> mnemonics4 = r.listMnemonics("4");
		ArrayList<String> expected4 = new ArrayList<String>();
		expected4.add("G");
		expected4.add("H");
		expected4.add("I");
		if( mnemonics4.equals(expected4))
			System.out.println( "Test 5.4 passed");
		else
			System.out.println( "Test 5.4 failed");
		
		
		

		String binary1 = r.getBinary(5000);
		String expectedBinary1 = "1001110001000";
		if( binary1.equals(expectedBinary1) )
			System.out.println( "Test 6 passed");
		else
			System.out.println( "Test 6 failed");
		
		String binary = r.getBinary(13);
		String expectedBinary = "1101";
		if( binary.equals(expectedBinary) )
			System.out.println( "Test 6 passed");
		else
			System.out.println( "Test 6 failed");

		binary = r.getBinary(64);
		expectedBinary = "1000000";
		if( binary.equals(expectedBinary) )
			System.out.println( "Test 7 passed");
		else
			System.out.println( "Test 7 failed");

		binary = r.getBinary(1000);
		expectedBinary = "1111101000";
		if( binary.equals(expectedBinary) )
			System.out.println( "Test 7.1 passed");
		else
			System.out.println( "Test 7.1 failed");
		
		
		binary = r.getBinary(2783);
		expectedBinary = "101011011111";
		if( binary.equals(expectedBinary) )
			System.out.println( "Test 7.2 passed");
		else
			System.out.println( "Test 7.2 failed");
		
		binary = r.getBinary(90875);
		expectedBinary = "10110001011111011";
		if( binary.equals(expectedBinary) )
			System.out.println( "Test 7.3 passed");
		else
			System.out.println( "Test 7.3 failed");
		
		binary = r.getBinary(6239492);
		expectedBinary = "10111110011010100000100";
		if( binary.equals(expectedBinary) )
			System.out.println( "Test 7.4 passed");
		else
			System.out.println( "Test 7.4 failed");
		
		
		
		String rev = r.revString("target");
		if( rev.equals("tegrat") )
			System.out.println( "Test 8 passed");
		else
			System.out.println( "Test 8 failed");

		rev = r.revString("Calvin and Hobbes");
		if( rev.equals("sebboH dna nivlaC") )
			System.out.println( "Test 9 passed");
		else
			System.out.println( "Test 9 failed");
		
		rev = r.revString("Happy!!!");
		if( rev.equals("!!!yppaH") )
			System.out.println( "Test 9.1 passed");
		else
			System.out.println( "Test 9.1 failed");
		
		rev = r.revString("yes");
		if( !rev.equals("on") )
			System.out.println( "Test 9.2 passed");
		else
			System.out.println( "Test 9.2 failed");
		
		rev = r.revString("12345678");
		if( rev.equals("87654321") )
			System.out.println( "Test 9.3 passed");
		else
			System.out.println( "Test 9.3 failed");
		
		rev = r.revString("JaVa");
		if( rev.equals("aVaJ") )
			System.out.println( "Test 9.4 passed");
		else
			System.out.println( "Test 9.4 failed");
		
		int[][] world = {{5,5,5,5,5,5},
				         {5,5,5,5,5,5},
				         {5,5,5,5,5,5},
				         {5,5,4,4,5,5},
				         {5,5,3,3,5,5},
				         {5,5,2,2,5,5},
				         {5,5,5,1,5,5},
				         {5,5,5,-2,5,5}};
		
		if( r.canFlowOffMap(world,0,0))
			System.out.println( "Test 10 passed");
		else
			System.out.println( "Test 10 failed");
		
		if( !r.canFlowOffMap(world,1,1))
			System.out.println( "Test 11 passed");
		else
			System.out.println( "Test 11 failed");	
		
		if( r.canFlowOffMap(world,3,3))
			System.out.println( "Test 12 passed");
		else
			System.out.println( "Test 12 failed");
		
		if( r.canFlowOffMap(world,1,5))
			System.out.println( "Test 13 passed");
		else
			System.out.println( "Test 13 failed");
		
		world = new int[][]
		                  {{10, 10, 10, 10, 10, 10, 10},
				           {10, 10, 10,  5, 10, 10, 10},
				           {10, 10, 10,  6, 10, 10, 10},
				           {10, 10, 10,  7, 10, 10, 10},
				           {5,   6,  7,  8,  7,  6, 10},
				           {10, 10, 10,  7, 10, 10, 10},
				           {10, 10, 10,  6, 10, 10, 10},
				           {10, 10, 10,  5, 10, 10, 10},
				           {10, 10, 10, 10, 10, 10, 10},
		                  };
		
		if( !r.canFlowOffMap(world,3,3))
			System.out.println( "Test 14 passed");
		else
			System.out.println( "Test 14 failed");	
		
		if( r.canFlowOffMap(world,4,3))
			System.out.println( "Test 15 passed");
		else
			System.out.println( "Test 15 failed");
		
		if( r.canFlowOffMap(world,8,6))
			System.out.println( "Test 15.1 passed");
		else
			System.out.println( "Test 15.1 failed");
		
		if( !r.canFlowOffMap(world,7,2))
			System.out.println( "Test 15.2 passed");
		else
			System.out.println( "Test 15.2 failed");
		
		if( r.canFlowOffMap(world,4,1))
			System.out.println( "Test 15.3 passed");
		else
			System.out.println( "Test 15.3 failed");
		
		if( r.canFlowOffMap(world,0,6))
			System.out.println( "Test 15.4 passed");
		else
			System.out.println( "Test 15.4 failed");
        
        // try the Sierpinski triangle
        r.drawTriangles(400, 2, 360);
        
        //try the Sierpinski Carpet\
       r.drawCarpet(600, 1);
/*
       RecursiveTrace N = new RecursiveTrace();
       Stopwatch s = new Stopwatch();
       s.start();
       N.e(20);
       s.stop();
       System.out.println(s);
*/
	}
}

/*
CS 307 Students. Put your answers to the questions from the
RecursiveTrace class here.

 	   What is the output when a(5) called?  
 	   		5 performing recursive step
			4 performing recursive step
			3 performing recursive step
			2 performing recursive step
			1 performing recursive step
			0 at base case.
	   What is the Big O of this method?
	   		O(N)
	   What would occur if the method call a(-5) is made?
	   		It would go straight to the base case.
	   What is the output when b(7) called.
	   		7 performing recursive step
			5 performing recursive step
			3 performing recursive step
			1 performing recursive step
			-1 at base case.
			1 done with recursive step
			3 done with recursive step
			5 done with recursive step
			7 done with recursive step
	   What is the output when c(7) called.
	   		0
			0
			0
			0
			0
			0
			0
			0 at base case.
			5
			8
			11
			14
			17
			20
			23
	   What does d(16) return?
	   		9
	   What is the Big O of this method?
	   		O(log(N)) [base 3]
	   What does e(4) return?
	   		77
	   What is the Big O of this method?
	   		O(N^15)
	   Use the stopwatch class to record the time it takes for
	   		this method to complete as n goes from 1 to 30.
	   		Based on your answer what is the expected time to complete
	   		when n = 40?
	   		
	   		Data		Time
	   		
	   		1			8.56E-6 seconds
	   		10			1.39437E-4 seconds
	   		20			0.012278999 seconds
	   		30			5.622277575 seconds
	   		
	   					Expected?
	   		40			2574.314496674
	 

*/