package com.example.demo.controller;

import com.example.demo.exceptionhandling.AppResponse;
import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class Controller {

    @Autowired
    private IStudentService iService;

    @GetMapping("/getall")
    public ResponseEntity<Object> getAllStudents() {
        List<Student> st = iService.getAllStudents();
        if (!st.isEmpty()) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), st);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.BAD_REQUEST.value(), "NO DATA FUND ", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insertStudent(@RequestBody Student student) {
        Student st;
        try {
            st = iService.insertStudent(student);
            AppResponse response = new AppResponse(HttpStatus.OK.value(), "RECORD INSERTED SUCCESSFULLY.. ", st);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            AppResponse response = new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "STUDENT ID EXISTS, PLEASE INSERT DATA IN ANOTHER STUDENT ID", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        Student st = iService.updateStudent(student);
        ;
        if (st != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), " RECORD UPDATED  SUCCESSFULLY.. ", st);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), " INVALID STUDENT ID ", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Object> getStudentById(@PathVariable("studentId") int studentId) {
        Student student = iService.getById(studentId);
        if (student != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), student);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.BAD_REQUEST.value(), "INVALID STUDENT ID", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Object> deleteStudentById(@PathVariable("studentId") int studentId) {
        String s = iService.deleteById(studentId);
        if (s != null) {
            AppResponse response = new AppResponse(HttpStatus.OK.value(), "RECORD DELETED SUCCESSFULLY..", s);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            AppResponse response = new AppResponse(HttpStatus.BAD_REQUEST.value(), "INVALID STUDENT ID", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    // TODO : FILE UPLOAD API - TAKE FILE FROM POSTMAN AND SAVE IT AT A LOCATION WITH NAME -> NAME+TIMESTAMP.EXTENSTION
    // TODO : LOMBOK INTEGRATION
    // TODO : BASIC OF LINUX COMMANDS - https://www.youtube.com/watch?v=G23ef2D-qrY

}

