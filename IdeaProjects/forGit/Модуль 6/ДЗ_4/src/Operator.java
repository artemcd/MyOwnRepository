public class Operator implements Employee {

    private final int SALARY;
    public Operator(){
        SALARY = getMonthSalary();
    }


        public int getMonthSalary () {
            int randomSalary = 35000;
            return randomSalary;
        }
    public int getSalary(){
        return SALARY;
    }
    }

