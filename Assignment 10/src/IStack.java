
public interface IStack<E>{
   //pre: none, post: top() = data
    public void push(E data);
    
    //pre: !isEmpty(), 
    //post: return item most recently added to this Stack
    public E top();
    
    public boolean isEmpty();
    
    //pre: !isEmpty()
    //post: remove and return item most recently added to this Stack
    public E pop();  
    
    // return a copy of this stack
    public IStack<E> getCopy();
}
