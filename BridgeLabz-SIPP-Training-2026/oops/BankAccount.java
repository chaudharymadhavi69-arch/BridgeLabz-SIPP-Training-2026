class BankAccount {
    long accountNumber;
    String accountHolderName;
    double balance;

    static int totalAccounts = 0;
    public BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
    public void getStatement() {
        System.out.println("\n----- Account Statement -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount acc1 =
                new BankAccount(123456789L, "John Doe", 5000.50);
        
        acc1.deposit(1000);
        acc1.withdraw(500);
        acc1.deposit(2000);
        acc1.withdraw(1000);
        acc1.deposit(500);
        acc1.getStatement();
        System.out.println("Total Accounts Created: "
                + BankAccount.totalAccounts);
    }
}