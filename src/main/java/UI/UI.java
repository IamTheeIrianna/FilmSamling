package UI;

import model.Controller;
import model.Movie;

import java.io.FileNotFoundException;
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

        while (running) {
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "add", "1" -> {
                    System.out.println("Enter movie title:");
                    String title = scanner.nextLine().trim();

                    System.out.println("Enter director:");
                    String director = scanner.nextLine().trim();

                    System.out.println("Enter year created:");
                    int year = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.println("Is the movie in color? (y/n)");
                    boolean isInColor = scanner.nextLine().trim().equalsIgnoreCase("y");

                    System.out.println("Enter movie length in minutes:");
                    int length = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.println("Enter genre:");
                    String genre = scanner.nextLine().trim();

                    Movie newMovie = new Movie(title, director, year, isInColor, length, genre);

                    controller.getMovieCollection().addMovie(newMovie);
                    System.out.println("Movie added successfully!");
                }


                case "movies", "2" -> {
                    System.out.println("Movies in collection: ");
                    String moviesDisplay = controller.getMovieCollection().displayMovies();
                    System.out.println(moviesDisplay);
                }
                case "search", "3" -> controller.getMovieCollection().searchMovie();
                case "edit", "4" -> controller.getMovieCollection().editMovie();
                case "load", "5" -> {
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
                    System.out.println("Film gemt til tekst fil.");
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
