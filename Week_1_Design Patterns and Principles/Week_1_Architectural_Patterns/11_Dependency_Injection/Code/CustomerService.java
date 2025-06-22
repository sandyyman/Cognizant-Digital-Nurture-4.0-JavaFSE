public class CustomerService {
    private CustomerRepository repository;

    // Constructor injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomer(int id) {
        Customer customer = repository.findCustomerById(id);
        System.out.println(customer);
    }
}
