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
public class SongTest extends student.TestCase {

    /**
     * ~ FIELDS ...............................................................
     */

    private Song song;
    private Song sameSong;
    private Song nullSong;
    private Song differentArtist;
    private Song differentDate;
    private Song differentGenre;
    private Song differentTitle;
    private Object obj;


    /**
     * Instantiates variables to be used in testing, runs before every test
     * case
     */
    @Override
    public void setUp() {
        song = new Song("Title", "Artist", 2000, "Genre");
        sameSong = new Song("Title", "Artist", 2000, "Genre");
        differentArtist = new Song("Title", "Different Artist", 2000, "Genre");
        differentDate = new Song("Different Title", "Artist", 2000, "Genre");
        differentGenre = new Song("Title", "Artist", 2000, "Different Genre");
        differentTitle = new Song("Title", "Artist", 2001, "Genre");
        nullSong = null;
        obj = new Object();
    }


    /**
     * Tests to make sure the method getArtist works as intended
     */
    public void testGetArtist() {
        assertEquals(song.getArtist(), "Artist");
    }


    /**
     * Tests to make sure the method getTitle works as intended
     */
    public void testGetTitle() {
        assertEquals(song.getTitle(), "Title");
    }


    /**
     * Tests to make sure the method getGenre works as intended
     */
    public void testGetGenre() {
        assertEquals(song.getGenre(), "Genre");
    }


    /**
     * Tests to make sure the method getDate works as intended
     */
    public void testGetDate() {
        assertEquals(song.getDate(), 2000);
    }


    /**
     * Tests to make sure the method toString works as intended
     */
    public void testToString() {
        assertEquals(song.toString(),
            "Artist: Artist Title: Title Genre: Genre Release Year: 2000");
    }


    /**
     * Tests to make sure the method equals works as intended
     */
    public void testEquals() {
        assertTrue(song.equals(sameSong));
        assertTrue(song.equals(song));
        assertFalse(song.equals(nullSong));
        assertFalse(song.equals(obj));
        assertFalse(song.equals(differentArtist));
        assertFalse(song.equals(differentTitle));
        assertFalse(song.equals(differentGenre));
        assertFalse(song.equals(differentDate));
    }

}
