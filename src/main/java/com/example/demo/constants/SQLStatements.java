package com.example.demo.constants;

public class SQLStatements {
    public  static final String NEW_STUDENT = "insert into student(studentId,studentName,studentEmail) values (?,?,?)";
    public static final String UPDATE_STUDENT = "update student set studentName=?, studentEmail=? where studentId=?";
    public static final String GET_STUDENT = "select * from student where studentId=?";
    public static final String DELETE_STUDENT = "delete from student where studentId=? ";
    public static final String GET_STUDENTS = "select * from student ";
}
