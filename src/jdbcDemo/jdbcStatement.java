package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcStatement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要更改的账号地址名：");
        String add = sc.next();
        System.out.println("请输入更改后的邮箱号码");
        String email = sc.next();
        sb.append("update student set email = ");
        sb.append("'"+email+"' ");
        sb.append("where address =");
        sb.append("'"+add +"'");
        System.out.println(sb);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/myschool", "root", "123456");
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