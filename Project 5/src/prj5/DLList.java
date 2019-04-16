package doublylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <E>
 *            The type of object the class will store
 */
public class DLList<E> {
    /**
     * A doubly linked node that stores data of type E
     *
     * @param <E>
     *            The type of object that this class will store
     */
    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;


        /**
         * Creates a new node
         *
         * @param d
         *            the data for the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the node after this node to the given node
         *
         * @param n
         *            the node after this node
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Sets the node before this to the given node
         *
         * @param n
         *            the node before this node
         */
        public void setPrevious(Node<E> n) {
            previous = n;
        }


        /**
         * Returns the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Returns the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * Returns the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }
    }


    private int size;
    private Node<E> head;
    private Node<E> tail;


    /**
     * Create a new DLList object
     */
    public DLList() {
        init();
    }


    /**
     * Initializes the DLList with sentinal nodes
     */
    private void init() {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Returns whether or not the list is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of entries in the list
     *
     * @return the number of entries in the list
     */
    public int size() {
        return size;
    }


    /**
     * Clears all the entries from the list
     */
    public void clear() {
        init();
    }


    /**
     * Checks if the object is in the list
     *
     * @param obj
     *            an object that may or may not be in the list
     * @return true the object is in the list
     */
    public boolean contains(E obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Returns the object at the given index
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     * @return true if successful
     */
    public boolean remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(E obj) {
        Node<E> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(obj)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            Node<E> currNode = head.next();
            while (currNode != tail) {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail) {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * Creates an iterator for a DLList
     */
    private class DLListIterator<A> implements Iterator<E> {
        // Fields
        private Node<E> nextNode;
        private boolean nextCalled;


        // Constructor
        /**
         * Creates a new DLListIterator
         */
        public DLListIterator() {
            nextNode = head;
            nextCalled = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return nextNode.next().getData() != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                nextNode = nextNode.next();
                nextCalled = true;
                return nextNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call to next(); "
                    + "iterator is after end of list.");
            }
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (nextCalled) {
                nextNode.previous().setNext(nextNode.next());
                nextNode.next().setPrevious(nextNode.previous());
                size--;
                nextCalled = false;
            }
            else {
                throw new IllegalStateException("Illegal call to remove(); "
                    + "next() was not called.");
            }

        }
    }
    
    /**
     * Returns an array representing the doubly linked list
     *
     * @return an array representing the doubly linked list
     */
    public Object[] toArray(){|
        Object[] arr = new Object[size];
        Node current = head;
        for(int i = 0; i < size; i++){
            arr[i] = current.getData();
            current = current.next();
        } 
        return arr;
    }
    
    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }


    private class RDLListIterator<A> implements Iterator<E> {
        // Fields
        private Node<E> nextNode;
        private boolean nextCalled;


        // Constructor
        /**
         * Creates a new DLListIterator
         */
        public RDLListIterator() {
            nextNode = tail;
            nextCalled = false;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return nextNode.previous().getData() != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                nextNode = nextNode.previous();
                nextCalled = true;
                return nextNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call to next(); "
                    + "iterator is after end of list.");
            }
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (nextCalled) {
                nextNode.previous().setNext(nextNode.next());
                nextNode.next().setPrevious(nextNode.previous());
                size--;
                nextCalled = false;
            }
            else {
                throw new IllegalStateException("Illegal call to remove(); "
                    + "next() was not called.");
            }

        }
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> reverseIterator() {
        return new RDLListIterator<E>();
    }
}
