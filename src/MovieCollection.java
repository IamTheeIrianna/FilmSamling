import java.util.ArrayList;
import java.util.Scanner;

// *** brug settere i stedet for scanner !

// *** al input og print skal være i UserInterface (evt. return strings i stedet for sout i MovieCollevtion)

public class MovieCollection {
    private ArrayList<Movie> movies;
    private Scanner scanner;

    public MovieCollection() {
        movies = new ArrayList<>();
        scanner = new Scanner(System.in);
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
        ArrayList<Movie> matchingMovies = new ArrayList<>();
        title = title.toLowerCase();
        for (Movie movie : movies) {
            String movieTitle = movie.getTitle().toLowerCase();
            if (movieTitle.contains(title)) {
                matchingMovies.add(movie);
                return matchingMovies;
            }
        }
        return matchingMovies;
    }


    public ArrayList<Movie> getMovieCollectionList() {
        return movies;
    }
}














