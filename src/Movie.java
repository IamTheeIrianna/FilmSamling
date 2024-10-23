public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private String isInColor;
    private String lengthInMinutes;
    private String genre;


    public Movie(String title, String director, int yearCreated, String isInColor, String lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsInColor() {
        return isInColor;
    }

    public String getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getTitle() {
        return title;
    }
}

