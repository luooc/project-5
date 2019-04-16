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


    /**
     * Returns a String representation of a Song object
     * 
     * @return a String representation of a Song object
     */
    public String toString() {
        return "Artist: " + artist + " Title: " + title + " Genre: " + genre
            + " Release Year: " + date;
    }


    /**
     * Returns a boolean value representing whether an object is equal to this
     * Song
     * 2 Songs are considered equal if all 4 of their input values are the same
     * 
     * @param obj
     *            an Object to compare aginst
     * @return true if the the object is equal to this Song
     */
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
