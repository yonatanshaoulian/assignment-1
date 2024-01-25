public class StandardAccount implements IAccount {

    private int accountNumber;
    private double creditLimit = 0;
    private double balance = 0;
    
    public StandardAccount(int accountNumber,double creditLimit) {
        this.accountNumber = accountNumber;
        if (creditLimit < 0) {
            this.creditLimit = creditLimit;
        } 
    }

    @Override
    public double Withdraw(double amount) {
        if(amount < 0){
            System.out.println("Invalid amount");
            return 0;
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
        return "Account type: Standard account\n" + "Account Number: " + accountNumber + "\nBalance: " + balance + "\nCredit Limit: " + creditLimit;
    }
}
