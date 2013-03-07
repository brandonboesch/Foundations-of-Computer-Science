import java.util.Iterator;

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
	
///// Code for contains method from class website /////
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
			else
				It.next();
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
				Comparable val = (Comparable) LHS.next();
				boolean result = false;
				while(RHS.hasNext()){
					if(val.compareTo(RHS.next()) == 0){
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
