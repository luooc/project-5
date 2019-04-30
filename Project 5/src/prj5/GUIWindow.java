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
     * getter for studentList
     * 
     * @return studentList DLList
     */
    public DLList<Song> getSongList() {
        return songList;
    }


    /**
     * getter for songList
     * 
     * @return songList DLList
     */
    public DLList<Student> getStudentList() {
        return studentList;
    }


    /**
     * Recursive helper method to alphabetize a list of genres
     * 
     * @param sortingArray
     *            an array of objects that can be cast as songs
     * @param i
     *            the index of an object in sortingArray
     * @param j
     *            the index of an object in sortingArray
     * @param index
     *            a cursor that keeps track of where in the string the method
     *            looks at
     * @return the index of the string that comes first alphabetically
     */
    private int alphabetize(Object[] sortingArray, int i, int j, int index) {
        if (index >= ((Song)sortingArray[i]).getGenre().length()) {
            return i;
        }
        if (index >= ((Song)sortingArray[j]).getGenre().length()) {
            return j;
        }

        if (((Song)sortingArray[i]).getGenre().charAt(
            index) > ((Song)sortingArray[j]).getGenre().charAt(index)) {
            return j;
        }
        else if (((Song)sortingArray[i]).getGenre().charAt(
            index) == ((Song)sortingArray[j]).getGenre().charAt(index)) {
            return alphabetize(sortingArray, i, j, index + 1);
        }
        else {
            return i;
        }
    }


    /**
     * Sorts list alphabetically by song genre
     * 
     * @return sorted DLList
     */
    public DLList<Song> sortByGenre() {
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songList.toArray();
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                min = alphabetize(sortingArray, min, j, 0);
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
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
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (((Song)sortingArray[i]).getArtist().compareTo(
                    ((Song)sortingArray[j]).getArtist()) > 0) {
                    min = j;
                }
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
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
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (((Song)sortingArray[i]).getTitle().compareTo(
                    ((Song)sortingArray[j]).getTitle()) > 0) {
                    min = j;
                }
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
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
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (((Song)sortingArray[i]).getDate() > ((Song)sortingArray[j])
                    .getDate()) {
                    min = j;
                }
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
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
        DLList<Student> sorted = new DLList<Student>();
        Object[] sortingArray = studentList.toArray();
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (((Student)sortingArray[i]).getHobby().compareTo(
                    ((Student)sortingArray[j]).getHobby()) > 0) {
                    min = j;
                }
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
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
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (((Student)sortingArray[i]).getMajor().compareTo(
                    ((Student)sortingArray[j]).getMajor()) > 0) {
                    min = j;
                }
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
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
        for (int i = 0; i < sortingArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < sortingArray.length; j++) {
                if (((Student)sortingArray[i]).getState().compareTo(
                    ((Student)sortingArray[j]).getState()) > 0) {
                    min = j;
                }
            }
            Object temp = sortingArray[i];
            sortingArray[i] = sortingArray[min];
            sortingArray[min] = temp;
        }
        for (int i = 0; i < sortingArray.length; i++) {
            sorted.add((Student)sortingArray[i]);
        }
        return sorted;
    }
}
