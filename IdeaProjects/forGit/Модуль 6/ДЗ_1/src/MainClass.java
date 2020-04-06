import java.time.LocalDate;
import java.time.Period;

public class MainClass {
    public static void main(String[] args) {
        Debit debit = new Debit(10000);
        debit.takeMoney(10000000);
        debit.takeMoney(10);
        debit.getCount();
        debit.addMoney(50);
        debit.getCount();
        debit.takeMoney(577);
        CreditCount creditCount = new CreditCount(5000);
        creditCount.getCount();
        creditCount.takeMoney(1000);
creditCount.getCount();
    }
}

