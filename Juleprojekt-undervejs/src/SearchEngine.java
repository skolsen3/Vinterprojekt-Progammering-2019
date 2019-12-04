import java.util.ArrayList;

public class SearchEngine {
    protected Library library;

    public ArrayList<Media> searchForString(String s) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getName().contains(s)) {
                tempList.add(m);
            }

        }
        return tempList;
    }

    public ArrayList<Media> searchByCategory(String category1) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getGenres().toString().contains(category1)) {
                tempList.add(m);
            }

        }
        return tempList;
    }

    public ArrayList<Media> searchByCategory(String category1, String category2) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        //I stedet for at bruge dobbelt if-statement, brug hellere "eller" eller "og" (|| og &&)
        for (Media m : l) {
            if (m.getGenres().toString().contains(category1))
                if (m.getGenres().toString().contains(category2)) {
                    tempList.add(m);
                }

        }
        return tempList;
    }
    public ArrayList<Media> searchByCategory(String category1, String category2, String category3) {
        ArrayList<Media> tempList = new ArrayList<>();
        ArrayList<Media> l = library.getAsList();
        //Samme som ovenstående kommentar
        for (Media m : l) {
            if (m.getGenres().toString().contains(category1))
                if (m.getGenres().toString().contains(category2))
                if(m.getGenres().toString().contains(category3))
                {
                    tempList.add(m);
                }

        }
        return tempList;
    }
}