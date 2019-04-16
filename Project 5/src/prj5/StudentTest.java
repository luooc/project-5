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
 */

public class StudentTest extends student.TestCase {
    // Fields ---------------------------------------
    private Student student;
    private Student otherStudent;
    private Student sameStudent;
    private Student nullStudent;
    private Object obj;
    private String[] songsHeard = { "yes", "no", "yes" };
    private String[] songsLiked = { "yes", "no", "yes" };;


    /**
     * Initializes variables for testing
     */
    public void setUp() {
        student = new Student("Hobby", "Major", "State", songsHeard,
            songsLiked);
        otherStudent = new Student("Other Hobby", "Other Major", "Other State",
            songsHeard, songsLiked);
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
            "Hobby: Hobby Major: Major State: State Songs heard: " + songsHeard
                + "Songs Liked: " + songsLiked);
    }


    /**
     * Tests to make sure the method equals works as intended
     */
    public void testEquals() {
        assertTrue(student.equals(student));
        assertTrue(student.equals(sameStudent));
        assertFalse(student.equals(otherStudent));
        assertFalse(student.equals(nullStudent));
        assertFalse(student.equals(obj));
    }
}
