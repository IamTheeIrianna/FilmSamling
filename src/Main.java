import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


       Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title of your movie");
        String title = scanner.nextLine();

        System.out.println("Enter the director of the movie");
        String director = scanner.nextLine();

        System.out.println("Enter the year the movie was made");
        String year = scanner.nextLine();
    }
}