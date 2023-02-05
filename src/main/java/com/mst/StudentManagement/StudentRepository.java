package com.mst.StudentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int admnNo){
        return db.get(admnNo);
    }

    public Student getStudentByName(String name){
        for(Student s:db.values()){
            if(s.getName().equals(name)) return s;
        }
        return null;
    }

    public String addStudent(Student student){
        int admnNo=student.getAdmnNo();

        db.put(admnNo,student);

        return "Student Added Successfully";
    }

    public String updateStudent(int admnNo, Student student){
        db.put(admnNo,student);
        return "Updated Successfully";
    }

    public String deleteStudent(int admnNo){
        db.remove(admnNo);
        return "Student Removed With admnNo "+admnNo;
    }

}
