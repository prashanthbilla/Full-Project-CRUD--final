package com.example.demo.service;

import com.example.demo.dao.IStudentRepository;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
/*
    public File fileUpload(MultipartFile file) throws IOException {
        String file_directory = null;
        File myFile = new File(file_directory + file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return myFile;
    }*/

    @Override
    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd:HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }


}
