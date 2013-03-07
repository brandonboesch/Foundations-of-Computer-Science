import java.util.Iterator;
import java.util.ArrayList;

/**
 * In this implementation of the ISet interface the elements in the Set are
 * maintained in ascending order.
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
		myCon = (ArrayList<Comparable>)other.toArrayList();
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
		Iterator It = myCon.iterator();
    	int count = 0;
		
    	if(myCon.size() == 0)
    		myCon.add((Comparable) item);
    	else{
    		if(!myCon.contains(item)){
    			while(It.hasNext()){
    				Comparable temp = (Comparable) It.next();
    				if( ((Comparable) item).compareTo(temp) < 0){
    					myCon.add(count, (Comparable) item);
    					return true;
    				}
    				if(count == myCon.size()-1){
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
		   this.add((Comparable) It.next());
		   result = true;
	   }
	   return result;
   }

	@Override
	public ISet difference(ISet otherSet) {
		ISet result = new UnsortedSet();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISet union(ISet otherSet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean contains(Object item){
	    boolean found = false;
	    Comparable tempItem = (Comparable) item;
	    Iterator it = myCon.iterator(); 
	    Comparable temp;
	    while( !found && it.hasNext() ){
	        temp = (Comparable) it.next();
	        found = temp.equals( tempItem );
	    }
	    return found;
	}
	
	@Override
	public boolean remove(Object item) {
		Iterator It = myCon.iterator();
		while(It.hasNext()){
			if (myCon.contains(item)){
				It.next();
				It.remove();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int size() {
		Iterator it = myCon.iterator();
		int count = 0;
		while ( it.hasNext() ){
			it.next();
			count++;
		}
		return count;
	}
	
	@Override
	public boolean containsAll(ISet otherSet) {
		Iterator It = ((SortedSet)otherSet).toArrayList().iterator();
		boolean contains = true;
		while(It.hasNext() && contains){
			if(this.contains(It.next())){
				contains = true;
			}
			else
				return false;
		}
		return contains;
	}	
	
///// Code for shell sort from class slides /////

	public void shellsort(ArrayList<Comparable> list)
	{ 
		Comparable temp; boolean swap;
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
	@Override
	public boolean equals(Object other){
		Iterator LHS = myCon.iterator();
		if(myCon.size() == ((ISet) other).size()){
			while(LHS.hasNext()){
				Iterator RHS = ((ISet)other).iterator();
				Object val = LHS.next();
				boolean result = false;
				while(RHS.hasNext()){
					if(val == RHS.next()){
						result = true;
					}
				}
				if (result == false)
					return false;
			}
		}
		return true;
	}

	public String toString(){
		return myCon.toString();
	}
	public ArrayList toArrayList(){
		return myCon;
	}

}
