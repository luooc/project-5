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
        song1 = new Song("Ariana Grande", "R.E.M.", "Pop", 2018);
        song2 = new Song("Marc E. Bassy", "Morning", "R&B", 2016);
        song3 = new Song("Whitney Houston", "I Will Always Love You", "Balad",
            1974);
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        student1 = new Student("Art", "Computer Science", "Virginia");
        student2 = new Student("Singing", "Food Science", "Wisconsin");
        student3 = new Student("Animation", "Human Foods & Nutrition",
            "California");
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
