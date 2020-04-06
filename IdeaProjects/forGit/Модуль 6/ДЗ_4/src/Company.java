import java.util.*;

public class Company {
    private int profit;

    private ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public int getIncome() {
        for (int i = 0; i < employeeArrayList.size(); i++) {
            if (employeeArrayList.get(i) instanceof Manager) {
                profit += ((employeeArrayList.get(i)).getSalary());
            }
        }
        return profit;

    }

    public void fire(int count) {
        if (count < employeeArrayList.size() && count > 0) {
            for (int index = 0; index < count; index++)
                employeeArrayList.remove(index);
            ;
        } else System.out.println("Такого сотрудника не существует");
    }

    public void hire(String profi) {
        if (profi.equalsIgnoreCase("Manager")) {
            employeeArrayList.add(new Manager());
        } else if (profi.equalsIgnoreCase("TopManager")) {
            employeeArrayList.add(new TopManager());
        } else if (profi.equalsIgnoreCase("Operator")) {
            employeeArrayList.add(new Operator());
        }
    }

    public void hireAll(int countOfManager, int countOfTopManager, int countOfOperator) {
        for (int index1 = 0; index1 < countOfManager; index1++) {
            employeeArrayList.add(new Manager());
        }
        for (int index2 = 0; index2 < countOfTopManager; index2++) {
            employeeArrayList.add(new TopManager());
        }
        for (int index3 = 0; index3 < countOfOperator; index3++) {
            employeeArrayList.add(new Operator());
        }
    }


    List<Employee> topSalary = new ArrayList<>();
    List<Employee> lowestSalary = new ArrayList<>();


    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employeeArrayList);
        int number = 1;
        for (int i = 0; i < count; i++) {
            topSalary.add(employeeArrayList.get(i));
            System.out.println(number + ". " + employeeArrayList.get(i).getSalary()  + " руб.");
            number++;

        } return topSalary;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employeeArrayList);
        int number = 1;

        for (int i = employeeArrayList.size() - 1; i >= employeeArrayList.size()- count; i--) {
            topSalary.add(employeeArrayList.get(i));
            System.out.println(number + ". " + employeeArrayList.get(i).getSalary() + " руб.");
            number++;
        } return lowestSalary;
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

