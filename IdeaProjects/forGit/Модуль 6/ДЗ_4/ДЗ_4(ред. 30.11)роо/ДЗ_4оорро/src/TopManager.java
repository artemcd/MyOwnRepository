public class TopManager  implements Employee{
    private final int SALARY;

    public TopManager() {
        if (getProfit() >= 10000000) {
            SALARY = 210000;
        } else {
            SALARY = 70000;
        }
    }


    @Override
    public int getMonthSalary() {
        return SALARY;
    }
}





