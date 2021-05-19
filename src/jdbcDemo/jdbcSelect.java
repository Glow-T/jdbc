package jdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class jdbcSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        System.out.println("请输入需要查询的顾客姓名：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "123456");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select customerId,customerName from userInfo ");
            //resultSet = statement.executeQuery("select customerId,customerName from userInfo where customerName = '"+str+"'");
            int id;
            String name;
            while (resultSet.next()) {
                int i = resultSet.getRow();
                id = resultSet.getInt("customerId");
                name = resultSet.getString("customerName");
                System.out.println(i + "    customerId=" + id + "     customerName=" + name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
