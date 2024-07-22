import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a bank with multiple branches.
 */
public class Bank {
    private static final Logger logger = Logger.getLogger(Bank.class.getName());
    private String name;
    private ArrayList<Branch> branches;

    /**
     * Constructs a new Bank with the specified name.
     *
     * @param name the name of the bank
     */
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    /**
     * Adds a branch to the bank.
     *
     * @param branchName the name of the branch
     * @return true if the branch was added, false otherwise
     */
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            logger.log(Level.INFO, "Branch {0} added.", branchName);
            return true;
        }
        logger.log(Level.WARNING, "Branch {0} already exists.", branchName);
        return false;
    }

    /**
     * Adds a customer to the specified branch.
     *
     * @param branchName   the name of the branch
     * @param customerName the name of the customer
     * @param initialAmount the initial amount for the customer's account
     * @return true if the customer was added, false otherwise
     */
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        logger.log(Level.WARNING, "Branch {0} not found.", branchName);
        return false;
    }

    /**
     * Adds a transaction for the specified customer at the specified branch.
     *
     * @param branchName the name of the branch
     * @param customerName the name of the customer
     * @param amount the transaction amount
     * @return true if the transaction was added, false otherwise
     */
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        logger.log(Level.WARNING, "Branch {0} not found.", branchName);
        return false;
    }

    /**
     * Lists customers and their transactions for the specified branch.
     *
     * @param branchName the name of the branch
     * @param printTransaction true to print transactions, false otherwise
     * @return true if the branch was found, false otherwise
     */
    public boolean listCustomers(String branchName, boolean printTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + " [" + (i + 1) + "]");
                if (printTransaction) {
                    System.out.println("Transactions:");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount: " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            logger.log(Level.WARNING, "Branch {0} not found.", branchName);
            return false;
        }
    }

    /**
     * Finds a branch by name.
     *
     * @param branchName the name of the branch
     * @return the Branch object if found, null otherwise
     */
    private Branch findBranch(String branchName) {
        for (Branch branch : this.branches) {
            if (branch.getName().equalsIgnoreCase(branchName)) {
                return branch;
            }
        }
        return null;
    }
}
