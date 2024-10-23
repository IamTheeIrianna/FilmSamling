import java.util.Scanner;

public class Controller {
private Movie movie;
private MovieCollection movieCollection;
private Scanner scanner;

public Controller(){
    movieCollection = new MovieCollection();
    scanner = new Scanner(System.in);

}


public void startProgram() {
    boolean running = true;
    while (running) {
        displayMenu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                movieCollection.addMovie();
                break;
            case 2:
                running = false;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    Scanner scanner = new Scanner(System.in);
    String command;
    System.out.println("Welcome to your movie collection");
    System.out.println("1. Add a movie to your collection");
    System.out.println("2. exit programme");




    }

}
