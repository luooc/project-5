package prj5;

public class Student
{
    private String hobby;
    private String major;
    private String state;
    private String[] songsHeard;
    private String[] songsLiked;
    
    /**
     * Constructor for student object
     * @param hobby 
     * @param major
     * @param state
     */
    public Student(String hobby, String major, String state)
    {
        this.hobby = hobby;
        this.major = major;
        this.state = state;
    }
    
    public String getHobby()
    {
        return hobby;
    }
    
    public String getMajor()
    {
        return major;
    }
    
    public String getState()
    {
        return state;
    }
    
    public String[] getSongsHeard()
    {
        return songsHeard;
    }
    
    public String[] getSongsLiked()
    {
        return songsLiked;
    }
}
