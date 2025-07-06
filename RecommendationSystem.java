package recommendationSystem;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

  class Book {
    private String title;
    private String genre;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
public class RecommendationSystem {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Harry Potter and the Sorcerer's Stone", "Fantasy"));
        books.add(new Book("The Hobbit", "Fantasy"));
        books.add(new Book("Pride and Prejudice", "Romance"));
        books.add(new Book("To Kill a Mockingbird", "Classic"));
        books.add(new Book("1984", "Dystopian"));
        books.add(new Book("The Great Gatsby", "Classic"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your favorite genre (e.g., Fantasy, Romance, Classic, Dystopian):");
        String favGenre = scanner.nextLine();

        System.out.println("\nRecommended books for you:");
        boolean found = false;
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(favGenre)) {
                System.out.println(book.getTitle());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recommendations found for this genre.");
        }

        scanner.close();
    }
}


