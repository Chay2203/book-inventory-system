import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatasetReader {
    
    public static ArrayList<Book> readCSV(String fileName) {
        ArrayList<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                
                String[] values = line.split(",");
                
                if (values.length == 7) {
                    String name = values[0].trim();
                    String author = values[1].trim();
                    double userRating = Double.parseDouble(values[2].trim());
                    int reviews = Integer.parseInt(values[3].trim());
                    int price = Integer.parseInt(values[4].trim());
                    int year = Integer.parseInt(values[5].trim());
                    String genre = values[6].trim();
                    
                    Book book = new Book(name, author, userRating, reviews, price, year, genre);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
        
        return books;
    }
}