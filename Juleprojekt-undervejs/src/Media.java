public class Media {
    protected String name;
    protected String year;
    protected double rating;
    protected String[] genres;
    protected boolean visible;

    public Media(String name, String year, double rating, String[] genres, boolean visible) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.visible = visible;
    }
}
