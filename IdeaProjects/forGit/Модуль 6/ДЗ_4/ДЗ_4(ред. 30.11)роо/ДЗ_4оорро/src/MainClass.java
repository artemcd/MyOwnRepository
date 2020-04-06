import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        Company company = new Company();
        company.hireAll(new Manager(), 10);
        company.hireAll(new TopManager(), 10);

        company.hireAll(new Operator(), 10);

        company.getTopSalaryStaff(30);
        company.getIncome();

/*
        company.getLowestSalaryStaff(30);
*/









    }

    }

