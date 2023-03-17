package jdbc;

import jdbc.dao.DBConnection;
import jdbc.dao.StudentRepo;
import jdbc.entity.Student;


import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "" ;
        DBConnection db = new DBConnection( url, user, password);

        StudentRepo studentRepo = new StudentRepo(db.getConnection());
        /*
            Student student = studentRepo.getById((long)3);
            System.out.println(studentRepo.delete((long)3));
            System.out.println(student.name);
            System.out.println(studentRepo.getAll().get(0).name);
        */
        Student student = new Student();
        student.name = "samet";
        student.surname = "pehlivan";
        student.studentNumber = "1111111";
        System.out.println(studentRepo.create(student).name);




    }
}
