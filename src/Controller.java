public class Controller {

    private MovieCollection movieCollection;
    private Movie movie;

    public Controller() {
        movieCollection = new MovieCollection();
        movie = new Movie(movie.getTitle(), movie.getDirector(), movie.getYearCreated(), movie.getIsInColor(), movie.getLengthInMinutes(), movie.getGenre());
    }

    public MovieCollection getMovieCollection() {
        return movieCollection;
    }

    public Movie getMovie() {
        return movie;
    }
}




