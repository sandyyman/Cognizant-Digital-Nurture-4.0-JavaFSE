public class DIExampleTest {
    public static void main(String[] args) {
        // Inject repository into service
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use service
        service.displayCustomer(1);
    }
}
