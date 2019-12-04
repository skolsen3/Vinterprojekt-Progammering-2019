import java.util.ArrayList;

public class SearchEngine {
    protected Library library;

    public ArrayList<Media> searchForString(String s) {
        ArrayList<Media> tempList = new ArrayList<Media>();
        ArrayList<Media> l = library.getAsList();
        for (Media m : l) {
            if (m.getName().contains(s)) {
                tempList.add(m);
            }

        }
        return tempList;
    }
}
