package com.studentdatabase.studentdatabase.Service;

import com.studentdatabase.studentdatabase.Exception.StudentNotFound;
import com.studentdatabase.studentdatabase.Models.Students;
import com.studentdatabase.studentdatabase.Repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentsService{

    private StudentsRepository studentsRepository;

    public StudentServiceImplementation(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Students saveStudents(Students students) {
        return studentsRepository.save(students);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Students getStudentsByRollNo(int RollNo) {
        return studentsRepository.findById(RollNo).orElseThrow(()->new StudentNotFound(RollNo));
    }

    @Override
    public Students updateStudent(Students students,int RollNo) {
        Students existingStudent = studentsRepository.findById(RollNo).orElseThrow(()->new StudentNotFound(RollNo));

        existingStudent.setName(students.getName());
        existingStudent.setGender(students.getGender());
        existingStudent.setEmail(students.getEmail());
        existingStudent.setPhoneNumber(students.getPhoneNumber());
        studentsRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(int RollNo) {
        studentsRepository.findById(RollNo).orElseThrow(()->new StudentNotFound(RollNo));
        studentsRepository.deleteById(RollNo);
    }
}
