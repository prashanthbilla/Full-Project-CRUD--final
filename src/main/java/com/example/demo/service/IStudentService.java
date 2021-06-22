package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    Student insertStudent(Student student);

    Student updateStudent(Student student);

    Student getById(int studentId);

    String deleteById(int studentId);
}
