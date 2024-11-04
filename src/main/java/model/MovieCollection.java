package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieCollection {
    private ArrayList<Movie> movies;
    private Scanner scanner;

    public MovieCollection(ArrayList<Movie> movieCollectionList) {
        this.movies = movieCollectionList;
        this.scanner = new Scanner(System.in);
    }

    // Display all movies in the collection
   public String displayMovies() {
       if (movies.isEmpty()) {
           return "No movies available.";
       }
       StringBuilder movieList = new StringBuilder();
       for (Movie movie : movies) {
           movieList.append(movie.toString()).append("\n\n");
       }
       return movieList.toString();
   }

    public void addMovie(Movie newMovie) {
        movies.add(newMovie);
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
    //--------------------------- SearchMovies----------------
    public static ArrayList<Movie> searchMovie(String title) {
        ArrayList<Movie> matchingMovies = new ArrayList<>();
        try {
            for (Movie movie : movies) {
                if (movie.getTitle().equalsIgnoreCase(title)) {
                    matchingMovies.add(movie);
                }
            }
        }catch (Exception e) {
            e.getMessage();
        }


        return matchingMovies;
    }


    // Edit a movie's details by title
    public void editMovie() {
        displayMovies(); // lav evt. en metode som kun viser film titler som kan ændres
        System.out.print("Enter the title of the movie to edit: ");
        String title = scanner.nextLine().trim();
        Movie movieToEdit = getMovieByTitle(title);

        if (movieToEdit == null) {
            System.out.println("model.Movie not found.");
            return;
        }
        //----------------------------------------------------------
        /*System.out.println("Would you like to delete or edit this movie? (delete/edit)");
            String action = scanner.nextLine().trim();
            if (action.equalsIgnoreCase("delete")) {
        deleteMovie(title);
    } else if (action.equalsIgnoreCase("edit")) {
       public void deleteMovie(String title) {
    Movie movieToDelete = getMovieByTitle(title);

    if (movieToDelete == null) {
        System.out.println("Movie not found.");
        return;
    }

    movies.remove(movieToDelete);
    System.out.println("Movie deleted successfully.");
}
        */
//------------------------------------------------------
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

        File nameFile = new File("FilmSamling.txt");
        PrintStream output = new PrintStream(nameFile);

        for (Movie m : movies) {
            output.println(m.getTitle() + "," + m.getDirector() + "," + m.getYearCreated() + "," + m.getIsInColor() + "," + m.getLengthInMinutes() + "," + m.getGenre());
        }
        output.close();

    }



}
