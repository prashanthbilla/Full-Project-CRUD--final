package com.example.demo.service;

import com.example.demo.dao.IStudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository istudentRepository;

    @Override
    public List<Student> getAllStudents() {
        return istudentRepository.getAllStudents();
    }

    @Override
    public Student insertStudent(Student student) {
        return istudentRepository.insertStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return istudentRepository.updateStudent(student);
    }

    @Override
    public Student getById(int studentId) {
        return istudentRepository.getById(studentId);
    }

    @Override
    public String deleteById(int studentId) {
        return istudentRepository.deleteById(studentId);
    }

    @Override
    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

}
