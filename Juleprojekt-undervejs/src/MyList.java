import java.util.ArrayList;

public class MyList {
    protected ArrayList<Media> myList;

    public MyList(ArrayList<Media> myList) {
        this.myList = myList;
    }


    public void addMedia(Media m) {
        myList.add(m);

    }
    public void removeMedia(Media m){
        myList.remove = myList.remove(m);
    }

}
