import java.util.Scanner;
// *** Controlleren bliver ikke brugt
// *** UI skal kalde på Controller, Controller skal have adgang til Movie og MovieCollection

public class Controller {


    private Controller controller;
    private Movie movie;
    private Scanner scanner;

    public Controller() {
       MovieCollection movieCollection = new MovieCollection();
        movie = new Movie(movie.getTitle(), movie.getDirector(), movie.getYearCreated(), movie.getIsInColor(), movie.getLengthInMinutes(), movie.getGenre());
    }
}




