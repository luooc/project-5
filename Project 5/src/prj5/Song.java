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

public class Song {
    private String artist;
    private String title;
    private String genre;
    private int date;


    /**
     * Constructor for Song object
     * 
     * @param artist
     *            param for artist field
     * @param title
     *            param for title field
     * @param genre
     *            param for genre field
     * @param date
     *            param for date field
     */
    public Song(String artist, String title, int date, String genre) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.date = date;
    }


    /**
     * getter for artist field
     * 
     * @return artist field
     */
    public String getArtist() {
        return artist;
    }


    /**
     * getter for title field
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }


    /**
     * getter for genre field
     * 
     * @return genre field
     */
    public String getGenre() {
        return genre;
    }


    /**
     * getter for date field
     * 
     * @return date field
     */
    public int getDate() {
        return date;
    }
}
