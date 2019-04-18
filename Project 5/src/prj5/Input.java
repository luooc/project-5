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
    public static void main(String[] args) {
        String studentFile = args[0];
        String songFile = args[1];
        GUIWindow window = new GUIWindow(songFile, studentFile);

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
        output(students, songs, sorter.getSongList());

        songs = sorter.sortByTitle();
        output(students, songs, sorter.getSongList());
    }


    private static void output(DLList<Student> students, DLList<Song> songs, DLList<Song> original)
    {
        for (int i = 0; i < songs.size(); i++)
        {
            int index = 0;
            for (int j = 0; j < original.size(); j++)
            {
                if (songs.get(i).equals(original.get(j)))
                {
                    index = j;
                }
            }
            
            System.out.println("Song Title: " + songs.get(i).getTitle());
            System.out.println("Song Artist: " + songs.get(i).getArtist());
            System.out.println("Song Genre: " + songs.get(i).getGenre());
            System.out.println("Song Year: " + songs.get(i).getDate());
            
            int[] reading = getPercentage(students, "reading", index);
            int[] art = getPercentage(students, "art", index);
            int[] sports = getPercentage(students, "sports", index);
            int[] music = getPercentage(students, "music", index);
            
            System.out.println("Heard");
            System.out.println("reading:" + reading[1] + " art:" + art[1] + " sports:"
                + sports[1] + " music:" + music[1]);
            
            System.out.println("Likes");
            System.out.println("reading:" + reading[0] + " art:" + art[0] + " sports:"
                + sports[0] + " music:" + music[0] + "\n");
        }

    }
    
    /**
     * Helper method to find count of students who liked/heard the song
     * @param students
     * @param hobby
     * @param songIndex
     * @return an array [liked, heard]
     */
    private static int[] getPercentage(DLList<Student> students, String hobby, int songIndex)
    {
        int yesLiked = 0;
        int yesHeard = 0;
        int noLiked = 0;
        int noHeard = 0;
        
        for (int i = 0; i < students.size(); i++)
        {
            Student check = students.get(i);
            if (check.getHobby() != null && check.getMajor() != null && check.getState() != null)
            {
                if (check.getHobby().equals(hobby))
                {
                    if (check.getSongsLiked()[songIndex] != null)
                    {
                        if (check.getSongsLiked()[songIndex].equals("Yes"))
                        {
                            yesLiked++;
                        }
                        else if (check.getSongsLiked()[songIndex].equals("No"))
                        {
                            noLiked++;
                        }
                    }
                    if (check.getSongsHeard()[songIndex] != null)
                    {
                        if (check.getSongsHeard()[songIndex].equals("Yes"))
                        {
                            yesHeard++;
                        }
                        else if (check.getSongsHeard()[songIndex].equals("No"))
                        {
                            noHeard++;
                        }
                    }
                }
            }
            
        }
        int percentageLiked = 0;
        if (yesLiked != 0)
        {
            percentageLiked = (int)(yesLiked * 100 / (yesLiked + noLiked));
        }
        
        int percentageHeard = 0;
        if (yesHeard != 0)
        {
            percentageHeard = (int)(yesHeard * 100 / (yesHeard + noHeard));
        }
        int[] info = {percentageLiked, percentageHeard};
        return info;
    }
}
