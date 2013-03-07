import java.util.Iterator;

/**
 * Students are to complete this class. Students should implement as many methods
 * as they can using the Iterator from the iterator method and the other methods. 
 * @author scottm
 *
 */
public abstract class AbstractSet implements ISet{

	@Override
	public void clear() {
		Iterator It = this.iterator();
		while (It.hasNext()){
			It.next();
			It.remove();
		}
	}
	public boolean contains(Object obj){
	    for(Object val : this)
	        if( val.equals(obj ) )
	            return true;
	    return false;
	}
	
	@Override
	public boolean containsAll(ISet otherSet) {
		Iterator It = otherSet.iterator();
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

	@Override
	public boolean remove(Object item) {
		Iterator It = this.iterator();
		while(It.hasNext()){
			if (this.contains(item)){
				It.next();
				It.remove();
				return true;
			}
		}
		return false;
	}
	@Override
	public int size() {
		Iterator it = this.iterator();
		int count = 0;
		while ( it.hasNext() ){
			it.next();
			count++;
		}
		return count;
	}
	@Override
	public boolean equals(Object other){
		Iterator LHS = this.iterator();
		if(this.size() == ((ISet)other).size()){
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
	
	public ISet union(ISet otherSet){
		ISet result = this.difference( otherSet );
		result.addAll( this.intersection( otherSet));
		result.addAll( otherSet.difference(this));
		return result;	
	}
}
