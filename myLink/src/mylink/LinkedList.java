package mylink;



public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    // Add a new item to end of list
    public void add(T item) {
        // create new node to hold item
        Node<T> node = new Node<T>();
        node.setData(item);

        // special case - first item in list
        if (head == null) {
            head = node;
            tail = node;
        } else { // not first item
            // walk list until last item. Add new node at end
            Node temp = head;
            while (temp.hasNext() && temp.hasData()) {
                // if(temp.getNext()!=null)
                temp = temp.getNext();
            }
            if (temp.getData() == null) {
                // node.setNext(temp.getNext());
                temp.setData(item);

            }
            if (temp.getNext() == null) {
                temp.setNext(node);
                tail = node;
            }
        }
    }

    // add item at a specific point in list
    public void add(T item, int index) {
        // create new node to hold item
        Node<T> newNode = new Node<T>();
        newNode.setData(item);
        //special case if its empty list and index is 0,
        if (index == 0 && head == null) {
            head = newNode;
            tail = newNode;
        } // special case. New first item
        else if (index == 0) {
            Node oldHead = head;
            head = newNode;
            newNode.setNext(oldHead);
        } else { // if index is not the 0. Need to walk items until
            // correct spot and the add node. May need
            // to create "empty" nodes along the way
            // if nodes dont exist all the way to the desired
            // index

            // Make sure we have a head or create an empty one
            if (head == null) {
                head = new Node<T>();
            }
            // loop through nodes until desired index
            Node next = head;
            for (int i = 0; i < index - 1; i++) {
                Node temp = next.getNext();
                // create an empty node if needed
                if (temp == null) {
                    temp = new Node<T>();
                    next.setNext(temp);
                }
                next = temp;
            }
            // We got to desired index, now add new node
            Node oldNext = next.getNext();
            next.setNext(newNode);
            newNode.setNext(oldNext);

            if (newNode.hasNext() != true) {
                tail = newNode;
            }
        }
    }

    public void addFirst(T item) {
        if (head == null) {
            add(item);
        } else {
            Node node = new Node();
            node.setData(item);
            node.setNext(head);
            head = node;
        }

    }

    public void addLast(T item) {
        if (head == null) {
            add(item);
        } else {
            Node<T> node = new Node();
            node.setData(item);
            Node<T> temp = head;
            while (temp.hasNext()) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    public T get(int index) {
        if (index > size()) {
            return null;
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return (T) temp.getData();
    }

    //This method is returning the size of the list and only elements with data.
    public int sizeOfElementWithData() {
        Node temp = head;
        int size = 0;
        for (int i = 0; temp.hasNext(); i++) {
            if (temp.hasData()) {
                size++;
            }
            temp = temp.getNext();
        }
        if (temp.hasData()) {
            size++;
        }
        return size;
    }

    // This method is returning the size of the list even the empty ones.
    public int size() {
        Node temp = head;
        int size = 0;
        for (int i = 0; temp.hasNext(); i++) {

            size++;

            temp = temp.getNext();
        }

        return size + 1;
    }

    public T[] toArray() {
        Object[] tempArray = new Object[sizeOfElementWithData()];
        Node<T> temp = head;
        int i = 0;
        while (temp.hasNext()) {
            if (temp.hasData()) {
                tempArray[i++] = temp.getData();
            }
            temp = temp.getNext();
        }
        if (temp.hasData()) {
            tempArray[i] = temp.getData();
        }
        return (T[]) tempArray;
    }

    public T remove(int index) {
        if (index == 0) {
            T temp3 = get(index);
            head = head.getNext();
            return temp3;
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            // prev = i-1;
            temp = temp.getNext();
        }

        Node temp2 = head;
        for (int i = 0; i < index - 1; i++) {
            temp2 = temp2.getNext();
        }
        temp2.setNext(temp.getNext());
        return temp.getData();
    }

    public void clear() {
        head = null;
    }

    //returns true if the data type is the same data type of the pram.
    public boolean contains(Object obj) {
        if (head.getData().getClass().equals(obj.getClass()) || tail.getData().getClass().equals(obj.getClass())) {
            return true;
        } else {
            return false;
        }
    }

    //returns the index position of the specified object. Returns -1 if it can't find it;
    public int indexOf(Object obj) {
        T theObj = (T) obj;
        Node<T> temp = head;
        int x = 0;
        for (; x < size(); x++) {
            if (temp.getData() == obj) {
                break;
            }
            temp = temp.getNext();
        }
        if (x == size()) {
            return -1;
        }
        return x;
    }

    public T peek() {
        if (head == null) {
            throw new EmptyStackException("This is an empty stack");
        }
        return tail.getData();
    }

    public Node[] toArrayNode() {
        Node[] tempArray = new Node[size()];
        Node temp = head;
        int i = 0;
        while (temp.hasNext()) {

            tempArray[i++] = temp;

            temp = temp.getNext();
        }

        tempArray[i] = temp;
        tempArray[i].setNext(new Node());
        tempArray[0].setPrev(new Node());

        return tempArray;
    }

    public void push(T item) {
        Node node = new Node<T>();
        node.setData(item);
        tail.setNext(node);
        tail = tail.getNext();
    }
    

    public T pop() {
        T theReturn = peek();
        Node<T> tempTail = tail;
        Node<T> tempPrev = tail.getPrev();
            if(tempPrev == null){
                tail = null;
                head = null;
                return theReturn;
            }
        tempPrev.setNext(null);
        tail = tempPrev;
        return theReturn;
    }
    
    public boolean isEmpty()
    {
        if (head == null)
            return true;
        return false;
    }

    

    public void sort() {
        int sortCounter = -1;
        while (sortCounter != 0) {
            sortCounter = 0;

            Node<T> temp = head;
            int size = size();
            for (int x = 0; x < size - 1; x++) {

                Comparable t = (Comparable) temp.getData();

                Comparable y = (Comparable) temp.getNext().getData();
                int compareTester = t.compareTo(y);

                if (compareTester != 1) {
                    temp = temp.getNext();
                    continue;
                }

                if (compareTester == 1) {
                    T nextData = temp.getNext().getData();
                    T thisData = temp.getData();
                    temp.setData(nextData);
                    temp.getNext().setData(thisData);

                    sortCounter++;
                }
            }
        }
    }
    
    /*public void sort() {
        int sortCounter = -1;
        while (sortCounter != 0) {
            sortCounter = 0;

            Node<T> temp = head;

            for (int x = 0; x < size() - 1; x++) {

                MyComparable t = (MyComparable) temp.getData();

                MyComparable y = (MyComparable) temp.getNext().getData();
                int compareTester = t.compareTo(y);

                if (compareTester != 1) {
                    temp = temp.getNext();
                    continue;
                }

                if (temp == head) {
                    Node<T> tempNext = temp.getNext().getNext();
                    temp.getNext().setNext(temp);
                    temp.setNext(tempNext);
                    head = temp.getPrev();
                    sortCounter++;
                } else if (temp.getNext() == tail) {

                    tail.setPrev(temp.getPrev());
                    temp.setPrev(tail);
                    tail = temp;
                    sortCounter++;
                    tail.setNext(null);
                } else {
                    Node<T> tempNext = temp.getNext().getNext();
                    temp.getPrev().setNext(temp.getNext());

                    temp.setPrev(temp.getNext());
                    temp.setNext(tempNext);
                    sortCounter++;
                }
            }
        }
    }*/

}
