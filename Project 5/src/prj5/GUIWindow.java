package prj5;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

public class GUIWindow {
    private Window window;
    private DLList<Student> students;
    private DLList<Song> songs;
    private Button previous;
    private Button next;
    private Glyph[] glyphs;
    private SongReader reader;
    private Sorter sorter;
    private int glyphIndex;

    public GUIWindow() {
        window = new Window();
        previous = new Button("<- Previous");
        window.addButton(previous, WindowSide.NORTH);
        Button artist = new Button("Sort by Artist Name");
        window.addButton(artist, WindowSide.NORTH);
        Button title = new Button("Sort by Song Title");
        window.addButton(title, WindowSide.NORTH);
        Button genre = new Button("Sort by Genre");
        window.addButton(genre, WindowSide.NORTH);
        Button year = new Button("Sort by Release Year");
        window.addButton(year, WindowSide.NORTH);
        next = new Button("Next ->");
        window.addButton(next, WindowSide.NORTH);
        Button major = new Button("Represent Major");
        window.addButton(major, WindowSide.SOUTH);
        Button state = new Button("Represent State");
        window.addButton(state, WindowSide.SOUTH);
        Button hobby = new Button("Represent Hobby");
        window.addButton(hobby, WindowSide.SOUTH);
        next.onClick(this, "clickedNext"); 
        previous.onClick(this, "clickedPrevious"); 
        artist.onClick(this, "clickedArtist"); 
        title.onClick(this, "clickedTitle"); 
        genre.onClick(this, "clickedGenre"); 
        year.onClick(this, "clickedDate"); 
        major.onClick(this, "clickedNext"); 
        state.onClick(this,"clickedState");
        hobby.onClick(this,"clickedHobby");
        
        reader = new SongReader();
        students = reader.getStudents();
        songs = reader.getSongs();
        sorter = new Sorter(songs,students);
        
        glyphIndex = 0;

        
    }

    public void clickedPrevious(Button button) {
        if(glyphIndex > 8) {
            glyphIndex = glyphIndex - 9;
        }
        else {
            previous.disable();
        }
        next.enable();
        drawGlyph();
    }
    public void clikedArtist(Button button){
        sorter.sortByArtist();
    }
    public void clickedTitle(Button button) {
        sorter.sortByTitle();
    }
    public void clickedGenre(Button button) {
        sorter.sortByGenre();
    }
    public void clickedDate(Button button) {
        sorter.sortByDate();
    }
    public void lickedHobby(Button button) {
        sorter.sortByHobby();
    }
    public void clickedMajor(Button button) {
        sorter.sortByMajor();
    }
    public void clickedState(Button button) {
        sorter.sortByState();
    }
    public void clickedNext(Button button) {
        if(glyphIndex > 8) {
            glyphIndex = glyphIndex - 9;
        }
        else {
            next.disable();
        }
        previous.enable();
        drawGlyph();
    }
    public void clickedQuit(Button button) {
        
    }
    public void update(Observable, Object) {
        
    }
    
    private void drawGlyph(int start, int end) {
        
    }
    private void drawLegend() {
        
    }
}