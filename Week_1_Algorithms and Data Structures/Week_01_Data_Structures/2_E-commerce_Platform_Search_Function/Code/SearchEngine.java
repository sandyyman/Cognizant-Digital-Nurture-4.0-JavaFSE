import java.util.Comparator;
import java.util.*;
public class SearchEngine {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }
    public static void main(String[] args) {
        Product[] productList = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Book", "Education"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Tablet", "Electronics")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Product result1 = linearSearch(productList, "Phone");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sorting before binary search
        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        System.out.println("Binary Search:");
        Product result2 = binarySearch(productList, "Phone");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}

