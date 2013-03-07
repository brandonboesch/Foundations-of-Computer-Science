//MathMatrix.java. Mike Scott

/*  Student information for assignment
 * 
 *  On our honor, Jesse Campos and Zachary Tschirhart, 
 *  this programming assignment is our own work.
 *
 *  Student #1: Jesse Campos
 *  Name #1: 
 *  EID #1: _____________
 *  email address #1: ____________
 *  TA name #1: Xiuming 
 *  Unique course ID #1: 54022
 *  programming hours #1: 8 (if this is ok with you?)
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
 * A class that models mathematical matrices for linear algebra
 *
 * @author
 * @version Skeleton file for students
 */


public class MathMatrix
{
	private int[][] matrix;

    /**
     * default constructor.
     * <br>pre: none
     * <br>post: create a 1 by 1 matrix that contains 0
     */
    public MathMatrix(){
        matrix = new int[1][1];
    }


    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat){
        assert ( mat != null ) && ( mat.length > 0 ) && ( mat[0].length > 0 )
                && ( rectangularMatrix(mat) ) : "Violation of precondition: int[][] Matrix constructor";
                
        matrix = new int[mat.length][mat[0].length];
        for(int row = 0; row < mat.length; row++){
        	for(int column = 0; column < mat[0].length; column++){
        		matrix[row][column] = mat[row][column];
        	}
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal){
    	matrix = new int[numRows][numCols];
        for(int row = 0; row < numRows; row++){
        	for(int column = 0; column < numCols; column++){
        		matrix[row][column] = initialVal;
        	}
        }
    }


    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    
    public void changeElement(int row, int col, int newValue){
        assert (row >= 0) && (col >= 0) && (row < numRows()) 
        && (col < numCols()) : "Violation of Precondition: method changeElemnt";
    	matrix[row][col] = newValue;
    }


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows(){
        return matrix.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols(){
        return matrix[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col){
        assert (row >= 0) : "1";
        assert (col >= 0) : "2";
        assert (row < numRows()) : "3";
        assert (col < numCols()): "Violation of Precondition: method getVal";
        return matrix[row][col];
    }


   /**
    * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
    * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix add(MathMatrix rightHandSide){
	
    	assert (rightHandSide.numRows() == numRows()) && 
    	(rightHandSide.numCols() == numCols()) : "Violation of Precondition: method add";
        
    	MathMatrix matrix2 = new MathMatrix(matrix.length, matrix[0].length, 0);
        for ( int row = 0; row < matrix.length; row++)
        {
        	for ( int col = 0; col < matrix[0].length; col++)
        	{
        		matrix2.changeElement(row, col, matrix[row][col] + rightHandSide.getVal(row, col));
        	}
        }
        return matrix2; //this return can be altered or deleted
    }
   /**
    * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix subtract(MathMatrix rightHandSide){
    	assert (rightHandSide.numRows() == numRows()) && (rightHandSide.numCols() == numCols()) : "Violation of Precondition: method subtract";
        MathMatrix matrix2 = new MathMatrix(matrix.length, matrix[0].length, 0);
        
        for ( int row = 0; row < matrix.length; row++)
        {
        	for ( int col = 0; col < matrix[0].length; col++)
        	{
        		matrix2.changeElement(row, col, matrix[row][col] - rightHandSide.getVal(row, col));
        	}
        }
        return matrix2; //this return can be altered or deleted
    }


   /**
    * implements matrix multiplication, (this MathMatrix) * rightHandSide.
    * <br>pre: rightHandSide.numRows() = numCols()
    * <br>post: This method should not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numCols()
    * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
    */
    public MathMatrix multiply(MathMatrix rightHandSide){
    	assert (rightHandSide.numRows() == numCols()) : "Violation of Precondition: method multiply";
        MathMatrix matrix3 = new MathMatrix(matrix.length, rightHandSide.numCols(), 0);
        
        
        for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < rightHandSide.numCols(); col++){
        		int count = 0;
        		for(int bump = 0; bump < matrix[0].length; bump++){
        			count += matrix[row][bump] * rightHandSide.getVal(bump, col);
        		}
        		matrix3.changeElement(row, col, count);
        	}
        }
    	
    	return matrix3; //this return can be altered or deleted
    } 


   /**
    * Multiply all elements of this MathMatrix by factor.
    * <br>pre: none
    * <br>post: all elements in this matrix have been multiplied by factor. 
    * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
    * for all valid r and c.
    * @param factor the value to multipy every cell in this Matrix by.
    */
    public void scale(int factor){
        
    	for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < matrix[0].length; col++){
        		matrix[row][col] *= factor;
        	}
        }
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose(){
    	MathMatrix transMatrix = new MathMatrix(matrix[0].length, matrix.length, 0);
        for (int row = 0; row < matrix.length; row++)
        {
        	for (int col = 0; col < matrix[0].length; col++)
        	{
        		transMatrix.changeElement(col, row, matrix[row][col]);
        	}
        }
        return transMatrix;
    }


    /**
     * mutator: transpose this MathMatrix.
     * <br>pre: none
     * <br>post: numRows() = old numCols(), numCols() = old numRows(), all elements have been transposed
     */
    public void transpose(){
    	MathMatrix trans2Matrix = this.getTranspose();
        int[][] newMatrix = new int[trans2Matrix.numRows()][trans2Matrix.numCols()];
    	for (int row = 0; row < trans2Matrix.numRows(); row++)
        {
        	for (int col = 0; col < trans2Matrix.numCols(); col++)
        	{
        		newMatrix[row][col] = trans2Matrix.getVal(row, col);
        	}
        }  
    	matrix = newMatrix;
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
        boolean result = true;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            
        	MathMatrix otherMatrix = (MathMatrix)rightHandSide;
        	if(otherMatrix.numRows() != matrix.length || otherMatrix.numCols() != matrix[0].length){
        		result = false;
        		
        	}
            for (int row = 0; result && row < matrix.length; row++)
            {
            	for (int col = 0; result && col < matrix[0].length; col++)
            	{
            		if (matrix[row][col] != otherMatrix.getVal(row, col))
            		{
            			result = false;
            			break;
            		}
            	}
            }
            
        }
        return result;
    }
    

    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString(){
        StringBuffer result = new StringBuffer();
        int spaces = 0;
       
        for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < matrix[0].length; col++){
        		int test = ("" + matrix[row][col]).length();
        		if(test > spaces) spaces = test;
        	}
        }
        
        
        for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < matrix[0].length; col++){
        		int length = ("" + matrix[row][col]).length();
        		result.append(" ");
        		for(int i = 0; i < spaces-length; i++) result.append(" ");
        		result.append(matrix[row][col]);
        	}
        	if(row < matrix.length-1) result.append("\n");
        }
        return result.toString(); 
        
     
        
    }
    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular(){
    	assert (matrix[0].length == matrix.length): "Violation of Precondition: method isUpperTriangular";
    	int zeros = 0;
        int startingRow;
        boolean result = true;
        
        if(matrix.length == 1 && matrix[0].length == 1) return true;        
        
        if(matrix[0].length % 2 > 0) startingRow = matrix[0].length/2;
        else startingRow = (matrix[0].length/2) - 1;

    	for (;startingRow < matrix.length; startingRow++){
    		for(int column = 0; column <= zeros; column++){
    			if(matrix[startingRow][column] != 0){
    				result = false;
    				break;
    			}
    		
    		}
    		if(!result)break;
        	zeros++;
        }
        return result;  	
    	
    }
    private boolean rectangularMatrix( int[][] mat ){
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length )
        {   isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }
}


