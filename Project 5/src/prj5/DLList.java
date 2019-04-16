package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLList<T> implements DoublyLinkedList<T>, Iterable<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(T obj) {
        Node current = head;
        while(current != null){
            if(current.data.equals(obj)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        Node current = head;
        for(int i = 0; i <= index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void add(T newEntry) {
        
        
    }

    @Override
    public void add(int index, T obj) {
        
        
    }

    @Override
    public boolean remove(int index) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(T obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new DLListIterator<T>();
    }

    private static class Node<T>
    {
        private Node<T> next;
        private Node<T> previous;
        private T data;
    
        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(T d) {
            data = d;
        }
    
        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<T> n) {
            next = n;
        }
    
        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<T> n) {
            previous = n;
        }
    
        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }
    
        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<T> previous() {
            return previous;
        }
    
        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public T getData() {
            return data;
        }
    }

    private class DLListIterator<A> implements Iterator<T>
    {
        private Node<T> nextNode;
        private T nextCalled;
        
        public DLListIterator()
        {
            nextNode = head.next();
            nextCalled = null;
        }
        
        @Override
        public boolean hasNext()
        {
            return nextNode == tail;
        }

        /**
         * Gets the next value in the list
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (!hasNext())
            {
                throw new NoSuchElementException("Illegal call to next(); " + 
                                             "iterator is after end of list.");
            }
            Node<T> returnNode = nextNode;
            nextNode = nextNode.next();
                
            return null;
        }
    }
}
