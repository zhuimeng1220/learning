package top.felixu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.Types.INTEGER;

public class JdbcDemo {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8" +
            "&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "felix19920320";

    public static void main(String[] args) {
        insert(new Person(2, "felixu", 1, "Mars"));
    }

    public static int insert(Person person) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.prepareStatement("INSERT INTO person VALUES (?,?,?,?)");
            statement.setString(2, person.getName());
            statement.setInt(1, person.getId());
            statement.setInt(3, person.getAge());
            statement.setString(4, person.getAddress());
            return statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (null != statement) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;

    }

    public static Person get() {
        return null;
    }
}