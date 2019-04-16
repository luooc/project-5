// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Avni Trasi (avnitrasi)

package prj5;

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

public class Sorter {

    /**
     * ~ FIELDS ...............................................................
     */
    private DLList<Song> songList;
    private DLList<Student> studentList;


    /**
     * two-argument constructor
     * 
     * @param songs
     *            list of Songs
     * @param students
     *            list of Student
     */
    public Sorter(DLList<Song> songs, DLList<Student> students) {
        this.songList = songs;
        this.studentList = students;
    }


    /**
     * Sorts list alphabetically by song genre
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Song> sortByGenre(DLList<Song> songs) {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song)sortingArray[i];
            String genre = song1.getGenre();
            for (int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song)sortingArray[j];
                if (song2.getGenre().equals("R&B")) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
                else if (genre.compareTo(song2.getGenre()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by song artist
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Song> sortByArtist(DLList<Song> songs) {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song)sortingArray[i];
            String artist = song1.getArtist();
            for (int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song)sortingArray[j];
                if (artist.compareTo(song2.getArtist()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by song title
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Song> sortByTitle(DLList<Song> songs) {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song)sortingArray[i];
            String title = song1.getTitle();
            for (int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song)sortingArray[j];
                if (title.compareTo(song2.getTitle()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by song date
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Song> sortByDate(DLList<Song> songs) {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song)sortingArray[j];
                if (song1.getDate() < song2.getDate()) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by student hobby
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Student> sortByHobby(DLList<Student> songs) {
        DLList<Student> sorted = new DLList<Student>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song student1 = (Student)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Song student2 = (Student)sortingArray[j];
                if (student1.getHobby() < student2.getHobby()) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by student major
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Student> sortByMajor(DLList<Student> songs) {
        DLList<Student> sorted = new DLList<Student>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song student1 = (Student)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Song student2 = (Student)sortingArray[j];
                if (student1.getMajor() < student2.getMajor()) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by student home state
     * 
     * @param songs
     *            list of Songs needed to be sorted
     * @return sorted DLList
     */
    public DLList<Student> sortByRegion(DLList<Student> songs) {
        DLList<Student> sorted = new DLList<Student>();
        Object[] sortingArray = songs.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Song student1 = (Student)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Song student2 = (Student)sortingArray[j];
                if (student1.getRegion() < student2.getRegion()) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song)sortingArray[i]);
        }
        return sorted;
    }
}
