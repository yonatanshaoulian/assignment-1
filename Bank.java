import java.util.List;
import java.util.ArrayList;

public class Bank implements IBank{
    private List<IAccount> accounts;

    public Bank() {
        accounts = new ArrayList<IAccount>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() < 0) {
                    System.out.println("Account :" + accountNumber + " is not closed due to debt.");
                }
                else {
                    accounts.remove(account);
                }
                return;
            }
        }
        System.out.println("Account :" + accountNumber + " is not found.");        
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<IAccount>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                accountsInDebt.add(account);
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<IAccount>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account);
            }
        }
        return accountsWithBalance;
    } 

    public String toString() {
        String result = "";
        for (IAccount account : accounts) {
            result += account.toString() + "\n\n";
        }
        return result;
    }
}
