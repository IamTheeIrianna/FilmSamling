
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.FileHandler;

//// !!!! Få styr på adgang til filhåndtering mappen (load og save) !!!!


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

        while (running) {
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add", "1" -> controller.getMovieCollection().addMovie();
                case "movies", "2" -> controller.getMovieCollection().displayMovies();
                case "search", "3" -> controller.getMovieCollection().searchMovie();
                case "edit", "4" -> controller.getMovieCollection().editMovie();
                case "load", "5"-> {
                    try {
                        controller.getMovieCollection().loadMovies();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "save", "6" -> {
                    try {
                        controller.getMovieCollection().saveMovie();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "exit", "7" -> {
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
            if (running) displayMenu();
        }
    }
}
