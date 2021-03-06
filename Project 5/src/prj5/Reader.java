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
import java.util.Scanner;

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

public class Reader {
    private DLList<Song> songList;
    private DLList<Student> studentList;


    /**
     * two-argument constructor
     * 
     * @param songFileName
     *            name of the file containing the song information
     * @param studentFileName
     *            name of the file containing the student information
     * @throws FileNotFoundException
     *             if file cannot be found
     */
    public Reader(String songFileName, String studentFileName)
        throws FileNotFoundException {
        songList = readSongFile(songFileName);
        studentList = readStudentFile(studentFileName);
    }


    /**
     * helper-method, returns a DLList of type Song representing the information
     * in the song file
     * 
     * @param fileName
     *            name of song file
     * @return DLList representation of song info
     * @throws FileNotFoundException
     *             if file cannot be found
     */
    private DLList<Song> readSongFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        DLList<Song> copy = new DLList<Song>();

        while (file.hasNext()) {
            String nextLine = file.nextLine();
            if (!nextLine.equals("Song Title,Artist,Year,Genre")) {
                String[] info = nextLine.split(",");
                if (info.length == 4) {
                    Song newSong = new Song(info[0], info[1], Integer.parseInt(
                        info[2]), info[3]);
                    copy.add(newSong);
                }
            }
        }
        file.close();
        return copy;
    }


    /**
     * helper-method, returns a DLList of type Student representing the
     * information in the student file
     * 
     * @param fileName
     *            name of student file
     * @return DLList representation of student info
     * @throws FileNotFoundException
     *             if file cannot be found
     */
    private DLList<Student> readStudentFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        DLList<Student> copy = new DLList<Student>();
        file.nextLine();
        while (file.hasNextLine()) {
            String[] info = file.nextLine().split(",");
            if(info.length >= 6) {
                String hobby = info[4];
                String major = info[2];
                String region = info[3];
                String[] songsHeard = new String[((info.length - 5) / 2)+1];
                String[] songsLiked = new String[((info.length - 5) / 2)+1];
                int count = 0;
                for (int i = 5; i < info.length; i += 2)
                {
                    songsHeard[count] = info[i];
                    count++;
                }
                count = 0;
                for (int i = 6; i < info.length; i += 2)
                {
                    songsLiked[count] = info[i];
                    count++;
                }
                Student student = new Student(hobby, major, region, songsHeard,
                    songsLiked);
                copy.add(student);
            }
        }
        file.close();
        return copy;
    }


    /**
     * getter for songList field
     * 
     * @return songList DLList
     */
    public DLList<Song> getSongs() {
        return songList;
    }


    /**
     * getter for studentList field
     * 
     * @return studentList DLList
     */
    public DLList<Student> getStudents() {
        return studentList;
    }
}
