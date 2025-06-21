public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        // Simulating a database fetch
        System.out.println("Fetching customer with ID " + id + "...");
        return new Customer(id, "John Doe", "john@example.com");
    }
}
