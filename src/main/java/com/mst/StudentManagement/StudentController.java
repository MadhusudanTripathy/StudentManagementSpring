package com.mst.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getStudent")
    public ResponseEntity<Student> getStudent(@RequestParam("q") int admnNo){
        Student student =studentService.getStudent(admnNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @GetMapping("getStudentByName")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name") String name){
        Student student =studentService.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @PostMapping("addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String message= studentService.addStudent(student);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
    @PutMapping("updateStudent")
    public ResponseEntity<String> updateStudent(@RequestParam("q") int admnNo,@RequestBody Student student){
        String message= studentService.updateStudent(admnNo,student);
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestParam("q") int admnNo){
        String message= studentService.deleteStudent(admnNo);
        return new ResponseEntity<>(message,HttpStatus.FOUND);
    }

}
