
public interface Employee extends Comparable<Employee> {
   public int getMonthSalary ();
    int getSalary ();
    default int compareTo(Employee o2) {
      if (getSalary() > o2.getSalary()) {
          return  -1;
      }
      if (getSalary() < o2.getSalary() ) {
          return 1;
      }
      return 0;
    }

}
