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

import CS2114.Button;
import CS2114.Window;
import java.io.FileNotFoundException;
import CS2114.WindowSide;

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

public class GUIWindow {
    private Window window;
    private DLList<Student> students;
    private DLList<Song> songs;
    private Button previous;
    private Button next;
    private Glyph[] glyphs;
    private Reader reader;
    private Sorter sorter;
    private int glyphIndex;
    private final int GLYPH_BAR_WIDTH = 20;

    /**
     * two-argument constructor
     * 
     * @param songFileName
     *            name of the file containing the song information
     * @param studentFileName
     *            name of the file containing the student information
     */
    public GUIWindow(DLList<Song> songs, DLList<Student> students) {
        this.songs = songs;
        this.students = students;
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
        state.onClick(this, "clickedState");
        hobby.onClick(this, "clickedHobby");

        sorter = new Sorter(songs, students);

        glyphIndex = 0;
        glyphs = new Glyph[songs.size()];
    }


    /**
     * Goes to the previous page of glyphs
     * 
     * @param button
     *            Button that will execute method when clicked *
     */
    @SuppressWarnings("deprecation")
    public void clickedPrevious(Button button) {
        if (glyphIndex > 8) {
            glyphIndex = glyphIndex - 9;
        }
        else {
            previous.disable();
        }
        next.enable();
        drawGlyph();
    }


    /**
     * Goes to the next page of glyphs
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedNext(Button button) {
        if (glyphIndex > 8) {
            glyphIndex = glyphIndex - 9;
        }
        else {
            next.disable();
        }
        previous.enable();
        drawGlyph();
    }


    /**
     * When button is clicked, glyphs are sorted by artist
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedArtist(Button button) {
        sorter.sortByArtist();
    }


    /**
     * When button is clicked, glyphs are sorted by song title
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedTitle(Button button) {
        sorter.sortByTitle();
    }


    /**
     * When button is clicked, glyphs are sorted by song genre
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedGenre(Button button) {
        sorter.sortByGenre();
    }


    /**
     * When button is clicked, glyphs are sorted by song release date
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedDate(Button button) {
        sorter.sortByDate();
    }


    /**
     * When button is clicked, glyphs are sorted by student hobby
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedHobby(Button button) {
        sorter.sortByHobby();
        drawLegend("hobby");
    }


    /**
     * When button is clicked, glyphs are sorted by student major
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedMajor(Button button) {
        sorter.sortByMajor();
        drawLegend("major");
    }


    /**
     * When button is clicked, glyphs are sorted by student's state
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedState(Button button) {
        sorter.sortByRegion();
        drawLegend("region");
    }


    /**
     * When clicked, program is exited and window is closed
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * draws the glyph representation of the data
     */
    private void drawGlyph() {
        for(i = glyphIndex; i < glyphIndex + 9; i++){
            if(i > 0 && i < songs.size()){
                s = songs.get(i);
                Glyph g = new Glyph(s.getTitle() + "\n by " + s.getArtist(),s.getSongsLiked());
                g.draw(i % 9);
            }
        }
    }


    /**
     * draws the key that the user can use to understand the glyphs
     */
    private void drawLegend(String str) {
        Shape border = new Shape();
        if(str.equals("hobby")){
            
        }
        else if(str.equals("major")){

        }
        else{
            
        }
    }


    /**
     * ~ INNER GLYPH CLASS ....................................................
     */
    private class Glyph {
        private String text;
        private int[] likes;


        public Glyph(String text, int[] likes) {
            this.text = text;
            this.likes = likes;
        }
        
        public void draw(int index){
            int pos = index - glyphIndex;
            int col = pos % 3;
            int row;
            if(pos < 3){
                row = 0;
            }
            else if(pos < 6){
                row = 1;
            }
            else{
                row = 2;
            }
            for(int i = 0;i++;i<students.size()){
                String yesNo = students.get(i).getSongsLiked()[index];
                if(yesNo.equals("Yes")){
                    
                }
                else if(yesNo.equals("No")){

                }
            }
            Shape bar1 = new Shape((col*50) + 25,(row*50) + GLYPH_BAR_WIDTH,,GLYPH_BAR_WIDTH,Color.MAGENTA);
            Shape bar2 = new Shape((col*50) + 25,(row*50) + GLYPH_BAR_WIDTH*2,,GLYPH_BAR_WIDTH,Color.BLUE);
            Shape bar1 = new Shape((col*50) + 25,(row*50) + GLYPH_BAR_WIDTH*3,,GLYPH_BAR_WIDTH,Color.YELLOW);
            Shape bar2 = new Shape((col*50) + 25,(row*50) + GLYPH_BAR_WIDTH*4,,GLYPH_BAR_WIDTH,Color.GREEN);
            Shape vertBar = new Shape(,,height,GLYPH_BAR_WIDTH,Color.BLACK);
        }
    }

}
