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

import java.util.Arrays;

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

public class StudentTest extends student.TestCase {
   
    /**
     * ~ FIELDS ...............................................................
     */
    private Student student;
    private Student differentHobby;
    private Student differentMajor;
    private Student differentState;
    private Student differentSongsHeard;
    private Student differentSongsLiked;
    private Student sameStudent;
    private Student nullStudent;
    private Object obj;
    private String[] songsHeard = { "yes", "no", "yes" };
    private String[] songsLiked = { "yes", "no", "yes" };
    private String[] differentHeard = { "no", "yes", "no" };
    private String[] differentLiked = { "no", "yes", "no" };



    /**
     * Instantiates variables to be used in testing, runs before every test
     * case
     */
    public void setUp() {
        student = new Student("Hobby", "Major", "State", songsHeard,
            songsLiked);
        differentHobby = new Student("Different Hobby", "Other Major", "Other State",
            songsHeard, songsLiked);
        differentMajor = new Student("Hobby", "Different Major", "State", songsHeard,
            songsLiked);
        differentState = new Student("Hobby", "Major", "Different State", songsHeard,
            songsLiked);
        differentSongsHeard = new Student("Hobby", "Major", "State", differentHeard,
            songsLiked);
        differentSongsLiked = new Student("Hobby", "Major", "State", songsHeard,
            differentLiked);
        sameStudent = new Student("Hobby", "Major", "State", songsHeard,
            songsLiked);
        nullStudent = null;
        obj = new Object();
    }


    /**
     * Tests to make sure the method getHobby works as intended
     */
    public void testGetHobby() {
        assertEquals(student.getHobby(), "Hobby");
    }


    /**
     * Tests to make sure the method getMajor works as intended
     */
    public void testGetMajor() {
        assertEquals(student.getMajor(), "Major");
    }


    /**
     * Tests to make sure the method getState works as intended
     */
    public void testGetState() {
        assertEquals(student.getState(), "State");
    }


    /**
     * Tests to make sure the method getSongsHeard works as intended
     */
    public void testGetSongsHeard() {
        assertEquals(student.getSongsHeard(), songsHeard);
    }


    /**
     * Tests to make sure the method getSongsLiked works as intended
     */
    public void testGetSongsLiked() {
        assertEquals(student.getSongsLiked(), songsLiked);
    }


    /**
     * Tests to make sure the method toString works as intended
     */
    public void testToString() {
        assertEquals(student.toString(),
            "Hobby: Hobby Major: Major State: State Songs heard: " + Arrays
                .toString(songsHeard) + "Songs Liked: " + Arrays.toString(
                    songsLiked));
    }


    /**
     * Tests to make sure the method equals works as intended
     */
    public void testEquals() {
        assertTrue(student.equals(student));
        assertTrue(student.equals(sameStudent));
        assertFalse(student.equals(differentHobby));
        assertFalse(student.equals(differentHobby));
        assertFalse(student.equals(differentMajor));
        assertFalse(student.equals(differentState));
        assertFalse(student.equals(differentSongsHeard));
        assertFalse(student.equals(differentSongsLiked));
        assertFalse(student.equals(nullStudent));
        assertFalse(student.equals(obj));
    }
}
