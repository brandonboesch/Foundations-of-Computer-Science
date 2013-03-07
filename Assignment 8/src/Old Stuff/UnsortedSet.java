import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

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

}
