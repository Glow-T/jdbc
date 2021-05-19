package daodemo.impl;

import daodemo.BaseDao;
import daodemo.Student;
import daodemo.StudentDao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public boolean save(Student student) {
        getConnect();
        StringBuffer sb = new StringBuffer();
        sb.append("insert into student(studentNo,loginpwd,studentName,sex,gradeID,phone,address,bornDate,email,identityCard,age) ");
        sb.append("values(?,?,?,?,?,?,?,?,?,?,?)");
        Object[] objects = new Object[11];
        objects[0] = student.getStudentNo();
        objects[1] = student.getLoginpwd();
        objects[2] = student.getStudentName();
        objects[3] = student.getSex();
        objects[4] = student.getGradeID();
        objects[5] = student.getPhone();
        objects[6] = student.getAddress();
        objects[7] = student.getBornDate();
        objects[8] = student.getEmail();
        objects[9] = student.getIdentityCard();
        objects[10] = student.getAge();
        int r = executeSql(sb, objects);
        closeResource();
        return r > 0;
    }

    @Override
    public boolean delete(int studentNo) {
        getConnect();
        StringBuffer sb = new StringBuffer();
        sb.append("delete from student where studentNo = ?");
        Object[] objects = new Object[1];
        objects[0] = studentNo;
        int r = executeSql(sb, objects);
        closeResource();
        return r > 0;
    }

    @Override
    public boolean update(String phone,int studentNo) {
        getConnect();
        StringBuffer sb = new StringBuffer();
        sb.append("update student set phone = ? where studentNo = ?");
        Object[] objects = new Object[2];
        objects[0] = phone;
        objects[1] = studentNo;
        int r = executeSql(sb, objects);
        closeResource();
        return r > 0;
    }

    @Override
    public List<Student> select() {
        getConnect();
        List<Student> studentList = new ArrayList<Student>();
        StringBuffer sb = new StringBuffer();
        sb.append("select studentNo,loginpwd,studentName,sex,gradeID,phone,address,bornDate,email,identityCard,age from student ");
        resultSet = executeSelect(sb);
        try {
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentNo(resultSet.getInt("studentNo"));
                student.setLoginpwd(resultSet.getString("loginpwd"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setSex(resultSet.getString("sex"));
                student.setGradeID(resultSet.getInt("gradeID"));
                student.setPhone(resultSet.getString("phone"));
                student.setAddress(resultSet.getString("address"));
                student.setBornDate(resultSet.getDate("bornDate"));
                student.setEmail(resultSet.getString("email"));
                student.setIdentityCard(resultSet.getString("identityCard"));
                student.setAge(resultSet.getInt("age"));
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            closeAllResource();
            return studentList;
        }
    }
}
