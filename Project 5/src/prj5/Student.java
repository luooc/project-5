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

public class Student {
    private String hobby;
    private String major;
    private String state;
    private String[] songsHeard;
    private String[] songsLiked;


    /**
     * Constructor for student object
     * 
     * @param hobby
     *            param for hobby field
     * @param major
     *            param for major field
     * @param state
     *            param for state field
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
     * Returns a String representation of the Student
     * 
     * @return a String representation of the Student
     */
    public String toString() {
        return "Hobby: " + hobby + " Major: " + major + " State: " + state
            + " Songs heard: " + Arrays.toString(songsHeard) + "Songs Liked: " 
            + Arrays.toString(songsLiked);
    }


    /**
     * Returns whether or not an object is equal to this student
     * 2 students are considered equal if their 5 input fields are the same
     * 
     * @param obj
     *            an object to compare against
     * @return true if they are equals
     */
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
