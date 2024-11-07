
package UI;

import model.Controller;
import model.Movie;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Controller controller;
    private Scanner scanner;

    public UI() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n--- Movie Collection Menu ---");
        System.out.println("1. Type 'add' to add a movie to your collection");
        System.out.println("2. Type 'movies' to show your movie collection");
        System.out.println("3. Type 'search' to search for a specific movie");
        System.out.println("4. Type 'edit' to edit a movie in your collection");
        System.out.println("5. Type 'load' to load movies from a file");
        System.out.println("6. Type 'save' to save movies to a file");
        System.out.println("7. Type 'delete' to delete a movie from your collection");
        System.out.println("8. Type 'exit' to exit program");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();

        try {
            while (running) {
                String choice = scanner.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "add", "1" -> addMovie();
                    case "movies", "2" -> showMovies();
                    case "search", "3" -> searchMovie();
                    case "edit", "4" -> manageMovie();
                    case "load", "5" -> {
                        try {
                            controller.loadMovies();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Movie loaded to text file");
                    }
                    case "save", "6" -> {
                        try {
                            controller.saveMovies();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Movie saved to text file");
                    }
                    case "delete", "7" -> deleteMovie();
                    case "exit", "8" -> {
                        System.out.println("Exiting program. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice, please try again.");
                }

                if (running) displayMenu();
            }
        } finally {
            scanner.close();
        }
    }
    private void deleteMovie() {
        System.out.print("Enter the title of the movie to delete: ");
        String title = scanner.nextLine().trim();
        controller.getMovieCollection().deleteMovie(title);
        System.out.println("Movie deleted successfully.");
    }


    private void addMovie() {
        System.out.println("Enter movie title:");
        String title = scanner.nextLine().trim();

        System.out.println("Enter director:");
        String director = scanner.nextLine().trim();

        System.out.println("Enter release year:");
        int year = getIntInput();

        System.out.println("Is the movie in color? (y/n)");
        boolean isInColor = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.println("Enter movie length in minutes:");
        int length = getIntInput();

        System.out.println("Enter genre:");
        String genre = scanner.nextLine().trim();

        Movie newMovie = new Movie(title, director, year, isInColor, length, genre);
        controller.getMovieCollection().addMovie(newMovie);
        System.out.println("Movie added successfully!");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        return input;
    }

    private void showMovies() {
        String moviesDisplay = controller.getMovieCollection().displayMovies();
        System.out.println("Movies in collection:\n" + moviesDisplay);
    }

    private void searchMovie() {
        System.out.print("Enter movie title to search: ");
        String title = scanner.nextLine().trim();
        ArrayList<Movie> matchingMovies = controller.getMovieCollection().searchMovie(title);

        if (matchingMovies.isEmpty()) {
            System.out.println("No movies found with that title.");
        } else {
            System.out.println("Movies found:");
            for (Movie movie : matchingMovies) {
                System.out.println(movie);
            }
        }
    }

    private void manageMovie() {
        System.out.print("Enter the title of the movie to manage (delete/edit): ");
        String title = scanner.nextLine().trim();
        Movie movieToManage = controller.getMovieCollection().getMovieByTitle(title);

        if (movieToManage == null) {
            System.out.println("Movie not found.");
            return;
        }

        System.out.println("Would you like to delete or edit this movie? (delete/edit)");
        String action = scanner.nextLine().trim();

        if (action.equalsIgnoreCase("delete")) {
            controller.getMovieCollection().deleteMovie(title);
            System.out.println("Movie deleted successfully.");
        } else if (action.equalsIgnoreCase("edit")) {
            editMovie(movieToManage);
        } else {
            System.out.println("Invalid action. Please enter either 'delete' or 'edit'.");
        }
    }

    private void editMovie(Movie movieToEdit) {
        System.out.print("Enter new title (press Enter to keep current): ");
        String newTitle = scanner.nextLine().trim();

        System.out.print("Enter new director (press Enter to keep current): ");
        String newDirector = scanner.nextLine().trim();

        System.out.print("Enter new year (press Enter to keep current): ");
        String yearInput = scanner.nextLine().trim();
        Integer newYear = yearInput.isEmpty() ? null : Integer.parseInt(yearInput);

        System.out.print("Is the movie in color? (y/n, Enter to keep current): ");
        String colorInput = scanner.nextLine().trim();
        Boolean newInColor = colorInput.isEmpty() ? null : colorInput.equalsIgnoreCase("y");

        System.out.print("Enter new length in minutes (press Enter to keep current): ");
        String lengthInput = scanner.nextLine().trim();
        Integer newLength = lengthInput.isEmpty() ? null : Integer.parseInt(lengthInput);

        System.out.print("Enter new genre (press Enter to keep current): ");
        String newGenre = scanner.nextLine().trim();

        controller.getMovieCollection().editMovie(movieToEdit, newTitle, newDirector, newYear, newInColor, newLength, newGenre);
        System.out.println("Movie details updated: " + movieToEdit);
    }
}
/*package UI;

import model.Controller;
import model.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UI {
    private Controller controller;
    private Scanner scanner;

    public UI() {
        this.controller = new Controller();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n--- Movie Collection Menu ---");
        System.out.println("1. Type 'add' to add a movie to your collection");
        System.out.println("2. Type 'movies' to show your movie collection");
        System.out.println("3. Type 'search' to search for a specific movie");
        System.out.println("4. Type 'edit' to edit a movie in your collection");
        System.out.println("5. Type 'load' to load movies from a file");
        System.out.println("6. Type 'save' to save movies to a file");
        System.out.println("7. Type 'exit' to exit program");
    }

    public void startProgram() {
        boolean running = true;
        displayMenu();

        try {
            while (running) {
                String choice = scanner.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "add", "1" -> addMovie();
                    case "movies", "2" -> showMovies();
                    case "search", "3" -> searchMovie();
                    case "edit", "4" -> manageMovie();
                    case "load", "5" -> {
                        try {
                            controller.loadMovies();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Movie loaded to text file");
                    }
                    case "save", "6" -> {
                        try {
                            controller.saveMovies();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Movie saved to text file");
                    }
                    case "exit", "7" -> {
                        System.out.println("Exiting program. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice, please try again.");
                }

                if (running) displayMenu();
            }
        } finally {
            scanner.close();
        }
    }

    private void addMovie() {
        System.out.println("Enter movie title:");
        String title = scanner.nextLine().trim();

        System.out.println("Enter director:");
        String director = scanner.nextLine().trim();

        System.out.println("Enter release year:");
        int year = getIntInput();

        System.out.println("Is the movie in color? (y/n)");
        boolean isInColor = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.println("Enter movie length in minutes:");
        int length = getIntInput();

        System.out.println("Enter genre:");
        String genre = scanner.nextLine().trim();

        Movie newMovie = new Movie(title, director, year, isInColor, length, genre);
        controller.getMovieCollection().addMovie(newMovie);
        System.out.println("Movie added successfully!");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        return input;
    }

    private void showMovies() {
        ArrayList<Movie> movies = controller.getMovieCollection().getMovies();

        // Sorter filmene alfabetisk efter titel
        movies.sort(Comparator.comparing(Movie::getTitle));

        if (movies.isEmpty()) {
            System.out.println("No movies on the list.");
        } else {
            System.out.println("Movies in collection:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    private void searchMovie() {
        System.out.print("Enter movie title to search: ");
        String title = scanner.nextLine().trim();
        ArrayList<Movie> matchingMovies = controller.getMovieCollection().searchMovie(title);

        if (matchingMovies.isEmpty()) {
            System.out.println("No movies found with that title.");
        } else {
            System.out.println("Movies found:");
            for (Movie movie : matchingMovies) {
                System.out.println(movie);
            }
        }
    }

    private void manageMovie() {
        System.out.print("Enter the title of the movie to manage (delete/edit): ");
        String title = scanner.nextLine().trim();
        Movie movieToManage = controller.getMovieCollection().getMovieByTitle(title);

        if (movieToManage == null) {
            System.out.println("Movie not found.");
            return;
        }

        System.out.println("Would you like to delete or edit this movie? (delete/edit)");
        String action = scanner.nextLine().trim();

        if (action.equalsIgnoreCase("delete")) {
            controller.getMovieCollection().deleteMovie(title);
            System.out.println("Movie deleted successfully.");
        } else if (action.equalsIgnoreCase("edit")) {
            editMovie(movieToManage);
        } else {
            System.out.println("Invalid action. Please enter either 'delete' or 'edit'.");
        }
    }

    private void editMovie(Movie movieToEdit) {
        System.out.print("Enter new title (press Enter to keep current): ");
        String newTitle = scanner.nextLine().trim();

        System.out.print("Enter new director (press Enter to keep current): ");
        String newDirector = scanner.nextLine().trim();

        System.out.print("Enter new year (press Enter to keep current): ");
        String yearInput = scanner.nextLine().trim();
        Integer newYear = yearInput.isEmpty() ? null : Integer.parseInt(yearInput);

        System.out.print("Is the movie in color? (y/n, Enter to keep current): ");
        String colorInput = scanner.nextLine().trim();
        Boolean newInColor = colorInput.isEmpty() ? null : colorInput.equalsIgnoreCase("y");

        System.out.print("Enter new length in minutes (press Enter to keep current): ");
        String lengthInput = scanner.nextLine().trim();
        Integer newLength = lengthInput.isEmpty() ? null : Integer.parseInt(lengthInput);

        System.out.print("Enter new genre (press Enter to keep current): ");
        String newGenre = scanner.nextLine().trim();

        controller.getMovieCollection().editMovie(movieToEdit, newTitle, newDirector, newYear, newInColor, newLength, newGenre);
        System.out.println("Movie details updated: " + movieToEdit);
    }
//------- sort movies switch case
    private void sortMovies(){
        System.out.println("Please select the sorting method: ");
        System.out.println("1. Sort by title (A-Z)");
        System.out.println("2. Sort by release year");

        String choice = this.scanner.nextLine().trim();
        ArrayList<Movie> movies = controller.getMovieCollection().getMovies();

        switch (choice) {
            case "1", "Title":
                movies.sort(Comparator.comparing(Movie::getTitle));
                break;

            case "2", "Release year":
                movies.sort(Comparator.comparing(Movie::getYearCreated));
                break;
        }

    }

}
*/
