public class Media {
    protected String name;
    protected String year;
    protected String[] genres;
    protected double rating;
    protected boolean visible;

    public Media(String name, String year, String[] genres, double rating, boolean visible) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.visible = visible;
    }
}
