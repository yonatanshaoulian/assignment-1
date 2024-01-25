public class PremiumAccount implements IAccount{

    private int accountNumber;
    private double balance = 0;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public double Withdraw(double amount) {
        if(amount < 0){
            System.out.println("Invalid amount");
            return 0;
        }
        balance -= amount;
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
        return "Account type: Premium account\n" + "Account Number: " + accountNumber + "\nBalance: " + balance;
    }
}
