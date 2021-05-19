package daodemo;


import java.sql.ResultSet;
import java.util.List;

public interface StudentDao {
    public boolean save(Student student);
    public boolean delete(int studentNo);
    public boolean update(String phone,int studentNo);
    public List<Student> select();
}
