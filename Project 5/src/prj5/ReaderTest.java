package prj5;

import static org.junit.Assert.assertEquals;
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
public class ReaderTest {
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
        DLList<Song> songs = new DLList<Song>();
        assertEquals(reader.getSongs(), songs);
    }


    /**
     * Tests to make sure the method getStudents works as intended
     */
    public void testGetStudents() {
        DLList<Student> students = new DLList<Student>();
        assertEquals(reader.getStudents(), students);
    }
}
