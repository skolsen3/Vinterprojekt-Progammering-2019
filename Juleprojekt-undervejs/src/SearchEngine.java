import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngine {
    protected ArrayList<Media> library;
    protected ArrayList<Media> originalLibrary;
    protected ArrayList<String> genreList;

    public SearchEngine() {
        library = FileReader.readMedia().get(0);
        originalLibrary = library;
        genreList = FileReader.readMedia().get(1);
    }

    public ArrayList<Media> getLibrary() {
        return library;
    }

    public ArrayList<Media> resetMedia() {
        return originalLibrary;
    }

    public ArrayList<String> getGenreList() {
        return genreList;
    }

    public void clearLibrary(){library = new ArrayList();}

    public ArrayList<Media> sortByName(String s) {
        ArrayList<Media> tempList = new ArrayList<>();
        for (Media m : library) {
            if (m.getName().contains(s)) {
                tempList.add(m);
            }

        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException(s);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1) {
        clearLibrary();
        for (Media m : originalLibrary) {
            String str = Arrays.toString(m.getGenres());
            if (str.contains(category1)) {
                library.add(m);
            }

        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException(category1);
        } else {
            return library;
        }
    }

    public ArrayList<Media> sortByCategory(String category1, String category2) {
        clearLibrary();
        for (Media m : originalLibrary) {
            String str = Arrays.toString(m.getGenres());
            if (str.contains(category1) ||
                    (str.contains(category2))) {
                library.add(m);
            }

        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException(category1+","+category2);
        } else {
            return library;
        }
    }

    public ArrayList<Media> sortByCategory(String category1, String category2, String category3) {
       clearLibrary();
        for (Media m : originalLibrary) {
            String str = Arrays.toString(m.getGenres());
            if (m.getGenres().toString().contains(category1) ||
                    (str.contains(category2)) ||
                    (str.contains(category3))) {
                library.add(m);
            }

        }
        if (library.isEmpty()) {
            throw new NoSuchMediaException(category1+","+category2+","+category3);
        } else {
            return library;
        }
    }

    public ArrayList<Media> sortByTypeOfMedia(String typeOfMedia) {
        ArrayList<Media> tempList = new ArrayList<>();

        if (typeOfMedia.contains("Movie")) {
            for (Media m : library) {
                if (m instanceof Movie) {
                    tempList.add(m);
                }
            }
        }
        if (typeOfMedia.contains("Series")) {
            for (Media m : library) {
                if (m instanceof Series) {
                    tempList.add(m);
                }
            }
        }
        return tempList;
    }


}