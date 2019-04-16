package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SongReader
{
    private DLList<Song> songList;
    private DLList<Student> studentList;
    
    public SongReader(String songFileName, String studentFileName)
    {
        
    }
    
    private DLList<Song> readSongFile(String fileName) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File(fileName));
        DLList<Song> copy = new DLList<Song>();
        
        while (file.hasNext())
        {
            String nextLine = file.nextLine();
            if (!nextLine.equals("Song Title,Artist,Year,Genre"))
            {
                String[] info = nextLine.split(",");
                if (info.length == 4)
                {
                    Song newSong = new Song(info[0], info[1], Integer.parseInt(info[2]), info[3]);
                    copy.add(newSong);
                }
            }
        }
        file.close();
        return copy;
        
    }
    
    private DLList<Student> readStudentFile(String fileName) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File(fileName));
    }
}
