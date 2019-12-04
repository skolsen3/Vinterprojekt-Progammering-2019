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

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String[] getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    public boolean isVisible() {
        return visible;
    }
}

