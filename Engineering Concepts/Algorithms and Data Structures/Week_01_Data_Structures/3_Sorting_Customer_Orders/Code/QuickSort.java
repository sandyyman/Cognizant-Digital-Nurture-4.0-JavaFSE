import java.util.Arrays;

public class QuickSort {
    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(201, "Alice", 320.0),
                new Order(202, "Bob", 150.5),
                new Order(203, "Charlie", 499.9),
                new Order(204, "Diana", 210.0)
        };

        quickSort(orders, 0, orders.length - 1);

        System.out.println("Sorted by Quick Sort:");
        Arrays.stream(orders).forEach(System.out::println);
    }
}
