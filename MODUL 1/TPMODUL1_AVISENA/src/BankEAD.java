package PraktikumOOP.MODUL1.TPMODUL1_AVISENA;
import java.util.ArrayList;

public class BankEAD{
    private ArrayList<Account> accountList;

    public BankEAD() {
        accountList = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    public void deposit(Account account, Integer amount) {
        account.deposit(amount);
    }

    public boolean withdraw(Account account, Integer amount) {
        return account.withdraw(amount);
    }

    public ArrayList<Account> getAllAccounts() {
        return accountList;
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
