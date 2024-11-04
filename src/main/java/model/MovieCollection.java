package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movies;

    public MovieCollection(ArrayList<Movie> movieCollectionList) {
        this.movies = movieCollectionList;
    }

    // Display all movies in the collection
    public String displayMovies() {
        if (movies.isEmpty()) {
            return "No movies on the list.";
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
    public ArrayList<Movie> searchMovie(String title) {
        ArrayList<Movie> matchingMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                matchingMovies.add(movie);
            }
        }

        return matchingMovies;
    }

    // Edit a movie's details by title
    public void editMovie(Movie movie, String newTitle, String newDirector, Integer newYear, Boolean newInColor, Integer newLength, String newGenre) {

        if (newTitle != null)
            movie.setTitle(newTitle);

        if (newDirector != null)
            movie.setDirector(newDirector);

        if (newYear != null)
            movie.setYearCreated(newYear);

        if (newInColor != null)
            movie.setInColor(newInColor);

        if (newLength != null)
            movie.setLengthInMinutes(newLength);

        if (newGenre != null && !newGenre.isEmpty())
            movie.setGenre(newGenre);
    }

    // Metode til at slette en film fra samlingen
    public void deleteMovie(String title) {
        Movie movieToDelete = getMovieByTitle(title);
        if (movieToDelete == null) {
            return;
        }

        // Sletter filmen
        movies.remove(movieToDelete);
    }

    // Helper method to find a movie by title
    public Movie getMovieByTitle(String title) {
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

    public void saveMovies() throws FileNotFoundException {
        File nameFile = new File("FilmSamling.txt");
        PrintStream output = new PrintStream(nameFile);

        for (Movie m : movies) {
            output.println(m.getTitle() + "," + m.getDirector() + "," + m.getYearCreated() + "," + m.getIsInColor() + "," + m.getLengthInMinutes() + "," + m.getGenre());
        }
        output.close();
    }
}
