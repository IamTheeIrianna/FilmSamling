import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   MovieCollection movieCollection = new MovieCollection();
   Scanner scanner = new Scanner(System.in);

        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("Director: ");
        String director = scanner.nextLine();

        System.out.println("Is the movie in colour or B&W?");
        boolean isInColor = scanner.nextBoolean();

        System.out.println("Movie length in minutes: ");
        int length = scanner.nextInt();

        System.out.println("Creation year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Genre: ");
        String genre = scanner.nextLine();

        movieCollection.addMovie();

        System.out.println("Your movie has been added to the retrospective collection. ");

        scanner.close();
    }
}