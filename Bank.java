import java.util.Scanner;

class Account {
    String customerName;
    String accountNumber;
    double balance;

    Account(String name, String accNo, double bal) {
        customerName = name;
        accountNumber = accNo;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Updated balance: " + balance);
    }

    void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

class SavAcct extends Account {
    SavAcct(String name, String accNo, double bal) {
        super(name, accNo, bal);
    }

    void computeInterest(double rate, int years) {
        double interest = balance * Math.pow(1 + rate / 100, years) - balance;
        balance += interest;
        System.out.println("Interest added. Updated balance: " + balance);
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 500.0;
    private static final double PENALTY = 50.0;

    CurAcct(String name, String accNo, double bal) {
        super(name, accNo, bal);
    }

    void withdraw(double amount) {
        if (balance - amount < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Below minimum balance. Penalty imposed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
        System.out.println("Updated balance: " + balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavAcct savings = new SavAcct("Alice", "S123", 1000.0);
        CurAcct current = new CurAcct("Bob", "C456", 2000.0);

        savings.deposit(500);
        savings.computeInterest(5, 2);
        savings.displayBalance();

        current.deposit(1000);
        current.withdraw(1800);
        current.displayBalance();

        scanner.close();
    }
}
