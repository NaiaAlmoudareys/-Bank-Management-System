import java.util.ArrayList;

/**
 * Represents a customer with a list of transactions.
 */
public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    /**
     * Constructs a new Customer with the specified name and initial amount.
     *
     * @param name the name of the customer
     * @param initialAmount the initial amount for the customer's account
     */
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    /**
     * Gets the name of the customer.
     *
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of transactions for the customer.
     *
     * @return the list of transactions
     */
    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    /**
     * Adds a transaction to the customer's account.
     *
     * @param amount the transaction amount
     */
    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }
}
