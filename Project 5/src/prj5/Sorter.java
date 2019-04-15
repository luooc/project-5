package prj5;

public class Sorter
{
    private DLList<Song> songList;
    private DLList<Student> studentList;
    
    public Sorter(DLList<Song> songs, DLList<Student> students)
    {
        this.songList = songs;
        this.studentList = students;
    }
}
