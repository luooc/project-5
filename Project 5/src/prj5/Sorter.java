package prj5;

public class Sorter {
    
    private DLList<Song> songList;
    private DLList<Student> studentList;

    public Sorter(DLList<Song> songs, DLList<Student> students) {
        this.songList = songs;
        this.studentList = students;
    }
    
    public DLList<Song> sortByGenre(DLList<Song> songs){
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for(int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song) sortingArray[i];
            String genre = song1.getGenre();
            for(int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song) sortingArray[j];
                if(song2.getGenre().equals("R&B")){
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
                else if(genre.compareTo(song2.getGenre()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song) sortingArray[i]);
        }
        return sorted;
    }
    
    public DLList<Song> sortByArtist(DLList<Song> songs){
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for(int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song) sortingArray[i];
            String artist = song1.getArtist();
            for(int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song) sortingArray[j];
                if(artist.compareTo(song2.getArtist()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song) sortingArray[i]);
        }
        return sorted;
    }
    
    public DLList<Song> sortByTitle(DLList<Song> songs){
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for(int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song) sortingArray[i];
            String title = song1.getTitle();
            for(int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song) sortingArray[j];
                if(title.compareTo(song2.getTitle()) < 0) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song) sortingArray[i]);
        }
        return sorted;
    }
    
    public DLList<Song> sortByDate(DLList<Song> songs){
        DLList<Song> sorted = new DLList<Song>();
        Object[] sortingArray = songs.toArray();
        for(int i = 0; i < sorted.size(); i++) {
            Song song1 = (Song) sortingArray[i];
            for(int j = 0; j < sorted.size(); i++) {
                Song song2 = (Song) sortingArray[j];
                if(song1.getDate() < song2.getDate()) {
                    Object temp = sortingArray[i];
                    sortingArray[i] = sortingArray[j];
                    sortingArray[j] = temp;
                }
            }
            sorted.add((Song) sortingArray[i]);
        }
        return sorted;
    }
}
