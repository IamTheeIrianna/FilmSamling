import java.util.ArrayList;
import java.util.Scanner;

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

    public void editMovie(String title) {
        ArrayList<Movie> matchingMovies = searchMovie(title);
        if (matchingMovies.isEmpty()) {
            System.out.println("No movies found under title" + title);
            return;
        }

        // display found movies
        System.out.println("Found movies: ");
        for (int i = 0;i < matchingMovies.size();i++) {
            System.out.println((i + 1) + ". " + matchingMovies.get(i));

        }

        //User select movie ti edit
        System.out.println("Enter the number of the movie you want to edit:");
        int movieIndex = scanner.nextInt() - 1; // Adjust for zero-based index
        scanner.nextLine();
        if (movieIndex < 0 || movieIndex >= matchingMovies.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Movie movieToEdit = matchingMovies.get(movieIndex);
        System.out.println("Editing Movie: " + movieToEdit.getTitle());

        System.out.println("New title (press <enter> to keep current title) : ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            movieToEdit.setTitle(newTitle);
        }
        System.out.println("Enter new director (press <enter> to keep current director): ");
        String newDirector = scanner.nextLine();
        if (!newDirector.isEmpty()) {
            movieToEdit.setDirector(newDirector);
        }
        System.out.println("Enter new year created (press <enter> to keep current year): ");
        String newYearCreatedInput = scanner.nextLine();

        if (!newYearCreatedInput.isEmpty()) {
            try {
                int newYearCreated = Integer.parseInt(newYearCreatedInput);
                movieToEdit.setYearCreated(newYearCreated);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for year. Keeping current year: " + movieToEdit.getYearCreated());
            }
        } else {
            System.out.println("Keeping current year: " + movieToEdit.getYearCreated());
        }

        System.out.println("Is the movie in colour? (y/n) (press <enter> to keep current info): ");
        boolean newIsInColor = scanner.nextLine().equals("y");
        movieToEdit.setInColor(newIsInColor);

        System.out.println("Edit movie length in minutes (press <enter> to keep current movie length:");
        String newLengthInput = scanner.nextLine();
        if (!newLengthInput.isEmpty()) {
            try {
                int newLengthInMinutes = Integer.parseInt(newLengthInput);
                movieToEdit.setLengthInMinutes(newLengthInMinutes);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for length. Keeping current length.");
            }
        }
        System.out.println("Edit movie genre (press <enter> to keep current genre: ");
        String newGenre = scanner.nextLine();
        if (!newGenre.isEmpty()) {
            movieToEdit.setGenre(newGenre);
        }
        System.out.println("Movie details updated: " + movieToEdit);
    }
}














