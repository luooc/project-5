package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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


    public Reader(String songFileName, String studentFileName)
        throws FileNotFoundException {
        songList = readSongFile(songFileName);
        studentList = readStudentFile(studentFileName);
    }


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


    private DLList<Student> readStudentFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        DLList<Student> copy = new DLList<Student>();
        StringBuilder s = new StringBuilder();

        while (file.hasNext()) {
            String nextLine = file.nextLine();
            if (!nextLine.contains("\n")) {
                s.append(nextLine);
            }
            else {
                String info = s.toString();
                String[] student = info.split(",");
                ArrayList<String> likes = new ArrayList<String>();
                ArrayList<String> heard = new ArrayList<String>();
                for (int i = 5; i < student.length; i += 2) {
                    heard.add(student[i]);
                }
                for (int i = 6; i < student.length; i += 2) {
                    likes.add(student[i]);
                }
                copy.add(new Student(student[4], student[2], student[3],
                    (String[])heard.toArray(), (String[])likes.toArray()));
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