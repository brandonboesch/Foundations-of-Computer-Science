/* MathMatrixTester.java
 * Mike Scott
 */

/*  Student information for assignment
 * 
 *  On our honor, Jesse Campos and Zachary Tschirhart, 
 *  this programming assignment is our own work.
 *
 *  Student #1: Jesse Campos
 *  Name #1:
 *  EID #1:
 *  email address #1:
 *  TA name #1: Xiuming
 *  Unique course ID #1: 54022
 *  programming hours #1: 8
 *  
 *  Student #2: Zachary Tschirhart
 *  Name #2:
 *  EID #2: zst75
 *  email address #2: ztschir@gmail.com
 *  TA name #2: Xiuming
 *  Unique course ID #2: 54022
 *  programming hours #2: 8
*/

//imports

/**
 * A class to run tests on the MathMatrix class
 *
 * @author Mike Scott(initial)
 * @version initial version
 */
public class MathMatrixTester
{

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args)
    {   int[][] data1 = { {1, 2, 3},
                       {2, 3, 4}};
        int[][] data2 = { {2, 1, 1},
                       {2, 3, 1}};
        int[][] e1;

        //test 1, default constructor
        MathMatrix mat1 = new MathMatrix();
        e1 = new int[][] {{0}};
        printTestResult( get2DArray(mat1), e1, 1, "default constructor");

        //tests 2 and 3, int[][] constructor, deep copy
        mat1 = new MathMatrix( data1 );
        data1[0][0] = 2;
        e1 = new int[][] { {2, 2, 3}, {2, 3, 4} };
        printTestResult( data1, e1, 2, "constructor with one parameter of type int[][]");
        e1 = new int[][] { {1, 2, 3}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 3, "constructor with one parameter of type int[][]");

        //tests 4 - 6, addition
        data1[0][0] = 1;
        mat1 = new MathMatrix(data1);
        MathMatrix mat2 = new MathMatrix(data2);
        MathMatrix mat3 = mat1.add(mat2);
        e1 = new int[][] { {1, 2, 3}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 4, "add method");
        e1 = new int[][] { {2, 1, 1}, {2, 3, 1} };
        printTestResult( get2DArray(mat2), e1, 5, "add method");
        e1 = new int[][] { {3, 3, 4}, {4, 6, 5} };
        printTestResult( get2DArray(mat3), e1, 6, "add method");

        //test 7, multiplication
        data2 = new int[][] { {1, 2}, {3, 1}, {2, 1} };
        mat2 = new MathMatrix(data2);
        mat1 = new MathMatrix(data1);
        mat3 = mat2.multiply(mat1);
        e1 = new int[][] { {5, 8, 11}, {5, 9, 13}, {4, 7, 10} };
        printTestResult( get2DArray(mat3), e1, 7, "multiply method");

        //test 8, toString()
        data1 = new int[][] {{10, 100, 101, -1000},
                          {1000, 10, 55, 4},
                          {1, -1, 4, 0}};
        mat1 = new MathMatrix(data1);
        String expected = "    10   100   101 -1000\n  1000    10    55     4\n     1    -1     4     0";
        if( mat1.toString().equals( expected ) )
            System.out.println("passed test 8, toString method.");
        else
            System.out.println("failed test 8, toString method.");
        
        //test 9, upperTriangular
        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {0, 0, 0, 12}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular())
            System.out.println("Passed test 9, upperTriangular method.");
        else
            System.out.println("Failed test 9, upperTriangular method.");
        
        //test 10, upperTriangular
        data1 = new int[][] {{1, 2, 3, 0}, {0, 3, 2, 3}, {0, 0, 4, -1}, {1, 2, 3, 4}};
        mat2 = new MathMatrix(data1);
        if( !mat2.isUpperTriangular())
            System.out.println("Passed test 10, upperTriangular method.");
        else
            System.out.println("Failed test 10, upperTriangular method.");      

        
        
/////////////////////StudentTests//////////////////////////////
        System.out.println("");
        data1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        mat1 = new MathMatrix(data1);
        printTestResult( get2DArray(mat1), data1, 1, "MathMatrix(int[][] mat)");
       
        data1 = new int[][]{{16, 2324, 354, 44856}, {57, 643, 75, 85}, {97, 10, 11, 90}};
        mat1 = new MathMatrix(data1);
        printTestResult( get2DArray(mat1), data1, 2, "MathMatrix(int[][] mat)");

        System.out.println("");
       
        data1 = new int[][]{{12, 12, 12, 12}, {12, 12, 12, 12}, {12, 12, 12, 12}};
        mat1 = new MathMatrix(3, 4, 12);
        printTestResult( get2DArray(mat1), data1, 1, "MathMatrix(int numRows, int numCols, int initialVal)");
       
        data1 = new int[][]{{12, 12, 12, 12, 12}};
        mat1 = new MathMatrix(1, 5, 12);
        printTestResult( get2DArray(mat1), data1, 2, "MathMatrix(int numRows, int numCols, int initialVal)");

        System.out.println("");

        data1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        mat1 = new MathMatrix(data1);
        mat1.changeElement(2, 3, 33);
        e1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 33}};
        printTestResult( get2DArray(mat1), e1, 1, "changeElement(int row, int col, int newValue)");
       
        mat1.changeElement(0, 1, 101);
        e1 = new int[][]{{1, 101, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 33}};
        printTestResult( get2DArray(mat1), e1, 2, "changeElement(int row, int col, int newValue)");

        System.out.println("");

        mat1 = new MathMatrix(13, 1, 2);
        if (mat1.numRows() == 13)
            System.out.println( "Passed test number 1, tests numRows().");
        else
            System.out.println( "Failed test number 1, tests numRows().");

        mat1 = new MathMatrix(130012, 15, 2);
        if (mat1.numRows() == 130012)
            System.out.println( "Passed test number 2, tests numRows().");
        else
            System.out.println( "Failed test number 2, tests numRows().");
       
        System.out.println("");

        mat1 = new MathMatrix(13, 1, 2);
        if (mat1.numCols() == 1)
            System.out.println( "Passed test number 1, tests numCols().");
        else
            System.out.println( "Failed test number 1, tests numCols().");

        mat1 = new MathMatrix(130012, 15, 2);
        if (mat1.numCols() == 15)
            System.out.println( "Passed test number 2, tests numCols().");
        else
            System.out.println( "Failed test number 2, tests numCols().");
       
        System.out.println("");

        data1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        mat1 = new MathMatrix(data1);
        if (mat1.getVal(2, 2) == 11)
            System.out.println( "Passed test number 1, tests getVal(int row, int col).");
        else
            System.out.println( "Failed test number 1, tests getVal(int row, int col).");
        if (mat1.getVal(0, 0) == 1)
            System.out.println( "Passed test number 2, tests getVal(int row, int col).");
        else
            System.out.println( "Failed test number 2, tests getVal(int row, int col).");

        System.out.println("");
       
        data1 = new int[][]{{1, 1, 1, 1}, {5, 4, 3, 2}, {2, 4, 6, 8}, {5, 5, 5, 5}, {10, 20, 30, 40}};
        data2 = new int[][]{{99, 99, 99, 99}, {95, 96, 97, 98}, {98, 96, 94, 92}, {95, 95, 95, 95}, {90, 80, 70, 60}};
        e1 = new int[][] {{100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}, {100, 100, 100, 100}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        printTestResult( get2DArray(mat1.add(mat2)), e1, 1, "add(MathMatrix rightHandSide)");
        printTestResult( get2DArray(mat2.add(mat1)), e1, 2, "add(MathMatrix rightHandSide)");
       
        data1 = new int[][]{{5, 2}, {2, 7}, {7, 7}, {1, 1}, {9, 3}};
        data2 = new int[][]{{1, 3}, {4, 6}, {1, 6}, {8, 5}, {3, 3}};
        e1 = new int[][]{{6, 5}, {6, 13}, {8, 13}, {9, 6}, {12, 6}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        printTestResult( get2DArray(mat1.add(mat2)), e1, 3, "add(MathMatrix rightHandSide)");

        System.out.println("");
       
        e1 = new int[][]{{4, -1}, {-2, 1}, {6, 1}, {-7, -4}, {6, 0}};
        printTestResult( get2DArray(mat1.subtract(mat2)), e1, 1, "subtract(MathMatrix rightHandSide)");
        e1 = new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        printTestResult( get2DArray(mat1.subtract(mat1)), e1, 2, "subtract(MathMatrix rightHandSide)");

        System.out.println("");
       
        data1 = new int[][] {{1, 2}, {2, 2}, {1, 1}};
        data2 = new int[][] {{3}, {1}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        e1 = new int[][]{{5}, {8}, {4}};
        printTestResult( get2DArray(mat1.multiply(mat2)), e1, 1, "multiply(MathMatrix rightHandSide)");
       
        data1 = new int[][] {{1}, {2}, {3}, {4}, {5}};
        data2 = new int[][] {{5, 5, 5, 5, 5}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        e1 = new int[][]{{5, 5, 5, 5, 5}, {10, 10, 10, 10, 10}, {15, 15, 15, 15, 15}, {20, 20, 20, 20, 20}, {25, 25, 25, 25, 25}};
        printTestResult( get2DArray(mat1.multiply(mat2)), e1, 2, "multiply(MathMatrix rightHandSide)");

        System.out.println("");
       
        e1 = new int[][]{{10}, {10}, {10}, {10}, {10}};
        e1 = new int[][]{{10, 10, 10, 10, 10}};
        mat2.scale(2);
        printTestResult( get2DArray(mat2), e1, 1, "scale(int factor)");
        mat2.scale(5);
        e1 = new int[][]{{50, 50, 50, 50, 50}};
        printTestResult( get2DArray(mat2), e1, 2, "scale(int factor)");
        mat2.scale(0);
        e1 = new int[][]{{0, 0, 0, 0, 0}};
        printTestResult( get2DArray(mat2), e1, 3, "scale(int factor)");

        System.out.println("");

        int[][] e2 = new int[][]{{0}, {0}, {0}, {0}, {0}};
        mat3 = mat2.getTranspose();
        if (equals(get2DArray(mat2),e1))    //makes sure mat2 was not altered by the getTranspose method.
            printTestResult( get2DArray(mat3), e2, 1, "getTranspose()");
        else
            System.out.println("Failed test number 1, tests getTranspose().");
       
        data1 = new int[][]{{3, 5, 6, 7, 8}, {2, 3, 54, 9, 5}};
        mat1 = new MathMatrix(data1);
        e1 = new int[][]{{3, 2}, {5, 3}, {6, 54}, {7, 9}, {8, 5}};
        mat2 = mat1.getTranspose();
        if (equals(get2DArray(mat1),data1))    //makes sure mat1 was not altered by the getTranspose method.
            printTestResult( get2DArray(mat2), e1, 2, "getTranspose()");
        else
            System.out.println("Failed test number 2, tests getTranspose().");
       
        System.out.println("");
       
        data1 = new int[][]{{3, 5, 6, 7, 8}, {2, 3, 54, 9, 5}};
        mat1 = new MathMatrix(data1);
        e1 = new int[][]{{3, 2}, {5, 3}, {6, 54}, {7, 9}, {8, 5}};
        mat1.transpose();
        if (!equals(get2DArray(mat1),data1))    //makes sure mat1 IS altered by the transpose method.
            printTestResult( get2DArray(mat1), e1, 1, "transpose()");
        else
            System.out.println("Failed test number 1, tests transpose().");
       
        data1 = new int[][]{{3, 5, 6, 7, 8}};
        mat1 = new MathMatrix(data1);
        e1 = new int[][]{{3}, {5}, {6}, {7}, {8}};
        mat1.transpose();
        if (!equals(get2DArray(mat1),data1))    //makes sure mat1 IS altered by the transpose method.
            printTestResult( get2DArray(mat1), e1, 2, "transpose()");
        else
            System.out.println("Failed test number 2, tests transpose().");

        System.out.println("");
       
        data1 = new int[][]{{3, 5, 6, 7, 8}};
        data2 = new int[][]{{3, 5, 6, 7, 8}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        if (mat1.equals(mat2))
            System.out.println("Passed test number 1, tests equals().");
        else
            System.out.println("Failed test number 1, tests equals().");

        data1 = new int[][]{{3, 5, 6, 5, 8}};
        data2 = new int[][]{{3, 5, 6, 5}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        if (!mat1.equals(mat2))
            System.out.println("Passed test number 2, tests equals().");
        else
            System.out.println("Failed test number 2, tests equals().");
       
        data1 = new int[500][1];
        for (int i = 0; i < 500; i++){
            data1[i][0] = (int)Math.random();
        }
        mat1 = new MathMatrix(data1);
        data2 = get2DArray(mat1);
        mat2 = new MathMatrix(data2);
        if (mat1.equals(mat2))
            System.out.println("Passed test number 3, tests equals().");
        else
            System.out.println("Failed test number 3, tests equals().");
        mat1.changeElement(0, 0, 2);
        mat2.changeElement(0, 0, 1);
        if (!mat1.equals(mat2))
            System.out.println("Passed test number 4, tests equals().");
        else
            System.out.println("Failed test number 4, tests equals().");

        System.out.println("");

        data1 = new int[][] {    {1, 11, 111, 1111},
                                  {-1, -11, -111, -11111111},
                                  {3, 6, 8, 10}};
        mat1 = new MathMatrix(data1);
        expected = "         1        11       111      1111\n        -1       -11      -111 -11111111\n         3         6         8        10";
        if( mat1.toString().equals( expected ) )
            System.out.println("Passed test number 1, tests toString().");
        else
            System.out.println("Failed test number 1, tests toString().");

        data1 = new int[][] {    {5, 12377, 23, 643}};
        mat1 = new MathMatrix(data1);
        expected = "     5 12377    23   643";
        if( mat1.toString().equals( expected ) )
            System.out.println("Passed test number 2, tests toString().");
        else
            System.out.println("Failed test number 2, tests toString().");

        data1 = new int[][] {{1}, {1}, {1}, {1}, {1}, {467}};
        mat1 = new MathMatrix(data1);
        expected = "   1\n   1\n   1\n   1\n   1\n 467";
        if( mat1.toString().equals( expected ) )
            System.out.println("Passed test number 3, tests toString().");
        else
            System.out.println("Failed test number 3, tests toString().");

        System.out.println("");
       
        data1 = new int[][] {    {1, 2, 3, 0},
                                {0, 3, 2, 3},
                                {0, -1, 4, -1},
                                {0, 0, 0, 12}};
        mat1 = new MathMatrix(data1);
        if( !mat1.isUpperTriangular())
            System.out.println("Passed test number 1, tests isUpperTriangular().");
        else
            System.out.println("Failed test number 1, tests isUpperTriangular().");

        data1 = new int[][] {    {0, 0, 0, 0},
                                {0, 0, 0, 0},
                                {0, -1, 0, 0},
                                {0, 0, 0, 0}};
        mat1 = new MathMatrix(data1);
        if( !mat1.isUpperTriangular())
            System.out.println("Passed test number 2, tests isUpperTriangular().");
        else
            System.out.println("Failed test number 2, tests isUpperTriangular().");

        data1 = new int[][] {    {5, 6, -10},
                                {0, 3, 6},
                                {0, 0, 34}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular())
            System.out.println("Passed test number 3, tests isUpperTriangular().");
        else
            System.out.println("Failed test number 3, tests isUpperTriangular().");

        data1 = new int[][] {    {5, 6}, 
                                {-1, 90234}};
        mat1 = new MathMatrix(data1);
        if( !mat1.isUpperTriangular())
            System.out.println("Passed test number 4, tests isUpperTriangular().");
        else
            System.out.println("Failed test number 4, tests isUpperTriangular().");
       

        data1 = new int[][] {    {5}};
        mat1 = new MathMatrix(data1);
        if( mat1.isUpperTriangular())
            System.out.println("Passed test number 5, tests isUpperTriangular().");
        else
            System.out.println("Failed test number 5, tests isUpperTriangular().");
        

    }
    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat)
    {     String result = equals(data1, data2) ? "Passed" : "Failed";
        System.out.print( result + " ");
        System.out.println( "test number " + testNum + ", tests " + testingWhat + ".");
    }

    // pre: m != null, m is at least 1 by 1 in size
    private static int[][] get2DArray(MathMatrix m)
    {   //check precondition
        assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
                : "Violation of precondition: get2DArray";

        int[][] result = new int[m.numRows()][m.numCols()];
        for(int r = 0; r < result.length; r++)
        {   for(int c = 0; c < result[0].length; c++)
            {   result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2)
    {   //check precondition
        assert ( data1 != null ) && ( data1.length > 0 )
               && ( data1[0].length > 0 ) && rectangularMatrix( data1 )
               &&  ( data2 != null ) && ( data2.length > 0 )
               && ( data2[0].length > 0 ) && rectangularMatrix( data2 )
                : "Violation of precondition: get2DArray";

        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        int col;
        while( result && row < data1.length )
        {   col = 0;
            while( result && col < data1[0].length )
            {   result = ( data1[row][col] == data2[row][col] );
                col++;
            }
            row++;
        }

        return result;
    }


    // private method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat )
    {   //check preconditions
        assert (mat != null) && (mat.length > 0) && (mat[0].length > 0)
               : "Violation of precondition : rectangularMatrix";

        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length )
        {   isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }

    /*
     * CS307 Students. Put your experiment results and
     * answers to questions here.
     */
}

