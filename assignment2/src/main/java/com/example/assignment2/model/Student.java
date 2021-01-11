package com.example.assignment2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "College")
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String joiningDate;
    private String address;
    private String mobileNumber;
    private College college;
}
