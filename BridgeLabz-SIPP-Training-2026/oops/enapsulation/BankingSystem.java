abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber,
                       String holderName,
                       double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account No : " + accountNumber);
        System.out.println("Holder Name : " + holderName);
        System.out.println("Balance : " + balance);
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accNo,
                          String name,
                          double balance,
                          double interestRate) {
        super(accNo, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {
    private double monthlyBonusRate;

    public CurrentAccount(String accNo,
                          String name,
                          double balance,
                          double monthlyBonusRate) {
        super(accNo, name, balance);
        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        SavingsAccount sa =
                new SavingsAccount("S101", "Rahul",
                        50000, 5);

        CurrentAccount ca =
                new CurrentAccount("C201", "Priya",
                        40000, 2);

        sa.deposit(5000);
        sa.withdraw(2000);

        ca.deposit(3000);
        ca.withdraw(1000);

        System.out.println("Savings Account");
        sa.displayAccountDetails();
        System.out.println("Interest = " +
                sa.calculateInterest());

        System.out.println();

        System.out.println("Current Account");
        ca.displayAccountDetails();
        System.out.println("Interest = " +
                ca.calculateInterest());
    }
}