import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(201, "Alice", 320.0),
                new Order(202, "Bob", 150.5),
                new Order(203, "Charlie", 499.9),
                new Order(204, "Diana", 210.0)
        };

        bubbleSort(orders);

        System.out.println("Sorted by Bubble Sort:");
        Arrays.stream(orders).forEach(System.out::println);
    }
}
