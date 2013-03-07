import java.util.Collection;
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
 * A simple implementation of an ISet. Elements are not in any particular order.
 * Students are to implement methods that were not implemented in AbstractSet and override
 * methods that can be done more efficiently. An ArrayList must be used as the internal storage container.
 * @author scottm
 *
 */
public class UnsortedSet extends AbstractSet {
	private ArrayList<Object> myCon;
	public UnsortedSet(){
		myCon = new ArrayList<Object>();
	}
	@Override
	public boolean add(Object item) {
		if(!myCon.contains(item)){
			myCon.add(item);
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(ISet otherSet) {
		Iterator it = otherSet.iterator();
		boolean result = false;
		
		if(it.hasNext()){
    		Iterator check = this.iterator();
    		Iterator check1 = otherSet.iterator();
    		Object checkitem = check.next();
    		Object checkitem1 = check1.next();
        	if(checkitem1.getClass() != checkitem.getClass())
        		return false;
		}
		while(it.hasNext()){
			Object val = it.next();
			if(!this.contains(val)){
				this.add(val);
				result = true;
			}
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
		Iterator it = otherSet.iterator();
		ISet result = new UnsortedSet();
		while(it.hasNext()){
			Object val = it.next();
			if(this.contains(val)){
				result.add(val);
			}
		}
		return result;
	}
	
	public ISet union(ISet otherSet) {
		ISet result = this;
		result.addAll(otherSet);
		return result;
	}
	@Override
	public Iterator iterator() {
		Iterator it = myCon.iterator();
		return it;
	}
	
	public ArrayList toArrayList(){
		return myCon;
	}
	
	public String toString(){
		return myCon.toString();
	}

}
