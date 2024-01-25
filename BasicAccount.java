public class BasicAccount implements IAccount{

    private int accountNumber;
    private double withdrawLimit;
    private double creditLimit = 0;
    private double balance = 0;

    public BasicAccount (int accountNumber,double withdrawLimit) {
        this.accountNumber = accountNumber;
        this.withdrawLimit = withdrawLimit;
    }
    
    @Override
    public double Withdraw(double amount) {
        if(amount < 0){
            System.out.println("Invalid amount");
            return 0;
        }
        if (amount > withdrawLimit) {
            amount = withdrawLimit;
        }
        double creditNeeded = balance - amount;
        if (creditNeeded < creditLimit) {
            amount = balance - creditLimit;
            balance = creditLimit;
        }
        else {
            balance -= amount;
        }
        return amount;
    }

    @Override
    public void Deposit(double amount) {
        if(amount < 0){
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }

    public String toString(){
        return "Account type: Basic account\n" + "Account Number: " + accountNumber + "\nBalance: " + balance + "\nWithdraw Limit: " + withdrawLimit + "\nCredit Limit: " + creditLimit;
    }
}
