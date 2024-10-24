import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movies;

        public MovieCollection () {
            movies = new ArrayList<>();
        }

    public void addMovie(String movie, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        Movie newMovie = new Movie(movie, director, yearCreated, isInColor, lengthInMinutes, genre);
        movies.add(newMovie);
    }

    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies was found.");
        } else {
            System.out.println("\n--- Your Movie Collection ---");
            for (Movie movie : movies) { //første movie skal referere til ArrayList Movie (stort M) ?
                System.out.println(movie);
            }
        }
    }

    public ArrayList<Movie> searchMovie(String title) {
        ArrayList<Movie>  movieMatch = new ArrayList<>();
        title = title.toLowerCase();
        for (Movie movie : movies) {
            String movieTitle = movie.getTitle().toLowerCase();
            if (movieTitle.contains(title)) {
                return movies;
            }
        }
        return null;
    }
} // denne lukker klassen










