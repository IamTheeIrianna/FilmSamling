import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieCollection movieCollection = new MovieCollection();

       Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of your movie: ");
        String title = scanner.nextLine();


        System.out.print("Enter the director of the movie: ");
        String director = scanner.nextLine();

        System.out.print("Enter the year the movie was made: ");
        String year = scanner.nextLine();

        System.out.print("Enter the lenght of your movie: ");
        String lenght = scanner.nextLine();


    }
}