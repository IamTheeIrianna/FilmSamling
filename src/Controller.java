import java.util.ArrayList;
public class Controller {

    private MovieCollection movieCollection;
    private Movie movie;

    public Controller() {
    movieCollection = new MovieCollection(new ArrayList<>());
    movie = new Movie("Default Title", "Default Director", 1900, true, 60, "Default Genre");
}
   /* public Controller() {
        movieCollection = new MovieCollection(new ArrayList<>());
        movie = new Movie(movie.getTitle(), movie.getDirector(), movie.getYearCreated(), movie.getIsInColor(), movie.getLengthInMinutes(), movie.getGenre());
    }*/

    public MovieCollection getMovieCollection() {
        return movieCollection;
    }

    public Movie getMovie() {
        return movie;
    }
}




