package com.example.demo.dao;

import com.example.demo.constants.SQLStatements;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {


    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public Student insertStudent(Student student) {
        int j = jdbcTemplate.update(SQLStatements.NEW_STUDENT, student.getStudentId(), student.getStudentName(), student.getStudentEmail());
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        int j = jdbcTemplate.update(SQLStatements.UPDATE_STUDENT, student.getStudentName(), student.getStudentEmail(), student.getStudentId());
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
            student = jdbcTemplate.queryForObject(SQLStatements.GET_STUDENT, (rs, rowNum) -> {
                return new Student(rs.getInt("studentId"), rs.getString("studentName"), rs.getString("studentEmail"));
            }, studentId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("StudentRepositoryImpl.getById :: NO STUDENT FOUND");
        }
        return student;
    }

    @Override
    public String deleteById(int studentId) {
        int j = jdbcTemplate.update(SQLStatements.DELETE_STUDENT, studentId);
        if (j > 0) {
            return "STUDENT DELETED WHERE STUDENT ID = " + studentId;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return jdbcTemplate.query(SQLStatements.GET_STUDENTS, (rs, rowNum) -> {

            return new Student(rs.getInt("studentId"), rs.getString("studentName"), rs.getString("studentEmail"));
        });
    }
}
