public class Urr extends BankClients {
    public Urr(int count) {
        super(count);
    }
    @Override
        public void takeMoney(int money) {
                super.takeMoney(money -(money/100));
    }
}
