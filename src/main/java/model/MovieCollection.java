package model;

import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies;


    public MovieCollection(ArrayList<Movie> movieCollectionList) {
        this.movies = movieCollectionList;
    }
    public ArrayList<Movie> getMovies() {
        return movies; // Assuming 'movies' is the list of movies in MovieCollection
    }
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    // Display all movies in the collection
    public String displayMovies() {
        if (movies.isEmpty()) {
            return "No movies on the list.";
        }
        StringBuilder movieList = new StringBuilder();
        for (Movie movie : movies) {
            movieList.append(movie.toString()).append("\n\n");
        }
        return movieList.toString();
    }

    public void addMovie(Movie newMovie) {
        movies.add(newMovie);
    }

    //Search for movies by title
//Search for movies by title
public ArrayList<Movie> searchMovie(String title) {
    ArrayList<Movie> matchingMovies = new ArrayList<>();
    for (Movie movie : movies) {
        if (movie.getTitle().equalsIgnoreCase(title)) {
            matchingMovies.add(movie);
        }
    }
    return matchingMovies;
}

    // Edit a movie's details by title
    public void editMovie(Movie movie, String newTitle, String newDirector, Integer newYear, Boolean newInColor, Integer newLength, String newGenre) {

        if (newTitle != null)
            movie.setTitle(newTitle);

        if (newDirector != null)
            movie.setDirector(newDirector);

        if (newYear != null)
            movie.setYearCreated(newYear);

        if (newInColor != null)
            movie.setInColor(newInColor);

        if (newLength != null)
            movie.setLengthInMinutes(newLength);

        if (newGenre != null && !newGenre.isEmpty())
            movie.setGenre(newGenre);
    }

    // Metode til at slette en film fra samlingen
    public void deleteMovie(String title) {
        Movie movieToDelete = getMovieByTitle(title);
        if (movieToDelete == null) {
            return;
        }

        // Sletter filmen
        movies.remove(movieToDelete);
    }

    // Helper method to find a movie by title
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }


}
