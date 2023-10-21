package com.API.API.models.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "enrollment_status")
    private String enrollmentStatus;
}


