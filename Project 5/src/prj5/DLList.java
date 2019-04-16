package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <T>
 *            The type of object the class will store
 */
public class DLList<T> {
    /**
     * A doubly linked node that stores data of type E
     *
     * @param <T>
     *            The type of object that this class will store
     */
    private static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T data;


        /**
         * Creates a new node
         *
         * @param data
         *            the data for the node
         */
        public Node(T data) {
            this.data = data;
        }


        /**
         * Sets the node after this node to the given node
         *
         * @param next
         *            the node after this node
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }


        /**
         * Sets the node before this to the given node
         *
         * @param previous
         *            the node before this node
         */
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }


        /**
         * Returns the next node
         *
         * @return the next node
         */
        public Node<T> next() {
            return next;
        }


        /**
         * Returns the node before this one
         *
         * @return the node before this one
         */
        public Node<T> previous() {
            return previous;
        }


        /**
         * Returns the data in the node
         *
         * @return the data in the node
         */
        public T getData() {
            return data;
        }
    }

    // Fields -----------------------------------------------------
    private int size;
    private Node<T> head;
    private Node<T> tail;


    // Constructor ------------------------------------------------
    /**
     * Creates a new DLList object
     */
    public DLList() {
        init();
    }


    /**
     * Initializes the DLList with sentinel nodes
     */
    private void init() {
        head = new DLList.Node<T>(null);
        head.setNext(tail);
        tail = new DLList.Node<T>(null);
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
     * Clears all the entries from the list while keeping the sentinel nodes
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
    public boolean contains(T obj) {
        return lastIndexOf(obj) != -1;
    }


    /**
     * Returns the object at the given index
     *
     * @param index
     *            where the object is
     * @return The object at the given index
     * @throws IndexOutOfBoundsException
     *             if the index is not within the size of the list
     */
    public T get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end of the list
     */
    public void add(T newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds the object at the index given to the list
     *
     * @param index
     *            where in the list the object goes
     * @param obj
     *            the object to add to the list
     * @throws IndexOutOfBoundsException
     *             if the index is not within the size of the list
     * @throws IllegalArgumentException
     *             if the obj given is null
     */
    public void add(int index, T obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<T> current;
        if (index == size) {
            current = tail;
        }
        else {
            current = getNodeAtIndex(index);
        }

        Node<T> newNode = new Node<T>(obj);
        newNode.setPrevious(current.previous());
        newNode.setNext(current);
        current.previous().setNext(newNode);
        current.setPrevious(newNode);
        size++;

    }


    /**
     * Returns the node at the index given
     * 
     * @param index
     *            the index of the node
     * @return node the node at the index
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<T> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Returns the index of the last time the object occurs in the list
     *
     * @param obj
     *            an object in the list
     * @return the index of the last time the object occurs in the list starting
     *         at 0, or -1 If the object is not in the list
     */
    public int lastIndexOf(T obj) {
        Node<T> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1;
    }


    /**
     * Removes the entry at the given index from the list
     *
     * @param index
     *            where the object is in the list
     * @throws IndexOutOfBoundsException
     *             if the index is not within the size of the list
     * @return true if the entry is removed
     */
    public boolean remove(int index) {
        Node<T> node = getNodeAtIndex(index);
        node.previous().setNext(node.next());
        node.next().setPrevious(node.previous());
        size--;
        return true;
    }


    /**
     * Removes the first time the entry occurs in the list from the list
     *
     * @param obj
     *            the object to remove
     * @return true if the entry was removed
     */

    public boolean remove(T obj) {
        Node<T> current = head.next();
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
     * Returns a string representation of the list
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        String str = "[";
        if (!isEmpty()) {
            Node<T> current = head.next();
            while (current != tail) {
                str = str + current.getData();
                if (current.next != tail) {
                    str = str + ", ";
                }
                current = current.next();
            }
        }
        return str + "}";
    }


    /**
     * Creates an iterator for a DLList
     */
    private class DLListIterator<A> implements Iterator<T> {
        // Fields
        private Node<T> nextNode;
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
        public T next() {
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
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new DLListIterator<T>();
    }


    /**
     * Returns an array representing the doubly linked list
     *
     * @return an array representing the doubly linked list
     */
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.getData();
            current = current.next();
        }
        return arr;
    }

}
