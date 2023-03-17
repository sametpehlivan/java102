package jdbc.dao;

import jdbc.entity.BaseEntity;
import jdbc.entity.Student;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo  extends  GenericRepo <Student>{

    public StudentRepo(Connection connection) throws SQLException
    {
        super(connection);
    }

    @Override
    public Student create(Student entity) throws SQLException
    {
        int count =  dataManage("INSERT INTO `students` (`name`, `surname`, `student_number`) VALUES ( '"+entity.name+"', '"+entity.surname+"', '"+entity.studentNumber+"');");
        return count == 1  ? entity : null ;
    }

    @Override
    public boolean update( Student entity) throws SQLException {
        Student student = getById(entity.id);
        int count = dataManage("UPDATE table_name SET name = '"+student.name+"', surname = '"+student.surname+"',student_number = '"+student.studentNumber+"', WHERE id = "+student.id+";");
        return count == 1;
    }

    @Override
    public boolean delete(Long id) throws SQLException
    {

       Student student = getById(id);
       int count = dataManage("delete from students where id = "+student.id+";");
       return count == 1;
    }

    @Override
    public List<Student> getAll() throws SQLException
    {
        ResultSet countQuery = query("select count(*) as count from students;");
        countQuery.next();
        if (!(countQuery.getInt("count") > 0)) throw new SQLException("Not Found Record");

        ResultSet rs = query("select * from students");
        var students = new ArrayList<Student>();
        while (rs.next())
        {
            Student student = new Student();
            student.id = rs.getLong("id");
            student.name = rs.getString("name");
            student.surname = rs.getString("surname");
            student.studentNumber = rs.getString("student_number");
            students.add(student);
        }
        return students;


    }

    @Override
    public Student getById(Long id) throws SQLException {
        ResultSet rs = query("select * from students where id ="+id+";");
        if (rs.next())
        {
            Student student = new Student();
            student.id = rs.getLong("id");
            student.name = rs.getString("name");
            student.surname = rs.getString("surname");
            student.studentNumber = rs.getString("student_number");
            return student;
        }
        throw new SQLException("Not Found Record");
    }


}
