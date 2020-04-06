import java.util.*;

import static com.sun.tools.attach.VirtualMachine.list;

public class ContactBook {
    TreeMap<String, Long> telefonBook = new TreeMap<>();
    Scanner scanner = new Scanner(System.in);
    public void doIT() {
        for (; ; ) {
            String[] name = scanner.nextLine().split(("\\s+"));
            if (name.length == 1) {
                if (name[0].equalsIgnoreCase("list")) {
                    list(telefonBook);
                } else if (isABC(name[0]) == true) {
                    if (telefonBook.containsKey(name[0])) {
                        System.out.println(name[0] + " " + telefonBook.get(name[0]));
                    } else {
                        System.out.println("Введите номер телефона");
                        String[] number = scanner.nextLine().split(("\\s+"));
                        long number1 = Long.parseLong(number[0]);
                        telefonBook.put(name[0], number1);
                        System.out.println("Теперь к этому имени привязан номер");
                    }
                } else if (isABC(name[0]) == false)  {
                    long lastnumber = Long.parseLong(name[0]);
                    if (telefonBook.containsValue(lastnumber)) {
                        System.out.println(getKeyFromValue(telefonBook, lastnumber) + " " + lastnumber);
                    } else {
                        System.out.println("Введите Имя");
                        String newName = scanner.nextLine();
                        long newNumber =Long.parseLong(name[0]);
                        telefonBook.put(newName, newNumber);
                        System.out.println("Теперь к этому имени привязан номер");
                    }

                    } else System.out.println("Вы ввели не корректные данные");
                } else System.out.println("Вы ввели не корректные данные");
            }
        }

    private boolean isABC (String str) {
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (!Character.isLetter(c)) {
                return false;
            }
    }
        return true;
    }
    private void list (Map <String, Long> map)  {
        for (String key : map.keySet())  {
            System.out.println(key + " " + map.get(key));
        }
    }
    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}

/*
    public void doIt() {
        System.out.println("Чтобы добавить почту введите \"ADD вашапочта@mail.ru\", чтобы открыть список всех почт введите \"LIST\". ");
        boolean smth = true;
        while (smth) {
            Scanner scanner = new Scanner(System.in);
            String[] newMail = scanner.nextLine().split("\\s+");
            if (newMail[0].equalsIgnoreCase("list") && newMail.length == 1) {
                list();
            } else if (newMail[0].equalsIgnoreCase("add") && newMail.length == 2) {
                add(newMail);
            } else System.out.println("Введите корректную команду");
        }
    }

    private void list() {
        for (String email : emails)
            System.out.println(email);
    }

    private void add(String[] newMail) {
        if (newMail[1].replaceAll("[^@]", "").equals("@")) {
            correct(newMail[1]);
        } else {
            System.out.println("Введите корректную почту.");
        }
    }

    private void correct(String str) {
        String[] arr1 = str.split("@");
        if (arr1.length == 2 && arr1[0].length() > 0 && arr1[1].length() > 3) {
            if (arr1[1].replaceAll("[^.]", "").equals(".")) {
                String[] arr10 = arr1[1].split("\\.");
                if (arr10[0].length() > 0 && arr10[1].length() > 0  && isABC(arr10[0]) == true && isABC(arr10[1]) == true ) {

                    emails.add(str);
                } else System.out.println("Error 3");
            }

            private boolean isABC(String str) {
                char[] ch = str.toCharArray();
                for (char c : ch) {
                    if (!Character.isLetter(c)) {
                        return false;
                    }
                }
                return true;
            }
        }              System.out.println("Почта корректна и успешно добавлена.");
                } else System.out.println("Error 1");
            } else System.out.println("Error 2");
    */
/*

        String[] arr = str.split("");
        if (arr[0].replaceAll("[^a-z A-z 0-9]", "") != "")   {
            if (str.)
        }
                   for (String str1 : arr)
                    System.out.println(str1);
*/




