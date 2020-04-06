public class IP extends BankClients {
    public IP(int count) {
        super(count);
    }

    @Override
    public void addMoney(int money) {
        if (money < 1000) {
            super.addMoney(money - (money / 100));
        } else  {
            super.addMoney(money - (money / 200));
        }
    }

}
