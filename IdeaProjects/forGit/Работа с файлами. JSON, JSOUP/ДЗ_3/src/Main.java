import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Main
{
    private static String staffFile = "C:\\Users\\User\\IdeaProjects\\МОДУЛИ\\Модуль 9\\ДЗ_3\\List.csv";

    public static void main(String[] args) throws IOException {
        ArrayList<BankAccount> staff = loadStaffFromFile();
        Set <String> listOfExpenditures = new HashSet<>();

  for (int i = 0; i < staff.size(); i++ )   {
      if (staff.get(i).getOutgoing() > 1) {
              String payInfo = staff.get(i).getDescribe().substring(18, 70).trim();
              if(payInfo.lastIndexOf('\\') > 0) {
                  listOfExpenditures.add(payInfo.substring(payInfo.lastIndexOf('\\')+1));
              } else if (payInfo.lastIndexOf('/') > 0) {
                  listOfExpenditures.add(payInfo.substring(payInfo.lastIndexOf('/')+1));
              }
      }
  }
  ArrayList <String> arrayListOfExpenditures = new ArrayList<>();
TreeMap <String, Double> listOfSpends = new TreeMap<>();
arrayListOfExpenditures.addAll(listOfExpenditures);

        for( int x  = 0; x < listOfExpenditures.size(); x++) {
            for (int i = 0; i < staff.size(); i++) {
                if (staff.get(i).getDescribe().contains(arrayListOfExpenditures.get(x))) {
                    if (listOfSpends.containsKey(arrayListOfExpenditures.get(x))) {
                        listOfSpends.put(arrayListOfExpenditures.get(x), listOfSpends.get(arrayListOfExpenditures.get(x)) + staff.get(i).getOutgoing());
                    } else {
                        listOfSpends.put(arrayListOfExpenditures.get(x), staff.get(i).getOutgoing());
                    }
                }
            }
        }
for (Map.Entry<String, Double> entry : listOfSpends.entrySet()){
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

        System.out.println("Общий доход:");
        staff.stream().map(s -> s.getComing()).reduce( (s1, s2) -> s2 + s1).ifPresent(System.out::println);
        System.out.println();
        System.out.println("Общий расход:");
        staff.stream().map(s -> s.getOutgoing()).reduce( (s1, s2) -> s2 + s1).ifPresent(System.out::println);

    }

    private static ArrayList<BankAccount> loadStaffFromFile() throws IOException {
        ArrayList<BankAccount> staff = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(staffFile));
        for (int line = 1; line < lines.size(); line++) {
            String[] fragments = lines.get(line).split(",");
            if (fragments.length == 9) {
                fragments[7] = fragments[7] + "." + fragments[8];
                fragments[7] = fragments[7].substring(1, fragments[7].length() - 1);
            }
            staff.add(new BankAccount(fragments));
        }
        return staff;
    }
}








