import java.util.List;
import java.util.ArrayList;

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
 * Shell for a bianry search tree class.
 * @author scottm
 *
 */

public class BinarySearchTree<E extends Comparable<? super E>> {
    private int size;
    private BSTNode<E> root;
    
    public BinarySearchTree(){
    	size = 0;
    	root = null;
    }
    
    
    /**
     *  add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: data != null<br>
     *  post: add this item to the tree. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param data the data to add to the tree
     *  @return false if an item equivalent to data is already present
     *  in the tree, return true if data is added to the tree and size() = old size() + 1
     */
    public boolean add(E data){
        int oldSize = size();        
        root = addHelper(root, data);
        return oldSize != size();
    }
    
    private BSTNode addHelper(BSTNode n, E obj){
    	if(n == null){
    		n = new BSTNode(obj, null, null);
    		size++;
    	}
    	else{
    		int diff = obj.compareTo((E) n.getValue());
    		if(diff < 0)
    			n.setLeft(addHelper(n.getLeft(),obj));
    		else if(diff > 0)
    			n.setRight(addHelper(n.getRight(), obj));
    	}
    	return n;
    }

    /**
     *  remove a specified item from this Binaray Search Tree if it is present.
     *  <br>
     *  pre: data != null<br>
     *  post: remove data from the tree, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param data the data to remove from the tree if present
     *  @return false if data was not present
     *  returns true if data was present and size() = old size() - 1
     */
    public boolean remove(E data){
        int oldSize = size();
        root = removeHelper(root, data);
        return oldSize != size();
    }
    
    private BSTNode removeHelper(BSTNode n, E obj){
    	if(n == null){
    		//Nothing
    	}
    	else{
    		int diff = obj.compareTo((E) n.getValue());
    		if(diff < 0)
    			n.setLeft(removeHelper(n.getLeft(), obj));
    		else if(diff > 0)
    			n.setRight(removeHelper(n.getRight(), obj));
    		else{
    			if(n.getLeft() == null && n.getRight() == null)
    				n = null;
    			else if(n.getLeft() == null)
    				n = n.getRight();
    			else if(n.getRight() == null)
    				n = n.getLeft();
    			else{
    				E temp = removeHelperHelper(n);
    				n.setValue(temp);
    				removeHelper(n.getLeft(), temp);
    				size++;
    			}
    			size--;
    		}
    	}
    	return n;
    }
    
    private E removeHelperHelper(BSTNode n){
    	BSTNode temp = n;
    	temp = temp.getLeft();
    	while(temp.getRight() != null){
    		temp = temp.getRight();
    	}
    	
    	return (E) temp.getValue();
    }


    /**
     *  check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: data != null<br>
     *  post: return true if data is present in tree, false otherwise
     *  @param data the data to look for in the tree
     *  @returns true if data is present in this tree, false otherwise
     */
    public boolean isPresent(E data){
    	return isPresentHelper(root, data);
    }
    
    private boolean isPresentHelper(BSTNode n, E obj){
    	boolean result = false;
    	if(n == null){
    		result = false;
    	}
    	else{
    		int diff = obj.compareTo((E) n.getValue());
    		if(diff < 0)
    			result = isPresentHelper(n.getLeft(),obj);
    		else if(diff > 0)
    			result = isPresentHelper(n.getRight(), obj);
    		else if (diff == 0)
    			result = true;
    	}
    	return result;
    }


    /**
     *  return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @returns the number of items in this Binary Search Tree
     */
    public int size(){
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @returns the height of this tree or -1 if the tree is empty
     */
    public int height(){
    	return heightHelper(root);
    }
       
    private int heightHelper(BSTNode n){
    	int tempLeft, tempRight;
    	if(n == null) 
    		return -1;
    	tempLeft = 1 + heightHelper(n.getLeft());
    	tempRight = 1 + heightHelper(n.getRight());
    	if(tempLeft > tempRight)
    		return tempLeft;
    	else 
    		return tempRight;
    }
    /**
     *  return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order. 
     *  If the tree is empty return an empty List
     *  @returns a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll(){
        List<E> listOfNodes = (List<E>) new ArrayList();
    	getAllHelper(root, listOfNodes);
    	return listOfNodes;
    }
    
    private void getAllHelper(BSTNode n, List<E> listOfNodes){
    	if(n == null){
    		//Nothing happens
    	}
    	else{
    		getAllHelper(n.getLeft(), listOfNodes);
    		listOfNodes.add((E) n.getValue());
    		getAllHelper(n.getRight(), listOfNodes);
    	}
    }
                                  


    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: size() > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
     public E max(){
    	 BSTNode<E> temp = root;
    	 while(temp.getRight() != null){
    		 temp = temp.getRight();
    	 } 
    	 return (E) temp.getValue();
     }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: size() > 0<br>
     * post: eturn the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
     public E min(){
    	 BSTNode<E> temp = root;
    	 while(temp.getLeft() != null){
    		 temp = temp.getLeft();
    	 } 
    	 return (E) temp.getValue();
     }
	
	/**
	 * An add method that implements the add algorithm iteratively instead of recursively.
	 * <br>pre: data != null
	 * <br>post: if data is not present add it to the tree, otherwise do nothing.
	 * @param data the item to be added to this tree
	 * @return true if data was not present before this call to add, false otherwise.
	 */
	public boolean iterativeAdd(E data){
		int oldSize = size();        
		BSTNode n = root;
		boolean Added = false;
		boolean isEqual = false;

		if(root == null){
			root = new BSTNode(data, null, null);
			size++;
		}
		else{
			while(!Added && !isEqual){
				int diff = data.compareTo((E) n.getValue());
				if(diff < 0 && n.getLeft() == null){
					n.setLeft(new BSTNode(data));
					Added = true;
					size++;
				}
				else if(diff > 0 && n.getRight() == null){
					n.setRight(new BSTNode(data));
					Added = true;
					size++;
				}
				else if(diff < 0)
					n = n.getLeft();
				else if(diff > 0)
					n = n.getRight();
				else 
					isEqual = true;
			}
		}

		return oldSize != size();
	}

	/**
	 * Find the number of nodes in this tree at the specified depth.
	 * @param d The depth to find nodes at.
	 * @return The number of nodes in this tree at a depth equal tot
	 * the parameter d.
	 */
	public int numNodesAtDepth(int d) {
		return numNodesHelper(root, d);
	}
	
	private int numNodesHelper(BSTNode n, int d){
		int count = 0;
		
		if(n != null){
			if(d == 0)
				count = 1;
			else{
				count += numNodesHelper(n.getLeft(), d - 1);
				count += numNodesHelper(n.getRight(), d - 1);
			}
		}
		return count;
	}
	
	/**
	 * Prints a vertical representation of this tree.
	 * The tree has been rotated counter clockwise 90
	 * degrees. The root is on the left. Each node is printed
	 * out on its own row. A node's children wil not necessarily
	 * be at the rows directly above and below a row. They will
	 * be indented three spaces from the parent. Nodes indented the
	 * same amount are at the same depth.
	 * pre: none
	 */
	public void printTree(){
	    printTree(root, "");
	}
	
	private void printTree(BSTNode<E> n, String spaces){
	  if(n != null){
	      printTree(n.getRight(), spaces + "  ");
	      System.out.println(spaces + n.getValue());
	      printTree(n.getLeft(), spaces + "  ");
	  }
	}
	
	private static class BSTNode<E extends Comparable<? super E>> {
	    private E value;
	    private BSTNode<E> left;
	    private BSTNode<E> right;

	    public BSTNode(){
	        this(null);
	    }
	 
	    public BSTNode(E initValue){
	        this(initValue, null, null); 
	    }

	    public BSTNode(E initValue, 
	            BSTNode<E> initLeft, 
	            BSTNode<E> initRight) {
	        value = initValue; 
	        left = initLeft; 
	        right = initRight; 
	    }

	    public E getValue() { 
	        return value; 
	    }
	    
	    public BSTNode<E> getLeft() { 
	        return left;
	    }
	    
	    public BSTNode<E> getRight() { 
	        return right; 
	    }

	    public void setValue(E theNewValue) { 
	        value = theNewValue; 
	    }
	    
	    public void setLeft(BSTNode<E> theNewLeft) { 
	        left = theNewLeft; 
	    }
	    
	    public void setRight(BSTNode<E> theNewRight) { 
	        right = theNewRight; 
	    }    
	}


}
