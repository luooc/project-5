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
public class SorterTest {
    // Fields -----------------------------------------------
    private Reader reader;
    private DLList<Song> songs;
    private DLList<Student> students;
    private Sorter sorter;


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
        songs = reader.getSongs();
        students = reader.getStudents();
        sorter = new Sorter(songs, students);
    }


    /**
     * Tests to make sure the method sortByGenre works as intended
     */
    public void testSortByGenre() {

    }


    /**
     * Tests to make sure the method sortByArtist works as intended
     */
    public void testSortByArtist() {

    }


    /**
     * Tests to make sure the method sortByTitle works as intended
     */
    public void testSortByTitle() {

    }


    /**
     * Tests to make sure the method sortByDate works as intended
     */
    public void testSortByDate() {

    }


    /**
     * Tests to make sure the method sortByHobby works as intended
     */
    public void testSortByHobby() {

    }


    /**
     * Tests to make sure the method sortByMajor works as intended
     */
    public void testSortByMajor() {

    }


    /**
     * Tests to make sure the method sortByRegion works as intended
     */
    public void testSortByRegion() {

    }

}
