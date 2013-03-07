import java.util.ArrayList;

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
*/

public class Stack<E> implements IStack<E>{
	private ArrayList<E> myCon;

	
	public Stack(){
		myCon = new ArrayList<E>();
	}
	@Override
	public IStack<E> getCopy() {
		IStack<E> newList = new Stack<E>();
		for(int index = 0; index < myCon.size(); index++){
			newList.push(myCon.get(index));
		}
		return newList;
	}

	@Override
	public boolean isEmpty() {
		return myCon.size() == 0;
	}

	@Override
	public E pop() {
		return myCon.remove(myCon.size()-1);
	}

	@Override
	public void push(E data) {
		myCon.add(data);
	}

	@Override
	public E top() {
		return myCon.get(myCon.size()-1);
	}


}
