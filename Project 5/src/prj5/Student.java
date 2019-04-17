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

import java.util.Arrays;

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

public class Student {
    private String hobby;
    private String major;
    private String state;
    private String[] songsHeard;
    private String[] songsLiked;


    /**
     * five-argument constructor
     * 
     * @param hobby
     *            student's hobby
     * @param major
     *            student's major
     * @param state
     *            student's state of residence
     * @param songsHeard
     *            array of songs that a student has heard
     * @param songsLiked
     *            array of songs that a student liked from those they have heard
     */
    public Student(
        String hobby,
        String major,
        String state,
        String[] songsHeard,
        String[] songsLiked) {
        this.hobby = hobby;
        this.major = major;
        this.state = state;
        this.songsHeard = songsHeard;
        this.songsLiked = songsLiked;
    }


    /**
     * getter for hobby field
     * 
     * @return hobby field
     */
    public String getHobby() {
        return hobby;
    }


    /**
     * getter for major field
     * 
     * @return major field
     */
    public String getMajor() {
        return major;
    }


    /**
     * getter for state field
     * 
     * @return state field
     */
    public String getState() {
        return state;
    }


    /**
     * getter for songsHeard field
     * 
     * @return songsHeard field
     */
    public String[] getSongsHeard() {
        return songsHeard;
    }


    /**
     * getter for songsLiked field
     * 
     * @return songsLiked field
     */
    public String[] getSongsLiked() {
        return songsLiked;
    }


    /**
     * Returns a String representation of a Student object.
     * 
     * EX: a Student pupil with the following criteria-
     * 
     * arrayHeard = { "Ivy", "Africa", "Silver Soul"}
     * arrayLiked = {"Ivy", "Silver Soul"}
     * ("Painting", "Neuroscience", "Virginia, "Virginia", arrayHeard,
     * arrayLiked)
     * 
     * pupil.toString() will return "Hobby: Painting Major: Neuroscience State:
     * Virginia Songs heard: [Ivy, Africa, Silver Soul] Songs liked: [Ivy,
     * Silver Soul]"
     * 
     * @return a String representation of this Student object
     */
    @Override
    public String toString() {
        return "Hobby: " + hobby + " Major: " + major + " State: " + state
            + " Songs heard: " + Arrays.toString(songsHeard) + "Songs Liked: "
            + Arrays.toString(songsLiked);
    }


    /**
     * Compares two Student objects
     * 
     * @param obj
     *            an object to compare against
     * @return true if hobby, major, state, songsHeard, and songsLiked are
     *         identical, false if otherwise
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
            Student other = (Student)obj;
            if (other.getHobby().equals(this.getHobby()) && other.getMajor()
                .equals(this.getMajor()) && other.getState().equals(this
                    .getState()) && other.getSongsLiked().equals(this
                        .getSongsLiked()) && other.getSongsHeard().equals(this
                            .getSongsHeard())) {
                return true;
            }
        }
        return false;
    }
}
