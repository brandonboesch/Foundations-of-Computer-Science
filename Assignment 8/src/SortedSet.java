import java.util.Iterator;
import java.util.ArrayList;


/*  Student information for assignment
*
*  On my honor, Jesse Campos , Zachary Tschirhart.
*  this programming assignment is my own work.
*
*  Student #1: 
*  Name #1: Jesse Campos
*  EID #1: jpc639
*  email address #1: jesse.campos@mail.utexas.edu
*  TA name #1: Xiuming
*  Unique course ID #1: 54022
*  programming hours #1: 20
*  
*  *  Student #2: 
*  Name #2: Zachary Tschirhart
*  EID #2: zst75
*  email address #2: ztschir@gmail.com
*  TA name #2: Xiuming
*  Unique course ID #2:54022
*  programming hours #2: 20
*/

//slip days info
/*
Slip days used on this assignment: 0
Slip days I think I have used for the term thus far: 1
*/

/**
 * In this implementation of the ISet interface the elements in the Set are
 * maintained in ascedning order.
 * All elements in a given SortedSet must be of the same type and that
 * type must implement the Comparable interface.
 * Students are to implement methods that were not implemented in AbstractSet and override
 * methods that can be done more efficiently. An ArrayList must be used as the internal storage container.
 * For methods involving two set, if that method can be done more efficiently if the
 * other set is also a SortedSet do so.
 *
 */
public class SortedSet extends AbstractSet{

	// CS307 students: You may, if you wish change
    // the type of the ArrayList to Comparable.
    private ArrayList<Comparable> myCon;

	/**
	 * create an empty SortedSet
	 */
	public SortedSet(){
		myCon = new ArrayList<Comparable>();
	}

	public SortedSet(UnsortedSet other){
		myCon = other.toArrayList();
		shellsort(myCon);
	}

    /**
     * POST CONDITION ALTERED FROM ISet
     * Add an item to this set.
     * @param item the item to be added to this set. If size() > 1
     * item is only added if it is the same type as the other
     * elements in this SortedSet. If size() == 0 item is added
     * only if it implements the Comparable interface.
     * @return true if this set changed as a result of this operation, false otherwise.
     */
	@Override
    public boolean add(Object item){
		Iterator It = this.iterator();
    	int count = 0;
    	
    	if(It.hasNext()){
    		Iterator check = this.iterator();
    		Object checkitem = check.next();
        	if(item.getClass() != checkitem.getClass())
        		return false;
    	}
    	    	
    	if(this.size() == 0)
    		myCon.add((Comparable) item);

    	else{
    		
    		if(!this.contains((Comparable)item)){
    			while(It.hasNext()){
    				Comparable temp = (Comparable) It.next();
    				if( ((Comparable)item).compareTo(temp) < 0){
    					myCon.add(count, (Comparable) item);
    					return true;
    				}
    				if(count == this.size()-1){
    					myCon.add(count+1, (Comparable) item);
    					return true;
    				}
    				count++;
    			}
    		}
    	}
		return false;


    }

    /**
     * POST CONDITION ALTERED FROM ISet
     * A union operation. Add all items of otherSet that are the
     * same data type as the elements of this SortedSet and
     * that are not already present in this set. If this SortedSet
     * is empty add the first element in otherSet that implements
     * Comparable and all other elements from otherSet that are that
     * same type.
     * @param otherSet != null
     * @return true if this set changed as a result of this operation, false otherwise.
     */
    @Override
    public boolean addAll(ISet otherSet){
    	boolean result = false;
    	Iterator It = otherSet.iterator();
    	while(It.hasNext()){
    		if(this.add((Comparable) It.next()))
    			result = true;
    	}
    	return result;

   }

	@Override
	public ISet difference(ISet otherSet) {
		ISet result = new SortedSet();
		Iterator it = myCon.iterator();
		while(it.hasNext()){
			Object temp = it.next();
			if(!otherSet.contains(temp)){
				result.add(temp);
			}
		}
		return result;
	}

	@Override
	public ISet intersection(ISet otherSet) {
		Iterator it = otherSet.iterator();
		ISet result = new SortedSet();
		while(it.hasNext()){
			Object val = it.next();
			if(this.contains(val)){
				result.add(val);
				
			}
		}
		return result;
	}

	@Override
	public Iterator iterator() {
		Iterator it = myCon.iterator();
		return it;
	}
	
	public boolean equals(SortedSet other){
		Iterator LHS = this.iterator();
		Iterator RHS = other.iterator();
		
		if(this.size() == ((SortedSet)other).size()){
			while(LHS.hasNext()){
				if(((Comparable) RHS.next()).compareTo( LHS.next()) != 0)
					return false;
			}

		}
		return true;
	}

	
///// Code for shell sort from class slides /////
	
	public void shellsort(ArrayList<Comparable> list)
	{  
		for(int gap = list.size() / 2; gap > 0; gap /= 2)
			for(int i = gap; i < list.size(); i++)
			{   
				Comparable tmp = list.get(i);
				int j = i;
				for( ; j >= gap &&
						tmp.compareTo( list.get(j - gap) ) < 0;
						j -= gap )
					list.set(j,list.get(j - gap));
				list.set(j, tmp);
			}
	}

	public String toString(){
		return myCon.toString();
	}
	
/////Binary Sort method in class slides////////
	public boolean contains( Comparable target)
	{   
		boolean result = false;
		int low = 0;
		int high = this.size() - 1;
		int mid;
		while( !result && low <= high ){      
			mid = low + ((high - low) / 2);
			
			if( target.equals(myCon.get(mid)))
				result = true;
			else if(target.compareTo(myCon.get(mid)) > 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return result;
	}


}
