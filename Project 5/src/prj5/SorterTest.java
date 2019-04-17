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
     * Instantiates variables to be used in testing, runs before every test
     * case
     */
    @Override
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
        assertEquals(temp.get(0), song3);
        assertEquals(temp.get(1), song1);
        assertEquals(temp.get(2), song2);
    }


    /**
     * tests sortByArtist() method
     */
    public void testSortByArtist() {
        DLList<Song> temp = sorter.sortByArtist();
        assertEquals(temp.get(0), song1);
        assertEquals(temp.get(1), song2);
        assertEquals(temp.get(2), song3);
    }


    /**
     * tests sortByTitle() method
     */
    public void testSortByTitle() {
        DLList<Song> temp = sorter.sortByTitle();
        assertEquals(temp.get(0), song3);
        assertEquals(temp.get(1), song2);
        assertEquals(temp.get(2), song1);
    }


    /**
     * tests sortByDate() method
     */
    public void testSortByDate() {
        DLList<Song> temp = sorter.sortByDate();
        assertEquals(temp.get(0), song3);
        assertEquals(temp.get(1), song2);
        assertEquals(temp.get(2), song1);
    }


    /**
     * tests sortByHobby() method
     */
    public void testSortByHobby() {
        DLList<Student> temp = sorter.sortByHobby();
        assertEquals(temp.get(0), student3);
        assertEquals(temp.get(1), student1);
        assertEquals(temp.get(2), student2);
    }


    /**
     * tests sortByMajor() method
     */
    public void testSortByMajor() {
        DLList<Student> temp = sorter.sortByMajor();
        assertEquals(temp.get(0), student1);
        assertEquals(temp.get(1), student2);
        assertEquals(temp.get(2), student3);
    }


    /**
     * tests sortByRegion() method
     */
    public void testSortByRegion() {
        DLList<Student> temp = sorter.sortByRegion();
        assertEquals(temp.get(0), student3);
        assertEquals(temp.get(1), student1);
        assertEquals(temp.get(2), student2);
    }
}
