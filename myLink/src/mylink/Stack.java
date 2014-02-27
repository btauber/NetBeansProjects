package mylink;

public class Stack<T> {
    
    LinkedList<T> stack = new LinkedList<T>();
     
    public void push(T item)
    {
        stack.add(item);
    }
    
    public T pop()
    {
        return stack.pop();
    }
    
    public T peek()
    {
       return stack.peek();
    }
    
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
}
