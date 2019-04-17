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

public class Song {

    /**
     * ~ FIELDS ...............................................................
     */
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
    public Song(String title, String artist, int date, String genre) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.date = date;
    }


    /**
     * getter for artist field
     * 
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }


    /**
     * getter for title field
     * 
     * @return song title
     */
    public String getTitle() {
        return title;
    }


    /**
     * getter for genre field
     * 
     * @return song genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * getter for date field
     * 
     * @return song release date
     */
    public int getDate() {
        return date;
    }


    /**
     * Returns a String representation of a Song object.
     * EX: a Song tune with the following criteria-
     * ("Ivy", "Frank Ocean", 2016, "R&B")
     * tune.toString() will return "Artist: Frank Ocean Title: Ivy Genre: R&B
     * Release Year: 2016"
     * 
     * @return a String representation of this Song object
     */
    @Override
    public String toString() {
        return "Artist: " + artist + " Title: " + title + " Genre: " + genre
            + " Release Year: " + date;
    }


    /**
     * Compares two Song objects.
     * 
     * @param obj
     *            an Object to compare against
     * @return true if if all title, artist, date and genre are identical, false
     *         otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Song other = (Song)obj;
            if (other.getArtist().equals(this.getArtist()) && other
                .getDate() == this.getDate() && other.getGenre().equals(this
                    .getGenre()) && other.getTitle().equals(this.getTitle())) {
                return true;
            }
        }
        return false;
    }
}
