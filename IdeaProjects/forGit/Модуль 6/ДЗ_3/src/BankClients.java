public abstract class BankClients {
    private int count = 0;

    public BankClients(int count) {

        this.count = count;
    }

    public  void addMoney(int money)   {
        if (money > 0) {
            count += money;
        }else System.out.println("Не верная сумма");

    }

    public  void takeMoney(int money) {
        if (money < 0 && money > count) {
            System.out.println("Не верная сумма снятия");
        } else {
            count -= money;
        }
    }


    public int getCount() {
        System.out.println(count);
        return count;
    }
}