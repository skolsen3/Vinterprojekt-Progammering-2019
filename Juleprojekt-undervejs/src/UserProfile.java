/**
 * This class represents a userprofile. It does not have any use right now.
 */
public class UserProfile {
    protected String username;
    protected String password;
    protected boolean isAdmin;
    protected boolean isChild;
    protected MyList mylist;

    /**
     * Constructor of a UserProfile.
    */
    public UserProfile(String username, String password, boolean isAdmin, boolean isChild, MyList mylist) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isChild = isChild;
        this.mylist = mylist;
    }
}
