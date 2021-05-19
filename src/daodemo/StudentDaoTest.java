package daodemo;

import daodemo.impl.StudentDaoImpl;
import java.util.Date;
import java.util.List;


public class StudentDaoTest {
    public static void main(String[] args) {
        Student student = new Student();
        StudentDaoImpl sdi = new StudentDaoImpl();
//        Date date = new Date();
//        date=Date1.strToDateLong("1996-03-09 00:00:00");
//        student.setAddress("南京市");
//        student.setAge(25);
//        student.setBornDate(date);
//        student.setEmail("23131@163.com");
//        student.setGradeID(1);
//        student.setIdentityCard("123141864871");
//        student.setLoginpwd("123456");
//        student.setPhone("123123123");
//        student.setSex("男");
//        student.setStudentName("刘建宇");
//        student.setStudentNo(10323);
//        boolean b = sdi.save(student);
//        if(b){
//            System.out.println("插入成功");
//        }else{
//            System.out.println("插入失败");
//        }
//        List<Student> studentList = sdi.select();
//        for (Student student1: studentList) {
//            System.out.println(student1.getStudentNo()+","
//            +student1.getLoginpwd()+","
//            +student1.getStudentName()+","
//            +student1.getSex()+","
//            +student1.getGradeID()+","
//            +student1.getPhone()+","
//            +student1.getAddress()+","
//            +student1.getBornDate()+","
//            +student1.getEmail()+","
//            +student1.getIdentityCard()+","
//            +student1.getAge()
//            );
        boolean b = sdi.update("123456789011",10323);
        System.out.println(b);

        }
    }

