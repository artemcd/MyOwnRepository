import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        List <Employee> sortedStaffList = staff.stream().sorted((o1, o2) -> {
            int compareSalary = o1.getSalary().compareTo(o2.getSalary());
            return compareSalary !=0
                    ? compareSalary
                    : o1.getName().compareTo(o2.getName());
        }).collect(Collectors.toList());

        for (Employee e: sortedStaffList)   {
            System.out.println(e);
        }

    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}








    /*Calendar calendar1 = new GregorianCalendar(2016, 11, 31 );
    Calendar calendar2 = new GregorianCalendar(2018, 0, 1);
         staff.stream()
                 .filter(employee ->
                 employee.getWorkStart().after(calendar1.getTime()) == true && employee.getWorkStart().before(calendar2.getTime()) == true)
                 .max(((employee, t1) -> employee.getSalary().compareTo(t1.getSalary())))
                 .ifPresent(System.out::println);*/