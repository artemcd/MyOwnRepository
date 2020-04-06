public class MainClass {

    public static void main(String[] args) {
        IP io = new IP(1000000);
        Urr urr = new Urr (50000);
        Fiz fiz = new Fiz(2000);

        io.addMoney(30000);
        io.takeMoney(100000);
        io.getCount();

        fiz.addMoney(2000);
        fiz.getCount();

    }
}
