import java.util.Scanner;

public class Controller {


    private Controller controller;
    private Movie movie;
    private Scanner scanner;

    public Controller() {
       MovieCollection movieCollection = new MovieCollection();
        movie = new Movie(movie.getTitle(), movie.getDirector(), movie.getYearCreated(), movie.getIsInColor(), movie.getLengthInMinutes(), movie.getGenre());
    }
}
/*
    //-------------------------------
    public void startProgram() {
        while (true) {
            System.out.println("Title: ");
            Scanner scanner = null;
            String title = scanner.nextLine();

            if (title.equals("exit"))
                break;

            System.out.println("Director: ");
            String director = scanner.nextLine();

            System.out.println("Is the movie in colour? (y/n)");
            String colorInput = scanner.nextLine().trim().toLowerCase();
            boolean isInColor = colorInput.equals("y");

            System.out.println("Movie length in minutes: ");
            int lengthInMinutes = scanner.nextInt();

            System.out.println("Creation year: ");
            int yearCreated = scanner.nextInt();

            System.out.println("Genre: ");
            String genre = scanner.nextLine();

            movieCollection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);

            System.out.println("Your movie has been added to the retrospective collection. ");

            scanner.close();
            }
        }*/



