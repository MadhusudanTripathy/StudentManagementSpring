package com.mst.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int admnNo){
        return studentRepository.getStudent(admnNo);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public String updateStudent(int admnNo, Student student){
        return studentRepository.updateStudent(admnNo,student);
    }

    public String deleteStudent(int admnNo){
        return studentRepository.deleteStudent(admnNo);
    }
}
