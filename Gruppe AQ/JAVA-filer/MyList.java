import java.util.ArrayList;

/**
 * This is a class that represents a list of media's, which a user can make himself by adding/removing medias from the
 * whole library.
 */
public class MyList {
    protected ArrayList<Media> myList;

    /**
     * Constructor of myList.
     * @param myList List of Media-objects assigned to be in a personal list.
     */
    public MyList(ArrayList<Media> myList) {
        this.myList = myList;
    }

    /**
     * @param m The Media-object which needs to be added to the MyList.
     */
    public void addMedia(Media m) {
        myList.add(m);
    }

    /**
     * @param m The Media-object which needs to be removed from the MyList.
     */
    public void removeMedia(Media m){
        myList.remove(m);
    }

}
