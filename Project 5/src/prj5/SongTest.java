package prj5;

public class SongTest extends student.TestCase {
    // Fields -----------------------------------------------
    private Song song;
    private Song otherSong;
    private Song sameSong;
    private Song nullSong;
    private Object obj;


    /**
     * Sets up variables for testing
     */
    public void setUp() {
        song = new Song("Artist", "Title", 2000, "Genre");
        otherSong = new Song("Other Artist", "Title", 2000, "Genre");
        sameSong = new Song("Artist", "Title", 2000, "Genre");
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
        assertFalse(song.equals(otherSong));
        assertFalse(song.equals(nullSong));
        assertFalse(song.equals(obj));
    }

}
