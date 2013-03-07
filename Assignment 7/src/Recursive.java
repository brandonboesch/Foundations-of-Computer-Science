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
 * 	Slip days used on this assignment: 1
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

//imports

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Recursive
{	
	/**
	 * McCarthy's 91 function.  
	 * <br>pre: n > 0
	 * @param n
	 * @return
	 */
	public int mcCarthy91(int n){
		assert n > 0 : "Failed Precondition: mc91";
		
		if(n > 100) n = n - 10;
		else if (n <= 100){
			n = mcCarthy91(mcCarthy91(n + 11));
		}
		
		return n; //dummy return, replace as necessary
	}

    /* pre: ch is a digit '0' through '9'
     * post: return the characters associated with this digit on a phone keypad
     */
    private String digitLetters(char ch)
    {   assert ('0' <= ch) && (ch <= '9') : "Failed precondition: digitLetters";
        String[] letters = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};
        int index = (int)(ch - '0');
        return letters[index];
    }

    /*  pre: number != null
        post: see tips section of assigment handout
    */
    public ArrayList<String> listMnemonics(String number)
    {   assert number != null : "Failed precondition: listMnemonics";
    	ArrayList<String> result = new ArrayList<String>();
    	recursiveMnemonics(result, "", number);
		return result;
    }

    private void recursiveMnemonics(ArrayList<String> mnemonics, String mnemonicSoFar, String digitsLeft)
    {
    	String number = digitLetters(digitsLeft.charAt(0));
    	if(digitsLeft.length() == 1){
    		for(int index = 0; index < number.length(); index++){
    			mnemonics.add(mnemonicSoFar + number.charAt(index));
    		}
    	}
    	else{
    		for(int index = 0; index < number.length(); index++){
    			recursiveMnemonics(mnemonics, mnemonicSoFar + number.charAt(index), digitsLeft.substring(1));
    		}
    	}    		
    }

    /*  pre: n >= 0
        post: Returns a String that represents N in binary.
        All chars in returned String are '1's or '0's.
        Most significant digit is at position 0
    */
    public String getBinary(int n)
    {   assert n >= 0 : "Failed precondition: getBinary";
    	String binary = new String();
    	if(n <= 1)
    		return "" + n;
    	else
    		binary = getBinary( n/2 );
    		
    	return   binary + n%2 ;
    }

    /*  pre: target != null
        post: returns a String that is the reverse of target
    */
    public String revString(String target)
    {   assert target != null : "Failed precondition: revString";
    	if ( target.length() == 1)
    		return target;
    	else
    	{
    		return revString(target.substring(1)) + target.charAt(0);
    	}
   }
   
    
    /**
     * Determine the sum of digits in n.
     * @param n >= 0
     * @return the sume of the digits in n.
     */
    public int sumOfDigits(int n){
        assert n >= 0 : "Failed precondition: sumOfDigits";
        
        if ( n < 10 )
        	return n;
        else
        	return n % 10 + sumOfDigits(n / 10);
    }

    /**
    * Determine if water at a given point on a map can flow off the map.
    * <br>pre: map != null, map.length > 0, 
    * map is a rectangular matrix, 0 <= row < map.length, 0 <= col < map[0].length
    * post: return true if a drop of water starting at the location 
    * specified by row, column can reach the edge of the map, false otherwise.
  � * @param map The elevations of a section of a map.
  	* @param row The starting row of a drop of water.
  	* @param col The starting column of a drop of water.
    */
    public boolean canFlowOffMap(int[][] map, int row, int col){
    	assert map != null && map.length > 0 && isRectangular(map) && inbounds(row, col, map)
    	: "Failed precondition: canFlowOffMap";
    	if ( row == 0 || row == map.length-1 || col == 0 || col == map[0].length-1){
    		return true;
    	}
    	if ( row+1 < map.length && map[row+1][col] >= map[row][col] 
    	                        && row-1 >= 0 && map[row-1][col] >= map[row][col] 
    	                        && col+1 < map[0].length && map[row][col+1] >= map[row][col] 
    	                        && col-1 >= 0 && map[row][col-1] >= map[row][col]){
    		return false;
    	}
    	if ( row + 1 < map.length && map[row + 1][col] < map[row][col] ){
    		if(canFlowOffMap(map, row+1, col)){
    			return true;
    		}
    	}
    	if ( row-1 >= 0 && map[row-1][col] < map[row][col] ){
    		if(canFlowOffMap(map, row-1, col)){
    			return true;
    		}
    	}
    	if ( col+1 < map[0].length && map[row][col+1] < map[row][col] ){
    		if(canFlowOffMap(map, row, col+1)){
    			return true;
    		}
    	}
    	if ( col-1 >= 0 && map[row][col-1] < map[row][col] ){
    		if(canFlowOffMap(map, row, col-1)){      
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Create a DrawingPanel and place Sierpinski triangles in it. The lower
     * left corner should be 20 pixels from the left edge of the window
     * and 20 pixels from the bottom of the window.
     * @param windowSize > 20
     * @param minSideLength > 4
     * @param startingSideLength > minSideLength
     */
    public void drawTriangles(int windowSize, int minSideLength, int startingSideLength){
        DrawingPanel p = new DrawingPanel(windowSize, windowSize);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLUE);
        drawTriangles(minSideLength, startingSideLength, 20, windowSize - 20, g);
    }

    public void drawTriangles(int minSideLength, double currentSideLength, double x1, double y1, Graphics g){
    	if ( currentSideLength > minSideLength ){
    		g.drawLine((int)x1, (int)y1, (int)x1 + (int)currentSideLength, (int)y1 );
    		g.drawLine((int)x1 + (int)currentSideLength, (int)y1, (int)x1+((int)(currentSideLength / 2)) , (int)y1 - (int)((Math.sqrt(3)/2)*currentSideLength));
    		g.drawLine((int)x1, (int)y1, (int)x1+((int)(currentSideLength / 2)), (int)y1 - (int)((Math.sqrt(3)/2)*currentSideLength));
    		
    		drawTriangles(minSideLength, currentSideLength / 2, x1, y1, g);
    		drawTriangles(minSideLength, currentSideLength / 2,  x1 + (currentSideLength / 4), 
    				y1 - (Math.sqrt(3) * currentSideLength / 4 ), g);
    		drawTriangles(minSideLength, currentSideLength / 2,  x1 + (currentSideLength / 2), y1, g);
    	}
    }

    /*
     * pre: mat != null, 
     */
    private boolean inbounds(int r, int c, int[][] mat){
    	assert mat != null : "Failed precondition: inbounds";
    	return r >= 0 && r < mat.length && mat[r] != null && c >= 0 && c < mat[r].length;
    }
    
	/* pre: mat != null, mat.length > 0
	 * post: return true if mat is rectangular
	 */
	private static boolean isRectangular(int[][] mat)
	{	assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

		boolean correct = true;
		final int numCols = mat[0].length;
		int row = 0;
		while( correct && row < mat.length)
		{	correct = (mat[row] != null) && (mat[row].length == numCols);
			row++;
		}
		return correct;
	}

    /**
     * Draw a Sierpinski Carpet.
     * @param size the size in pixels of the window
     * @param limit the smallest size of a sqauer in the carpet.
     */
    public void drawCarpet(int size, int limit){
        DrawingPanel p = new DrawingPanel(size, size);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,size,size);
        g.setColor(Color.WHITE);
        drawSquares(g, size, limit, 0, 0);
    }
    
    /**
     * Draw the individual squares of the carpet.
     * @param g The Graphics object to use to fill rectangles
     * @param size the size of the current square
     * @param limit the smallest allowable size of squares
     * @param x the x coordinate of the upper left corner of the current square
     * @param y the y coordinate of the upper left corner of the current square
     */
    private static void drawSquares(Graphics g, int size, int limit, double x, double y){
    	if( size > limit){
    		g.fillRect((int)(x+(size/3)), (int)(y+(size/3)), (int)(size/3), (int)(size/3));
    		for(int index = 0; index < 3; index++){
    			drawSquares(g, size/3, limit,x+(index*size/3), y);
    			drawSquares(g, size/3, limit,x, y+(index*size/3));
    			drawSquares(g, size/3, limit,x+(index*size/3), y+(index*size/3));
    			drawSquares(g, size/3, limit,x+((index+1)*size/3), y+(index*size/3));
    			drawSquares(g, size/3, limit,x+(index*size/3), y+((index+1)*size/3));
    		
    		}
    	}

    }
}

