

public class Controller {



    private Movie movie;


    public Controller() {
       MovieCollection movieCollection = new MovieCollection();
        movie = new Movie(movie.getTitle(), movie.getDirector(), movie.getYearCreated(), movie.getIsInColor(), movie.getLengthInMinutes(), movie.getGenre());
    }
}




