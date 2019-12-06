import java.util.ArrayList;

public class SearchEngine {
    protected Library library;

    public ArrayList<Media> sortByName(String s) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getName().contains(s)) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(s);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getGenres().toString().contains(category1)) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(category1);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1, String category2) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getGenres().toString().contains(category1) ||
                    (m.getGenres().toString().contains(category2))) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(category1+","+category2);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByCategory(String category1, String category2, String category3) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getGenres().toString().contains(category1) ||
                    (m.getGenres().toString().contains(category2)) ||
                    (m.getGenres().toString().contains(category3))) {
                tempList.add(m);
            }

        }
        if (tempList.get(0) == null) {
            throw new NoSuchMediaException(category1+","+category2+","category3);
        } else {
            return tempList;
        }
    }

    public ArrayList<Media> sortByTypeOfMedia(String typeOfMedia) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();

        if (typeOfMedia.contains("Movie")) {
            for (Media m : l) {
                if (m instanceof Movie) {
                    tempList.add(m);
                }
            }
        }
        if (typeOfMedia.contains("Series")) {
            for (Media m : l) {
                if (m instanceof Series) {
                    tempList.add(m);
                }
            }
        }
        return tempList;
    }
}