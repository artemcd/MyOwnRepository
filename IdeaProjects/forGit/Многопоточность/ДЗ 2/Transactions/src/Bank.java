import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(int fromAccountNum, int toAccountNum, long amount) throws InterruptedException {
        if (amount > 50000) {
            if(isFraud(String.valueOf(fromAccountNum), String.valueOf(toAccountNum), amount) == true) {
               try {
                   Account.listOfAccount.get(fromAccountNum).setBlockAccount(true);
                   Account.listOfAccount.get(toAccountNum).setBlockAccount(true);
               } catch (Exception e) {
                   System.out.println(e.getMessage());
                   }
            } else {
                try {
                    Account.listOfAccount.get(fromAccountNum).setMoney(Account.listOfAccount.get(fromAccountNum).getMoney() - amount);
                    Account.listOfAccount.get(toAccountNum).setMoney(Account.listOfAccount.get(toAccountNum).getMoney() + amount);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } else {
            try {
                Account.listOfAccount.get(fromAccountNum).setMoney(Account.listOfAccount.get(fromAccountNum).getMoney() - amount);
                Account.listOfAccount.get(toAccountNum).setMoney(Account.listOfAccount.get(toAccountNum).getMoney() + amount);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(int accountNum)
    {
        return  Account.listOfAccount.get(accountNum).getMoney();
    }
}
