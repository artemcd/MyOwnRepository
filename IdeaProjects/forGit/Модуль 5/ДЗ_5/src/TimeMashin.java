import com.sun.source.tree.Tree;

import java.util.*;

public class TimeMashin {
char[] allLetter = new char[] {'A', 'B', 'C', 'E', 'H',  'K', 'M', 'У', 'O', 'P', 'T', 'У', 'X'};
    ArrayList <String> carNumber = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);

    private void makeArr ()    {
    for(int index1 = 1; index1 < 199; index1 ++) {
       for (int indexOf1Letter = 0; indexOf1Letter < allLetter.length; indexOf1Letter++){
           for (int indexOf2Letter = 0; indexOf2Letter < allLetter.length; indexOf2Letter++){
               for (int indexOf3Letter = 0; indexOf3Letter < allLetter.length; indexOf3Letter++){
                   for(int index100 = 111; index100 <1000; index100+=111) {
                       StringBuilder stringBuilder = new StringBuilder();
                       stringBuilder.append(allLetter[indexOf1Letter]);
                       stringBuilder.append(index100);
                       stringBuilder.append(allLetter[indexOf2Letter]);
                       stringBuilder.append(allLetter[indexOf3Letter]);
                       stringBuilder.append(index1);
                       carNumber.add(stringBuilder.toString());
                   }
               }
           }
       }
    }
    }

    public void start ()   {
        makeArr();
        HashSet<String> set123 = new HashSet<>();
        set123.addAll(carNumber);

        TreeSet <String> set1 = new TreeSet<>();
        set1.addAll(carNumber);

        for (;;)  {
            String userEnter = scanner.nextLine();
            long time1 = System.nanoTime();
            carNumber.contains(userEnter);
            long time2 = System.nanoTime();
            System.out.println(time2 - time1);
            long time3 = System.nanoTime();
            Collections.binarySearch(carNumber, userEnter);
            long time4 = System.nanoTime();
            System.out.println(time4 - time3);
            long time5 = System.nanoTime();
            set1.contains(userEnter);
            long time6 = System.nanoTime();
            System.out.println(time6 - time5);
            long time7 = System.nanoTime();
            set123.contains(userEnter);
            long time8 = System.nanoTime();
            System.out.println(time8 - time7);
        }
    }
    /*private void list()   {
        for (String str : carNumber)   {
            System.out.println("str");
        }
    }*/
}
