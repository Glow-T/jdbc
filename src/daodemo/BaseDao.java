package daodemo;

import javax.xml.transform.Result;
import java.sql.*;

public class BaseDao {
     public static Connection connection = null;
     public static PreparedStatement statement = null;
     public static ResultSet resultSet = null;
    public static void getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/myschool", "root", "123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeResource(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void closeAllResource(){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public int executeSql(StringBuffer sql,Object[] objects){
        int r = 0;
        try {
            statement = connection.prepareStatement(sql.toString());
            for(int i = 1; i <= objects.length; i++){
                statement.setObject(i,objects[i-1]);
            }
            r = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }
    public ResultSet executeSelect(StringBuffer sql){
        try {
            statement = connection.prepareStatement(sql.toString());
            resultSet = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
