// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Avni Trasi (avnitrasi)
// -- James Livingston (jamesrliving)
// -- Oliver Luo (luooc)
// -- Sabrina Lesser (brinalesser)

package prj5;

/**
* @author Avni Trasi (avnitrasi)
* @version 2019.04.15
* @author James Livingston (jamesrliving)
* @version 2019.04.15
* @author Oliver Luo (luooc)
* @version 2019.04.15
* @author Sabrina Lesser (brinalesser)
* @version 2019.04.15
* @param <T>
*            The type of object the class will store
*/

public interface DoublyLinkedList<T>
{    
    /**
     * Checks if the array is empty
     * @return if the array is empty
     */
    public abstract boolean isEmpty();

    /**
     * Gets the amount of elements in the list
     * @return the amount of elements in the list
     */
    public abstract int size();

    /**
     * Removes all of the elements from the list
     * @postcondition size = 0 and all of the nodes are removed
     */
    public abstract void clear();

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public abstract boolean contains(T obj);

    /**
     * Getter for a the element at the specified index of the list
     * @param index index to get the element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException
     *             if there is not a node at the given index
     */
    public abstract T get(int index);

    /**
     * Adds a new element to the linked list
     * @param newEntry element to be added
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public abstract void add(T newEntry);
    
    /**
     * Adds the object to the position in the list
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public abstract void add(int index, T obj);
    
    /**
     * Gets the node at the specified index
     * @param index index of the object
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @return the Node at the index
     */
    //public abstract Node<T> getNodeAtIndex(int index);
    
    /**
     * Removes the object at the given position
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public abstract boolean remove(int index);
    
    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public abstract boolean remove(T obj);
    
    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public abstract String toString();
    
    /**
     * Checks if this list is equal to the parameter
     * @param obj object to be compared
     * @return true if the two are equal, false if not
     */
    public abstract boolean equals(Object obj);
}
