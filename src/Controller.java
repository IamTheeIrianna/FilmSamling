import java.util.Scanner;

public class Controller {


    private Controller controller;
    private Movie movie;
    private Scanner scanner;

    public Controller() {
       MovieCollection movieCollection = new MovieCollection();
        movie = new Movie(movie.getTitle(), movie.getDirector(), movie.getYearCreated(), movie.getIsInColor(), movie.getLengthInMinutes(), movie.getGenre());
    }
}




