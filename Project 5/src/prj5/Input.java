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

import java.io.File;
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

public class Input {
    /**
     * Constructor intentionally left blank
     */
    public Input() {

    }


    /**
     * Creates a GUIWindow and sends two input files
     * 
     * @param args
     *            a String array
     */
    public static void main(File surveyData, File songList) {
        GUIWindow window = new GUIWindow("SongList2018.csv",
            "MusicSurveyData2018.csv");
        String studentFile = surveyData.getName();
        String songFile = songList.getName();

        Reader reader = null;
        try {
            reader = new Reader(songFile, studentFile);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Sorter sorter = new Sorter(reader.getSongs(), reader.getStudents());

        DLList<Student> students = sorter.sortByHobby();
        DLList<Song> songs = sorter.sortByGenre();
        output(students, songs);

        songs = sorter.sortByTitle();
        output(students, songs);

    }


    private static void output(DLList<Student> students, DLList<Song> songs) {

    }
}
