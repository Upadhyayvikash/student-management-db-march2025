package com.jpahibernate.example.student_management_db.controller;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {
    //controller <-> service <-> repository
    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public String saveStudent(@RequestBody Student studentRequest){
        String response = studentService.addStudent(studentRequest);
        return response;
    }
    @GetMapping("/find/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student=studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        List<Student> studentList = studentService.getAllStudent();
        return studentList;
    }
    @GetMapping("/count")
    public String getCountOfStudents(){
       String studentCount=studentService.countStudents();
       return studentCount;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        String response=studentService.deleteStudentsById(id);
        return response;
    }
    @PutMapping("/updatePut/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student newStudentRequest){
        String response=studentService.updateStudentByPut(id,newStudentRequest);
        return response;
    }
    @PatchMapping("/updateMobile/{id}")
    public String updateStudentMobile(@PathVariable int id, @RequestParam String mobile){
        String response=studentService.updateStudentByPatch(id,mobile);
        return response;
    }
}

