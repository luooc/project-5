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
import CS2114.Shape;
import java.awt.Color;

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
    private Reader reader;
    private Sorter sorter;
    private int glyphIndex;
    private final int GLYPH_BAR_WIDTH = 20;
    private String sortedBy;

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
        sortedBy = "";
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
        drawGlyphs();
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
        drawGlyphs();
    }


    /**
     * When button is clicked, glyphs are sorted by artist
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedArtist(Button button) {
        sorter.sortByArtist();
        drawGlyphs();
    }


    /**
     * When button is clicked, glyphs are sorted by song title
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedTitle(Button button) {
        sorter.sortByTitle();
        drawGlyphs();
    }


    /**
     * When button is clicked, glyphs are sorted by song genre
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedGenre(Button button) {
        sorter.sortByGenre();
        drawGlyphs();
    }


    /**
     * When button is clicked, glyphs are sorted by song release date
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedDate(Button button) {
        sorter.sortByDate();
        drawGlyphs();
    }


    /**
     * When button is clicked, glyphs are sorted by student hobby
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedHobby(Button button) {
        sorter.sortByHobby();
        sortedBy = "hobby";
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyphs are sorted by student major
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedMajor(Button button) {
        sorter.sortByMajor();
        sortedBy = "major";
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyphs are sorted by student's state
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedState(Button button) {
        sorter.sortByRegion();
        sortedBy = "region";
        drawLegend(sortedBy);
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
    private void drawGlyphs() {
        window.removeAllShapes();
        for(int i = glyphIndex; i < glyphIndex + 9; i++){
            if(i > 0 && i < songs.size()){
                Song s = songs.get(i);
                Glyph g = new Glyph(s.getTitle() + "\n by " + s.getArtist(),s.getSongsLiked());
                g.draw(i % 9);
            }
        }
        drawLegend(sortedBy);
    }


    /**
     * draws the key that the user can use to understand the glyphs
     */
    private void drawLegend(String str) {

    }


    /**
     * ~ INNER GLYPH CLASS ....................................................
     */
    private class Glyph
    {
        private String text;
        private int[] likes;


        public Glyph(String text, int[] likes) 
        {
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

            Shape verticalBar = new Shape((col*50) + 75,(row*50) + GLYPH_BAR_WIDTH,GLYPH_BAR_WIDTH*4,GLYPH_BAR_WIDTH,Color.BLACK);
            window.addShape(verticalBar);
            Color[] colors = new Color[4];
            colors[0] = Color.MAGENTA;
            colors[1] = Color.BLUE;
            colors[2] = Color.YELLOW;
            colors[3] = Color.GREEN;



            String[] categories = new String[4];
            if(sortedBy.equals("hobby"))
            {
                categories[0] = "art";
                categories[1] = "music";
                categories[2] = "read";
                categories[3] = "sports";

                for(int j = 0; j < 4; j++)
                {
                    int yesLiked = 0;
                    int totalLiked = 0;
                    int yesHeard = 0;
                    int totalHeard = 0;

                    while(students.get(i).getHobby() != categories[j]){
                        String yesNoLiked = students.get(i).getSongsLiked()[index];
                        if(yesNoLiked.equals("Yes")){
                            yesLiked++;
                            totalLiked++;
                        }
                        else if(yesNoLiked.equals("No")){
                            totalLiked++;
                        }

                        String yesNoHeard = students.get(i).getSongsHeard()[index];
                        if(yesNoHeard.equals("Yes")){
                            yesHeard++;
                            totalHeard++;
                        }
                        else if(yesNoHeard.equals("No")){
                            totalHeard++;
                        }
                    }

                    Shape heard = new Shape(col*50,row+(j*GLYPH_BAR_WIDTH),(yesHeard/totalHeard)*100,GLYPH_BAR_WIDTH,colors[j]);
                    Shape liked = new Shape(col*50 + 50,row+(j*GLYPH_BAR_WIDTH),(yesLiked/totalLiked)*100,GLYPH_BAR_WIDTH,colors[j]);
                    window.addShape(heard);
                    window.addShape(liked);
                }
            }
            else if(sortedBy.equals("major"))
            {
                categories[0] = "Computer Science";
                categories[1] = "Math or CMDA";
                categories[2] = "Other";
                categories[3] = "Other Engineering";

                for(int j = 0; j < 4; j++)
                {
                    int yesLiked = 0;
                    int totalLiked = 0;
                    int yesHeard = 0;
                    int totalHeard = 0;

                    while(students.get(i).getMajor() != categories[j]){
                        String yesNoLiked = students.get(i).getSongsLiked()[index];
                        if(yesNoLiked.equals("Yes")){
                            yesLiked++;
                            totalLiked++;
                        }
                        else if(yesNoLiked.equals("No")){
                            totalLiked++;
                        }

                        String yesNoHeard = students.get(i).getSongsHeard()[index];
                        if(yesNoHeard.equals("Yes")){
                            yesHeard++;
                            totalHeard++;
                        }
                        else if(yesNoHeard.equals("No")){
                            totalHeard++;
                        }
                    }

                    Shape heard = new Shape(col*50,row+(j*GLYPH_BAR_WIDTH),(yesHeard/totalHeard)*100,GLYPH_BAR_WIDTH,colors[j]);
                    Shape liked = new Shape(col*50 + 50,row+(j*GLYPH_BAR_WIDTH),(yesLiked/totalLiked)*100,GLYPH_BAR_WIDTH,colors[j]);
                    window.addShape(heard);
                    window.addShape(liked);
                }
            }
                else{
                    categories[0] = "Northeast US";
                    categories[1] =  "Southeast US";
                    categories[2] = "outside the US";
                    categories[3] = "the rest of US";
                    for(int j = 0; j < 4; j++){
                        int yesLiked = 0;
                        int totalLiked = 0;
                        int yesHeard = 0;
                        int totalHeard = 0;

                        while(students.get(i).getState() != categories[j]){
                            String yesNoLiked = students.get(i).getSongsLiked()[index];
                            if(yesNoLiked.equals("Yes")){
                                yesLiked++;
                                totalLiked++;
                            }
                            else if(yesNoLiked.equals("No")){
                                totalLiked++;
                            }

                            String yesNoHeard = students.get(i).getSongsHeard()[index];
                            if(yesNoHeard.equals("Yes")){
                                yesHeard++;
                                totalHeard++;
                            }
                            else if(yesNoHeard.equals("No")){
                                totalHeard++;
                            }
                        }

                        Shape heard = new Shape(col*50,row+(j*GLYPH_BAR_WIDTH),(yesHeard/totalHeard)*100,GLYPH_BAR_WIDTH,colors[j]);
                        Shape liked = new Shape(col*50 + 50,row+(j*GLYPH_BAR_WIDTH),(yesLiked/totalLiked)*100,GLYPH_BAR_WIDTH,colors[j]);
                        window.addShape(heard);
                        window.addShape(liked);
                    }
                }
            }
    }
}
