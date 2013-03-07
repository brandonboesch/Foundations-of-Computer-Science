import java.util.Iterator;
import java.lang.StringBuffer;



/*  Student information for assignment
*
*  Name: Zachary Tschirhart	
*  EID: zst75
*  email address: ztschir@gmail.com	
*  TA name: Xiuming 
*  On honor Zachary this assignment is my 
*  own work.
*/

//slip days info
/*
Slip days used on this assignment: 0
Slip days I think I have used for the term thus far: 1
*/

public class LinkedList<E> implements IList<E> {

	private DoubleListNode beginningNode = new DoubleListNode();
	private DoubleListNode lastNode = new DoubleListNode();
	private int size;
    
	private class LLIterator implements Iterator<E>{
		private DoubleListNode node, prevnode;
		private int count = 0;
		private int sizeBeforeRemove;
		private boolean hasCalledNext;
		
		////// O(1) \\\\\\
		public LLIterator(){
			hasCalledNext = false;
			node = beginningNode;
			sizeBeforeRemove = size;
		}
		
		////// O(1) \\\\\\
		public boolean hasNext(){ 
			if(node != null)
				return true;
			else 
				return false;
		}
		
		////// O(1) \\\\\\
        public E next(){ 
        	hasCalledNext = true;
        	E temp = (E) node.getData();
        	prevnode = node;
        	node = node.getNext();
        	count++;
        	return temp;
        	
        }
        
        ////// O(1) \\\\\\
        public void remove(){
        	if(hasCalledNext){
        		hasCalledNext = false;
        		if(count == 1){
        			beginningNode = node;
        			beginningNode.setPrev(null);
        		}
        		else if(count == sizeBeforeRemove){
        			lastNode = prevnode.getPrev();
        			lastNode.setNext(null);

        		}
        		else{
        			DoubleListNode temp = prevnode.getNext();
        			prevnode = prevnode.getPrev();
        			prevnode.setNext(temp);
        			temp.setPrev(prevnode);
        		}
        		size--;
        	}
        	else
        		throw new IllegalStateException("Can't call remove()");       	
        }
    }
	
	////// O(1) \\\\\\
	public LinkedList(){
		beginningNode = null;
		lastNode = null;
		size = 0;
	}
	
	////// O(1) \\\\\\
	public void add(E item){
		if(size == 0){	
			beginningNode = lastNode = new DoubleListNode(item, null, null);
		}
		else{
			DoubleListNode temp = lastNode;
			lastNode = new DoubleListNode(item, null, temp);
			temp.setNext(lastNode);
		}
		size++;
	}

	////// O(N) \\\\\\
	public void add(int pos, E item){

		if(size == 0){
			add(item);
		}

		else if(pos <= size) {
			if(pos == 0 ){
				addFirst(item);
			}
			else if(pos == size){
				add(item);
			}
			else{
				DoubleListNode node, tempPrev, tempNext;			
				if(pos < size/2){
					node = beginningNode;	
					for(int index = 0; index < pos; index++){
						node = node.getNext();
					}
				}
				else{
					node = lastNode;
					for(int index = size-1; index > pos; index--){
						node = node.getPrev();
					}
				}
				tempPrev = node.getPrev();
				tempNext = node;
				DoubleListNode newNode = new DoubleListNode(item, tempNext, tempPrev);
				tempPrev.setNext(newNode);
				tempNext.setPrev(newNode);
				size++;
			}
		}

	}
	////// O(N) \\\\\\
	public E set(int pos, E item){
		DoubleListNode node, temp;			
		if(pos < size/2){
			node = beginningNode;	
			for(int index = 0; index < pos; index++){
				node = node.getNext();
			}
		}
		else{
			node = lastNode;
			for(int index = size-1; index > pos; index--){
				node = node.getPrev();
			}
		}
		temp = node;
		node.setData(item);
		return (E) temp.getData();
	}

	////// O(N) \\\\\\
	public E get(int pos){
		DoubleListNode node;			
		if(pos < size/2){
			node = beginningNode;	
			for(int index = 0; index < pos; index++){
				node = node.getNext();
			}
		}
		else{
			node = lastNode;
			for(int index = size-1; index > pos; index--){
				node = node.getPrev();
			}
		}
		return (E) node.getData();
	}

	////// O(N) \\\\\\
	public E remove(int pos){
		DoubleListNode node, tempPrev, tempNext;
		E data = null;

		if(pos >= 0 && pos < size){
			if(pos == 0){
				data = removeFirst();
			}
			else if (pos == size-1){
				data = removeLast();

			}
			else{
				if(pos < size/2){
					node = beginningNode;	
					for(int index = 0; index < pos; index++){
						node = node.getNext();
					}
				}
				else{
					node = lastNode;
					for(int index = size-1; index > pos; index--){
						node = node.getPrev();
					}
				}
				tempPrev = node.getPrev();
				tempNext = node.getNext();
				tempNext.setPrev(node.getPrev());
				tempPrev.setNext(node.getNext());
				data = (E) node.getData();
				size--;
			}
		}
		return data;
	}

	////// O(N) \\\\\\
	public boolean remove(E obj){
		Iterator temp = this.iterator();
		Boolean result = false;
		while(temp.hasNext() && !result){
			if(temp.next().equals(obj)){
				temp.remove();
				result = true;
			}
		}
		return result;
	}

	////// O(N) \\\\\\
	public IList<E> getSubList(int start, int stop){
		IList<E> result = new LinkedList();
		DoubleListNode temp = beginningNode;
		if(start >= 0 && stop <= size && start < stop){
			for(int index = 0; index < start; index++)
				temp = temp.getNext();
			for(int index = start; index < stop; index++){
				result.add((E) temp.getData());
				temp = temp.getNext();
			}
		}
		
		return result;
	}

	//////O(1) \\\\\\
	public int size(){
		return size;
	}

	////// O(1) \\\\\\
	public int indexOf(E item){
		return indexOf(item, 0);
	}

	////// O(N) \\\\\\
	public int indexOf(E item, int pos){
		int result = -1; 
		DoubleListNode temp = beginningNode;
		
		if(pos >= 0 && pos < size){
			for(int index = 0; index < pos; index++){
				temp = temp.getNext();
			}			
			for(int index = pos; result == -1 && index < size; index++){
				if(temp.getData().equals(item))
					result = index;
				temp = temp.getNext();
			}
		}
		return result;
	}

	////// O(1) \\\\\\
	public void makeEmpty(){
		beginningNode = null;
		lastNode = null;
		size = 0;
	}

	////// O(1) \\\\\\
	public Iterator<E> iterator(){
		return new LinkedList.LLIterator();
	}
	
	////// O(N) \\\\\\
    public void removeRange(int start, int stop){
    	DoubleListNode tempstart = beginningNode;
    	DoubleListNode tempstop = beginningNode;
    	if(start >= 0 && stop <= size && start < stop){

    		if(stop-start == size){
    			this.makeEmpty();
    		}
    		else{
    			for(int index = 0; index < start; index++){
    				tempstart = tempstart.getNext();
    			}
    			for(int index = 0; index < stop; index++){
    				tempstop = tempstop.getNext();
    			}
    			if(start == 0){
    				beginningNode = tempstop;
    				beginningNode.setPrev(null); 
    			}
    			else if(stop == size){
    				lastNode = tempstart.getNext();
    				lastNode.setNext(null);
    				tempstart.setNext(lastNode);
    			}
    			else{
    				 tempstart.getPrev().setNext(tempstop);
    				 tempstop.setPrev(tempstart);
    			}
    			size = size - (stop-start);
    		}
    		
    	}
    	
    }
	
	/**
	 * add item to the front of the list.
	 * <br>pre: none
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
	////// O(1) \\\\\\
	public void addFirst(E item){
		if(size == 0)
			add(item);
		else{
			DoubleListNode tempBeginning = beginningNode;
			DoubleListNode beginning = new DoubleListNode(item, tempBeginning, null);
			beginningNode = beginning;
			tempBeginning.setPrev(beginningNode);
			size++;
		}
	}


	/**
	 * add item to the end of the list.
	 * <br>pre: none
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	
	////// O(N) \\\\\\
	public void addLast(E item){
		add(item);
	}


	/**
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	
	////// O(1) \\\\\\
	public E removeFirst(){	
	    DoubleListNode temp = beginningNode;
	    beginningNode = temp.getNext();
	    size--;
		return (E) temp.getData();
	}


	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	////// O(1) \\\\\\
	public E removeLast(){	
	    DoubleListNode temp = lastNode;
		if(size == 1){
	    	this.makeEmpty();
	    }
		else if(size == 2){
			beginningNode.setNext(null);
			lastNode = beginningNode;
			size--;
		}
	    else{
	    	lastNode = temp.getPrev();
	    	lastNode.setNext(null);
	    	size--;
	    }
		return (E) temp.getData();
	}

	////// O(N) \\\\\\
	public String toString(){	
		Iterator It = this.iterator();
		StringBuffer result = new StringBuffer();
		int count = 0;
		result.append("[");
		while(It.hasNext()){
			if(count == size-1)
				result.append(It.next().toString());
			else
				result.append(It.next().toString() + ", ");
			count++;
		}
		result.append("]");
		return result.toString();
	}


	/**
	 * check if this list is equal to another Object.
	 * <br>pre: none
	 * @return true if other is a non null LinkedList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 */
	////// O(N) \\\\\\
	public boolean equals(Object other){			
		Iterator LHS = this.iterator();
		Iterator RHS = ((IList<E>) other).iterator();
		boolean result = false;
		
		if(this.size() == ((IList<E>) other).size()){
			result = true;
			while(LHS.hasNext() && result){
				if(!LHS.next().equals(RHS.next()))
						result = false;
			}
		}
			
		return result;
	}

}