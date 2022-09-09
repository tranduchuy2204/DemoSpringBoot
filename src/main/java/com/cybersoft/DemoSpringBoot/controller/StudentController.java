package com.cybersoft.DemoSpringBoot.controller;

import com.cybersoft.DemoSpringBoot.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {

    public List<Student> students = new ArrayList<Student>();

    @PostMapping("/add-student")
    public List<Student> addStudent(
            @RequestParam String name,
            @RequestParam int age
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        students.add(student);
        return students;
    }

    @GetMapping("/{name}/{age}")
    public List<Student> addStudentPath(
            @PathVariable("name") String name,
            @PathVariable("age") int age
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        students.add(student);
        return students;
    }

    @PostMapping("add-student-json")
    public List<Student> addStudentJson(
            @RequestBody Student student
    ) {
        students.add(student);
        return students;
    }
}
