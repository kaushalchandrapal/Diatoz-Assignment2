package com.example.assignment2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class College {
    @Id
    private int collegeId;
    private String collegeName;
    private int collegeCode;
    private String collegeAddress;
    private String collegeMailId;
}
