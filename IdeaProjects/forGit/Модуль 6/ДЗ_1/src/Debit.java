import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Debit extends BankCount {
    public Debit(int count) {
        super(count) ;
    }
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate dateStart;
    public void addMoney(int money) {
        if (money >= 0 ) {
        super.addMoney(money);
            LocalDate localDate = LocalDate.now();
            dateStart = localDate;
    } else System.out.println("Нельзя положить на счёт отрицательное число.");
        }

    public void takeMoney (int money) {
        if (money <= super.getCount()) {
            if (dateStart != null) {
                LocalDate dateEnd = LocalDate.now();
                Period dif = Period.between(dateStart, dateEnd);
                String diff = dif.toString();
                String sub1 = "Y";
                String sub2 = "M";
                if (diff.indexOf(sub1) != -1 || diff.indexOf(sub2) != -1) {
                    super.takeMoney(money);
                } else {
                    System.out.println("Следующая дата снятия: " + (dateStart.plusMonths(1)).format(pattern));
                }
            } else super.takeMoney(money);

        }
    else System.out.println("Превышен лимит.");
    }


        }

