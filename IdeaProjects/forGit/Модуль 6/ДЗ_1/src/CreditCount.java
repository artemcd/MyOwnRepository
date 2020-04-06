public class CreditCount extends BankCount {
    public CreditCount(int count) {
super(count);
    }

    public void takeMoney (int money) {
        if ((money + (money / 100)) <= super.getCount()) {
            super.takeMoney(money + (money / 100));
        } else System.out.println("Превышен лимит.");
    }

    public void addMoney(int money) {
        if (money > 0) {
            super.addMoney(money);
        } else {
            System.out.println("Нельзя положить на счёт отрицательную сумму.");
        }
    }
}

