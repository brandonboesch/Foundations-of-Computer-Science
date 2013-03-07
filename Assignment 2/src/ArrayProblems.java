/*  Student information for assignment
 *
 *  On my honor, Zachary Tschirhart
 *  this programming code is my own work.
 *
 *  Name: Zachary Tschirhart
 *  EID: ZST75
 *  email address: ztschir@gmail.com
 *  TA name: Xiuming
 *  Unique course ID: 54022
*/

 //slip days info
 /*
 Student #1
 Slip days used on this assignment: 0
 Slip days I have used for the term thus far: 0
 
 */

/** 
 * ArrayProblems.java<br>
 * CS 307<br><br>
 * 
 * VERY IMPORTANT: For this assignment only, the only methods and classes from the 
 * Java standard library you may use in your final solutions are:<br>
 * 1. All methods from the System class<br>
 * 2. All methods from the Math class<br>
 * 3. All methods from the Random class<br>
 * 4. on the mostVowels method you can use any and all methods from the String class.<br>
 * 5. native arrays, including the <tt>arr.length</tt> field and creating and using new native arrays
 */
public class ArrayProblems
{

    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */    
    public static int hammingDistance(int[] aList, int[] bList){
        assert (aList != null && bList != null 
        		&& aList.length == bList.length) : "Violation of precondition: hammingDistance";
//************ADDED CODE*******************************************
        int distance = 0;
        for (int index = 0; index < aList.length; index++){
        	if(aList[index] != bList[index]) distance++;
        }
        return distance;
//************END ADDED CODE*******************************************
    }
    
	/**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or 
     * the parameter <tt>listB</tt> are altered as a result of this method.
     * @param listA != null
     * @param listB != null
     * @return <tt>true</tt> if listB is a permutation of listA, <tt>false</tt> otherwise
     * 
	*/
	public static boolean isPermutation(int[] listA, int[] listB) {
		assert (listA != null && listB != null) : "Violation of precondition: isPermutation";

//************ADDED CODE*******************************************
		boolean permutations = true;
        int[] sortedListA = sort(listA);
        int[] sortedListB = sort(listB);
        if(sortedListA.length == sortedListB.length){

        	for(int index = 0; permutations && index < sortedListA.length; index++){
        		if(sortedListA[index] != sortedListB[index]) permutations = false;
        	}
        }
        else permutations = false;
       
		return permutations;
	}

	private static int[] sort(int[] unsortedList){
		int[] sortedList = new int[unsortedList.length];
		boolean sorted = false;
		System.arraycopy(unsortedList, 0, sortedList, 0, unsortedList.length);
		while(!sorted){
			sorted = true;
			for(int index = 0; index < sortedList.length-1 ; index++){
				if(sortedList[index] > sortedList[index+1]){
					int tempNum = sortedList[index];
					sortedList[index] = sortedList[index+1];
					sortedList[index+1] = tempNum;
					sorted = false;
				}
			}
		}
		return sortedList;
	}
//************END ADDED CODE*******************************************

	
	/** Find the two values in an array that are closest to
	 * each other. On other words find the two nearest neighbors.
	 * The parameter <tt>nums</tt> is not altered as a result of
	 * this method.
	 * @param nums The array of ints to find the nearest neighbors in.
	 * <tt>nums</tt> != null, <tt>nums.length</tt> >= 2
	 * @return Returns an array of length 2. 
	 * The elements of the result are the indices of ints in 
	 * nums that have the smallest distance (absolute value of
	 * difference) of any pair of ints in nums.<br>
	 * If there is more than one pair of ints that meet this 
	 * criteria returns the indices of the pair with the minimum index.<br>
	 * If there is more than one pair of ints with the minimum
	 * index, returns the indices of the pair with the smaller s
	 * second index.<br>
	 * The first element of the result is the smaller of the two indices.
	 * For example given the array <tt>{5, 3, 7, 10, 12, 3}</tt> the method
	 * would return <tt>{0, 1}</tt>.
	 */
	public static int[] nearestNeighbors(int[] nums) {
//************ADDED CODE*******************************************
		int[] result = new int[2];
        int[][] sortedNums = sortWithIndex(nums);
        int distanceApart = sortedNums[0][sortedNums[0].length-1] - sortedNums[0][0];
        int indexDistanceApart = Math.abs(sortedNums[0][sortedNums[1].length-1] - sortedNums[1][0]);
        int firstNumIndex = sortedNums[1].length; 
        int secondNumIndex = firstNumIndex;
        for(int index = 0; index < sortedNums[0].length-1; index++){
        	int tempDistance = (sortedNums[0][index+1] - sortedNums[0][index]);
        	int tempIndexDistance = Math.abs(sortedNums[1][index] - sortedNums[1][index+1]);
        	if (tempDistance < distanceApart || 
        			(tempDistance <= distanceApart && tempIndexDistance <= indexDistanceApart) && 
        			(sortedNums[1][index] < firstNumIndex || sortedNums[1][index+1] < secondNumIndex ||
        			sortedNums[1][index] < secondNumIndex || sortedNums[1][index+1] < firstNumIndex)){
        		distanceApart = tempDistance;
        		indexDistanceApart = tempIndexDistance;
        		firstNumIndex = sortedNums[1][index];
        		secondNumIndex = sortedNums[1][index+1];
        	}
        }
        if(firstNumIndex > secondNumIndex){
            result[1] = firstNumIndex;
            result[0] = secondNumIndex;
        }
        else{
        	result[0] = firstNumIndex;
         	result[1] = secondNumIndex;       	
        }
	    return result;

	}
	
	private static int[][] sortWithIndex(int[] unsortedList){
		int[][] sortedList = new int[2][unsortedList.length];
		boolean sorted = false;
		System.arraycopy(unsortedList, 0, sortedList[0], 0, unsortedList.length);
		for(int index = 0; index < sortedList[1].length; index++){
			sortedList[1][index] = index;
		}
		while(!sorted){
			sorted = true;
			for(int numbers = 0; numbers < sortedList[0].length-1 ; numbers++){
				if(sortedList[0][numbers] > sortedList[0][numbers+1]){
					int tempNum = sortedList[0][numbers];
					int tempIndex = sortedList[1][numbers];
					sortedList[0][numbers] = sortedList[0][numbers+1];
					sortedList[1][numbers] = sortedList[1][numbers+1];
					sortedList[0][numbers+1] = tempNum;
					sortedList[1][numbers+1] = tempIndex;
					sorted = false;
				}
			}
		}
		return sortedList;
	}
//************END ADDED CODE*******************************************

	/**
	* Determine the index of the String thaht 
	* has the largest number of vowels. 
	* Vowels are defined to 'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', and 'u'.
	* The parameter <tt>list</tt> is not altered as a result of
	* this method.
	* <p>pre: <tt>list != null</tt>, <tt>list.length > 0</tt>, there is an least 1 non null element in list
	* <p>post: return the index of the String in list that has the largest number of characters that are vowels.
	* If there is a tie return the index closest to zero.
	* @param list the array to check
	* @return the index of the String in list that has the greatest number of vowels.
	*/
	public static int mostVowels(String[] list) {
		assert list != null && list.length > 0 && atLeastOneNonNull(list) : "Violation of precondition: mostVowels"; 

//************ADDED CODE*******************************************		
		int numberOfVowels = 0;
		int mostNumOfVowelsList = -1;
		for(int listNumber = 0; listNumber < list.length; listNumber++){
			int tempNumberOfVowels = 0;
			for(int index = 0; list[listNumber] != null && index < list[listNumber].length(); index++){
				char[] charList= list[listNumber].toLowerCase().toCharArray();
				if(charList[index] == 'a' || charList[index] == 'e' || charList[index] == 'i' || 
						charList[index] == 'o' || charList[index] == 'u'){
					tempNumberOfVowels++;
				}
			}
			if (tempNumberOfVowels > numberOfVowels){
				numberOfVowels = tempNumberOfVowels;
				mostNumOfVowelsList = listNumber;
			}	
		}
	    return mostNumOfVowelsList;
	}
//************END ADDED CODE*******************************************

	// pre: list != null
	private static boolean atLeastOneNonNull(String[] list) {
	    assert list != null : "Violation of precondition: atLeastOneNonNull"; 
	    boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < list.length ){
            foundNonNull = list[i] != null;
            i++;
        }
        return foundNonNull;
    }

    /**
	 * Determine if the chess board represented by board is a safe set up.
	 * <p>pre: board != null, board.length > 0, board is a square matrix.
	 * (In other words all rows in board have board.length columns.),
	 * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
	 * represent open spaces.<br>
	 * <p>post: return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	 * the parameter <tt>board</tt> is not altered as a result of 
	 * this method.
	 * @param board the chessboard
	 * @return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	*/
	public static boolean queensAreSafe(char[][] board) {
		char[] validChars = {'q', '.'};
		assert (board != null) && (board.length > 0)
				&& isSquare(board) && onlyContains(board, validChars)
				: "Violation of precondition: queensAreSafe";

//************ADDED CODE*******************************************
				
		for (int row = 0; row < board.length; row++){
			for (int column = 0; column < board[0].length; column++){
				if (board[row][column] == 'q'){
					if(!rowCheck(board, column)) return false;
					else if(!columnCheck(board, row)) return false;
					else if(!bottomToTopDiagCheck(board, row, column)) return false;
					else if(!topToBottomDiagCheck(board, row, column)) return false;
				}
			}
		}
		return true;
	}
	
	private static boolean rowCheck(char[][] board, int column) {
		boolean safe = true;
		int count = 0;
		for (int checkingRow = 0; checkingRow < board.length; checkingRow++){
			if(board[checkingRow][column] == 'q') count++;	
		}
		if (count > 1){
			safe = false;
		}
		return safe;
	}
	private static boolean columnCheck(char[][] board, int row) {
		boolean safe = true;
		int count = 0;
		for (int checkingColumn = 0; checkingColumn < board.length; checkingColumn++){
			if(board[row][checkingColumn] == 'q') count++;	
		}
		if (count > 1){
			safe = false;
		}
		return safe;
	}
	private static boolean bottomToTopDiagCheck(char[][] board, int row, int column) {
		boolean safe = true;
		int count = 0;
		while (row > 0 && column > 0){
			--row;
			--column;
		}

		for (; row < board.length && column < board[0].length; row++, column++){
			if(board[row][column] == 'q') count++;	
		}
		if (count > 1){
			safe = false;
		}
		return safe;
	}
	private static boolean topToBottomDiagCheck(char[][] board, int row, int column) {
		boolean safe = true;
		int count = 0;
		while (row < board.length-1 && column > 0){
			++row;
			--column;
		}
		for (; row >= 0 && column < board[0].length; row--, column++){
			if(board[row][column] == 'q') count++;
		}
		if (count > 1){
			safe = false;
		}
		return safe;
	}
//************END ADDED CODE*******************************************
	/**
	 * Determine which row or column in a matrix has the largest sum.
	 * The parameter <tt>mat</tt> is not altered as a result of
	 * this method call.
	 * <p>pre: mat != null, mat.length > 0,
	 * mat is a rectangular matrix, mat[0].length > 0
     * <p>post: determine which row or column of ints has the maximum sum in max. 
     * If a row contains the maximum sum, return a string starting with "R" and 
     * then the number of the row with no spaces. For example "R0" or "R12". If a 
     * column contains the maximum sum, return a string starting with "C" and then 
     * the number of the column with no spaces. For example "C0" or "C12".  
     * If there is more than one row or column with the maximum sum 
     * return rows over columns first, then smaller indices over
     * larger indices.<br>
     * Thus if rows 3, 5, and 12, and columns 0 and 2 all contained
     * the same maximum sum the method would return "R3".
	*/
	public static String maxSum(int[][] mat) {
		assert (mat != null) && (mat.length > 0) && (mat[0].length > 0)
				&& isRectangular( mat ) : "Violation of precondition: maxSum";

//***************ADDED CODE******************************************		
		int row, column;
		int maxSum = 0;
		int whichRowOrColumn = 0;
		String result;
		boolean columnInitialized = false;
		boolean firstTime = true;

		for (row = 0; row < mat.length; row++){
			int rowSum = 0;
			for (column = 0; column < mat[0].length; column++){
				rowSum += mat[row][column];
			}
			if(firstTime || rowSum > maxSum){
				maxSum = rowSum;
				whichRowOrColumn = row;
				firstTime = false;
			}
		}
		for (column = 0; column < mat[0].length; column++){
			int columnSum = 0;
			for (row = 0; row < mat.length; row++){
				columnSum += mat[row][column];
			}
			if(columnSum > maxSum){
				maxSum = columnSum;
				whichRowOrColumn = column;
				columnInitialized = true;
			}
		}
		
		if(columnInitialized) result = "C" + whichRowOrColumn;
		else result = "R" + whichRowOrColumn;
		
		
		return result;
	}
		
		
//*************END ADDED CODE********************************************
		
		
		
		
		public static void main(String[] args)
		{					
		//test 0
		int[] h1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
		int[] h2 = {1, 2, 2, 4, 5, 4, 3, 1, 1};
		if( hammingDistance(h1, h2) == 2 ) 
			System.out.println("passed test 0, hamming distance");
		else
			System.out.println("failed test 0, hamming distance");
		//test 0.1
		int[] h3 = {5, 5, 5, 5, 5, 5, 5, 5, 5};
		if( hammingDistance(h1, h3) == 8 )
			System.out.println("hamming distance: passed test 0.1");
		else
			System.out.println("hamming distance: failed test 0.1");

		//test 0.2
		int[] h4 = {0, -1, 3, 4, -1, 4, 3, 2, 1};
		if( hammingDistance(h1, h4) == 3 )
			System.out.println("hamming distance: passed test 0.2");
		else
			System.out.println("hamming distance: failed test 0.2");
		//test 0.3
		int[] h5 = { 1, 7, 3, 4, 5, 4, 3, 1, 1 };
		int[] h6 = { 1, 7, 3, 4, 5, 4, 3, 1, 1 };
		if (hammingDistance(h5, h6) == 0)
			System.out.println("hamming distance: passed test 0.3");
		else
			System.out.println("hamming distance: failed test 0.3");
		//test 0.4
		int[] h7 = { 23, 9, 78, 6, 4, 13, 9, 0, 9 };
		int[] h8 = { 9, 23, 78, 4, 6, 0, 9, 13, 9 };
		if (hammingDistance(h7, h8) == 6)
			System.out.println("hamming distance: passed test 0.4");
		else
			System.out.println("hamming distance: failed test 0.4");
		//test 1
		int[] a = {1, 2, 3};
		int[] b = {2, 1, 3};
		if ( isPermutation(a,b) )
			System.out.println("passed test 1, isPermutation");
		else
			System.out.println("failed test 1, isPermutation");

		//test 2
		b = new int[]{2, 1, 3, 3};
		if ( !isPermutation(a,b) )
			System.out.println("passed test 2, isPermutation");
		else
			System.out.println("failed test 2, isPermutation");
		//test 2.1
		int[] c = new int[]{3, 1, 2};
		if ( isPermutation(a,c) )
			System.out.println("isPermutation: passed test 2.1");
		else
			System.out.println("isPermutation: failed test 2.1");

		//test 2.2
		c = new int[]{1,2,3,3};
		int[] d = new int[]{2,3,1,3};
		if ( isPermutation(c,d) )
			System.out.println("isPermutation: passed test 2.2");
		else
			System.out.println("isPermutation: failed test 2.2");

		//test 2.3
		c = new int[]{-1,5,2,7,-1,0,0};
		d = new int[]{0,7,-1,2,0,5,-1};
		if ( isPermutation(c,d) )
			System.out.println("isPermutation: passed test 2.3");
		else
			System.out.println("isPermutation: failed test 2.3");

		//test 2.4
		c = new int[]{45,5,1,7,2,0,0};
		d = new int[]{0,7,2,1,0,5,45};
		if ( isPermutation(c,d) )
			System.out.println("isPermutation: passed test 2.4");
		else
			System.out.println("isPermutation: failed test 2.4");

		//test 3
		int[] neighNums = {19, 0, -5, 4, 7, 10};
		int[] neighResult = nearestNeighbors(neighNums);
		if( neighResult.length == 2 && neighResult[0] == 3 &&
				neighResult[1] == 4)
			System.out.println("passed test 3, nearest neighbor");
		else
			System.out.println("failed test 3, nearest neighbor");

        //test 3.1
        int[] neighNums2 = {50, -1, 90, 37, -65, 10, -11};
        neighResult = nearestNeighbors(neighNums2);
        if( neighResult.length == 2 && neighResult[0] == 1 && neighResult[1] == 6)
            System.out.println("nearest neighbor: passed test 3.1");
        else
            System.out.println("nearest neighbor: failed test 3.1");

		//test 3.2
		int[] neighNums3 = {10, 2, 10, 2, -8, 10, 2};
		neighResult = nearestNeighbors(neighNums3);
		if( neighResult.length == 2 && neighResult[0] == 0 &&
				neighResult[1] == 2)
			System.out.println("nearest neighbor: passed test 3.2");
		else
			System.out.println("nearest neighbor: failed test 3.2");

		//test 3.3
		int[] neighNums4 = {0, 2, 4, 6, 8, 10, 12};
		neighResult = nearestNeighbors(neighNums4);
		if( neighResult.length == 2 && neighResult[0] == 0 &&
				neighResult[1] == 1)
			System.out.println("nearest neighbor: passed test 3.3");
		else
			System.out.println("nearest neighbor: failed test 3.3");
		//test 3.4
		int[] neighNums5 = {0, 2, 4, 6, 8, 10, 12};
		neighResult = nearestNeighbors(neighNums5);
		if( neighResult.length == 2 && neighResult[0] == 0 &&
				neighResult[1] == 1)
			System.out.println("nearest neighbor: passed test 3.4");
		else
			System.out.println("nearest neighbor: failed test 3.4");

        //test 4
        String[] sList = {"aaaaaaa", "aieou"};
        if( mostVowels(sList) == 0 )
            System.out.println("passed test 4, mostVowels");
        else
            System.out.println("failed test 4, mostVowels");
        //test 5
        sList = new String[] {"Staying", null, "", "moo", "SEqUOIA NAtIOnAl FOrEst", "!!!!>>+_)(*&^%$#@!>)))???\\///\n\n/n"};
        if( mostVowels(sList) == 4 )
        	System.out.println("passed test 5, mostVowels");
        else
        	System.out.println("failed test 5, mostVowels");
        //test 5.1
        String[] sList2 = {null, null, "overlord", "barbarossa", "market garden"};
        if( mostVowels(sList2) == 3 )
        	System.out.println("mostVowels: passed test 5.1");
        else
        	System.out.println("mostVowels: failed test 5.1");
        //test 5.2
        String[] sList3 = {null, null, null, "mtv"};
        if( mostVowels(sList3) == -1 )
        	System.out.println("mostVowels: passed test 5.2");
        else
        	System.out.println("mostVowels: failed test 5.2");
        //test 5.3
        String[] sList4 = {"fail", null, "random", "string", "verbose", "rawr"};
        if( mostVowels(sList4) == 4 )
        	System.out.println("mostVowels: passed test 5.3");
        else
        	System.out.println("mostVowels: failed test 5.3");
        //test 5.4
        String[] sList5 = { "aeiou", "oh", "AEIUO", "I bid thee", "adeiu.", "*waves*", "adeiuADEIUtotheAEIOUaeiOU;farewell2tehA.e.I.o.U..."};
        if( mostVowels(sList5) == 6 )
        	System.out.println("mostVowels: passed test 5.4");
        else
        	System.out.println("mostVowels: failed test 5.4");

		//test 6
		char[][] safe = { {'.', '.', '.'},
				{'q', '.', '.'},
				{'.', '.', 'q'}};
		if( queensAreSafe(safe) )
			System.out.println("passed test 6, queensAreSafe");
		else
			System.out.println("failed test 6, queensAreSafe");

		//test 7
		char[][] unsafe = { {'.', '.', '.', 'q'},
				{'.', '.', '.', '.'},
				{'.', '.', '.', '.'},
				{'q', '.', '.', '.'}};
		if( !queensAreSafe(unsafe) )
			System.out.println("passed test 7, queensAreSafe");
		else
			System.out.println("failed test 7, queensAreSafe");
		//test 7.1
		char[][] queenTest1 = { {'.', '.', '.', 'q'},
				{'.', 'q', '.', '.'},
				{'.', '.', 'q', '.'},
				{'.', '.', '.', '.'}};
		if( !queensAreSafe(queenTest1) )
			System.out.println("queensAreSafe: passed test 7.1");
		else
			System.out.println("queensAreSafe: failed test 7.1");

		//test 7.2
		char[][] queenTest2 = { {'.', '.', '.', '.'},
				{'q', '.', '.', '.'},
				{'.', 'q', '.', '.'},
				{'.', '.', '.', '.'}};
		if( !queensAreSafe(queenTest2) )
			System.out.println("queensAreSafe: passed test 7.2");
		else
			System.out.println("queensAreSafe: failed test 7.2");

		//test 7.3
		char[][] queenTest3 = { {'.', '.', '.', 'q', '.'},
				{'.', '.', '.', '.', '.'},
				{'q', '.', '.', '.', '.'},
				{'.', '.', 'q', '.', '.'},
				{'.', '.', '.', '.', 'q'}};
		if( queensAreSafe(queenTest3) )
			System.out.println("queensAreSafe: passed test 7.3");
		else
			System.out.println("queensAreSafe: failed test 7.3");

		//test 7.4
		char[][] queenTest4 = { {'.', '.', '.', 'q', '.'},
				{'.', '.', 'q', '.', '.'},
				{'q', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', 'q'}};
		if( !queensAreSafe(queenTest4) )
			System.out.println("queensAreSafe: passed test 7.4");
		else
			System.out.println("queensAreSafe: failed test 7.4");
		
		//test 7.5
		char[][] queenTest5 = { {'.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.'},
				{'.', '.', '.', '.', '.'}};
		if( queensAreSafe(queenTest5) )
			System.out.println("queensAreSafe: passed test 7.5");
		else
			System.out.println("queensAreSafe: failed test 7.5");
		
		//test 8
		int[][] mat1 = { {1, 2, 3, 4},
				{0, 0, 0, 0},
				{1, 2, 3, 10},
				{4, 3, 2, 1}};
		if( maxSum(mat1).equals("R2") )
			System.out.println("passed test 8, maxSum");
		else
			System.out.println("failed test 8, maxSum");
		//test 9
		mat1 = new int[][] { {-10, -20, -30, -40},
				{-2, -2, -200, -300},
				{-200, -2, -300, -100},
				{-200, -3, -200, -100}};
		if( maxSum(mat1).equals("C1") )
			System.out.println("passed test 9, maxSum");
		else
			System.out.println("failed test 9, maxSum");
		//test 10
		mat1 = new int[][] { {1,  2,  3,  4},
				{2,  0,  0, -1},
				{3, -2, -2, -1},
				{4,  2,  3,  1}};
		if( maxSum(mat1).equals("R0") )
			System.out.println("passed test 10, maxSum");
		else
			System.out.println("failed test 10, maxSum");
		//test 10.1
		int[][] mat11 = {{-1000, -20000, -30000,     400},
				{-1000,   -200,     30,     -40},
				{  -50,   -100,   -130,   -1700},
				{ -500,    200,    -20,    -721}};
		if( maxSum(mat11).equals("R3") )
			System.out.println("passed test 10.1, maxSum");
		else
			System.out.println("failed test 10.1, maxSum");
		//test 10.2
		int[][] mat2 = { {9, 2, 3, 4 , 1},
				{9, 9, 9, 9 , 0},
				{9, 9, 9, 10, -1},
				{9, 3, 2, 1 , 0}};
		if( maxSum(mat2).equals("R1") )
			System.out.println("passed test 10.2, maxSum");
		else
			System.out.println("failed test 10.2, maxSum");
		//test 10.3
		int[][] mat3 = { {0, 2, 3, 4 , 1, 1, 1, 1, 1,  1},
				{9, 9, 9, 9 , 0, 0, 0, 0, 0,-50},
				{9, 9, 9, 10,-1,-1,-1,-1,-1,-60},
				{0, 3, 2, 0 , 0,18,-9,-9, 0,  0}};
		if( maxSum(mat3).equals("C1") )
			System.out.println("passed test 10.3, maxSum");
		else
			System.out.println("failed test 10.3, maxSum");
		//test 10.4
		int[][] mat4 = { {0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0} };

		if( maxSum(mat4).equals("R0") )
			System.out.println("passed test 10.4, maxSum");
		else
			System.out.println("failed test 10.4, maxSum");

	}


	/* pre: mat != null
	   post: return true if mat is a square matrix, false otherwise
	*/
	private static boolean isSquare(char[][] mat) {
		assert mat != null : "Violation of precondition: isSquare";

		final int numRows = mat.length;
		int row = 0;
		boolean square = true;
		while( square && row < numRows ) {
			square = ( mat[row] != null) && (mat[row].length == numRows);
			row++;
		}
		return square;
	}
	

	/* pre: mat != null, valid != null
	   post: return true if all elements in mat are one of the characters in valid
	*/
	private static boolean onlyContains(char[][] mat, char[] valid)
	{	assert mat != null && valid != null : "Violation of precondition: onlyContains";

		int row = 0;
		int col;
		boolean correct = true;
		while( correct && row < mat.length) {
			col = 0;
			while(correct && col < mat[row].length) {
				correct = contains(valid, mat[row][col]);
				col++;
			}
			row++;
		}
		return correct;
	}


	/* pre: list != null
	   post: return true if c is in list
	*/
	private static boolean contains(char[] list, char c) {
		assert ( list != null ) : "Violation of precondition: contains";

		boolean found = false;
		int index = 0;
		while( !found && index < list.length) {
			found = list[index] == c;
			index++;
		}
		return found;
	}


	/*
	/* pre: mat != null, mat.length > 0
	 * post: return true if mat is rectangular
	 */
	private static boolean isRectangular(int[][] mat) {
		assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

		boolean correct = true;
		final int numCols = mat[0].length;
		int row = 0;
		while( correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == numCols);
			row++;
		}
		return correct;
	}
}
