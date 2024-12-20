package datasource;

import model.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


public class Filehandler {
    private final String filePath = "FilmSamling.txt";
    ArrayList<Movie> movies = new ArrayList<>();

    public ArrayList<Movie> loadMovies() {

        try {
            // Check if file exists before trying to read
            if (!Files.exists(Paths.get(filePath))) {
                System.out.println("File not found. Returning empty movie list.");
                return movies;
            }

            // Use Streams to load movie data
            try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
                lines.forEach(line -> {
                    String[] data = line.split(",");
                    if (data.length == 6) {
                        String title = data[0];
                        String director = data[1];
                        int year = Integer.parseInt(data[2]);
                        boolean isInColor = Boolean.parseBoolean(data[3]);
                        int length = Integer.parseInt(data[4]);
                        String genre = data[5];

                        movies.add(new Movie(title, director, year, isInColor, length, genre));
                    }
                });
            }


            System.out.println("Loaded " + movies.size() + " movies from the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }


    public boolean saveMovie(ArrayList<Movie> movies) {
        try (PrintStream output = new PrintStream(new File(filePath))) {
            System.out.println("Saving " + movies.size() + " movies to the file.");
            for (Movie m : movies) {
                output.println(m.getTitle() + "," + m.getDirector() + "," + m.getYearCreated() + "," + m.getIsInColor() + "," + m.getLengthInMinutes() + "," + m.getGenre());
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;

        }
    }
}

