package model;

import datasource.Filehandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Controller {

    private MovieCollection movieCollection;
    private Movie movie;
    private Filehandler filehandler;

    public Controller() {
    movieCollection = new MovieCollection(new ArrayList<>());
    movie = new Movie("Default Title", "Default Director", 1900, true, 60, "Default Genre");
}

    public MovieCollection getMovieCollection() {
        return movieCollection;
    }

     public void loadMovies() throws FileNotFoundException {
        filehandler.loadMovies();
    }

    public void saveMovies() throws FileNotFoundException {
        filehandler.saveMovie(new ArrayList<>());
    }


}




