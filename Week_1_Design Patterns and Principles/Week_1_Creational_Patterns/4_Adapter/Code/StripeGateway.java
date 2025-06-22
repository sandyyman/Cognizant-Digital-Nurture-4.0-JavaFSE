public class StripeGateway {
    public void initiateTransaction(double amount) {
        System.out.println("Processing payment via Stripe: $" + amount);
    }
}
