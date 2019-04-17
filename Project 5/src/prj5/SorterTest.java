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
public class SorterTest extends student.TestCase {

    /**
     * Sets up variables for testing
     */

    private Song song1;
    private Song song2;
    private Song song3;
    private Student student1;
    private Student student2;
    private Student student3;
    private DLList<Song> songs;
    private DLList<Student> students;
    private Sorter sorter;
    private String[] songsHeard;
    public String[] songsLiked;


    /**
     * sets up variables for testing
     */
    public void setUp() {
        songs = new DLList<Song>();
        students = new DLList<Student>();
        song1 = new Song("R.E.M.", "Ariana Grande", 2018, "Pop");
        song2 = new Song("Morning", "Marc E. Bassy", 2016, "R&B");
        song3 = new Song("I Will Always Love You", "Whitney Houston", 1974,
            "Balad");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songsHeard = new String[3];
        songsHeard[0] = "R.E.M.";
        songsHeard[1] = "Morning";
        songsHeard[2] = "I  Will Always Love You";
        songsLiked = new String[3];
        songsLiked[0] = "R.E.M.";
        songsLiked[1] = "Morning";
        songsLiked[2] = "I  Will Always Love You";
        student1 = new Student("Art", "Computer Science", "Virginia",
            songsHeard, songsLiked);
        student2 = new Student("Singing", "Food Science", "Wisconsin",
            songsHeard, songsLiked);
        student3 = new Student("Animation", "Human Foods & Nutrition",
            "California", songsHeard, songsLiked);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        sorter = new Sorter(songs, students);
    }


    /**
     * tests sortByGenre() method
     */
    public void testSortByGenre() {
        sorter.sortByGenre();
        DLList<Song> temp = sorter.getSongList();
        assertEquals(temp.get(0), (Song)song2);
        assertEquals(temp.get(1), (Song)song3);
        assertEquals(temp.get(2), (Song)song1);
    }


    /**
     * tests sortByArtist() method
     */
    public void testSortByArtist() {
        sorter.sortByArtist();
        DLList<Song> temp = sorter.getSongList();
        assertEquals(temp.get(0), (Song)song1);
        assertEquals(temp.get(1), (Song)song2);
        assertEquals(temp.get(2), (Song)song3);
    }


    /**
     * tests sortByTitle() method
     */
    public void testSortByTitle() {
        sorter.sortByTitle();
        DLList<Song> temp = sorter.getSongList();
        assertEquals(temp.get(0), (Song)song3);
        assertEquals(temp.get(1), (Song)song2);
        assertEquals(temp.get(2), (Song)song1);
    }


    /**
     * tests sortByDate() method
     */
    public void testSortByDate() {
        sorter.sortByDate();
        DLList<Song> temp = sorter.getSongList();
        assertEquals(temp.get(0), (Song)song3);
        assertEquals(temp.get(1), (Song)song2);
        assertEquals(temp.get(2), (Song)song1);
    }


    /**
     * tests sortByHobby() method
     */
    public void testSortByHobby() {
        sorter.sortByHobby();
        DLList<Student> temp = sorter.getStudentList();
        assertEquals(temp.get(0), (Student)student1);
        assertEquals(temp.get(1), (Student)student3);
        assertEquals(temp.get(2), (Student)student2);
    }


    /**
     * tests sortByMajor() method
     */
    public void testSortByMajor() {
        sorter.sortByHobby();
        DLList<Student> temp = sorter.getStudentList();
        assertEquals(temp.get(0), (Student)student1);
        assertEquals(temp.get(1), (Student)student2);
        assertEquals(temp.get(2), (Student)student3);
    }


    /**
     * tests sortByRegion() method
     */
    public void testSortByRegion() {
        sorter.sortByHobby();
        DLList<Student> temp = sorter.getStudentList();
        assertEquals(temp.get(0), (Student)student3);
        assertEquals(temp.get(1), (Student)student1);
        assertEquals(temp.get(2), (Student)student2);
    }
}
