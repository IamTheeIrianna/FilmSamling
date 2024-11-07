package model;

import datasource.Filehandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Controller {

    private MovieCollection movieCollection;
    private Filehandler filehandler;

    public Controller() {
    movieCollection = new MovieCollection(new ArrayList<>());
    filehandler = new Filehandler();
}



    public MovieCollection getMovieCollection() {
        return movieCollection;
    }

     public void loadMovies() throws FileNotFoundException {
        filehandler.loadMovies();
    }

    public void saveMovies() throws FileNotFoundException {
        filehandler.saveMovie();
    }
}

