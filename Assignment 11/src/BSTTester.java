 /*  Student information for assignment
  *
  *  Student Information
  *  Name: Zachary Tschirhart
  *  EID: ZST75
  *  email address: ztschir@gmail.com
  *  TA name: Xiuming
  *  programming hours: 8
  */

/**
 * Test class for binary search tree
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class BSTTester
{
	public static void main(String[] args)
	{	BinarySearchTree<String> t = new BinarySearchTree<String>();

		//test 1
	    System.out.println("Test 1: empty tree created.");
		showTestResults( t.size() == 0, 1 );

		//test 2
        System.out.println("Test 2: height of empty tree must be -1.");
		showTestResults( t.height() == -1, 2 );

		//test 3
	    System.out.println("Test 3: empty tree must " +
	      		"not contain the String \"abyss\".");
		showTestResults( t.isPresent("abyss") == false, 3 );

		t.add("abyss");
		//test 4
        System.out.println("Test 4: added \"abyss\" to the" +
        		"tree. Size must be 1.");		
		showTestResults( t.size() == 1, 4 );

		//test 5
        System.out.println("Test 5: height of tree with 1" +
        		"element must be 0.");
		showTestResults( t.height() == 0, 5 );

		//test 6
        System.out.println("Test 6: \"abyss\" must be in the tree.");
		showTestResults( t.isPresent("abyss") == true, 6 );

		//test 7
        System.out.println("Test 7: tree must " +
        "not contain the String \"beep\".");		
		showTestResults( t.isPresent("beep") == false, 7);

		//test 8
        System.out.println("Test 8: min value must be" +
        		"\"abyss\" at this point.");		
		showTestResults( t.min().equals("abyss"), 8);

		//test 9
        System.out.println("Test 9: max value must be" +
        "\"abyss\" at this point.");    
		showTestResults( t.max().equals("abyss"), 9);

		t.add("abyss");
		//test 10
        System.out.println("Test 10: attempt to add \"abyss\"" +
        		"again. size must remain 1.");    
		showTestResults( t.size() == 1, 10 );

		//test 11
        System.out.println("Test 11: attempt to add \"abyss\"" +
                "again. height must remain 0.");  
		showTestResults( t.height() == 0, 11 );

		//test 12
        System.out.println("Test 12: \"abyss\" must still be" +
        		"present.");  
		showTestResults( t.isPresent("abyss") == true, 12 );

		t.add("beep");
		//test 13
        System.out.println("Test 13: added \"beep\" to the" +
                "tree. Size must be 2.");   		
		showTestResults( t.size() == 2, 13 );

		//test 14
        System.out.println("Test 14: height of tree with 2" +
                "elements must be 1."); 
		showTestResults( t.height() == 1, 14 );

		//test 15
		System.out.println("Test 15: Removing \"abyss\" from the tree.");
		showTestResults( t.remove("abyss") == true, 15 );

		//test 16
	    System.out.println("Test 16: Removing \"beep\" from the tree.");
		showTestResults( t.remove("beep") == true, 16 );

		//test 17
	    System.out.println("Test 17: Tree must be empty at this point.");
		showTestResults( t.size() == 0, 17 );

		t.add("beep");
		t.add("abyss");
		t.add("calls");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("abyss");
		expected.add("beep");
		expected.add("calls");

		//test 18
	    System.out.println("Test 18: Added \"beep\", \"abyss\", and" +
	    		"\"calls\" to the tree in that order.\n" +
	    		"Testing getAll method.");

		showTestResults( expected.equals( t.getAll() ) == true, 18 );
		
		//test 19
		t.add("bit");
		t.add("dish");
        System.out.println("Test 19: Added \"bit\" and \"dish\" to" +
        		"tree. Checking that \"yes\" is not present.");		
		showTestResults( t.remove("yes") == false, 19);
		
		//test 20
		t.add("a");
	    System.out.println("Test 20: Added \"a\" and then " +
	    		"removed it.");
		showTestResults(t.remove("a") == true, 20);
		
		//test 21
	    System.out.println("Test 21: Checking that \"calls\" is still present.");
		showTestResults(t.remove("calls") == true, 21);
		
		//test 22
		t.remove("abyss");
        System.out.println("Test 22: Removing \"abyss\". " +
        		"Checking that \"beep\" is still present.");
		showTestResults(t.remove("beep") == true, 22);
		
		//Student Test's
		studentTest();
		
		//The Question page experiments.
		//questionsTest();
	}

	private static void showTestResults(boolean passed, int testNum)
	{	if( passed )
			System.out.println( "test " + testNum + " passed.");
		else
			System.out.println( "test " + testNum + " failed.");
	}
	
	private static void studentTest(){
		BinarySearchTree<String> a = new BinarySearchTree<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		//studentTest 1
	    System.out.println("Test 1: empty tree created.");
		showTestResults( a.size() == 0 , 1 );
		
		a.add("Hello");
		//studentTest 2
	    System.out.println("Test 2: Add/isPresent Test 1.");
		showTestResults( a.isPresent("Hello") , 2 );
		
		a.add("7");
		//studentTest 3
	    System.out.println("Test 3: Add/isPresent Test 2.");
		showTestResults( a.isPresent("7") , 3 );
		
		//studentTest 4
	    System.out.println("Test 4: Add/isPresent Test 3.");
		showTestResults( !a.isPresent("Not Here") , 4 );
		
		//studentTest 5
	    System.out.println("Test 5: Remove Test 1.");
		showTestResults( !a.remove("Not Here") , 5 );
		
		//studentTest 6
	    System.out.println("Test 6: Remove Test 2.");
		showTestResults( a.remove("Hello") , 6 );
		
		//studentTest 7
	    System.out.println("Test 7: Remove Test 3.");
		showTestResults( a.remove("7") , 7 );
		
		//studentTest 8
	    System.out.println("Test 8: Size Test 1.");
		showTestResults( a.size() == 0 , 8 );
		
		a.add("something");
		//studentTest 9
	    System.out.println("Test 9: Size Test 2.");
		showTestResults( a.size() == 1 , 9 );
		
		a.remove("something");
		//studentTest 10
	    System.out.println("Test 10: Size Test 3.");
		showTestResults( a.size() == 0 , 10 );
		
		a.add("A");
		a.add("B");
		a.add("C");
		//studentTest 11
	    System.out.println("Test 11: Height Test 1.");
		showTestResults( a.height() == 2 , 11 );
		
		a.remove("B");
		//studentTest 12
	    System.out.println("Test 12: Height Test 2.");
		showTestResults( a.height() == 1 , 12 );
		
		a.remove("A");
		//studentTest 13
	    System.out.println("Test 13: Height Test 3.");
		showTestResults( a.height() == 0 , 13 );
		
		a = new BinarySearchTree<String>();
		a.iterativeAdd("Q");
		a.iterativeAdd("P");
		a.iterativeAdd("E");
		a.iterativeAdd("A");
		a.iterativeAdd("O");
		a.iterativeAdd("U");
		a.iterativeAdd("B");
		
		b.add("A");
		b.add("B");
		b.add("E");
		b.add("O");
		b.add("P");
		b.add("Q");
		b.add("U");
		
		//studentTest 14
	    System.out.println("Test 14: GetAll/iterativeAdd Test 1.");
		showTestResults( b.equals(a.getAll()) , 14 );
		
		a.remove("E");
		//studentTest 15
	    System.out.println("Test 15: GetAll/iterativeAdd Test 2.");
		showTestResults( !b.equals(a.getAll()) , 15 );
		
		b.remove("E");
		//studentTest 16
	    System.out.println("Test 16: GetAll/iterativeAdd Test 3.");
		showTestResults( b.equals(a.getAll()) , 16 );
		
		
		//studentTest 17
	    System.out.println("Test 17: Max Test 1.");
		showTestResults( a.max() == "U" , 17 );
		
		a.add("Z");
		//studentTest 18
	    System.out.println("Test 18: Max Test 2.");
		showTestResults( a.max() == "Z" , 18 );
		
		a.remove("Z");
		//studentTest 19
	    System.out.println("Test 19: Max Test 3.");
		showTestResults( a.max() != "Z", 19 );
		
		//studentTest 20
	    System.out.println("Test 20: Min Test 1.");
		showTestResults( a.min() == "A" , 20 );
		
		a.remove("A");
		//studentTest 21
	    System.out.println("Test 21: Min Test 2.");
		showTestResults( a.min() != "A" , 21 );
		
		a.add("A");
		//studentTest 22
	    System.out.println("Test 22: Min Test 3.");
		showTestResults( a.min() == "A" , 22 );
		
		//studentTest 23
	    System.out.println("Test 23: numNodesAtDepth Test 1.");
		showTestResults( a.numNodesAtDepth(0) == 1 , 23 );
		
		//studentTest 24
	    System.out.println("Test 24: numNodesAtDepth Test 2.");
		showTestResults( a.numNodesAtDepth(1) == 2 , 24 );
		
		a = new BinarySearchTree<String>();
		//studentTest 25
	    System.out.println("Test 25: numNodesAtDepth Test 3.");
		showTestResults( a.numNodesAtDepth(1) == 0 , 25 );
		

		//Other Tests!!!

		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		//Test 1
		tree.add("B"); tree.add("C"); tree.add("A"); tree.add("Z");
		if(tree.height() == 2)
			System.out.println("Passed test 1: height/add");
		else
			System.out.println("Failed test 1: height/add. Exp: 2 Got: " + tree.height());
		//Test 2
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		if(tree.height() == 4)
			System.out.println("Passed test 2: height/add");
		else
			System.out.println("Failed test 2: height/add. Exp: 4 Got: " + tree.height());
		//Test 3
		tree = new BinarySearchTree<String>(); tree.add("E"); tree.add("D"); tree.add("C"); tree.add("B"); tree.add("A");
		if(tree.height() == 4)
			System.out.println("Passed test 3: height/add");
		else
			System.out.println("Failed test 3: height/add. Exp: 4 Got: " + tree.height());
		//Test 4
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		tree.remove("A"); tree.remove("B"); tree.remove("C"); tree.remove("D"); tree.remove("E");
		if(tree.height() == -1 && tree.size() == 0)
			System.out.println("Passed test 4: remove/height/size");
		else
			System.out.println("Failed test 4: remove/height/size Exp: height,size: -1, 0 Got: " + tree.height() + ", " + tree.size());
		//Test 5
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		tree.remove("A"); tree.remove("B"); tree.remove("C");
		if(tree.height() == 1 && tree.size() == 2)
			System.out.println("Passed test 5: remove/height/size");
		else
			System.out.println("Failed test 5: remove/height/size Exp: height,size: 1, 2 Got: " + tree.height() + ", " + tree.size());
		//Test 6
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		tree.remove("A");
		if(tree.height() == 3 && tree.size() == 4)
			System.out.println("Passed test 6: remove/height/size");
		else
			System.out.println("Failed test 6: remove/height/size Exp: height,size: 3, 4 Got: " + tree.height() + ", " + tree.size());
		//Test 7
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		if(tree.isPresent("A"))
			System.out.println("Passed test 7: isPresent");
		else
			System.out.println("Failed test 7: isPresent Exp: true Got: " + tree.isPresent("A"));
		//Test 8
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		tree.remove("D"); tree.remove("B");
		if(tree.isPresent("E"))
			System.out.println("Passed test 8: isPresent");
		else
			System.out.println("Failed test 8: isPresent Exp: true Got: " + tree.isPresent("E"));
		//Test 9
		tree = new BinarySearchTree<String>(); tree.add("A"); tree.add("B"); tree.add("C"); tree.add("D"); tree.add("E");
		if(!tree.isPresent("F"))
			System.out.println("Passed test 9: isPresent");
		else
			System.out.println("Failed test 9: isPresent Exp: true Got: " + tree.isPresent("F"));
		//Test 10
		tree = new BinarySearchTree<String>(); tree.add("beep");
		tree.add("abyss");
		tree.add("calls");
		tree.add("Stuff");
		tree.remove("Stuff");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("abyss");
		expected.add("beep");
		expected.add("calls");
		if(expected.equals( tree.getAll() ) == true)
			System.out.println("Passed test 10: getAll");
		else
			System.out.println("Failed test 10: getAll Exp: " + expected.toString() + " Got: " + tree.getAll().toString());
		//Test 11
		tree = new BinarySearchTree<String>(); tree.add("A");
		tree.add("B");
		tree.add("calls");
		tree.add("Stuff");
		tree.remove("Stuff");
		expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		expected.add("calls");
		if(expected.equals( tree.getAll() ) == true)
			System.out.println("Passed test 11: getAll");
		else
			System.out.println("Failed test 11: getAll Exp: " + expected.toString() + " Got: " + tree.getAll().toString());
		//Test 12
		tree = new BinarySearchTree<String>(); tree.add("E");
		tree.add("D");
		tree.add("C");
		tree.add("F");
		tree.remove("F");
		expected = new ArrayList<String>();
		expected.add("C");
		expected.add("D");
		expected.add("E");
		if(expected.equals( tree.getAll() ) == true)
			System.out.println("Passed test 12: getAll");
		else
			System.out.println("Failed test 12: getAll Exp: " + expected.toString() + " Got: " + tree.getAll().toString());
		//Test 13
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
		tree1.add(10); tree1.add(5); tree1.add(15); tree1.add(3); tree1.add(7); tree1.add(12); tree1.add(20);
		if(tree1.max() == 20)
			System.out.println("Passed test 13: max");
		else
			System.out.println("Failed test 13: max Exp: 20 Got: " + tree1.max());
		//Test 14
		tree1 = new BinarySearchTree<Integer>();
		tree1.add(10); tree1.add(5); tree1.add(15); tree1.add(3); tree1.add(7); tree1.add(12); tree1.add(20); tree1.remove(20);
		if(tree1.max() == 15)
			System.out.println("Passed test 14: max");
		else
			System.out.println("Failed test 14: max Exp: 15 Got: " + tree1.max());
		//Test 15
		tree1 = new BinarySearchTree<Integer>();
		tree1.add(10); tree1.add(5); tree1.add(15); tree1.add(3); tree1.add(7); tree1.add(12); tree1.add(20); tree1.remove(20); tree1.add(10000);
		if(tree1.max() == 10000)
			System.out.println("Passed test 15: max");
		else
			System.out.println("Failed test 15: max Exp: 10000 Got: " + tree1.max());
		//Test 16
		tree1 = new BinarySearchTree<Integer>();
		tree1.add(10); tree1.add(5); tree1.add(15); tree1.add(3); tree1.add(7); tree1.add(12); tree1.add(20);
		if(tree1.min() == 3)
			System.out.println("Passed test 16: min");
		else
			System.out.println("Failed test 16: min Exp: 3 Got: " + tree1.min());
		//Test 17
		tree1 = new BinarySearchTree<Integer>();
		tree1.add(10); tree1.add(5); tree1.add(15); tree1.add(3); tree1.add(7); tree1.add(12); tree1.add(20); tree1.remove(20);
		if(tree1.min() == 3)
			System.out.println("Passed test 17: min");
		else
			System.out.println("Failed test 17: min Exp: 3 Got: " + tree1.min());
		//Test 18
		tree1 = new BinarySearchTree<Integer>();
		tree1.add(10); tree1.add(5); tree1.add(15); tree1.add(3); tree1.add(7); tree1.add(12); tree1.add(20); tree1.remove(20); tree1.add(-10000);
		if(tree1.min() == -10000)
			System.out.println("Passed test 18: min");
		else
			System.out.println("Failed test 18: min Exp: 10000 Got: " + tree1.min());
		//Test 19
		tree = new BinarySearchTree<String>(); tree.iterativeAdd("beep");
		tree.iterativeAdd("abyss");
		tree.iterativeAdd("calls");
		tree.iterativeAdd("Stuff");
		tree.remove("Stuff");
		expected = new ArrayList<String>();
		expected.add("abyss");
		expected.add("beep");
		expected.add("calls");
		if(expected.equals( tree.getAll() ) == true)
			System.out.println("Passed test 19: iterativeAdd/getAll");
		else
			System.out.println("Failed test 19: iterativeAdd/getAll Exp: " + expected.toString() + " Got: " + tree.getAll().toString());
		//Test 20
		tree = new BinarySearchTree<String>(); tree.iterativeAdd("A");
		tree.iterativeAdd("B");
		tree.iterativeAdd("calls");
		tree.iterativeAdd("Stuff");
		tree.remove("Stuff");
		expected = new ArrayList<String>();
		expected.add("A");
		expected.add("B");
		expected.add("calls");
		if(expected.equals( tree.getAll() ) == true)
			System.out.println("Passed test 20: iterativeAdd/getAll");
		else
			System.out.println("Failed test 20: iterativeAdd/getAll Exp: " + expected.toString() + " Got: " + tree.getAll().toString());
		//Test 21
		tree = new BinarySearchTree<String>(); tree.iterativeAdd("E");
		tree.iterativeAdd("D");
		tree.iterativeAdd("C");
		tree.iterativeAdd("F");
		tree.remove("F");
		expected = new ArrayList<String>();
		expected.add("C");
		expected.add("D");
		expected.add("E");
		if(expected.equals( tree.getAll() ) == true)
			System.out.println("Passed test 21: iterativeAdd/getAll");
		else
			System.out.println("Failed test 21: iterativeAdd/getAll Exp: " + expected.toString() + " Got: " + tree.getAll().toString());
		//Test 22
		tree1 = new BinarySearchTree<Integer>();
		tree1.iterativeAdd(10); tree1.iterativeAdd(5); tree1.iterativeAdd(15);
		tree1.iterativeAdd(3); tree1.iterativeAdd(7); tree1.iterativeAdd(12); tree1.iterativeAdd(20);
		if(tree1.numNodesAtDepth(2) == 4)
			System.out.println("Passed test 22: numNodesAtDepth");
		else
			System.out.println("Failed test 22: numNodesAtDepth. Exp: 4 Got: " + tree1.numNodesAtDepth(2));
		//Test 23
		tree1 = new BinarySearchTree<Integer>();
		tree1.iterativeAdd(10);
		if(tree1.numNodesAtDepth(4) == 0)
			System.out.println("Passed test 23: numNodesAtDepth");
		else
			System.out.println("Failed test 23: numNodesAtDepth. Exp: 0 Got: " + tree1.numNodesAtDepth(4));
		//Test 24
		tree1 = new BinarySearchTree<Integer>();
		tree1.iterativeAdd(10); tree1.iterativeAdd(5); tree1.iterativeAdd(15);
		tree1.iterativeAdd(3); tree1.iterativeAdd(7); tree1.iterativeAdd(12); tree1.iterativeAdd(20);
		if(tree1.numNodesAtDepth(0) == 1)
			System.out.println("Passed test 24: numNodesAtDepth");
		else
			System.out.println("Failed test 24: numNodesAtDepth. Exp: 1 Got: " + tree1.numNodesAtDepth(0)); 
		
	}
	
	private static void questionsTest(){
		Random r = new Random();
		Stopwatch s = new Stopwatch();
		
		for(int n = 1000; n <= 1024000; n *= 2){
			
			double avgTime = 0;
			int avgHeight = 0;
			int avgSize = 0;
			for(int index = 0; index < 10; index++){
				BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
				s.start();
				for(int i = 0; i < n; i++){
					b.add( r.nextInt() );
				}
				s.stop();
				avgTime += s.time();
				avgHeight += b.height();
				avgSize += b.size();
				
			}
			System.out.println("Random: It took an average of " + avgTime/10 + " seconds to add " + n + " items to the BST.");
			System.out.println("Random: The tree has a height of " + avgHeight/10 + " rows when it has " + n + " items.");
			System.out.println("Random: The tree has a size of " + avgSize/10 + " items when " + n + " supposed to be added");
			System.out.println(" ");
		}

		for(int n = 1000; n <= 1024000; n *= 2){
			
			double avgTime = 0;
			int avgHeight = 0;
			int avgSize = 0;
			for(int index = 0; index < 10; index++){
				BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
				s.start();
				for(int i = 0; i < n; i++){
					b.iterativeAdd(i);
				}
				s.stop();
				avgTime += s.time();
				avgSize += b.size();
			}
			System.out.println("In Order: It took an average of " + avgTime/10 + " seconds to add " + n + " items to the BST.");
			System.out.println("In Order: The tree has a height of " + avgSize/10 + " rows when it has " + n + " items.");
			System.out.println("In Order: The tree has a size of " + avgSize/10 + " items when " + n + " supposed to be added.");
			System.out.println(" ");
		}

		for(int n = 1000; n <= 1024000; n *= 2){
			
			double avgTime = 0;
			int avgSize = 0;
			for(int index = 0; index < 10; index++){
				TreeSet<Integer> t = new TreeSet<Integer>();
				s.start();
				for(int i = 0; i < n; i++){
					t.add(i);
				}
				s.stop();
				avgTime += s.time();
				avgSize += t.size();
			}
			System.out.println("In Order TreeSet: It took an average of " + avgTime/10 + " seconds to add " + n + " items to the BST.");
			System.out.println("In Order TreeSet: The tree has a size of " + avgSize/10 + " items when " + n + " supposed to be added.");
			System.out.println(" ");
		}
	}

}
