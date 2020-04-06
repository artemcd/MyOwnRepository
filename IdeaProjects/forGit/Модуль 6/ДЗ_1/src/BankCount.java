public class BankCount {
    private  int count;

    public    BankCount (int count) {
        this.count = count;
    }


    public void addMoney(int money) {
    if (money > 0) {
        count += money;
    } else {
        System.out.println("Нельзя положить на счёт отрицательную сумму.");
    }
}

    public void takeMoney (int money)  {
        if (money <= getCount() && money>0) {
            count -= money;
        }else {
            System.out.println("Вы хотите снять денег больше, чем есть на счёте.");
        }
}

    public int  getCount() {
        System.out.println(count);
        return count;
    }


}

