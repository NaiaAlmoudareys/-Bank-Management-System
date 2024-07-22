# Bank Management System

## Overview

The Bank Management System is a Java application designed to manage bank operations, including branches, customers, and transactions. It provides a user-friendly interface to add branches, manage customers, perform transactions, and view customer details.

## Features

- **Branch Management**: Create and manage branches.
- **Customer Management**: Add customers to branches and manage their transactions.
- **Transaction Management**: Record transactions for customers.
- **Customer Details**: View customer details and their transaction history.
- **User Interface**: Menu-driven text-based interface for easy interaction.
- **Logging**: Logging functionality for better debugging and monitoring.

## How to Use

1. **Start the Application**: Run the `Main` class to start the application.
2. **Interact with the Menu**: Use the provided menu to navigate through different operations:
   - `0`: Shutdown the application
   - `1`: Add a new branch
   - `2`: Add a new customer
   - `3`: Add a transaction for a customer
   - `4`: List customers of a branch
   - `5`: Modify customer details (to be implemented)
   - `6`: Delete a customer (to be implemented)
   - `7`: Print the list of available actions

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your computer.

### Installation

1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure the JDK is correctly set up in your IDE.

### Running the Application

1. Compile and run the `Main` class.
2. Follow the on-screen instructions to interact with the application.

## Code Structure

- **Bank.java**: Defines the Bank class, including methods to add branches, customers, and transactions, and list customer details.
- **Branch.java**: Defines the Branch class, including methods to add customers and transactions.
- **Customer.java**: Defines the Customer class, representing individual customers with a list of transactions.
- **Main.java**: Contains the main application logic and user interface.

## Example Usage

1. Add a new branch:
   ```java
   bank.addBranch("Adelaide");
