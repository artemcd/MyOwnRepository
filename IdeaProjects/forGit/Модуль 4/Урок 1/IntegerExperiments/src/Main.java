public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(sumDigits(100));
    }

    public static Integer sumDigits(Integer number)
    {
        int sum = 0;
        String newNumber = number.toString();
        for (int index = 0; index < newNumber.length(); index++)
        {
          sum = sum + newNumber.charAt(index);
        }
        return sum;
    }
}
