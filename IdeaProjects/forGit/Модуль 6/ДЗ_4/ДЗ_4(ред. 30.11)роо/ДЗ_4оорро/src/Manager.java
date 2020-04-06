public class Manager implements Employee {
    final int SALARY;
    private int profit;

    public Manager() {
        profit = (int) (500000 * Math.random()) + 100000;
        SALARY = 50000 + (int) (50000 * Math.random()) + (profit * 5 / 100);

    }

    public int getProfit() {
        return profit;
    }

    public int getMonthSalary() {
       return SALARY;
    }

    }




