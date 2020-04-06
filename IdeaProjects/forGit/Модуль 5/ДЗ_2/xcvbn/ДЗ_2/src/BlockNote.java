import java.util.ArrayList;
import java.util.Scanner;

public class BlockNote {


    ArrayList<String> myOwnList = new ArrayList<>() {{
        add("Почистить зубы.");
        add("Приготовить завтрак");
        add("Отправить ДЗ");
    }};

    int x = 2;

    public void compare() {
        System.out.println("Введите одну из следующих команд:\n" +
                "\tLIST - чтобы просмотреть весь текущий список дел \n" +
                "\tADD - чтобы добавить дело\n" +
                "\tEDIT + номер дела - чтобы изменить дело, которое находить под данным номером\n" +
                "\tDELET + номер дела - чтобы удалить задачу.");
        while (x != 1) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("LIST")) {
                for (String item : myOwnList) System.out.println(myOwnList.indexOf(item) + " " + item);
            } else if (command.substring(0, 3).equals("ADD")) {
                if (Character.isDigit(command.charAt(4))) {
                    if (Integer.parseInt(command.substring(4, 5)) >= myOwnList.size()) {
                        myOwnList.add(command.substring(5, command.length()).trim());
                    } else {
                        myOwnList.add(Integer.parseInt(command.substring(4, 5)), command.substring(5, command.length()).trim());
                    }

                } else {
                    myOwnList.add(command.substring(3, command.length()).trim());
                }
            } else if (command.substring(0, 5).equals("DELET"))   {

                myOwnList.remove(Integer.parseInt(command.substring(6, 7)));
            } else if (command.substring(0, 4).equals("EDIT"))  {
                myOwnList.set(Integer.parseInt(command.substring(5, 6)), command.substring(7, command.length()));
            } else {
                System.out.println("Нет такой команды. введите команду из списка.");
            }
        }
    }
}
