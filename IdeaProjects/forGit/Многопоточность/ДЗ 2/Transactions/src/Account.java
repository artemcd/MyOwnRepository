import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Account
{
    private long money;
    private int accNumber;
    private boolean isBlockAccount = false;
    public static TreeMap<Integer, Account> listOfAccount = new TreeMap<>();

    public Account () {
        this.accNumber = this.hashCode();
listOfAccount.put(this.accNumber, this);
    }


    public long getMoney() {
        if(this.isBlockAccount == true) {
            System.out.println("Счёт был заблокирован!!!");;
        }
        return money;
    }

    public void setMoney(long money) {
        if(this.isBlockAccount == true) {
            System.out.println("Счёт заблокирован! Невозможно изменить сумму на счёте!");;
        } else {
            this.money = money;
        }
    }

    public int getAccNumber() {
        if(this.isBlockAccount == true) {
            System.out.println("Счёт был заблокирован!!!");;
        }
        return accNumber;
    }


    public boolean isBlockAccount() {
        return isBlockAccount;
    }

    public void setBlockAccount(boolean blockAccount) {
        isBlockAccount = blockAccount;
    }
}
