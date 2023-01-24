package com.mst.StudentManagement;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//
@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    @GetMapping("getStudent")
    public Student getStudent(@RequestParam("q") int admnNo){
        return db.get(admnNo);
    }

    @GetMapping("getStudentByName")
    public Student getStudentByName(@RequestParam("name") String name){
        for(Student s:db.values()){
            if(s.getName().equals(name)) return s;
        }
        return null;
    }

    @PostMapping("addStudent")
    public String addStudent(@RequestBody Student student){
        int admnNo=student.getAdmnNo();

        db.put(admnNo,student);

        return "Student Added Successfully";
    }
    @PutMapping("updateStudent")
    public String updateStudent(@RequestParam("q") int admnNo,@RequestBody Student student){
        db.put(admnNo,student);
        return "Updated Successfully";
    }

    @DeleteMapping("deleteStudent")
    public String deleteStudent(@RequestParam("q") int admnNo){
       db.remove(admnNo);
       return "Student Removed With admnNo "+admnNo;
    }

}
