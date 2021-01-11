package com.example.assignment2.repository;

import com.example.assignment2.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    @Query("{ 'college.collegeName' : ?0 }")
    List<Student> findByCollegeName(String collegeName);

    @Query("{ 'college.collegeName' : ?0 ,'joiningDate' : ?1 }")
    List<Student> findByCollegeNameAndJoiningDate(String collegeName, String joiningDate);
}
