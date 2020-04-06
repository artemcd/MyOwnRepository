import java.util.*;

public class Company {
    private int profitOfCompany;

    public Company () {
        getIncome();
    }

    private ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public int getIncome() {
        System.out.println(profitOfCompany);
        return profitOfCompany;
    }

    public void fire (Employee employee) {
            if (employee instanceof Manager || employee instanceof TopManager || employee instanceof Operator) {
                    employeeArrayList.remove(employee);
                    profitOfCompany -= employee.getProfit();
                } else System.out.println("Такого сотрудника не существует");
        }


    public void hire(Employee employee) {
        if (employee instanceof Manager || employee instanceof TopManager || employee instanceof Operator) {
            employeeArrayList.add(employee);
            profitOfCompany += employee.getProfit();
        } else System.out.println("Такого сотрудника не существует");
    }

    public void hireAll(Employee employee, int countOfEmployee) {
        if (countOfEmployee <= 0) {
            System.out.println("Не верное число сотрудников");
        } else {
            if (employee instanceof Manager  || employee instanceof TopManager || employee instanceof Operator) {
                for (int index1 = 0; index1 < countOfEmployee; index1++) {
                    employeeArrayList.add(employee);
                    profitOfCompany += employee.getProfit();
                }
            } else System.out.println("Такого сотрудника не существует");
        }
    }


  private   List<Employee> topSalary = new ArrayList<>();
   private List<Employee> lowestSalary = new ArrayList<>();


    public List<Employee> getTopSalaryStaff(int count) {
        int index100 = 1;
        if (count > employeeArrayList.size() || count <= 0) {
            System.out.println("Не верное число сотрудников");
        } else {
            Collections.sort(employeeArrayList);
            topSalary = employeeArrayList.subList(0, count);
           for (Employee employee : topSalary){
               System.out.println(index100 + ". " + employee.getMonthSalary());
               index100++;
            }

        }
        return topSalary;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > employeeArrayList.size() || count <= 0) {
            System.out.println("Не верное число сотрудников");
        } else {
           int index100 = 0;

            Collections.sort(employeeArrayList,  Comparator.reverseOrder());
            lowestSalary = employeeArrayList.subList(0, count);
            for (Employee employee : lowestSalary){
                System.out.println(index100 + ". " + employee.getMonthSalary());
                index100++;
            }
        }
        return lowestSalary;
    }
}


   /* public void showAllEmployee() {
        for (Object employee : employeeArrayList) {
            System.out.println(employee);
}
    }*/




/*  public  void getLowestSalaryStaff(int count) {
      List<Integer> list123 = new ArrayList<>(listOfSallary.values());
      Collections.sort(list123);
      if (count <= list123.size()) {
          for (int index = 0; index < count; index++) {
              System.out.println(list123.get(index));
          }
      } else {
          System.out.println("Вы ввели неверное число");
      }
  }
      public  void getTopSalaryStaff (int count) {
          List<Integer> list123 = new ArrayList<> (listOfSallary.values());
          Collections.sort(list123);
          if (count <= list123.size()) {
              for (int index = list123.size()-1; index > list123.size()-1 - count; index--) {
                  System.out.println(list123.get(index));
              }
          } else {
              System.out.println("Вы ввели неверное число");
          }*/






/*


 public void showAllSallary() {
        for (Map.Entry e : listOfSallary.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());


Map <String, Integer> allEmployee = new TreeMap <> ();
String profi;
int salary;
public void makeAllEmployee () {
    for (int count = 1; count != 251; count++) {
        int index = (int) (Math.random() * 3);
        if (index == 1) {
            profi = "saleManager";
        } else if (index == 2) {
            profi = "topManager";
        } else {
            profi = "operator";
        }
    }
}
    public static int saleManagerSalary() {
        int randomSalary = 15000 + (int) (Math.random() * 50000);
    }
}

*/

