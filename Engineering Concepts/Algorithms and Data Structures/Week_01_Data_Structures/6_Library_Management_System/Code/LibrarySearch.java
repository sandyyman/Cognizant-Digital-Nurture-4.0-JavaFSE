import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);
            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] library = {
                new Book(101, "Data Structures", "Mark Allen"),
                new Book(102, "Operating Systems", "Andrew Tanenbaum"),
                new Book(103, "Algorithms", "CLRS"),
                new Book(104, "Computer Networks", "Forouzan"),
                new Book(105, "Database Systems", "Raghu Ramakrishnan")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Book result1 = linearSearch(library, "Algorithms");
        System.out.println(result1 != null ? result1 : "Book not found");

        // Sort before Binary Search
        Arrays.sort(library, Comparator.comparing(b -> b.title.toLowerCase()));

        // Binary Search
        System.out.println("\nBinary Search:");
        Book result2 = binarySearch(library, "Algorithms");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
