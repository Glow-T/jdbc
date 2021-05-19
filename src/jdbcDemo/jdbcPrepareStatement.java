package jdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class jdbcPrepareStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement statement = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要更改的账号地址名：");
        String add = sc.next();
        System.out.println("请输入更改后的邮箱号码");
        String email = sc.next();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/myschool", "root", "123456");
            statement = connection.prepareStatement("update student set email = ? where address = ?");
            statement.setString(1,email);
            statement.setString(2,add);
            int r = statement.executeUpdate();
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
