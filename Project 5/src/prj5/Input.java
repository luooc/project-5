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

public class Input {

    /**
     * Constructor intentionally left blank
     */
    public Input() {
        // nothing goes here
    }


    /**
     * Creates a GUIWindow and sends two input files
     * 
     * @param args
     *            a String array
     */
    public static void main(String[] args) {
        GUIWindow window = new GUIWindow("SongList2018.csv",
            "MusicSurveyData2018.csv");
    }
}
