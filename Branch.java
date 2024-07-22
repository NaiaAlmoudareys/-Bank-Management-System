import java.util.ArrayList;

/**
 * Represents a branch of a bank with multiple customers.
 */
public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    /**
     * Constructs a new Branch with the specified name.
     *
     * @param name the name of the branch
     */
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    /**
     * Gets the name of the branch.
     *
     * @return the name of the branch
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of customers at the branch.
     *
     * @return the list of customers
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /**
     * Adds a new customer to the branch.
     *
     * @param customerName the name of the customer
     * @param initialAmount the initial amount for the customer's account
     * @return true if the customer was added, false otherwise
     */
    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    /**
     * Adds a transaction for the specified customer.
     *
     * @param customerName the name of the customer
     * @param amount the transaction amount
     * @return true if the transaction was added, false otherwise
     */
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(amount);
            return true;
        }
        return false;
    }

    /**
     * Finds a customer by name.
     *
     * @param customerName the name of the customer
     * @return the Customer object if found, null otherwise
     */
    private Customer findCustomer(String customerName) {
        for (Customer customer : this.customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }
}
