
public interface Employee extends Comparable<Employee> {
    int getMonthSalary ();


    default int compareTo(Employee o2) {
      if (getMonthSalary() > o2.getMonthSalary()) {
          return  -1;
      }
      if (getMonthSalary() < o2.getMonthSalary() ) {
          return 1;
      }
      return 0;
    }
  default   int getProfit() {
     return 0;
  }

}
