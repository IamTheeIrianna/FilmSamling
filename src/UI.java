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
        System.out.println("3. Type 'search' to search for a specific movie.");
        System.out.println("4. Type 'edit' to edit or delete a movie in your collection");
        System.out.println("5. Type 'exit' Exit programme");
    }


    // *** START METHOD ** //
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        MovieCollection movieCollection = new MovieCollection(controller.getMovieCollection().getMovieCollectionList());

        boolean running = true;
        displayMenu();

        while (true) {

            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                System.out.println("You chose to exit Movie Collection Programme");
                running = false; //exit loop if user choose exit
                System.exit(0); //prøv denne funktion som rent faktisk lukker programmet
            } else { // if user choose any other option than exit

                switch (choice) {
                    case "add", "1":
                        System.out.println("Enter movie title:");
                        String title = scanner.nextLine().trim();

                        System.out.println("Enter director:");
                        String director = scanner.nextLine().trim();

                        System.out.println("Enter year created:");
                        int year = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        // lav try block for year - misMatchException

                        System.out.println("Is the movie in colour? (y/n)");
                        String colorInput = scanner.nextLine().trim().toLowerCase();
                        boolean isInColor = colorInput.equals("y");

                        System.out.println("Enter movie length in minutes:");
                        int length = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        // lav try block for length in minutes  misMatchException

                        System.out.println("Enter genre:");
                        String genre = scanner.nextLine().trim();

                        // Add the movie to the collection
                        movieCollection.addMovie(title, director, year, isInColor, length, genre);
                        System.out.println("Movie added!");

                        break;

                    case "movies", "2":
                        movieCollection.displayMovies();
                        break;

                    case "search", "3":
                        System.out.print("Search movie by title: ");
                        String searchTitle = scanner.nextLine();
                        ArrayList<Movie> matchingMovies = movieCollection.searchMovie(searchTitle);
                        if (!matchingMovies.isEmpty()) {
                            System.out.println("Movies found: ");
                            int counter = 1;
                            for (Movie movie : matchingMovies) {
                                System.out.println(counter + ". " + movie);
                                counter++;
                            }
                        } else {
                            System.out.println("No movie was found, try again.");
                        }
                        break;

                    case "edit", "4":
                        System.out.println("Enter the title of the movie you'd like to edit:");

                        String movieTitle = scanner.nextLine().trim();
                        editMovie(movieTitle);

                        System.out.println("Movie updated.");
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                displayMenu();
            }

        }

    }

    public void editMovie(String title) {
        // !! Search funktion virker ikke i edit !!
        ArrayList<Movie> matchingMovies = controller.getMovieCollection().searchMovie(title);
        if (matchingMovies.isEmpty()) {
            System.out.println("No movies found under title" + title);
            return;
        }

        // display found movies
        System.out.println("Found movies: ");
        for (int i = 0; i < matchingMovies.size(); i++) {
            System.out.println((i + 1) + ". " + matchingMovies.get(i));

        }

        //User select movie to edit
        System.out.println("Enter the number of the movie you want to edit or delete:");
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

