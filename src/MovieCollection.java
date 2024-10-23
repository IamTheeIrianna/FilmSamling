import java.util.ArrayList;
import java.util.Scanner;

    public class MovieCollection {
        private ArrayList<Movie> movies;

        public MovieCollection () {
            movies = new ArrayList<>();
        }

        public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lenghtInMinutes, String genre) {
            Movie newMovie = new Movie(title, director, yearCreated, isInColor, lenghtInMinutes, genre);
            movies.add(newMovie);
        }

        public void displayMovies() {
            if(movies.isEmpty()) {
                System.out.println("No movies was found.");
            } else {
                for (movie movie : movies) {
                    System.out.println(movie);
                }
            }
        }
    }





