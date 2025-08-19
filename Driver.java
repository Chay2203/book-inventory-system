import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Driver {
    
    public static int countBooksByAuthor(String authorName, ArrayList<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }
    
    public static void printAllAuthors(ArrayList<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        
        System.out.println("All Authors:");
        for (String author : authors) {
            System.out.println("- " + author);
        }
        System.out.println();
    }
    
    public static void printBooksByAuthor(String authorName, ArrayList<Book> books) {
        System.out.println("Books by " + authorName + ":");
        boolean found = false;
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println("- " + book.getName());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found by " + authorName);
        }
        System.out.println();
    }
    
    public static void printBooksByRating(double rating, ArrayList<Book> books) {
        System.out.println("Books with rating " + rating + ":");
        boolean found = false;
        
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                System.out.println("- " + book.getName() + " by " + book.getAuthor());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found with rating " + rating);
        }
        System.out.println();
    }
    
    public static void printBookPricesByAuthor(String authorName, ArrayList<Book> books) {
        System.out.println("Book prices by " + authorName + ":");
        boolean found = false;
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println("- " + book.getName() + ": $" + book.getPrice());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found by " + authorName);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayList<Book> books = DatasetReader.readCSV("books.csv");
        
        if (books.isEmpty()) {
            System.out.println("No books loaded from CSV file.");
            return;
        }
        
        System.out.println("Loaded " + books.size() + " books from CSV file.\n");
        
        System.out.println("Task 1: Count books by George Orwell");
        int count = countBooksByAuthor("George Orwell", books);
        System.out.println("George Orwell has " + count + " books.\n");
        
        System.out.println("Task 2: Print all authors");
        printAllAuthors(books);
        
        System.out.println("Task 3: Print books by George Orwell");
        printBooksByAuthor("George Orwell", books);
        
        System.out.println("Task 4: Print books with rating 4.7");
        printBooksByRating(4.7, books);
        
        System.out.println("Task 5: Print book prices by George Orwell");
        printBookPricesByAuthor("George Orwell", books);
    }
}