import java.util.*;
import java.util.Scanner;

public class BlockNote {


    ArrayList<String> myOwnList = new ArrayList<>() {{
        add("Почистить зубы.");
        add("Приготовить завтрак");
        add("Отправить ДЗ");
    }};



    public void compare() {
        int x = 2;
        System.out.println("Введите одну из следующих команд:\n" +
                "\tLIST - чтобы просмотреть весь текущий список дел \n" +
                "\tADD - чтобы добавить дело\n" +
                "\tEDIT + номер дела - чтобы изменить дело, которое находить под данным номером\n" +
                "\tDELET + номер дела - чтобы удалить задачу.");
        boolean repeating = true;
        while (repeating) {
            Scanner scanner = new Scanner(System.in);
            String[] command = scanner.nextLine().split("\\s+");

            if (command.length == 1 && command[0].equalsIgnoreCase("LIST"))
                list();
            else if (command.length == 2 && command[0].equalsIgnoreCase("DELET") && isDigit(command[1]))
                delete(Integer.parseInt(command[1]));
            else if (command[0].equalsIgnoreCase("ADD") )
                add(command);
            else if (command.length > 2 && command[0].equalsIgnoreCase("EDIT") && isDigit(command[1]))
                edit(command);
            else
                System.out.println("Введите корректную команду.");
        }
    }

    private boolean isDigit(String str){
        try{
            Integer.parseInt(str);
        }
        catch (NumberFormatException|NullPointerException e) {
            System.out.println("Вы не ввели индекс задачи.");
            return false;
        }
        return true;
    }

    private void edit(String[] command){
        int index = Integer.parseInt(command[1]);
        if (isInBound(index))
            myOwnList.set(index, formNewTask(command));
        else
            System.out.println("Задачи под таким индексом не обнаружено.");
    }

    private void delete(int index){
        if (isInBound(index))
            myOwnList.remove(index);
        else
            System.out.println("Задачи под таким индексом не обнаружено.");
    }

    private String formNewTask(String[] strArray){
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 2; i < strArray.length; i++){
            joiner.add(strArray[i]);
        }
        return joiner.toString();
    }
    private String formNewTask2 (String[] strArray){
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 1; i < strArray.length; i++){
            joiner.add(strArray[i]);
        }
        return joiner.toString();
    }


    private void add(String[] command) {
        isDigit1(command);
    }
        private void isDigit1 (String[] command)  {
            try{
              int index =  Integer.parseInt(command[1]);
                String task;
                if (command.length > 3) {
                    task = formNewTask(command);
                } else task = command[2];

                if (index <= myOwnList.size()) {
                    myOwnList.add(index, task);
                } else myOwnList.add(task);
            }
            catch (NumberFormatException|NullPointerException e) {
                String task;
                if (command.length > 1) {
                    task = formNewTask2(command);
                } else task = command[1];
                myOwnList.add(task);
            }
        }



    private void list(){
        for (String item : myOwnList)
            System.out.println(myOwnList.indexOf(item) + " " + item);
    }

    private boolean isInBound(int value){
        return value < myOwnList.size();
    }


    }
