public class Manager implements Employee {
    final int SALARY;

    public Manager() {
        SALARY = getMonthSalary();
    }



    @Override
    public int getMonthSalary() {
        int randomSalary = 50000 + (int) (15000 * Math.random());
        return randomSalary;
    }

    public int getSalary() {
        return ((SALARY - 50000) *20);
    }
}



