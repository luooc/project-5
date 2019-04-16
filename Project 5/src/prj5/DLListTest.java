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

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * @author Avni Trasi (avnitrasi)
 * @version 2019.04.15
 * @author James Livingston (jamesrliving)
 * @version 2019.04.15
 * @author Oliver Luo (luooc)
 * @version 2019.04.15
 * @author Sabrina Lesser (brinalesser)
 * @version 2019.04.15
 */

public class DLListTest extends TestCase {
    /**
     * Fields
     */
    private DLList<String> list;
    private DLList<String> emptyList;


    /**
     * Instantiates variables to be used in testing
     */
    @Override
    public void setUp() {
        list = new DLList<String>();
        emptyList = new DLList<String>();
    }


    /**
     * Tests that the method remove works as intended
     */
    public void testRemove() {
        // Makes sure remove throws the correct exceptions
        list.add("0");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        assertTrue(list.remove("0"));
        e = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        e = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        list.add("0");
        Iterator<String> iter = list.iterator();
        e = null;
        try {
            iter.remove();
        }
        catch (IllegalStateException exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalStateException);

        assertEquals(list.size(), 1);
        iter.next();
        iter.remove();
        assertEquals(list.size(), 0);

        e = null;
        try {
            iter.remove();
        }
        catch (IllegalStateException exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalStateException);

        // Makes sure remove works when calling with an index
        list.add("0");
        list.add("1");
        assertEquals(2, list.size());
        assertTrue(list.contains("1"));
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        assertFalse(list.contains("1"));
        assertFalse(list.remove(null));

        // Makes sure remove works when calling with an object
        list.clear();
        list.add("0");
        list.add("1");
        assertFalse(list.remove("2"));
        assertEquals("0", list.get(0));
        assertEquals(2, list.size());
        assertTrue(list.remove("0"));
        assertEquals("1", list.get(0));
        assertEquals(1, list.size());
        assertFalse(list.remove("0"));

        // Makes sure the iterator's remove works
        list.clear();
        list.add("0");
        list.add("1");
        list.add("2");
        iter = list.iterator();

        assertEquals(list.size(), 3);
        assertTrue(list.contains("0"));
        iter.next();
        iter.remove();
        assertEquals(list.size(), 2);
        assertFalse(list.contains("0"));
    }


    /**
     * Tests that the method add works as intended
     */
    public void testAdd() {
        // Makes sure the one parameter add method works
        assertEquals(0, list.size());
        list.add("0");
        assertEquals(1, list.size());
        assertEquals("0", list.get(0));
        list.add("1");
        assertEquals(2, list.size());
        assertEquals("1", list.get(1));

        // Makes sure the two parameter add method works
        list.clear();
        list.add(0, "1");
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));
        list.add(1, "2");
        assertEquals(2, list.size());
        assertEquals("2", list.get(1));
        list.add(0, "0");
        assertEquals(3, list.size());
        assertEquals("0", list.get(0));
        assertEquals("1", list.get(1));

        // Makes sure the correct exceptions are thrown
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);

        e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);

        list.clear();
        e = null;
        try {
            list.add(1, "1");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        list.add("0");
        e = null;
        try {
            list.add(2, "2");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        e = null;
        try {
            list.add(-1, "-1");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests to make sure the method get works as intended
     */
    public void testGet() {
        list.add("0");
        assertEquals("0", list.get(0));

        Exception e = null;
        try {
            list.get(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);

        e = null;
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests to make sure the method contains works as intended
     */
    public void testContains() {
        assertFalse(list.contains("0"));
        list.add("0");
        assertTrue(list.contains("0"));
        assertFalse(list.contains("1"));
        list.add("1");
        assertTrue(list.contains("1"));
        list.remove("1");
        assertFalse(list.contains("1"));
    }


    /**
     * Tests to make sure the method lastIndexOf works as intended
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("0"));
        list.add("0");
        assertEquals(0, list.lastIndexOf("0"));
        list.add("0");
        assertEquals(1, list.lastIndexOf("0"));
        list.add("2");
        assertEquals(2, list.lastIndexOf("2"));
        list.add("0");
        assertEquals(3, list.lastIndexOf("0"));
    }


    /**
     * Tests to make sure the method isEmpty works as intended
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("0");
        assertFalse(list.isEmpty());
        list.remove("0");
        assertTrue(list.isEmpty());
    }


    /**
     * Tests to make sure the method clear works as intended
     */
    public void testClear() {
        list.add("0");
        assertEquals(1, list.size());
        assertTrue(list.contains("0"));
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("0"));
    }


    /**
     * Tests to make sure the method toString works as intended
     */
    public void testToString() {
        assertEquals("[]", list.toString());
        list.add("0");
        assertEquals("[0]", list.toString());
        list.add("1");
        list.add("2");
        assertEquals("[0, 1, 2]", list.toString());
    }


    /**
     * Tests to make sure the iterator's hasNext method works as intended
     */
    public void testHasNext() {
        list.clear();
        list.add("0");
        Iterator<String> iter = list.iterator();
        assertEquals(iter.hasNext(), true);
        iter.next();
        assertEquals(iter.hasNext(), false);
    }


    /**
     * Tests to make sure the iterator's next method works as intended
     */
    public void testNext() {
        list.clear();
        list.add("0");
        list.add("1");
        list.add("2");
        Iterator<String> iter = list.iterator();

        assertEquals(iter.next(), "0");
        assertEquals(iter.next(), "1");
        assertEquals(iter.next(), "2");

        Exception e = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);
    }


    /**
     * Tests to make sure the method toArray works as intended
     */
    public void testToArray() {
        list.clear();
        assertEquals(list.toArray().length, 0);
        list.add("0");
        list.add("1");
        assertEquals(list.toArray().length, 2);

    }
}
