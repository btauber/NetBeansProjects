package linked;

public class Node<T> {
    private T data;
    private Node<T> next;
    private Node<T> prev;
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public boolean hasData()
    {
        if(data != null){
            return true;
        }
        return false;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
        if(next!=null&&next.getPrev()!=this)
            next.setPrev(this);
    }
    
    public boolean hasNext()
    {
        if(next != null){
            return true;
        }
        return false;
    }

    
    public Node<T> getPrev() {
        return prev;
    }

    
    public void setPrev(Node<T> prev) {
        this.prev = prev;
        if(prev.getNext()!=this)
            prev.setNext(this);
    }
    
    public boolean hasPrev()
    {
        if(prev != null){
            return true;
        }
        return false;
    }
    
}
