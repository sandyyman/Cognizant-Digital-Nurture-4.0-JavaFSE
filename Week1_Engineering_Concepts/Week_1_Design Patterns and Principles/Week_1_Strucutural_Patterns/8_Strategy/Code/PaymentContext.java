public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void payAmount(double amount) {
        if (strategy == null) {
            System.out.println("Payment method not selected.");
            return;
        }
        strategy.pay(amount);
    }
}
