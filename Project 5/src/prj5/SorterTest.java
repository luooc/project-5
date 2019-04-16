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
     * fields
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


    /**
     * sets up variables for testing
     */
    public void setUp() {
        songs = new DLList<Song>();
        students = new DLList<Student>();
        song1 = new Song("Ariana Grande", "R.E.M.", 2018, "Pop");
        song2 = new Song("Marc E. Bassy", "Morning", 2016, "R&B");
        song3 = new Song("Whitney Houston", "I Will Always Love You", 1974,
            "Balad");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        student1 = new Student("Art", "Computer Science", "Virginia",
            new String[3], new String[3]);
        student2 = new Student("Singing", "Food Science", "Wisconsin",
            new String[3], new String[3]);
        student3 = new Student("Animation", "Human Foods & Nutrition",
            "California", new String[3], new String[3]);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        sorter = new Sorter(songs, students);
    }


    /**
     * tests sortByGenre() method
     */
    public void testSortByGenre() {
        DLList<Song> temp = sorter.sortByGenre();
        assertEquals(temp.get(0), (Song)song2);
        assertEquals(temp.get(1), (Song)song3);
        assertEquals(temp.get(2), (Song)song1);
    }


    /**
     * tests sortByArtist() method
     */
    public void testSortByArtist() {
        DLList<Song> temp = sorter.sortByArtist();
        assertEquals(temp.get(0), (Song)song1);
        assertEquals(temp.get(1), (Song)song2);
        assertEquals(temp.get(2), (Song)song3);
    }


    /**
     * tests sortByTitle() method
     */
    public void testSortByTitle() {
        DLList<Song> temp = sorter.sortByTitle();
        assertEquals(temp.get(0), (Song)song3);
        assertEquals(temp.get(1), (Song)song2);
        assertEquals(temp.get(2), (Song)song1);
    }


    /**
     * tests sortByDate() method
     */
    public void testSortByDate() {
        DLList<Song> temp = sorter.sortByDate();
        assertEquals(temp.get(0), (Song)song3);
        assertEquals(temp.get(1), (Song)song2);
        assertEquals(temp.get(2), (Song)song1);
    }


    /**
     * tests sortByHobby() method
     */
    public void testSortByHobby() {
        DLList<Student> temp = sorter.sortByHobby();
        assertEquals(temp.get(0), (Student)student1);
        assertEquals(temp.get(1), (Student)student3);
        assertEquals(temp.get(2), (Student)student2);
    }


    /**
     * tests sortByMajor() method
     */
    public void testSortByMajor() {
        DLList<Student> temp = sorter.sortByMajor();
        assertEquals(temp.get(0), (Student)student1);
        assertEquals(temp.get(1), (Student)student2);
        assertEquals(temp.get(2), (Student)student3);
    }


    /**
     * tests sortByRegion() method
     */
    public void testSortByRegion() {
        DLList<Student> temp = sorter.sortByRegion();
        assertEquals(temp.get(0), (Student)student3);
        assertEquals(temp.get(1), (Student)student1);
        assertEquals(temp.get(2), (Student)student2);
    }
}
