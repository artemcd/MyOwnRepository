import java.util.Scanner;

public class Phone {

    public static void main(String[] args) {


            Scanner personPhon = new Scanner(System.in);
            System.out.println("Введите свой номер телефона:");
            String toNormalFormat = personPhon.nextLine().trim();

            String numberOnly = toNormalFormat.replaceAll("[^0-9]", "");
            String allNumber = "";
            if (numberOnly.length() > 10) {
                allNumber = numberOnly.substring(1, 11);
                System.out.println("7" + allNumber);
            } else {
                allNumber = "7" + numberOnly;
                System.out.println(allNumber);
            }


        }
    }


