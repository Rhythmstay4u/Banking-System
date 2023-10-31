import java.util.ArrayList;
import java.util.List;

class Account {
    private int accountNumber;
    private String accountName;
    private double balance;

    public Account(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + ", Account name: " + accountName + ", Balance: " + balance;
    }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountByAccountNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account number does not exist.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account number does not exist.");
        }
    }

    @Override
    public String toString() {
        return "Bank accounts: \n" + accounts;
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create some accounts
        Account account1 = new Account(123456789, "John Doe", 1000);
        Account account2 = new Account(987654321, "Jane Doe", 500);

        // Add the accounts to the bank
        bank.addAccount(account1);
        bank.addAccount(account2);

        // Deposit money into an account
        bank.deposit(123456789, 200);

        // Withdraw money from an account
        bank.withdraw(987654321, 100);

        // Print all the bank accounts
        System.out.println(bank);
    }
}
