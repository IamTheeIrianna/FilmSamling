import java.util.ArrayList;
import java.util.Scanner;

// *** flyt edit til UI
public class UI {
    public void displayMenu() {
        System.out.println("\n--- Movie Collection Menu ---");
        System.out.println("1. Type 'add' to add a movie to your collection");
        System.out.println("2. Type 'movies' to show your movie collection");
        System.out.println("3. Type 'search' to search for a specific movie.");
        System.out.println("4. Type 'edit' to edit a movie in your collection");
        System.out.println("5. Type 'exit' Exit programme");
    }

    // *** START METHOD ** //
    public void startProgram() {

        Scanner scanner = new Scanner(System.in);
        MovieCollection movieCollection = new MovieCollection();

        boolean running = true;
        displayMenu();


        while (running) {

            //User's choice
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("exit")) {
                System.out.println("You chose to exit Movie Collection Programme");
                running = false; //exit loop if user choose exit
                // System.exit(0); - prøv denne funktion som rent faktisk lukker programmet
            } else { // if user choose any other option than exit

                switch (choice) {
                    case "add":
                        System.out.println("Enter movie title:");
                        String title = scanner.nextLine().trim();

                        System.out.println("Enter director:");
                        String director = scanner.nextLine().trim();

                        System.out.println("Enter year created:");
                        int year = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        System.out.println("Is the movie in colour? (y/n)");
                        String colorInput = scanner.nextLine().trim().toLowerCase();
                        boolean isInColor = colorInput.equals("y");

                        System.out.println("Enter movie length in minutes:");
                        int length = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        System.out.println("Enter genre:");
                        String genre = scanner.nextLine().trim();

                        // Add the movie to the collection
                        movieCollection.addMovie(title, director, year, isInColor, length, genre);
                        System.out.println("Movie added!");

                        break;

                    case "movies":
                        movieCollection.displayMovies();
                        break;

                    case "search":
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

                    case "edit":
                        System.out.println("Enter the title of the movie you'd like to edit:");
                        String movieTitle = scanner.nextLine().trim();
                        movieCollection.editMovie(movieTitle);

                        System.out.println("Movie updated.");
                        break;

                    default:
                        System.out.println("Invalid choice");
                        break;
                }
                displayMenu();
            }
        }
        scanner.close();
    }
}

