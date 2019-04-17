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
    public static void main(String[] files) {
        String studentFile = files[0];
        String songFile = files[1];
        GUIWindow window = new GUIWindow("SongList2018.csv",
            "MusicSurveyData2018.csv");

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
        for (int i = 0; i < songs.size(); i++) {
            System.out.println("Song Title: " + songs.get(i).getTitle());
            System.out.println("Song Artist: " + songs.get(i).getArtist());
            System.out.println("Song Genre: " + songs.get(i).getGenre());
            System.out.println("Song Year: " + songs.get(i).getDate());
            int j = 0;
            int art = 0;
            while (students.get(j).getHobby().equals("art")) {
                if (students.get(j).getSongsHeard()[i].equals("yes")) {
                    art++;
                }
                j++;
            }

            int music = 0;
            while (students.get(j).getHobby().equals("music")) {
                if (students.get(j).getSongsHeard()[i].equals("yes")) {
                    music++;
                }
                j++;
            }
            int sports = 0;
            while (students.get(j).getHobby().equals("sports")) {
                if (students.get(j).getSongsHeard()[i].equals("yes")) {
                    sports++;
                }
                j++;
            }
            int reading = 0;
            while (students.get(j).getHobby().equals("reading")) {
                if (students.get(j).getSongsHeard()[i].equals("yes")) {
                    reading++;
                }
                j++;
            }
            System.out.println("Heard");
            System.out.println("reading:" + reading + " art:" + art + " sports:"
                + sports + " music:" + music);
            j = 0;
            art = 0;
            while (students.get(j).getHobby().equals("art")) {
                if (students.get(j).getSongsLiked()[i].equals("yes")) {
                    art++;
                }
                j++;
            }

            music = 0;
            while (students.get(j).getHobby().equals("music")) {
                if (students.get(j).getSongsLiked()[i].equals("yes")) {
                    music++;
                }
                j++;
            }
            sports = 0;
            while (students.get(j).getHobby().equals("sports")) {
                if (students.get(j).getSongsLiked()[i].equals("yes")) {
                    sports++;
                }
                j++;
            }
            reading = 0;
            while (students.get(j).getHobby().equals("reading")) {
                if (students.get(j).getSongsLiked()[i].equals("yes")) {
                    reading++;
                }
                j++;
            }
            System.out.println("Liked");
            System.out.println("reading:" + reading + " art:" + art + " sports:"
                + sports + " music:" + music);
        }

    }
}
