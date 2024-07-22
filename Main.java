import java.util.Scanner;

/**
 * Main class to run the bank management application.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("National Australia Bank");

    public static void main(String[] args) {
        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (7 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    listCustomers();
                    break;
                case 5:
                    modifyCustomer();
                    break;
                case 6:
                    deleteCustomer();
                    break;
                case 7:
                    printActions();
                    break;
            }
        }
    }

    private static void addBranch() {
        System.out.println("Enter new branch name:");
        String name = scanner.nextLine();
        if (bank.addBranch(name)) {
            System.out.println("New branch added: " + name);
        } else {
            System.out.println("Branch already exists.");
        }
    }

    private static void addCustomer() {
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial transaction amount:");
        double amount = scanner.nextDouble();
        if (bank.addCustomer(branchName, customerName, amount)) {
            System.out.println("New customer added: " + customerName + " to branch " + branchName);
        } else {
            System.out.println("Error adding customer.");
        }
    }

    private static void addTransaction() {
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction amount:");
        double amount = scanner.nextDouble();
        if (bank.addCustomerTransaction(branchName, customerName, amount)) {
            System.out.println("Transaction added for customer: " + customerName);
        } else {
            System.out.println("Error adding transaction.");
        }
    }

    private static void listCustomers() {
        System.out.println("Enter branch name:");
        String branchName = scanner.nextLine();
        System.out.println("Do you want to see transactions? (yes/no)");
        boolean showTransactions = scanner.nextLine().equalsIgnoreCase("yes");
        bank.listCustomers(branchName, showTransactions);
    }

    private static void modifyCustomer() {
        // Implement functionality to modify customer details
    }

    private static void deleteCustomer() {
        // Implement functionality to delete a customer
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\nPress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to add a new branch\n" +
                           "2 - to add a new customer\n" +
                           "3 - to add a transaction\n" +
                           "4 - to list customers\n" +
                           "5 - to modify customer\n" +
                           "6 - to delete customer\n" +
                           "7 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }
}
