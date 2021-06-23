package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();

    Student insertStudent(Student student);

    Student updateStudent(Student student);

    Student getById(int studentId);

    String deleteById(int studentId);

    public String getCurrentDate();

    //public File fileUpload(MultipartFile file) throws IOException;
}
