import java.util.ArrayList;

/**
 * This is a class that represents a list of media's, which a user can make himself by adding/removing medias from the
 * whole library.
 */
public class MyList {
    protected ArrayList<Media> myList;

    /**
     * Constructor of myList.
     * @param myList
     */
    public MyList(ArrayList<Media> myList) {
        this.myList = myList;
    }

    /**
     * @param m
     */
    public void addMedia(Media m) {
        myList.add(m);
    }

    /**
     * @param m
     */
    public void removeMedia(Media m){
        myList.remove(m);
    }

}
