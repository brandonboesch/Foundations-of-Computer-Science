import java.util.List;
import java.util.LinkedList;

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

public class Queue<E> implements IQueue<E>{
	// myCon's declared type is List
	// its actual type must be LinkedList
	private List<E> myCon;
	
	public Queue(){
		myCon = new LinkedList<E>();
	}
	@Override
	public E dequeue() {
		return myCon.remove(0);
	}

	@Override
	public void enqueue(E data) {
		myCon.add(data);
	}

	@Override
	public E front() {
		return myCon.get(0);
	}

	@Override
	public boolean isEmpty() {
		return myCon.size() == 0;
	}


}