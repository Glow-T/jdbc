package jdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class jdbcInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        sb.append("insert into userInfo(customerID,customerName,PID,telephone,address) values(");
        System.out.println("请输入客户ID：");
        sb.append(sc.nextInt()+",");
        System.out.println("请输入客户姓名：");
        sb.append("'"+sc.next()+"'"+",");
        System.out.println("请输入客户身份证号码：");
        sb.append("'"+sc.next()+"'"+",");
        System.out.println("请输入客户电话号码：");
        sb.append("'"+sc.next()+"'"+",");
        System.out.println("请输入客户地址：");
        sb.append("'"+sc.next()+"'");
        sb.append(")");
        System.out.println(sb);
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "123456");
            statement = connection.createStatement();
            statement.execute(sb.toString());
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
