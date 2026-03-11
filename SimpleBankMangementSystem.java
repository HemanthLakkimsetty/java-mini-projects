import java.util.*;

class Customer {

    String name;
    String phone;
    double balance;
    ArrayList<String> transactions;

    Customer(String name, String phone, double balance) {
        this.name = name;
        this.phone = phone;
        this.balance = balance;

        transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
        System.out.println("Deposit successful.");
    }

    void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Balance: " + balance);
    }

    void showTransactions() {

        System.out.println("\nTransaction History:");

        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

public class SimpleBankMangementSystem {

    static void transferMoney(HashMap<String, Customer> bank, String from, String to, double amount) {

        if (!bank.containsKey(from) || !bank.containsKey(to)) {
            System.out.println("Customer not found.");
            return;
        }

        Customer sender = bank.get(from);
        Customer receiver = bank.get(to);

        if (sender.balance >= amount) {

            sender.balance -= amount;
            receiver.balance += amount;

            sender.transactions.add("Transferred " + amount + " to " + to);
            receiver.transactions.add("Received " + amount + " from " + from);

            System.out.println("Transfer successful.");

        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Customer> bank = new HashMap<>();

        int choice;

        do {

            System.out.println("\n--- BANK MENU ---");
            System.out.println("1 Create Customer");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 View Customer Details");
            System.out.println("5 Transfer Money");
            System.out.println("6 View Transaction History");
            System.out.println("7 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    Customer c = new Customer(name, phone, balance);
                    bank.put(phone, c);

                    System.out.println("Customer created successfully.");
                    break;

                case 2:
                    System.out.print("Enter phone number: ");
                    phone = sc.next();

                    if (bank.containsKey(phone)) {
                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();
                        bank.get(phone).deposit(amount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter phone number: ");
                    phone = sc.next();

                    if (bank.containsKey(phone)) {
                        System.out.print("Enter withdraw amount: ");
                        double amount = sc.nextDouble();
                        bank.get(phone).withdraw(amount);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter phone number: ");
                    phone = sc.next();

                    if (bank.containsKey(phone)) {
                        bank.get(phone).displayDetails();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter sender phone: ");
                    String from = sc.next();

                    System.out.print("Enter receiver phone: ");
                    String to = sc.next();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();

                    transferMoney(bank, from, to, amount);
                    break;

                case 6:
                    System.out.print("Enter phone number: ");
                    phone = sc.next();

                    if (bank.containsKey(phone)) {
                        bank.get(phone).showTransactions();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the Bank System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}