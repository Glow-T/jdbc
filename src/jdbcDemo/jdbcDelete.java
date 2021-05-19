package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDelete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;
        StringBuffer sb = new StringBuffer();
        sb.append("delete from userInfo where customerID = 5");
        System.out.println(sb);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "123456");
            statement = connection.createStatement();
            int r = statement.executeUpdate(sb.toString());
            System.out.println("返回更新的条数"+r);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
