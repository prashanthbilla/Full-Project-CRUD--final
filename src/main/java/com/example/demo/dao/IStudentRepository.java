package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;


public interface IStudentRepository {
    List<Student> getAllStudents();

    Student insertStudent(Student student);

    Student updateStudent(Student student);

    Student getById(int studentId);

    String deleteById(int studentId);
}
