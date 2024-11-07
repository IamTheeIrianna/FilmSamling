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

    // Load movies from the file into the movie collection
    public void loadMovies() throws FileNotFoundException {
        ArrayList<Movie> loadedMovies = filehandler.loadMovies();
        if (loadedMovies != null) {
            movieCollection.setMovies(loadedMovies);  // Update the movie collection with the loaded movies
        } else {
            System.out.println("No movies found in file.");
        }
    }

    public void saveMovies() throws FileNotFoundException {
        // Step 1: Load existing movies from the file
        ArrayList<Movie> existingMovies = filehandler.loadMovies();  // Load existing movies

        // Step 2: Get the current list of movies from the movie collection (including newly added ones)
        ArrayList<Movie> currentMovies = movieCollection.getMovies();  // Get current movie collection

        // Step 3: Add new movies that are not already in the file
        for (Movie newMovie : currentMovies) {
            boolean exists = existingMovies.stream()
                    .anyMatch(movie -> movie.getTitle().equalsIgnoreCase(newMovie.getTitle()));  // Check if movie already exists

            if (!exists) {
                existingMovies.add(newMovie);  // Add the movie to the existing list if it doesn't exist
            }
        }

        // Step 4: Save the updated list of movies back to the file
        filehandler.saveMovie(existingMovies);  // Save the updated list to the file

        // Log the number of movies saved
        System.out.println("Saving " + existingMovies.size() + " movies to the file.");
    }
}

