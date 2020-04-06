public class Operator implements Employee {

    private final int SALARY;

    public Operator() {
        SALARY = 10000 + (int) (40000 * Math.random());
    }


    public int getMonthSalary() {
        {
            return SALARY;
        }

    }
}

