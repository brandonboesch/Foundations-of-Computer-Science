//  A1.java


/*  Student information for assignment
 *
 *  On my honor, Zachary Tschirhart, this programming assignment is my own work.
 *
 *  EID:zst75
 *  email address: ztschir@gmail.com
 *  TA name: Xiuming 
 *  programming hours: 6
 *
 * Lines of Code: ~100
 *
 *
 */

 //slip days info
 /*
 Slip days used on this assignment: 0
 Slip days I think I have used for the term thus far: 0
 */


//imports

import java.util.ArrayList;

/**
 * A class with two static methods for assignment 1
 */
public class A1 {

    /**
     * main method contains some tests for methods <tt>matches</tt> and
     * <tt>findMajority</tt>.
     * @param  args  not used
     */
    public static void main(String[] args) {
        ArrayList<Integer> result;
        ArrayList<Integer> expected = new ArrayList<Integer>();

        //test 1, matches
        result = matches("aaaa", "aaa");
        expected.add(0);
        expected.add(1);
        printTestResults(result, expected, 1);

        //empty expected to get it ready for next test
        expected.clear();

        //test 2, matches
        result = matches("aaa", "aaaa");
        printTestResults(result, expected, 2);
        expected.clear();

        //test 3, matches
        result = matches("aabbaabbaa", "abb");
        expected.add(1);
        expected.add(5);
        printTestResults(result, expected, 3);
        expected.clear();

        //test 4, matches
        //Changed the expected list to correct answers. The starting number of 0 
        //for the array was not taken into account, so I decreased each value by 1.
        result = matches("babcabc", "abc");
        expected.add(1);
        expected.add(4);
        printTestResults(result, expected, 4);
        expected.clear();


        //test 5, matches
        result = matches("aaaabaaaa", "aaa");
        expected.add(0);
        expected.add(1);
        expected.add(5);
        expected.add(6);
        printTestResults(result, expected, 5);
        expected.clear();


        //test 6, matches
        result = matches("aaabaaabaaabaa", "aab");
        expected.add(1);
        expected.add(5);
        expected.add(9);
        printTestResults(result, expected, 6);
        expected.clear();
        
        //test 7 findMajority
        int majorityIndex = -1;
        int[] b = new int[]{2, 1, 3, 3};
        if( findMajority(b) == -1 )
            System.out.println("passed test 7, findMajority");
        else
            System.out.println("failed test 7, findMajority");

        //test 8 findMajority
        b[0] = 3;
        majorityIndex = findMajority(b);
        if( majorityIndex == 0 )
            System.out.println("passed test 8, findMajority");
        else
            System.out.println("failed test 8, findMajority");
        
        //test 9 findMajority
        b = new int[]{-1, -1, -1, 0, 0};
        majorityIndex = findMajority(b);
        if( majorityIndex == 0 )
            System.out.println("passed test 9, findMajority");
        else
            System.out.println("failed test 9, findMajority");

        /*CS307 STUDENTS: ADD YOUR TESTS HERE. At least 5 for matches and 5 for findMajority*/
        
        
        
        
//***********************Added Test to Matches*************************
        
        //test 10, matches
        result = matches("qwerty", "dvorak");
        printTestResults(result, expected, 10);
        expected.clear();
        
        //test 11, matches
        result = matches("2389730918392739", "3");
        expected.add(1);
        expected.add(5);
        expected.add(10);
        expected.add(14);
        printTestResults(result, expected, 11);
        expected.clear();
        
        //test 12, matches
        result = matches("can", "candycandy");
        printTestResults(result, expected, 12);
        expected.clear();
        
        //test 13, matches
        result = matches("santas little helper", "little");
        expected.add(7);
        printTestResults(result, expected, 13);
        expected.clear();
        
        //test 14, matches
        result = matches("the fox ran past the hound, thus staying alive. The fox will live another day.", "fox");
        expected.add(4);
        expected.add(52);
        printTestResults(result, expected, 14);
        expected.clear();
        
//***********************End of Added Test to Matches*****************
        
//************************Added Test to Majority**********************
        
        //test 15 findMajority
        b = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        majorityIndex = findMajority(b);
        if( majorityIndex == -1 )
            System.out.println("passed test 15, findMajority");
        else
            System.out.println("failed test 15, findMajority");
        
        //test 16 findMajority
        b = new int[]{5, 6, 7, 10, 10, 10, 9, 10, 11, 12, 10, 10, 10};
        majorityIndex = findMajority(b);
        if( majorityIndex == 3 )
            System.out.println("passed test 16, findMajority");
        else
            System.out.println("failed test 16, findMajority");
        
        //test 17 findMajority
        b = new int[]{100, 200, 300, 300, 200, 100};
        majorityIndex = findMajority(b);
        if( majorityIndex == -1 )
            System.out.println("passed test 17, findMajority");
        else
            System.out.println("failed test 17, findMajority");
        
        //test 18 findMajority
        b = new int[]{11, 21, 22, 100, 21, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 
        		21, 21, 21, 21};
        majorityIndex = findMajority(b);
        if( majorityIndex == 1 )
            System.out.println("passed test 18, findMajority");
        else
            System.out.println("failed test 18, findMajority");
        
        //test 19 findMajority
        b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 100, 
        		100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 
        		100, 100, 100, 100};
        majorityIndex = findMajority(b);
        if( majorityIndex == 17 )
            System.out.println("passed test 19, findMajority");
        else
            System.out.println("failed test 19, findMajority");
        
        
        
        
//********************End of Added Test to Majority********************
    }

    /**
     * Find all indices in <tt>source</tt> that are the start of a complete
     * match of <tt>target</tt>.
     * @param  source  != null, source.length() > 0
     * @param  target  != null, target.length() > 0
     * @return  an ArrayList that contains the indices in source that are the
     * start of a complete match of target. The indices are stored in
     * ascending order in the ArrayList.
     */
    public static ArrayList<Integer> matches(String source, String target) {
        // check preconditions
        assert (source != null) && (source.length() > 0)
        	&& (target != null) && (target.length() > 0): "matches: violation of precondition";

        ArrayList<Integer> result = new ArrayList<Integer>();
        
        
//*************************Added Code**********************************
        
        for (int wholeStringIndex = 0; 
        	 wholeStringIndex <= ((source.length() - 1) - (target.length() - 1)); wholeStringIndex++){
        	
        	int numberOfMatches = 0;
        	for (int partialStringIndex = 0; partialStringIndex < (target.length()); partialStringIndex++){
        		if (source.charAt(wholeStringIndex + partialStringIndex) == target.charAt(partialStringIndex)) 
        			numberOfMatches++;
        	}
        	if (numberOfMatches == target.length()) result.add(wholeStringIndex);
        }
        
//*********************End Added Code***********************************
        
        return result;
    }

    /**
     * Determine if there is a majority element in an array of ints.
     * The parameter <tt>list</tt> is not altered as a result of this 
     * method.
     * @param list != null
     * @return  the first index of the value of the majority element if it exists.
     * If a majority element does not exist return -1.
    */
    public static int findMajority(int[] list)
    {   assert ( list != null ) : "Violation of precondition: findMajority";
        
//****************************Added Code********************************
    	for(int listIndex = 0; listIndex < list.length; listIndex++){
    		int matchNumber = list[listIndex];
    		int matchCount = 0;
    		for (int matchIndex = 0; matchIndex < list.length; matchIndex++){
    			if (matchNumber == list[matchIndex]) matchCount++;
    		}
    		if (matchCount > (list.length / 2)) return listIndex;
    	}
//************************End of Added Code*****************************
        return -1;
    }

    /* helper method for showing results of tests
     * pre: result != null, expected != null
     */
    private static void printTestResults(ArrayList<Integer> result, ArrayList<Integer> expected, int testNum){
        System.out.println( "Expected results: " + expected );
        System.out.println( "Actual results:   " + result );
        if( result.equals( expected ) ) {
            System.out.println( "Passed test " + testNum + "." );
        }
        else {
            System.out.println( "Failed test " + testNum + "." );
        }
        System.out.println();
    }

}// end of class




//********************************************************************************************
//***************************Answers to ShortCodeExamples.java********************************
//********************************************************************************************

/* Number 1
expected answer: 5
actual answer: 5
explanation: this is just an order of operations problem that has the division 
come before addition. 17 is divided by 5 which equals 3 then it adds 5.
*/

/* Number 2
expected answer: 2
actual answer: 2
explanation: 31 % 5 is evaluated to a remainder of 1, then 31 % 6 is evaluated to 1. 
then they are added up to assign the variable 2.
*/

/* Number 3
expected answer: 5.4
actual answer: 5.4
explanation: this is exactly like number 1, except the values are doubles
*/

/* Number 4
expected answer: 5.4
actual answer: 5.4
explanation: 17 is divided by 5.0 which results in a 3.4 because the variable 
is initialized as a double, then the 2.0 is added.
*/

/* Number 5
expected answer: 5.0
actual answer: 5.0
explanation: because there wasn't a “.0” on the end of the division, Java recognized 
that is integers dividing then made it a double after rounding down, then continued to add 2.0.
*/

/* Number 6
expected answer: 5.4
actual answer: 5.4
explanation: Because the integer is being divided by a double, it keeps the number 
as a double, even though the 17 is just an integer.
*/

/* Number 7
expected answer: 2.0
actual answer: 2.0
explanation: even though the variable being assigned the value is a double, the 
only numbers are integers. The division happens first then the addition by order of operations. 
*/

/* Number 8
expected answer: 0.666667
actual answer: 0.6666666666666666
explanation: the division is a integer division so it comes out to 1, then is 
multiplied by 2.0 which turns it into a float/double, then divides by 3.
*/

/* Number 9
expected answer: 2.0
actual answer: 2.0
explanation: 5.0 % 3.0 returns a remainder of 2.0, and keeps the double number format.
*/

/* Number 10
expected answer: 2147483648
actual answer: -2147483648
explanation: integers only go up to 32-bits and when the two variables were added 
it was over the 32- bit capacity that the int variable could hold.
*/

/* Number 11
expected answer: 0.91
actual answer: 0.9100000000000001
explanation: Because the Java language uses Binary fractions and exponents to 
represent the floating-point arithmetic instead of actual decimals and decimal places. 
This causes slight miscalculations with floating points, then rounding up to what 
the variable can handle(64-bit in this case).
*/

/* Number 12
expected answer:  1.0E9
		   10.0
		   1.0E9
actual answer: 1.0E9
		10.00000012522831
		1.0E9
explanation: Slightly the same as Number 11 but also in this case, the double can't 
hold more then 64-bits of data so it rounds down to the nearest integer.
*/

/* Number 13
expected answer: 16
actual answer: 16
explanation: the multiplication is a first order of operations so the 3 is multiplied 
by 4, then the 3 is added to the 12 to assign the y13 a value of 16.
*/

/* Number 14
expected answer: 24
actual answer: 14
explanation: the addition is done first before the multiplication. 
*/

/* Number 15
expected answer: 7
actual answer: 7
explanation: each of these statements just bumps the value by a value of 1, so it 
equals 7 after 4 bumps of 1.
*/

/* Number 16
expected answer: 5
		6
		4 4 3
actual answer: 5
		6
		4 4 3
explanation: the first two are just bumped up by one, for each print statement. 
The last statement shows that x16_1 is bumped up one at the end of the statement but is added 
with the x16_2 to make 6 because the x16_1 hasn't been bumped yet. 
*/

/* Number 17
expected answer:  6
		   6
		   7
actual answer: 6
		6
		7
explanation: this again shows that ++ before the variable is added to the statement 
right away, but after the variable it adds 1 after the statement is finished.
*/

/* Number 18 
expected answer: variable x18 equals 5
actual answer: syntax error in eclipse
explanation: I am used to c++ programming so I would have thought the statement would 
have always been true because it assigns x18 as 5 in the if statement, but eclipse or 
Java seems to have caught that.
*/

/* Number 19
expected answer: false
		     true
		     true
actual answer: false
		true
		true
explanation: the first expression trys to compare memory locations, and of course 
they are not equal. The others are the correct ways to compare weather or not they 
are the same values. 
*/

/* Number 20
expected answer: 1
actual answer: syntax error
explanation: This syntax error exist because the code is trying to assign a double 
value to an int variable.
*/

/* Number 21
expected answer: 12
actual answer: 12.0
explanation: you can assign a integer to a double because a double can hold both floating 
point numbers and integers.
*/

/* Number 22 
expected answer: -1
actual answer: -1
explanation: use of typecasting, turning the double into an integer, so the double is 
rounded down to assign the value of -1.
*/

/* Number 23
expected answer: unknown, because I don't know what the Function Rint does.
actual answer: 2.0
		2.0
explanation: the rint function rounds the double value to the nearest even integer, 
	so 2.0 is displayed both times.
Extra question: this function is included in the standard library of java.lang, 
	which you don't need to import separately, just like the println function.
*/

/* Number 24
expected answer: -49
		     syntax error
actual answer: -49
		syntax error
explanation: the first one just finds the 8th value in the array which is 49. 
but the second statement is invalid because the array is not 1 places long. 
Because arrays start from 0 then go to n-1 of what was initialized.
*/

/* Number 25
expected answer: 4
actual answer: 4
explanation: first the value in the 3rd place of the array(value 11) is divided by 
the value in 2nd value of the array(value 4) which produces the remainder of 3. 
Then the list 25[] array reads the 4th value in the array(value 0). then the 1st value 
in the array is looked up which has a value of 4.
*/

/* Number 26
expected answer: syntax error
actual answer: syntax error
explanation: The new box26 object wasn't initialized. Needed to have it assigned 
new Rectangle() or another different overloaded function.
*/

/* Number 27
expected answer:  s261: ight is coming." culture
		   s262: “wor
actual answer: s261: ght is coming." culture.
		s262: work
explanation: the s261 string shows the substring from the 26th character in the original 
string until the end, skipping the “/” because that is only used to tell the compiler not 
to that quote as the end of the string. The second function starts at the 11th place then read 
to the 16th place, still ignoring the “/”.
*/

/* Number 28
expected answer: 5 -2
actual answer: 5 -2
explanation: the statement calls the mustang function with 2 integer varables, 
because it is a overloaded function. It then does the arithmetic and prints 5 and -2.
*/

/* Number 29
expected answer: 6 39
actual answer: 6 39
explanation: this calls the other overloaded mustang function, 
which passes 13 and does the arithmetic and prints 6 and 3 and also returns 6.
*/

/* Number 30
expected answer:  5 2
		   5 15
		   2 6
		   2 2
		   5 -3
		   2 2
		   2 4 5
actual answer:	  5 2
		 5 15
		 2 6
		 2 2
		 5 -3
		 2 2
		 2 4 5
explanation: first the statement passes 5 and 2 to bobcat function that does arithmetic and prints 5 and 2. 
Then it assigns d the return value of mustang with the value of 5 being passed which prints 5 and 15 and returns 5. 
then the bobcat function sets b to 2 and c to the return value of the hornedfrogs function. 
The hornedfrogs function is passed 2 then calls the mustang function and passing 2 to it. 
The mustang function prints 2 and 6 and retuns 2. the program is now back in the hornedfrogs function and prints 2 and 2. 
it then passes 2 and 2 to the other mustang function that takes two int varables which prints 5 and -3 and retuns nothing. 
It returns to the hornedfrogs function again and prints out the values 2 and 2 again because it was never passed anything else. 
The two values are then added up and returned to the origianl bobcat function and then prints out 2,4, and 5.
*/