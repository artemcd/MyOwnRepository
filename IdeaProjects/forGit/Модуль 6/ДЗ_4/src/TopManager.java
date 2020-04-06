public class TopManager implements Employee {
    private  final int SALARY;

    public TopManager() {
        SALARY = getMonthSalary();
    }
    public int getSalary(){
        return SALARY;
    }

    @Override
    public int getMonthSalary() {
        int fix = 70000 + (int)(100000*Math.random());
        int randomSalary;
        if (new Company().getIncome() >= 10000000) {
            randomSalary = (int) (fix*1.5);
        }else{
            randomSalary = fix;
        }
        return randomSalary;
    }
}





