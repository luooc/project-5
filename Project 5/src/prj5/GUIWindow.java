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
import CS2114.WindowSide;
import CS2114.Shape;
import CS2114.TextShape;
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
    private Sorter sorter;
    private int glyphIndex;
    private final int GLYPH_BAR_WIDTH = 25;
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
        window = new Window("Project 5");
        sortedBy = "hobby";

        // create and add the buttons to the screen
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
        Button hobby = new Button("Represent Hobby");
        window.addButton(hobby, WindowSide.SOUTH);
        Button major = new Button("Represent Major");
        window.addButton(major, WindowSide.SOUTH);
        Button state = new Button("Represent Region");
        window.addButton(state, WindowSide.SOUTH);
        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);

        // link the buttons with their respective onClick methods
        next.onClick(this, "clickedNext");
        previous.onClick(this, "clickedPrevious");
        artist.onClick(this, "clickedArtist");
        title.onClick(this, "clickedTitle");
        genre.onClick(this, "clickedGenre");
        year.onClick(this, "clickedDate");
        hobby.onClick(this, "clickedHobby");
        major.onClick(this, "clickedMajor");
        state.onClick(this, "clickedState");
        quit.onClick(this, "clickedQuit");

        sorter = new Sorter(songs, students);

        glyphIndex = 0;
    }


    /**
     * Goes to the previous page of glyphs
     * 
     * @param button
     *            Button that will execute method when clicked *
     */
    public void clickedPrevious(Button button) {
        if (glyphIndex > 8) {
            glyphIndex = glyphIndex - 9;
        }
        else {
            previous.disable();
        }
        next.enable();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * Goes to the next page of glyphs
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedNext(Button button) {
        if (glyphIndex < songs.size() - 9) {
            glyphIndex = glyphIndex + 9;
        }
        else {
            next.disable();
        }
        previous.enable();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyphs are sorted by artist
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedArtist(Button button) {
        songs = sorter.sortByArtist();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyphs are sorted by song title
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedTitle(Button button) {
        songs = sorter.sortByTitle();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyphs are sorted by song genre
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedGenre(Button button) {
        songs = sorter.sortByGenre();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyphs are sorted by song release date
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedDate(Button button) {
        songs = sorter.sortByDate();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyph info shows student hobby
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedHobby(Button button) {
        sortedBy = "hobby";
        students = sorter.sortByHobby();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyph info shows student major
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedMajor(Button button) {
        sortedBy = "major";
        students = sorter.sortByMajor();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When button is clicked, glyph info shows student's state
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedState(Button button) {
        sortedBy = "region";
        students = sorter.sortByRegion();
        drawGlyphs();
        drawLegend(sortedBy);
    }


    /**
     * When clicked, program is exited and window is closed
     * 
     * @param button
     *            Button that will execute method when clicked
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * draws the glyph representation of the data
     */
    private void drawGlyphs()
    {
        window.removeAllShapes();
        //draws the 9 glyphs on the screen
        for (int i = glyphIndex; i < glyphIndex + 9; i++) {
            if (i >= 0 && i < songs.size()) {
                Glyph g = new Glyph(songs.get(i).getTitle(), songs.get(i)
                    .getArtist());
                g.draw(i);
            }
        }
        
        //draws the legend on the screen
        drawLegend(sortedBy);
    }


    /**
     * PRECONDITION: str is "hobby", "major", or "state"
     * 
     * draws the key that the user can use to understand the glyphs
     *
     * @param str
     *            The string that represents what the students are
     *            sorted by (e.g. hobby, major,or state)
     */
    private void drawLegend(String str) {
        // variables to reference window's dimensions
        int windowWidth = window.getGraphPanelWidth();
        int windowHeight = window.getGraphPanelHeight();

        // initializes an empty title for the legend at the correct place in the
        // window
        TextShape title = new TextShape(windowWidth - 112, windowHeight / 2 + 3,
            "");

        // initializes an empty pink, blue, orange, and green text object at the
        // correct place in the window
        TextShape pink = new TextShape(windowWidth - 105, windowHeight / 2 + 20,
            "");
        TextShape blue = new TextShape(windowWidth - 105, windowHeight / 2 + 34,
            "");
        TextShape orange = new TextShape(windowWidth - 105, windowHeight / 2
            + 49, "");
        TextShape green = new TextShape(windowWidth - 105, windowHeight / 2
            + 64, "");

        // creates a black rectangle to be placed behind the legend to serve as
        // a black outline
        Shape border = new Shape(windowWidth - 115, windowHeight / 2, 110,
            (windowHeight / 2) - 5, Color.BLACK);

        // creates a white rectangle to serve as the legend
        Shape legend = new Shape(windowWidth - 113, (windowHeight / 2) + 2, 106,
            (windowHeight / 2) - 9, Color.WHITE);

        // creates a black text for "Song Title" in the legend,
        TextShape songTitle = new TextShape((windowWidth - 93), (windowHeight
            / 2) + 79, "Song Title");
        songTitle.setForegroundColor(Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);

        // creates a rectangle in legend to visualize glyph layout
        Shape legendGlyphBar = new Shape(windowWidth - songTitle.getWidth() + 4,
            565, 7, 40, Color.BLACK);

        // legendGlyphBar = new Shape(50, 50, 5, legend.getHeight() - songTitle
        // .getY(), Color.BLACK);

        // creates a black text for "Heard" in legend for glyph visualization
        TextShape heard = new TextShape(windowWidth - 105, (windowHeight / 2)
            + 110, "Heard");
        heard.setBackgroundColor(Color.WHITE);
        heard.setForegroundColor(Color.BLACK);

        // creates a black text for "Likes" in legend for glyph visualization
        TextShape likes = new TextShape(windowWidth - 55, (windowHeight / 2)
            + 110, "Likes");
        likes.setBackgroundColor(Color.WHITE);
        likes.setForegroundColor(Color.BLACK);

        // if input is "hobby", then show legend for Hobby
        if (str.equals("hobby")) {
            title.setText("Hobby Legend");
            title.setForegroundColor(Color.BLACK);
            title.setBackgroundColor(Color.WHITE);
            pink.setText("Read");
            pink.setForegroundColor(Color.MAGENTA);
            pink.setBackgroundColor(Color.WHITE);
            blue.setText("Art");
            blue.setForegroundColor(Color.BLUE);
            blue.setBackgroundColor(Color.WHITE);
            orange.setText("Sports");
            orange.setForegroundColor(Color.ORANGE);
            orange.setBackgroundColor(Color.WHITE);
            green.setText("Music");
            green.setForegroundColor(Color.GREEN);
            green.setBackgroundColor(Color.WHITE);

        }
        // if input is "major", then show legend for Major
        else if (str.equals("major")) {
            title.setText("Major Legend");
            title.setForegroundColor(Color.BLACK);
            title.setBackgroundColor(Color.WHITE);
            pink.setText("Comp Sci");
            pink.setForegroundColor(Color.MAGENTA);
            pink.setBackgroundColor(Color.WHITE);
            blue.setText("Other Eng");
            blue.setForegroundColor(Color.BLUE);
            blue.setBackgroundColor(Color.WHITE);
            orange.setText("Math/CMDA");
            orange.setForegroundColor(Color.ORANGE);
            orange.setBackgroundColor(Color.WHITE);
            green.setText("Other");
            green.setForegroundColor(Color.GREEN);
            green.setBackgroundColor(Color.WHITE);

        }
        // if input is "region", then show legend for Region
        else {
            title.setText("Region Legend");
            title.setForegroundColor(Color.BLACK);
            title.setBackgroundColor(Color.WHITE);
            pink.setText("N.East");
            pink.setForegroundColor(Color.MAGENTA);
            pink.setBackgroundColor(Color.WHITE);
            blue.setText("S.East");
            blue.setForegroundColor(Color.BLUE);
            blue.setBackgroundColor(Color.WHITE);
            orange.setText("Other US");
            orange.setForegroundColor(Color.ORANGE);
            orange.setBackgroundColor(Color.WHITE);
            green.setText("Other");
            green.setForegroundColor(Color.GREEN);
            green.setBackgroundColor(Color.WHITE);

        }

        // adds everything to window
        window.addShape(legendGlyphBar);
        window.addShape(title);
        window.addShape(pink);
        window.addShape(blue);
        window.addShape(orange);
        window.addShape(green);
        window.addShape(songTitle);
        window.addShape(heard);
        window.addShape(likes);
        window.addShape(legend);
        window.addShape(border);
    }


    /**
     * ~ INNER GLYPH CLASS ....................................................
     */
    private class Glyph
    {
        private String songTitle;
        private String songArtist;
        private Color[] colors;
        private String[] categories;


        /**
         * Constructor for glyph object
         * 
         * @param text 
         *          Text to be shown on the glyph
         */
        public Glyph(String songTitle, String songArtist) {
            this.songTitle = songTitle;
            this.songArtist = songArtist;
            colors = new Color[4];
            colors[0] = Color.MAGENTA;
            colors[1] = Color.BLUE;
            colors[2] = Color.YELLOW;
            colors[3] = Color.GREEN;
            categories = new String[4];
            if (sortedBy.equals("hobby")) {
                categories[0] = "art";
                categories[1] = "music";
                categories[2] = "reading";
                categories[3] = "sports";
            }
            else if (sortedBy.equals("major")) {
                categories[0] = "Computer Science";
                categories[1] = "Math or CMDA";
                categories[2] = "Other";
                categories[3] = "Other Engineering";
            }
            else if (sortedBy.equals("region")) {
                categories[0] = "Northeast";
                categories[1] = "Southeast";
                categories[2] = "Outside of United States";
                categories[3] =
                    "United States (other than Southeast or Northwest)";
            }
        }


        /**
         * draws the glyph on the window
         * 
         * @param index
         *            index in songs of the specified song glyph
         */
        public void draw(int index) {
            //get the row and column positions for the glyph
            int pos = index - glyphIndex;
            int col = pos % 3;
            int row = 2;
            if (pos < 3) {
                row = 0;
            }
            else if (pos < 6) {
                row = 1;
            }

            // add title and vertical black bar to glyph
            Shape verticalBar = new Shape((col * 750) + 150, (row * 325) + 75,
                GLYPH_BAR_WIDTH, GLYPH_BAR_WIDTH * 4, Color.BLACK);
            window.addShape(verticalBar);

            // add the song info for the glyph
            TextShape songName = new TextShape((col * 750) + 50, (row * 325)
                + 30, songTitle);
            songName.setBackgroundColor(Color.WHITE);
            window.addShape(songName);
            TextShape artistName = new TextShape((col * 750) + 50, (row * 325)
                + 50, "by " + songArtist);
            artistName.setBackgroundColor(Color.WHITE);
            window.addShape(artistName);

            // add the colored bars to the glyph
            for (int j = 0; j < 4; j++)
            {
                int[] barWidths = getBarLengths(index, j);
                int likedWidth = (int)(((double)barWidths[1]
                    / (double)barWidths[3]) * 100.0);
                int heardWidth = (int)(((double)barWidths[0]
                    / (double)barWidths[2]) * 100.0);
                Shape heard = new Shape((col * 750) + 150 - heardWidth, (row
                    * 325) + GLYPH_BAR_WIDTH * (j + 3), heardWidth,
                    GLYPH_BAR_WIDTH, colors[j]);
                window.addShape(heard);
                Shape likes = new Shape((col * 750) + 150 + GLYPH_BAR_WIDTH,
                    (row * 325) + GLYPH_BAR_WIDTH * (j + 3), likedWidth,
                    GLYPH_BAR_WIDTH, colors[j]);
                window.addShape(likes);
            }
        }


        /**
         * returns an array of the lengths of the bars for the glyphs
         * 
         * @param songIndex
         * @param catIndex
         *            index of categories to be checked
         * @return counts
         *         counts[0] = yesHeard
         *         counts[1] = yesLiked
         *         counts[2] = totalHeard
         *         counts[3] = totalLiked
         */
        private int[] getBarLengths(int songIndex, int catIndex) {
            int[] counts = new int[4];
            int yesHeard = 0;
            int yesLiked = 0;
            int totalHeard = 0;
            int totalLiked = 0;

            // go through the student list and tally heard and liked
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                if (getSortedBy(s).equals(categories[catIndex])) {
                    if (s.getSongsHeard()[songIndex].equals("Yes")) {
                        totalHeard++;
                        yesHeard++;
                    }
                    else if (s.getSongsHeard()[songIndex].equals("No")) {
                        totalHeard++;
                    }

                    if (s.getSongsLiked()[songIndex].equals("Yes")) {
                        totalLiked++;
                        yesLiked++;
                    }
                    else if (s.getSongsLiked()[songIndex].equals("No")) {
                        totalLiked++;
                    }
                }

            }
            counts[0] = yesHeard;
            counts[1] = yesLiked;
            counts[2] = totalHeard;
            counts[3] = totalLiked;

            return counts;
        }


        /**
         * Returns a student's hobby, major, or region depending on what is
         * being sorted by
         * 
         * @param s
         *            a student object
         * @return the student's hobby, major, or region
         */
        private String getSortedBy(Student s) {
            if (sortedBy.equals("hobby") && s.getHobby() != null) {
                return s.getHobby();
            }
            else if (sortedBy.equals("major") && s.getMajor() != null) {
                return s.getMajor();
            }
            else if (sortedBy.equals("region") && s.getState() != null) {
                return s.getState();
            }
            else {
                return "";
            }
        }
    }
}
