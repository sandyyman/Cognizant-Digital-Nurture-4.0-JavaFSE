import java.util.HashMap;

public class Forecast {

    // Recursive method without memoization
    public static double futureValueRecursive(double initial, double rate, int years) {
        if (years == 0)
            return initial;
        return futureValueRecursive(initial, rate, years - 1) * (1 + rate);
    }

    // Optimized with memoization
    static HashMap<Integer, Double> memo = new HashMap<>();
    public static double futureValueMemo(double initial, double rate, int years) {
        if (years == 0)
            return initial;
        if (memo.containsKey(years))
            return memo.get(years);

        double value = futureValueMemo(initial, rate, years - 1) * (1 + rate);
        memo.put(years, value);
        return value;
    }

    public static void main(String[] args) {
        double initial = 10000.0;   // ₹10,000
        double rate = 0.08;         // 8% growth
        int years = 5;

        System.out.println("Using simple recursion:");
        System.out.printf("Future value after %d years: ₹%.2f%n", years, futureValueRecursive(initial, rate, years));

        System.out.println("\nUsing optimized (memoized) recursion:");
        System.out.printf("Future value after %d years: ₹%.2f%n", years, futureValueMemo(initial, rate, years));
    }
}
