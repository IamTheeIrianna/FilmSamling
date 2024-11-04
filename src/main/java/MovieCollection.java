import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// *** Refactor to filehandler *** //


public class MovieCollection {
    private ArrayList<Movie> movies;
    private Scanner scanner;

    public MovieCollection(ArrayList<Movie> movieCollectionList) {
        this.movies = movieCollectionList;
        this.scanner = new Scanner(System.in);
    }

    // Add a new movie to the collection
    public void addMovie() {
        try {
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
            movies.add(newMovie);
            System.out.println("Movie added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Display all movies in the collection
    public void displayMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in collection.");
        } else {
            System.out.println("\n--- Your Movie Collection ---");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    // Search for movies by title
    public void searchMovie() {
        System.out.print("Enter movie title to search: ");
        String title = scanner.nextLine().trim();
        ArrayList<Movie> matchingMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                matchingMovies.add(movie);
            }
        }

        if (matchingMovies.isEmpty()) {
            System.out.println("No movies found with that title.");
        } else {
            System.out.println("Movies found:");
            for (Movie movie : matchingMovies) {
                System.out.println(movie);
            }
        }
    }

    // Edit a movie's details by title
    public void editMovie() {
        System.out.print("Enter the title of the movie to edit: ");
        String title = scanner.nextLine().trim();
        Movie movieToEdit = getMovieByTitle(title);

        if (movieToEdit == null) {
            System.out.println("Movie not found.");
            return;
        }

        System.out.print("Enter new title (press Enter to keep current): ");
        String newTitle = scanner.nextLine().trim();
        if (!newTitle.isEmpty()) movieToEdit.setTitle(newTitle);

        System.out.print("Enter new director (press Enter to keep current): ");
        String newDirector = scanner.nextLine().trim();
        if (!newDirector.isEmpty()) movieToEdit.setDirector(newDirector);

        System.out.print("Enter new year (press Enter to keep current): ");
        String yearInput = scanner.nextLine().trim();
        if (!yearInput.isEmpty()) {
            try {
                movieToEdit.setYearCreated(Integer.parseInt(yearInput));
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format.");
            }
        }

        System.out.print("Is the movie in color? (y/n, Enter to keep current): ");
        String colorInput = scanner.nextLine().trim();
        if (!colorInput.isEmpty()) movieToEdit.setInColor(colorInput.equalsIgnoreCase("y"));

        System.out.print("Enter new length in minutes (press Enter to keep current): ");
        String lengthInput = scanner.nextLine().trim();
        if (!lengthInput.isEmpty()) {
            try {
                movieToEdit.setLengthInMinutes(Integer.parseInt(lengthInput));
            } catch (NumberFormatException e) {
                System.out.println("Invalid length format.");
            }
        }

        System.out.print("Enter new genre (press Enter to keep current): ");
        String newGenre = scanner.nextLine().trim();
        if (!newGenre.isEmpty()) movieToEdit.setGenre(newGenre);

        System.out.println("Movie details updated: " + movieToEdit);
    }

    // Helper method to find a movie by title
    private Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
    // throws FileNotFoundException to indicate that the file was not found
    public void loadMovies() throws FileNotFoundException {

        File namesFile = new File("FilmSamling.txt");
        Scanner scan = new Scanner(namesFile);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] data = line.split(",");

            if (data.length == 6) {

                String title = data[0];
                String director = data[1];
                int year = Integer.parseInt(data[2]);
                boolean isInColor = Boolean.parseBoolean(data[3]);
                int length = Integer.parseInt(data[4]);
                String genre = data[5];

                Movie movie = new Movie(title, director, year, isInColor, length, genre);
                movies.add(movie);
            }
        }
        scan.close();
        System.out.println("Film indlæst til samlingen.");
    }

    public void saveMovie() throws FileNotFoundException {
        // TODO: Implement save of the names list to a file
        //System.out.println("NOT IMPLEMENTED");
        File nameFile = new File("FilmSamling.txt");
        PrintStream output = new PrintStream(nameFile);

        for (Movie m : movies) {
            output.println(m.getTitle() + "," + m.getDirector() + "," + m.getYearCreated() + "," + m.getIsInColor() + "," + m.getLengthInMinutes() + "," + m.getGenre());
        }
        output.close();
        System.out.println("Film gemt til tekst fil.");

    }

}
