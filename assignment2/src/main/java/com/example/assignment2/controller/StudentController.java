package com.example.assignment2.controller;

import com.example.assignment2.model.College;
import com.example.assignment2.model.Student;
import com.example.assignment2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping("/addStudent")
    public String AddStudent(@RequestBody Student student){
        repository.save(student);
        return "Student with id: "+student.getStudentId()+" has been added";
    }

    @GetMapping("/findStudentsByCollegeName/{collegeName}")
    public List<Student> getStudentsByCollegeName(@PathVariable String collegeName){
        return repository.findByCollegeName(collegeName);
    }

    @GetMapping("/findStudentsByCollegeNameAndJoiningDate/{collegeName}/{joiningDate}")
    public List<Student> getStudentsByCollegeNameAndJoiningDate(@PathVariable("collegeName") String collegeName,@PathVariable("joiningDate") String joiningDate){
        return repository.findByCollegeNameAndJoiningDate(collegeName,joiningDate);
    }

    @PostMapping("/updateCollegeDetails/{studentId}")
    public String updateCollegeDetails(@PathVariable int studentId, Student student, @RequestBody College college){

        if(!repository.findById(studentId).isEmpty())
        {
            Student oldValues = repository.findById(studentId).get();

            student.setStudentId(oldValues.getStudentId());
            student.setStudentName(oldValues.getStudentName());
            student.setJoiningDate(oldValues.getJoiningDate());
            student.setAddress(oldValues.getAddress());
            student.setMobileNumber(oldValues.getMobileNumber());

            college.setCollegeId(college.getCollegeId());
            college.setCollegeName(college.getCollegeName());
            college.setCollegeCode(college.getCollegeCode());
            college.setCollegeAddress(college.getCollegeAddress());
            college.setCollegeMailId(college.getCollegeMailId());

            student.setCollege(college);

            repository.save(student);
            return "Updated Student College Details With Id: " + student.getStudentId();
        }
        return "No Student With Id: "+student.getStudentId();
    }

    @GetMapping("/findCollegeDetailsOfParticularStudent/{studentId}")
    public College getStudentsByCollegeName(@PathVariable int studentId){
        return repository.findById(studentId).get().getCollege();
    }
}
