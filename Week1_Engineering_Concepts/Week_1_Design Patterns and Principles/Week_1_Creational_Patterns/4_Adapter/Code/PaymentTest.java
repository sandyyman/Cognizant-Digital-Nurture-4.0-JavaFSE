public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        payPalProcessor.processPayment(250.00);
        stripeProcessor.processPayment(300.00);
    }
}
