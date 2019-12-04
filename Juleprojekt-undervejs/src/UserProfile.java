public class UserProfile {
    protected String username;
    protected String password;
    protected boolean isAdmin;
    protected boolean isChild;
    protected MyList mylist;

    public UserProfile(String username, String password, boolean isAdmin, boolean isChild, MyList mylist) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isChild = isChild;
        this.mylist = mylist;
    }
}
