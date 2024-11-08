package model;

public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private int lengthInMinutes;
    private String genre;


    public Movie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    //--------------------------
    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    //--------------------------------------
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //-----------------------------------------
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //------------------------------------------
    public boolean getIsInColor() {
        return isInColor;
    }

    public void setInColor(boolean isInColor) {
        this.isInColor = isInColor;
    }

    //----------------------------------------------
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //-----------------------------------
    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    //To print movie info
    @Override
    public String toString() {

        return "Title: " + title + "\nDirector: " + director + "\nYear: " + yearCreated + "\nmodel.Movie in colour: " + isInColor + "\nmodel.Movie length: " + lengthInMinutes + " minutes" + "\nGenre: " + genre;
    }

}




