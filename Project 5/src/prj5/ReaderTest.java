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

import java.io.FileNotFoundException;

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
public class ReaderTest extends student.TestCase {
    // Fields -----------------------------------------------
    private Reader reader;


    /**
     * Sets up variables for testing
     */
    public void setUp() {
        try {
            reader = new Reader("SongList2018.csv", "MusicSurveyData2018.csv");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Tests to make sure the method getSongs works as intended
     */
    public void testGetSongs() {
        assertEquals(reader.getSongs().get(0), new Song("Hotline Bling",
            "Drake", 2015, "R&B"));
    }


    /**
     * Tests to make sure the method getStudents works as intended
     */
    public void testGetStudents() {
        assertEquals(reader.getStudents().get(0).getHobby(), "reading");
    }
}
