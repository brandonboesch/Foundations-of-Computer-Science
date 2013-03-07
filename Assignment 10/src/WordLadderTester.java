 /*  Student information for assignment
  *
  *  Student #1 Information
  *  Name #1: Jesse Campos
  *  EID #1: JPC639
  *  email address #1: jesse.campos@mail.utexas.edu
  *  TA name #1: xiuming
  *  programming hours #1: 10
  *
  *  Student #2 Information
  *  Name #2: Zachary Tschirhart
  *  EID #2: ZST75
  *  email address #2: ztschir@gmail.com
  *  TA name #2: xiuming
  */

/*
 * Results of experiments and answers to questions from
 * questions.txt:

Answer the following questions for assignment 10.


Use your WordLadderFinder and the fives.txt file to check for ladders with the following starting and ending words. Use both methods for each set of words. Use the Stopwatch class to record the time it takes to find a ladder.

starting word	ending word
smart		brain
LinearSearch = too long
BinarySearch = 4.200352906 seconds

devil		angel
LinearSearch = too long
BinarySearch = 0.769061108 seconds

money 		greed
LinearSearch = too long
BinarySearch = 11.961669438 seconds

quiet		noise
LinearSearch = too long
BinarySearch = 1.418766327

quiet		quite
LinearSearch = 0.137598941 seconds
BinarySearch = 0.017606142 seconds

trees		angel
LinearSearch = too long
BinarySearch = too long!

xerox		zilch
LinearSearch = 0.003514555 seconds  nothing existed
BinarySearch = 0.006558576 seconds. nothing existed

zebra		lions
LinearSearch = 0.003140128 seconds. nothing existed
BinarySearch = 0.004225534 seconds. nothing existed

cools		heats
LinearSearch = too long
BinarySearch = 0.002214504 seconds. nothing existed

blast		mends
LinearSearch = 54.483552169 seconds
BinarySearch = 0.188133658 seconds

total		blank
LinearSearch = too long
BinarySearch = Too long.

lives		death
LinearSearch = too long
BinarySearch = too long

smile		frown
LinearSearch = too long
BinarySearch = too long

For each pair and each method (linear search for words one letter different and binary search for words one letter different) state the time it took to find the ladder or to prove no ladder existed and the length of the resulting ladder. If a ladder actual exists list the ladder

In general is breadth first with linear search faster or breadth first with binary search faster? Binary Search!!!!! By ALOTTTTT!!!!

At what size word list do you think breadth first with binary search would be faster than breadth first with linear? Possibly all.
 * 
 * 
 */

import java.util.ArrayList;

public class WordLadderTester
{   public void runTests()
    {   System.out.println("\nTest Harness");
        String[] wordList = {"bears", "beats", "crazy", "humid", "scuba", "sears",
                "smart", "stars", "start", "tumid"};
        String[] e1 = {"smart", "start", "stars", "sears", "bears", "beats"};
        String[] e2 = {"humid", "tumid", "timid"};
        String[] e3 = {"bimid", "timid"};
        String[] e5 = {"bears", "sears", "stars", "start"};
        WordLadderFinder f = new WordLadderFinder(wordList);
        ArrayList<String> actual;
        ArrayList<String> expected;

        //test 1
        actual = f.breadthFirstLinearSearch("smart", "beats");
        expected = buildExpected(e1);
        showTestResults(actual, expected, 1);

        //test 2
        actual = f.breadthFirstLinearSearch("humid", "timid");
        expected = buildExpected( e2 );
        showTestResults(actual, expected, 2);

        //test 3
        actual = f.breadthFirstLinearSearch("bimid", "timid");
        expected = buildExpected( e3 );
        showTestResults(actual, expected, 3);

        //test 4
        actual = f.breadthFirstLinearSearch("crazy", "scuba");
        expected.clear();
        showTestResults(actual, expected, 4);

        //test 5
        actual = f.breadthFirstLinearSearch("bears", "start");
        expected = buildExpected( e5 );
        showTestResults(actual, expected, 5);

        //test 6
        actual = f.breadthFirstLinearSearch("helps", "place");
        expected.clear();
        showTestResults(actual, expected, 6);
    }

    private ArrayList<String> buildExpected(String[] words)
    {   ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < words.length; i++)
            result.add( words[i] );
        return result;
    }

    private void showTestResults( ArrayList<String> actual, ArrayList<String> expected, int testNum )
    {   if( actual.equals(expected) )
            System.out.println( "Passed test " + testNum + ".");
        else
            System.out.println( "Failed test " + testNum + ".");
    }
}
