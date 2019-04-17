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
     *            doubly linked list of Songs
     * @param students
     *            doubly linked list of Student
     */
    public Sorter(DLList<Song> songs, DLList<Student> students) {
        songList = songs;
        studentList = students;
    }


    /**
     * Sorts list alphabetically by song genre
     * 
     * @return sorted DLList
     */
    public DLList<Song> sortByGenre() {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songList.toArray();
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
     * @return sorted DLList
     */
    public DLList<Song> sortByArtist() {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songList.toArray();
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
     * @return sorted DLList
     */
    public DLList<Song> sortByTitle() {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songList.toArray();
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
     * @return sorted DLList
     */
    public DLList<Song> sortByDate() {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songList.toArray();
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
     * @return sorted DLList
     */
    public DLList<Student> sortByHobby() {
        DLList<Student> sorted = new DLList<>();
        Object[] sortingArray = studentList.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Student student1 = (Student)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Student student2 = (Student)sortingArray[j];
                if (student1.getHobby().compareTo(student2.getHobby()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Student)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by student major
     * 
     * @return sorted DLList
     */
    public DLList<Student> sortByMajor() {
        DLList<Student> sorted = new DLList<Student>();
        Object[] sortingArray = studentList.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Student student1 = (Student)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Student student2 = (Student)sortingArray[j];
                if (student1.getMajor().compareTo(student2.getMajor()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Student)sortingArray[i]);
        }
        return sorted;
    }


    /**
     * Sorts list alphabetically by student home state
     * 
     * @return sorted DLList
     */
    public DLList<Student> sortByRegion() {
        DLList<Student> sorted = new DLList<Student>();
        Object[] sortingArray = studentList.toArray();
        for (int i = 0; i < sorted.size(); i++) {
            Student student1 = (Student)sortingArray[i];
            for (int j = 0; j < sorted.size(); i++) {
                Student student2 = (Student)sortingArray[j];
                if (student1.getState().compareTo(student2.getState()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Student)sortingArray[i]);
        }
        return sorted;
    }
}
