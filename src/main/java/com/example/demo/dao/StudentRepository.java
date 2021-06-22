package com.example.demo.dao;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    private static final String NEW_STUDENT = "insert into student(studentId,studentName,studentEmail) values (?,?,?)";
    private static final String UPDATE_STUDENT = "update student set studentName=?, studentEmail=? where studentId=?";
    private static final String GET_STUDENT = "select * from student where studentId=?";
    private static final String DELETE_STUDENT = "delete from student where studentId=? ";
    private static final String GET_STUDENTS = "select * from student ";

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public Student insertStudent(Student student) {
        int j = jdbcTemplate.update(NEW_STUDENT, student.getStudentId(), student.getStudentName(), student.getStudentEmail());
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        int j = jdbcTemplate.update(UPDATE_STUDENT, student.getStudentName(), student.getStudentEmail(), student.getStudentId());
        if (j > 0) {
            return student;
        } else {
            return null;
        }
    }

    @Override
    public Student getById(int studentId) {
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(GET_STUDENT, (rs, rowNum) -> {
                return new Student(rs.getInt("studentId"), rs.getString("studentName"), rs.getString("studentEmail"));
            }, studentId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("StudentRepositoryImpl.getById :: NO STUDENT FOUND");
        }
        return student;
    }

    @Override
    public String deleteById(int studentId) {
        int j = jdbcTemplate.update(DELETE_STUDENT, studentId);
        if (j > 0) {
            return "STUDENT DELETED WHERE STUDENT ID = " + studentId;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return jdbcTemplate.query(GET_STUDENTS, (rs, rowNum) -> {

            return new Student(rs.getInt("studentId"), rs.getString("studentName"), rs.getString("studentEmail"));
        });
    }
}
