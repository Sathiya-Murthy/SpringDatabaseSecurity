package com.studentdatabase.studentdatabase.Exception;

public class StudentNotFound extends RuntimeException {
    private Integer RollNo;

    public StudentNotFound(Integer rollNo) {
        super(String.format("Student not found with id %s",rollNo));
        RollNo = rollNo;
    }
}
