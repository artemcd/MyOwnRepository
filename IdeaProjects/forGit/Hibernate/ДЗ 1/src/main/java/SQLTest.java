import java.sql.*;

public class SQLTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "test";

        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("WITH t AS \n" +
                    "(SELECT course_id, \n" +
                    "count(*) AS amount, \n" +
                    "date_format(subscription_date, '%m-%Y') AS MONTH \n" +
                    "FROM Subscriptions \n" +
                    "GROUP BY course_id, \n" +
                    "date_format(subscription_date, '%m-%Y')) \n" +
                    "SELECT c.id, \n" +
                    "c.name, \n" +
                    "stat.a / stat.m AS avg_per_month \n" +
                    "FROM Courses c \n" +
                    "JOIN \n" +
                    "(SELECT course_id, \n" +
                    "sum(amount) AS a, \n" +
                    "count(MONTH) AS m \n" +
                    "FROM t \n" +
                    "GROUP BY course_id) stat ON stat.course_id = c.id;");
            while(resultSet.next()) {
                String courseName = resultSet.getString("name");
                String avg = resultSet.getString("avg_per_month");
                System.out.println(courseName + " кол-во покупок в месяц = " + avg);
            }
            resultSet.close();
            statement.close();
            connection.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

