package com.studentdatabase.studentdatabase.Controller;

import com.studentdatabase.studentdatabase.Models.Students;
import com.studentdatabase.studentdatabase.Service.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/database")
public class StudentController {
    StudentsService studentsService;

    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    @PostMapping
    public ResponseEntity<Students> saveStudents(@RequestBody Students students){
        return new ResponseEntity<Students>(studentsService.saveStudents(students), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Students> getAllStudents(){
        return (studentsService.getAllStudents());
    }
    @GetMapping("{RollNo}")
    public ResponseEntity<Students> getStudentsByRollNo(@PathVariable int RollNo){
        return new ResponseEntity<Students>(studentsService.getStudentsByRollNo(RollNo),HttpStatus.OK);
    }
    @PutMapping("{RollNo}")
    public ResponseEntity<Students> updateStudent(@PathVariable int RollNo,@RequestBody Students students){
        return new  ResponseEntity<Students>(studentsService.updateStudent(students,RollNo),HttpStatus.OK);
    }
    @DeleteMapping("{RollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable int RollNo){
        studentsService.deleteStudent(RollNo);
        return new ResponseEntity<String >("Student data deleted",HttpStatus.OK);
    }
}
