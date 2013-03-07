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
  *
  *
  * Total Lines of Code for Assignment(all completed classes): 300
  */

 // slip days info Student 1
 /*
 Slip days used on this assignment: 1
 Slip days I think I have used for the term thus far: 2
 */

  // slip days info Student 2
  /*
  Slip days used on this assignment: 1
  Slip days I think I have used for the term thus far: 2
 */

import java.util.ArrayList;

public class WordLadderFinder
{
	private ArrayList<String> words;
	private ArrayList<String> used;
    /**
     * create a Word Ladder Finder using the specified word list
     * @param wordList != null, wordList.length > 0,
     * no elements of wordList are null,
     * all elements of wordList are the same length,
     * elements of wordList are sorted in ascending order
     */
    public WordLadderFinder(String[] wordList)
    {
    	assert (wordList.length > 0 && wordList != null): "Violation of precondition: WordLadderFinder";
    	words = new ArrayList<String>();
    	used = new ArrayList<String>();
    	for(int index = 0; index < wordList.length; index++ ){
    		words.add(wordList[index]);
    	}
    }

    /**
     * find a word ladder using the breadth first search and a linear search for words one letter different
     *
     * @param start != null, start.length() == lengthOfWords()
     * @param end != null, end.length() == lengthOfWords()
     * @return an ArrayList of size() 0 if no ladder exists between start and end, otherwise return an ArrayList that
     * contains the words of a minimum length ladder between start and end. start is at position 0, end is at
     * position size() - 1, and all other entries are in the proper order
     */
    public ArrayList<String> breadthFirstLinearSearch(String start, String end)
    {   
    	used.clear();
    	boolean isEnd = false;
    	Stack newStack = new Stack();
    	Queue<Stack> newQueue = new Queue<Stack>();
    	Stack tempStack = new Stack();
    	ArrayList<String> result = new ArrayList();
    	newStack.push(start);
    	newQueue.enqueue(newStack);    	
    	used.add(start);
    	while(!newQueue.isEmpty() && !isEnd){

    		tempStack = newQueue.dequeue();
    		for(int index = 0; index < words.size(); index++){
    			if(testWord(tempStack,end)){

    				Stack addedStack = tempStack;
    				addedStack.push(end);
    				result = this.toArray(addedStack);
    				isEnd = true;
    				break;
    			}
    			if(testWord(tempStack,words.get(index))){

    				Stack addedStack = (Stack) tempStack.getCopy();
    				addedStack.push(words.get(index));
    				newQueue.enqueue(addedStack);
    				used.add(words.get(index));
    			}
    		}
    	}
    	return result;
    }
    
    private ArrayList<String> toArray(Stack item){
		ArrayList<String> newArray = new ArrayList();
    	Stack tempStack = new Stack();
    	while(!item.isEmpty()){
    		tempStack.push(item.pop());
    	}
		while(!tempStack.isEmpty()){
			newArray.add((String) tempStack.pop());
		}
    	return newArray;
    }

    private boolean testWord(Stack tester, String theString){
    	int count = 0;
    	for(int index = 0; index < used.size(); index++){
    		if(used.get(index).equals(theString)){
    			return false;
    		}
    	}
		for(int index = 0; index < theString.length(); index++){
			if(((String)tester.top()).charAt(index) != theString.charAt(index)){
				count++;
				if(count > 1){
					return false;
				}
			}
		}
    	return true;
    }
    

    /**
     * find a word ladder using a depth first search
     *
     * @param start != null, start.length() == lengthOfWords()
     * @param end != null, end.length() == lengthOfWords()
     * @return an ArrayList of size() 0 if no ladder exists between start and end, otherwise return an ArrayList that
     * contains the words of a minimum length ladder between start and end. start is at position 0, end is at
     * position size() - 1, and all other entries are in the proper order
     */
    public ArrayList<String> depthFirst(String start, String end)
    {   // You are not required to do this method. It is an extra option to explore if you would like.
		return new ArrayList<String>();
    }

    /**
     * find a word ladder using the breadth first search and a binary search for words one letter different
     *
     * @param start != null, start.length() == lengthOfWords()
     * @param end != null, end.length() == lengthOfWords()
     * @return an ArrayList of size() 0 if no ladder exists between start and end, otherwise return an ArrayList that
     * contains the words of a minimum length ladder between start and end. start is at position 0, end is at
     * position size() - 1, and all other entries are in the proper order
     */
    public ArrayList<String> breadthFirstBinarySearch(String start, String end)
    {    
    	used.clear();
    	ArrayList<String> combos = new ArrayList<String>();
    	ArrayList<String> result = new ArrayList<String>();
    	Stack<String> wordStack = new Stack();
    	Stack<String> temp = new Stack();
    	Queue<Stack> wordQueue = new Queue();
    	boolean found = false;
    	
    	wordStack.push(start);
    	wordQueue.enqueue(wordStack);
    	used.add(start);
    	
    	if(testWord(wordStack,end)){
			wordStack.push(end);
			found = true;
			result = toArray(wordStack);
    	}
    	
    	while(!found && !wordQueue.isEmpty()){
    		wordStack = wordQueue.dequeue();
    		combos = combinationFinder(wordStack.top());
    		combos = wordListFinder(combos);
    		for(int index = 0; index < combos.size(); index++){
    			temp = (Stack<String>) wordStack.getCopy();
    			if(testWord(temp, combos.get(index))){
    				temp.push(combos.get(index));
    				used.add(combos.get(index));
    			}
    			wordQueue.enqueue(temp);
    			if(temp.top().equals(end) || testWord(temp,end)){
    				temp.push(end);
    				found = true;
    				result = toArray(temp);
    				break;
    			}
    		}
    	}
    	return result;
    }
    
    private ArrayList<String> combinationFinder(String startWord){
    	ArrayList<String> holder = new ArrayList<String>();
    	String temp = new String();
    	
    	for(int begin = 0; begin < startWord.length(); begin++){
    		temp = startWord;
    		for(char start = 'a'; start <= 'z'; start++){
    			if(startWord.charAt(begin) != start){
    				holder.add(temp.substring(0, begin) + start + temp.substring(begin+1, startWord.length()));
    			}
    		}
    	}
    	return holder;
    }
    
    private ArrayList<String> wordListFinder(ArrayList<String> listOfWords){
    	ArrayList<String> result = new ArrayList<String>();

    	for(int index = 0; index < listOfWords.size(); index++){
    	
    		int position = -1;
    		int low = 0;
    		int high = words.size() - 1;
    		int mid;  

    		while( position == -1 && low <= high )
    		{      
    			mid = low + ((high - low) / 2);
    			if( listOfWords.get(index).equals(words.get(mid)) ){
    				position = mid;
    				result.add(listOfWords.get(index));
    			}
    			else if(listOfWords.get(index).compareTo(words.get(mid)) > 0)
    				low = mid + 1;
    			else
    				high = mid - 1;
    		}
    	}
    	return result;
    }
    
    

    /**
     * returns the length of the words in this word ladder finder. All words must be same length
     * @return the length of the words in this word ladder finder
     */
    public int lengthOfWords()
    {   return words.get(0).length();
    }
}


//    public static void main(String[] args){
//        String[] wordList = {"bears", "beats", "crazy", "humid", "scuba", "sears",
//                "smart", "stars", "start", "tumid"};
//    	WordLadderFinder test = new WordLadderFinder(wordList);
//    }
//}
